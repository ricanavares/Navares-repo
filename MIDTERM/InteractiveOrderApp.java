import java.util.*;

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private MenuItem item;
    private int quantity;

    public Order(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return item.getPrice() * quantity;
    }
}

public class InteractiveOrderApp {
    public static void main(String[] args) {
        // Create menu items and add-ons
        MenuItem c1 = new MenuItem("C1", 100.00);
        MenuItem c2 = new MenuItem("C2", 150.00);
        MenuItem c3 = new MenuItem("C3", 200.00);
        MenuItem r1 = new MenuItem("R1", 35.00);
        MenuItem r2 = new MenuItem("R2", 50.00);

        Map<String, MenuItem> menuItems = new HashMap<>();
        menuItems.put("C1", c1);
        menuItems.put("C2", c2);
        menuItems.put("C3", c3);

        Map<String, MenuItem> addons = new HashMap<>();
        addons.put("R1", r1);
        addons.put("R2", r2);

        List<Order> orders = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            for (String itemName : menuItems.keySet()) {
                System.out.println(itemName + " - Php " + menuItems.get(itemName).getPrice());
            }

            System.out.println("\nAdd Ons:");
            for (String addonName : addons.keySet()) {
                System.out.println(addonName + " - Php " + addons.get(addonName).getPrice());
            }

            System.out.print("\nEnter your choice (or 'done' to finish ordering): ");
            String choice = scanner.nextLine().toUpperCase();

            if (choice.equals("DONE")) {
                break;
            }

            MenuItem selectedItem = menuItems.get(choice);
            if (selectedItem == null) {
                selectedItem = addons.get(choice);
            }

            if (selectedItem != null) {
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();

                if (quantity > 0) {
                    orders.add(new Order(selectedItem, quantity));
                    scanner.nextLine(); // Consume the newline character
                } else {
                    System.out.println("Quantity must be greater than zero.");
                }
            } else {
                System.out.println("Invalid choice. Please select a valid item from the menu.");
            }
        }

        double totalPhp = 0.0;
        int totalQuantity = 0;

        System.out.println("\nYou ordered:");
        for (Order order : orders) {
            MenuItem item = order.getItem();
            int quantity = order.getQuantity();
            System.out.println(quantity + "x " + item.getName() + " - Php " + item.getPrice() + " each");
            totalPhp += order.getTotalPrice();
            totalQuantity += quantity;
        }

        double totalUsd = totalPhp * 0.019; // Assuming 1 PHP = 0.019 USD

        System.out.println("Total Price: Php " + totalPhp + " (USD " + totalUsd + ")");
        System.out.println("Total Quantity: " + totalQuantity);

        scanner.close();
    }
}
