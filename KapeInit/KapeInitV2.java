// LABORATORY ACTIVITY 1 - OOP 101
// Item #4 | Coding Exercise: Canteen Ordering System
// Submitted By: John Calvin Samson

import java.util.Scanner;

class KapeInitV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalItems = 0;
        double totalPrice = 0;
        double totalDiscount = 0;
        double finalAmount = 0;
        boolean isStudent = false;

        String[] menuList = {
            "Espresso",
            "Cappuccino",
            "Matcha Latte",
            "Caramel Macchiato",
            "Green Tea",
            "Hot Chocolate",
            "Smoothie"
        };

        double[] menuPrice = {
            39.99,
            49.99,
            54.99,
            54.99,
            59.99,
            59.99,
            59.99
        };

        System.out.println("===============================");
        System.out.println("//****  K a p e I n i t  ****\\\\");
        System.out.println("-------------------------------");

        System.out.println("======      M E N U      ======");
        for (int i = 0; i < menuList.length; i++) {
            System.out.printf("%d. %-20s- $%.2f\n", i+1, menuList[i], menuPrice[i]);
        }
        System.out.println();
        
        while(true) {
            System.out.print("Enter item number: ");
            int itemNumber = sc.nextInt();
            sc.nextLine();
            
            System.out.print("Enter quantity: ");
            int itemQuantity = sc.nextInt();
            sc.nextLine();

            if (itemNumber < 1 || itemNumber > menuList.length || itemQuantity < 1) {
                System.out.println("\nInvalid Order! Please enter a valid item and quantity.\n");
                continue;
            }
            totalItems += itemQuantity;

            char userChoice;

            do {
                System.out.print("Are you a student? (Y/N): ");
                userChoice = sc.next().charAt(0);
                userChoice = Character.toUpperCase(userChoice);
            } while (userChoice != 'Y' && userChoice != 'N');

            if (userChoice == 'Y') isStudent = true;

            System.out.println();
            
            double subTotal = menuPrice[itemNumber-1] * itemQuantity;
            totalPrice += subTotal;

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

            double orderTotal = subTotal - discount;
            finalAmount += orderTotal;

            System.out.printf("Subtotal: $%.2f%n", subTotal);
            System.out.printf("Discount: $%.2f%n", discount);
            System.out.printf("Order total: $%.2f%n", orderTotal);

            do {
                System.out.print("\nDo you want to order again? (Y/N): ");
                userChoice = sc.next().charAt(0);
                userChoice = Character.toUpperCase(userChoice);
            } while (userChoice != 'Y' && userChoice != 'N');
            System.out.println();

            if (userChoice == 'Y') continue;
            else if (userChoice == 'N') break;
        }

        // Optional Loading Interface, 
        // purely for visual aesthetics (Just for Fun ^.^)
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

        System.out.println("Brewing your Coffee...\n");

        try {
            for (int i = 0; i < 8; i++) {
                if (i > 0) {
                    System.out.print("\033[6A"); // Move cursor up 6 lines 
                }

                for (String line : frames[i % frames.length].split("\n")) {
                    System.out.print("\033[2K"); // Clear current line
                    System.out.println(line);
                }  

                System.out.flush();
                Thread.sleep(500);
            }

            System.out.print("\033[6B\n"); // Move cursor down 6 lines 

        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("==== ORDER SUMMARY ====");
        System.out.printf("Total items: %d%n", totalItems);
        System.out.printf("Total before discount: $%.2f%n", totalPrice);
        System.out.printf("Total discount: $%.2f%n", totalDiscount);
        System.out.printf("Final Amount: $%.2f%n", finalAmount);
        System.out.println("Thank you for ordering!");
        
        sc.close();
    }
}