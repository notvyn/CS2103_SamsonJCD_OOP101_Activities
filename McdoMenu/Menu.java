import java.util.Scanner;

class Menu {
    private static Scanner sc = new Scanner(System.in);

    private static int menuCount = 5;
    private static int totalItems = 0;
    private static float totalPrice = 0;
    private static float totalDiscount = 0;
    private static float finalAmount = 0;
    private static boolean isStudent = false;

    private static String[] menuList = {
        "Burger",
        "Pizza",
        "Pasta",
        "Sandwich",
        "Milk Tea"
    };

    private static float[] menuPrice = {
        80.00f,
        120.00f,
        100.00f,
        70.00f,
        90.00f
    };

    /* CORE PROCESS OF TRANSACTION */ 
    public static void displayMenu() {
        System.out.println("====   M E N U   ====");
        
        for (int i = 0; i < menuCount; i++) {
            System.out.printf("%d. %-10s - $%.2f\n", i+1, menuList[i], menuPrice[i]);
        }

        System.out.println();
    }

    public static void reorder() {
        if (isYes("\nDo you want to order again? (Y/N): ")) {
            processOrder();
        }
        else {
            displayOrderSummary();
        }
    }

    public static void displayOrderSummary() {
        System.out.println("==== ORDER SUMMARY ====");
        System.out.printf("Total items: %d\n", totalItems);
        System.out.printf("Total before discount: $%.2f\n", totalPrice);
        System.out.printf("Total discount: $%.2f\n", totalDiscount);
        System.out.printf("Final Amount: $%.2f\n", finalAmount);
        System.out.println("Thank you for ordering!");
    }

    public static void processOrder() {
        int itemNum = getItemNumber();
        int itemQuantity = setQuantity();
        
        if (!checkIfValidInput(itemNum, itemQuantity)) { 
            reorder(); return; 
        }
        else {
            updateOrder(itemNum, itemQuantity);
        }

        boolean isStudent = checkIfStudent();

        float subTotal = getSubtotal(itemNum, itemQuantity);
        float discount = computeDiscount(subTotal);
        float orderTotal = computeOrderTotal(subTotal, discount);

        displayCurrentOrder(subTotal, discount, orderTotal);

        reorder();
    }

    public static void displayCurrentOrder(float subTotal, float discount, float orderTotal) {
        System.out.printf("Subtotal: $%.2f\n", subTotal);
        System.out.printf("Discount: $%.2f\n", discount);
        System.out.printf("Order total: $%.2f\n", orderTotal);
    }

    public static int getItemNumber() {
        System.out.print("Enter item number: ");
        return sc.nextInt();
    }

    public static int setQuantity() {
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        
        return quantity;
    }

    public static void updateOrder(int itemNum, int itemQuantity) {
        if (checkIfValidInput(itemNum, itemQuantity)) {
            totalItems += itemQuantity;
        }
    }

    public static boolean checkIfStudent() {
        // System.out.print("Are you a student? (Y/N): ");
        return isStudent = isYes("Are you a student? (Y/N): ");
    }

    public static boolean checkIfValidInput(int itemNum, int itemQuantity) {
        if (itemNum < 0 || itemNum > menuCount || itemQuantity < 1) {
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

    public static float getSubtotal(int itemNum, int itemQuantity) {
        float subTotal = menuPrice[itemNum-1] * itemQuantity;
        
        return subTotal;
    }

    public static float computeDiscount(float subTotal) {
        float discount;
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

    public static float computeOrderTotal(float subTotal, float discount) {
        float orderTotal = subTotal - discount;
        finalAmount += orderTotal;
        return orderTotal;
    }

    public static void main(String[] args) {
        displayMenu();
        processOrder();

        sc.close();
    }
}