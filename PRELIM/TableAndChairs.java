class Table {
    private int numRows;
    private int numCols;

    public Table(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
    }

    public void draw() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (isTableBorder(row, col) || isChair(row, col)) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private boolean isTableBorder(int row, int col) {
        return (col == 0 || col == numCols - 1);
    }

    private boolean isChair(int row, int col) {
        return (row == 0 && col % 25 == 0) ||  // first row with 'X'
               (row == 1 && col % 25 == 0) ||  // second row with 'X'
               (row == 2 && (col >= 8 && col <= 17)) ||  // third row with 'X'
               (row == 3 && (col >= 1 && col <= 5 || col == 8 || col == 17 || (col >= 20 && col <= 25))) || // 4th row with 'X'
               (row == 4 && (col == 5 || col == 8 || col == 17 || col == 20)) || // 5th row with 'X'
               (row == 5 && (col == 5 || col == 8 || col == 17 || col == 20)) || // 6th row with 'X'
               (row == 6 && (col == 5 || col == 8 || col == 17 || col == 20)); // 7th row with 'X'
    }
}

public class TableAndChairs {
    public static void main(String[] args) {
        int numRows = 7;
        int numCols = 26;

        Table table = new Table(numRows, numCols);
        table.draw();
    }
}