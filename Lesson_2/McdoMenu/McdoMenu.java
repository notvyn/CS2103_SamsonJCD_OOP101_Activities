import java.util.Scanner;

class McdoMenu {
    private static Scanner sc = new Scanner(System.in);

    private static int menuCount = 5;
    
    private static int totalItems = 0;
    private static boolean isStudent = false;

    public static void displayMenu() {
        System.out.println("====  W E L C O M E T O M C D O N A L D S   ====");
        System.out.println("====      T o d a y ' s    M e n u          ====");

        String[] menuList = {"1-pc Chicken McDo Solo", "Crispy Chicken Fillet", "Big Mac", "McSpaghetti", "World Famous Fries", "Iced Coffee", "Sundae & McFlurry"};

        float[] menuPrice = {2.22f, 2.61f, 4.73f, 2.27f, 2.18f, 1.68f, 2.31f};

        for (int i = 0; i < menuCount; i++ ) {
            System.out.printf("%d. %-35s - $%.2f\n", i+1, menuList[i], menuPrice[i]);
        }
    }

    public static void reorder() {
        char answer;

        do {
            System.out.print("Do you want to order again? (Y/N): ");
            answer = sc.next().charAt(0);
            Character.toUpperCase(answer);

            if (answer == 'Y') {
                processOrder();
            } 
            else if (answer == 'N') {
                displayOrderSummary();
            }
        } while (answer != 'Y' && answer != 'N');
    }

    public static void displayOrderSummary() {
        System.out.println("==== ORDER SUMMARY ====");
        System.out.println("Total Items: %");
        System.out.println("Total before discount: %");
        System.out.println("Total discount: %");
        System.out.println("Final amount: %");
        System.out.println("Thank you for ordering!");
    }

    public static float processDiscount() {}
    public static float computeFinalAmount() {}


    public static void displayOrderPrice() {
        System.out.printf("Subtotal: $\n");
        System.out.printf("Discount: $\n");
        System.out.printf("Order total: $\n");
    }

    public static void processOrder() {
        int itemNum = getItemNumber();
        int itemQuantity = setQuantity();
        isStudent = checkIfStudent() ? true : false;

        System.out.println(itemNum);
        System.out.println(itemQuantity);
        System.out.println(isStudent);
    }

    public static int getItemNumber() {
        System.out.print("Enter item number: ");
        int itemNum = sc.nextInt();
        sc.nextLine();

        return itemNum;
    }

    public static int setQuantity() {
        System.out.print("Enter quantity: ");
        int itemQuantity = sc.nextInt();
        sc.nextLine();
        return itemQuantity;
    }

    // Add Validation 
    public static boolean checkIfStudent() {
        System.out.print("Are you a student? (Y/N): ");
        char answer;

        do {
            answer = sc.next().charAt(0);
            Character.toUpperCase(answer);

        } while (answer != 'Y' && answer != 'N');

        if (answer == 'Y') {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        displayMenu();
        processOrder();
    }
}