import java.util.Scanner;

public class DistanceArrival {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double speed;
        double distance;
        double time;

        System.out.println("Start (Cebu City) Landmark: South Bus Terminal (Emall)");

        System.out.println("You've arrived from Route 1 'Minglanilla'");
        System.out.println("Enter 1 to continue to the next route.");
        int routeChoice = scan.nextInt();
        System.out.println("\nYou're now leaving Minglanilla. Thank you for visiting the place.\n");

        if (routeChoice == 1) {
            System.out.println("You've arrived from Route 2 'San Fernando'");
            System.out.println("Enter 1 to continue to the next route.");
            routeChoice = scan.nextInt();
            System.out.println("\nYou're now leaving San Fernando. Thank you for visiting the place.\n");

            if (routeChoice == 1) {
                System.out.println("You've arrived from Route 3 'Carcar'");

                // More routes
                System.out.println("\nMore routes to go!");
                System.out.println("[1] Barili");
                System.out.println("[2] Sibonga");
                System.out.println("[3] Argao\n");

                System.out.print("Enter your route choice: ");
                routeChoice = scan.nextInt();
                System.out.println("\nYou're now leaving Carcar. Thank you for visiting the place.\n");

                switch (routeChoice) {
                    case 1:
                        System.out.println("Welcome to Route 4.1 'Barili'");
                        System.out.println("Route 4.1.1 -> Dumanjug");
                        System.out.println("Route 4.1.2 -> Alcantara");
                        System.out.println("End route -> Moalboal");
                        distance = 84.9;
                        System.out.print("Speed in km/hr: ");
                        speed = scan.nextDouble();
                        time = distance/speed;
                        int temp = (int)(time * 100);
                        int hour = temp/100;
                        int min = temp % 100;
                        if(min >=60){
                        hour++;
                        min = min-60;
                        }
                        System.out.println("The speed is " + speed + " km/hr");
                        System.out.println("Distance traveled: " + distance + " km");
                        // Calculate the time arrival
                        System.out.printf("ETA: %d hour and %d minutes", hour,min+1);
                        break;
                    case 2:
                        System.out.println("Welcome to Route 4.2 'Sibonga'");
                        System.out.println("Route 4.2.1 -> Dumanjug");
                        System.out.println("Route 4.2.2 -> Alcantara");
                        System.out.println("End route -> Moalboal");
                        distance = 96.2;
                        System.out.print("Speed in km/hr: ");
                        speed = scan.nextDouble();
                        time = distance/speed;
                        int temp1 = (int)(time * 100);
                        int hour1 = temp1/100;
                        int min1 = temp1 % 100;
                        if(min1 >=60){
                        hour1++;
                        min1 = min1-60;
                        }
                        System.out.println("The speed is " + speed + " km/hr");
                        System.out.println("Distance traveled: " + distance + " km");
                        // Calculate the time arrival
                        System.out.printf("ETA: %d hour and %d minutes", hour1,min1+1);
                        break;

                    case 3:
                        System.out.println("Welcome to Route 5 'Argao'");
                        System.out.println("Route 5.1 -> Ronda");
                        System.out.println("Route 5.2 -> Alcantara");
                        System.out.println("End route -> Moalboal");
                        distance = 126.7;
                        System.out.print("Speed in km/hr: ");
                        speed = scan.nextDouble();
                        time = distance / speed;
                        int temp2 = (int)(time * 100);
                        int hour2 = temp2/100;
                        int min2 = temp2 % 100;
                        if(min2 >=60){
                        hour2++;
                        min2 = min2-60;
                        }
                        System.out.println("The speed is " + speed + " km/hr");
                        System.out.println("Distance traveled: " + distance + " km");
                        // Calculate the time arrival
                        System.out.printf("ETA: %d hour and %d minutes", hour2,min2+1);
                        break;
                    default:
                        System.out.println("Invalid route choice.");
                        break;
                }
            }
        }
    }
}