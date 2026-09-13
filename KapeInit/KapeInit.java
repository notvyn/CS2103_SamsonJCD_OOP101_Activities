// LABORATORY ACTIVITY 1 - OOP 101
// Item #4 | Coding Exercise: Canteen Ordering System
// Submitted By: John Calvin Samson

/* Creator's Note: 
This version explores the use of methods 
and tries to utilize the DRY principle.

KapeInitV2.java expounds more on the usage of 
iterative structure solely through the main function.
*/ 

import java.util.Scanner;

class KapeInit {
    public static void main(String[] args) throws InterruptedException {
        displayMenu();
        
        while(true) {
            processOrder();

            if (!isYes("\nDo you want to order again? (Y/N): ")) break;
        }

        displayKapeAnimation();

        displayOrderSummary();
        

        sc.close();
    }

    private static Scanner sc = new Scanner(System.in);

    private static int totalItems = 0;
    private static double totalPrice = 0;
    private static double totalDiscount = 0;
    private static double finalAmount = 0;
    private static boolean isStudent = false;

    private static String[] menuList = {
        "Espresso",
        "Cappuccino",
        "Matcha Latte",
        "Caramel Macchiato",
        "Green Tea",
        "Hot Chocolate",
        "Smoothie"
    };

    private static double[] menuPrice = {
        39.99,
        49.99,
        54.99,
        54.99,
        59.99,
        59.99,
        59.99
    };

    /* CORE PROCESS OF TRANSACTION */ 
    public static void displayMenu() {
        displayKapeHeader();
        System.out.println("======      M E N U      ======");
        
        for (int i = 0; i < menuList.length; i++) {
            System.out.printf("%d. %-20s - $%.2f\n", i+1, menuList[i], menuPrice[i]);
        }

        System.out.println();
    }

    public static void displayOrderSummary() {
        System.out.println("==== ORDER SUMMARY ====");
        System.out.printf("Total items: %d%n", totalItems);
        System.out.printf("Total before discount: $%.2f%n", totalPrice);
        System.out.printf("Total discount: $%.2f%n", totalDiscount);
        System.out.printf("Final Amount: $%.2f%n", finalAmount);
        System.out.println("Thank you for ordering!");
    }

    public static void processOrder() {
        int itemNumber = getItemNumber();
        int itemQuantity = getQuantity();
        
        if (!isOrderValid(itemNumber, itemQuantity)) { 
            return; 
        }
        
        updateOrder(itemNumber, itemQuantity);

        askIfStudent();

        double subTotal = getSubtotal(itemNumber, itemQuantity);
        double discount = computeDiscount(subTotal);
        double orderTotal = computeOrderTotal(subTotal, discount);

        displayCurrentOrder(subTotal, discount, orderTotal);

    }

    public static void displayCurrentOrder(double subTotal, double discount, double orderTotal) {
        System.out.printf("Subtotal: $%.2f%n", subTotal);
        System.out.printf("Discount: $%.2f%n", discount);
        System.out.printf("Order total: $%.2f%n", orderTotal);
    }

    public static int getItemNumber() {
        System.out.print("Enter item number: ");
        return sc.nextInt();
    }

    public static int getQuantity() {
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        
        return quantity;
    }

    public static void updateOrder(int itemNumber, int itemQuantity) {
        totalItems += itemQuantity;
    }

    public static boolean askIfStudent() {
        return isStudent = isYes("Are you a student? (Y/N): ");
    }

    public static boolean isOrderValid(int itemNumber, int itemQuantity) {
        if (itemNumber < 1 || itemNumber > menuList.length || itemQuantity < 1) {
            System.out.println("\nInvalid Order! Please enter a valid item and quantity.");
            return false;
        }

        return true;
    }

    /* UTILITY FUNCTION */
    public static boolean isYes(String message) {
        char userChoice;
        
        do {
            System.out.print(message);
            userChoice = sc.next().charAt(0);
            userChoice = Character.toUpperCase(userChoice);
        } while (userChoice != 'Y' && userChoice != 'N');

        System.out.println();
        
        return userChoice == 'Y';
    }

    /* TRANSACTION COMPUTATION */
    public static double computeDiscount(double subTotal) {
        double discount;
        if (isStudent) {
            if (subTotal > 500) {
                discount = subTotal * 0.15f;
            }
            else {
                discount = subTotal * 0.1f;
            }            
        } 
        else if (subTotal > 500) {
            discount = subTotal * 0.05f;
        }
        else {
            discount = 0;
        }

        totalDiscount += discount;
        return discount;
    }

    public static double computeOrderTotal(double subTotal, double discount) {
        double orderTotal = subTotal - discount;
        finalAmount += orderTotal;
        return orderTotal;
    }

    public static double getSubtotal(int itemNumber, int itemQuantity) {
        double subTotal = menuPrice[itemNumber-1] * itemQuantity;
        totalPrice += subTotal;
        return subTotal;
    }

    /* VISUAL BRANDING (Optional & Just for Fun ^.^) */
    public static void displayKapeHeader() {
        System.out.println("===============================");
        System.out.println("//****  K a p e I n i t  ****\\\\");
        System.out.println("-------------------------------");
    }

    public static void displayKapeAnimation() throws InterruptedException {
        String[] frames = {
            """
              ( (
               ) )     
            ........
            |      |]  Tasty Coffee, Happy Life 
            \\      /      --- O(∩_∩)o ---
             `----'
            """,

            """
               ) )
              ( (
            ........
            |      |]  Tasty Coffee, Happy Life 
            \\      /      --- o(∩_∩)O ---
             `----'
            """
        };
        
        System.out.println("Brewing your order...\n");

        for (int i = 0; i < 8; i++) {

            // Move to the beginning of the animation area
            if (i > 0) {
                System.out.print("\033[6A");
            }

            // Clear and redraw each line
            for (String line : frames[i % frames.length].split("\n")) {
                System.out.print("\033[2K");
                System.out.println(line);
            }

            System.out.flush();
            Thread.sleep(500);
        }

        // Move below the animation
        System.out.print("\033[6B\n");
    }
}