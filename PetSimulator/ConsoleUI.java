package PetSimulator;

import java.util.Scanner;

public class ConsoleUI {
    private Scanner sc = new Scanner(System.in);

    public int getUserChoice() {
        System.out.print("Enter Interaction: ");
        return sc.nextInt();
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
