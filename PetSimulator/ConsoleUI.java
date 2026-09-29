package PetSimulator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
    private Scanner sc = new Scanner(System.in);

    public int getUserChoice() {
        while (true) {
            System.out.print("Choose an Interaction: ");
            String rawChoice = sc.nextLine();
            
            try {
                int choice = Integer.parseInt(rawChoice);

                if (choice >= 1 && choice <= 4) {
                    return choice;
                } 

                System.out.println("Please choose a number from 1 to 4.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input. Please enter a number.");
            }
        }
    }

    public void displayHeader(String message) {
        drawLine();
        System.out.println(message);
        drawLine();
        System.out.println();
    }

    public void displayPetInterface() {
        System.out.println("[1] Feed");
        System.out.println("[2] Play");
        System.out.println("[3] Sleep");
        System.out.println("[4] Quit & Save");
    }

    public void drawLine() {
        for (int i = 0; i < 30; i++ ) { 
            System.out.print("=");
        }
        System.out.println();
    }

    //  ( O)>
    // ( b )
    //  / \
}
