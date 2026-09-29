package PetSimulator;

import PetSimulator.ConsoleUI;
import PetSimulator.Pet;
import PetSimulator.SaveManager;
import java.util.Scanner;

public class Game {
    private Scanner sc = new Scanner(System.in); 
    
    private ConsoleUI ui = new ConsoleUI();
    private Pet playerPet = SaveManager.loadPet();

    public void runProgramFlow() {
        if (playerPet == null) {
            getPet();
        } else {
            System.out.println("Welcome back! " + playerPet.getName() + " missed you TT\n");
        }
        
        
        do {
            playerPet.displayStatus();
            ui.drawLine();
            System.out.println("Spend time with your pet duck");
            ui.displayPetInterface();
            int userChoice = ui.getUserChoice();
            
            if (userChoice == 4) {
                System.out.println("\nSaving...");
                System.out.println("Take Care! " + playerPet.getName() + " will wait for your return ;>");
                SaveManager.savePet(playerPet);
                return;
            }
            
            processUserChoice(userChoice);
            
        } while (true);
    }

    public void processUserChoice(int choice) {
        switch (choice) {
            case 1:
                playerPet.eat();
                System.out.println();
                break;
            case 2:
                playerPet.play();
                System.out.println();
                break;
            case 3:
                playerPet.sleep();
                System.out.println();
                break;
        }
    }

    public void getPet() {
        ui.displayHeader("Welcome to Pet Duck Simulator!");
        System.out.print("Enter the name of your duck: ");
        playerPet = new Pet(sc.nextLine());

        System.out.println();
        System.out.println("Say hello to your new pet duck, " + playerPet.getName() + "!");
        System.out.println("Take good care of him, Okay? ^v^ \n");
    }

}
