import java.util.Scanner;
import java.util.Stack;

public class InteractivePemdasCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter equation (or 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            double result = evaluateExpression(input);
            System.out.println("Result: " + result);
        }

        scanner.close();
    }

    private static double evaluateExpression(String expression) {
        Stack<Double> numStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        boolean isNegative = false;

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == ' ') {
                continue; // Skip spaces
            }

            if (ch == '-') {
                if (i == 0 || expression.charAt(i - 1) == '(') {
                    isNegative = true;
                    continue;
                }
            }

            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder numBuilder = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(ch) || ch == '.')) {
                    numBuilder.append(ch);
                    i++;
                    if (i < expression.length()) {
                        ch = expression.charAt(i);
                    }
                }
                double num = Double.parseDouble(numBuilder.toString());
                if (isNegative) {
                    num = -num;
                    isNegative = false;
                }
                numStack.push(num);
                i--;
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    evaluateTop(numStack, operatorStack);
                }
                operatorStack.pop();
            } else if (isOperator(ch)) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(ch)) {
                    evaluateTop(numStack, operatorStack);
                }
                operatorStack.push(ch);
            }
        }

        while (!operatorStack.isEmpty()) {
            evaluateTop(numStack, operatorStack);
        }

        if (numStack.isEmpty()) {
            throw new IllegalArgumentException("Invalid equation.");
        } else {
            return numStack.pop();
        }
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    private static void evaluateTop(Stack<Double> numStack, Stack<Character> operatorStack) {
        if (numStack.size() < 2 || operatorStack.isEmpty()) {
            throw new IllegalArgumentException("Invalid equation.");
        }

        double operand2 = numStack.pop();
        double operand1 = numStack.pop();
        char operator = operatorStack.pop();
        double result = performOperation(operand1, operand2, operator);
        numStack.push(result);
    }

    private static double performOperation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}