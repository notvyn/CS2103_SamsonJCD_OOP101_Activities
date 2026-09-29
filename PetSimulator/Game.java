package PetSimulator;

import PetSimulator.ConsoleUI;
import PetSimulator.Pet;
import java.util.Scanner;

public class Game {
    private Scanner sc = new Scanner(System.in); 
    
    private ConsoleUI ui = new ConsoleUI();
    private Pet pet;

    public void runProgramFlow() {
        getPet();
        
        do {
            pet.displayStatus();
            ui.drawLine();
            System.out.println("Interact with your pet duck OvO");
            ui.displayPetInterface();
            int userChoice = ui.getUserChoice();
            
            if (userChoice == 5) {
                System.out.println("\nSaving...");
                System.out.println("Take Care! " + pet.getName() + " will wait for your return ;>");
                return;
            }
            
            processUserChoice(userChoice);
            
        } while (true);
    }

    public void processUserChoice(int choice) {
        switch (choice) {
            case 1:
                pet.eat();
                System.out.println();
                break;
            case 2:
                pet.play();
                System.out.println();
                break;
            case 3:
                pet.sleep();
                System.out.println();
                break;
            default:


        }
    }

    public void getPet() {
        ui.displayHeader("Welcome to Pet Duck Simulator!");
        System.out.print("Enter the name of your duck: ");
        pet = new Pet(sc.nextLine());

        System.out.println();
        System.out.println("Say hello to your new pet duck, " + pet.getName() + "!");
        System.out.println("Take good care of him, Okay? ^v^ \n");
    }

}
