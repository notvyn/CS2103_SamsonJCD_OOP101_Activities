package PetSimulator;

public class Pet {
    private String petName;
    private int hunger;
    private int energy;
    private int happiness;

    public Pet(String name) {
        this.petName = name;
        this.hunger = 30;
        this.energy = 30;
        this.happiness = 30; 
    }

    public String getName() {
        return this.petName;
    }

    private int limitStatus(int attribute) {
        return (attribute > 100) ? 100 : (attribute < 0) ? 0 : attribute;
    }

    private void normalizeStatus() {
        this.energy = limitStatus(energy);
        this.hunger = limitStatus(hunger);
        this.happiness = limitStatus(happiness);
    } 

    public void displayStatus() {
        System.out.println(getName());
        System.out.printf("> Happiness: %d%n", this.happiness);
        System.out.printf("> Energy: %d%n", this.energy);
        System.out.printf("> Hunger: %d%n", this.hunger);
    }

    public void eat() {
        if (this.hunger > 0) {
            System.out.println(getName() + " is eating. (-5 hunger)");
            this.hunger -= 5;
            this.energy += 5;
            this.happiness += 5;
            normalizeStatus();
        } else {
            System.out.println(getName() + " is full!");
        }
    } 
    
    public void sleep() {
        if (this.energy < 100) {
            System.out.println(getName() + " is sleeping. (+10 energy)");
            this.energy += 10;
            this.hunger += 5;
            normalizeStatus();
        } else {
            System.out.println(getName() + " cannot sleep anymore, let's play instead!"); 
        }
        
    }
    
    public void play() {
        if (this.energy > 0) {
            System.out.println(getName() + " is happily playing (+5 happiness & hunger, -5 energy)");
            this.energy -= 5;
            this.hunger += 5;
            this.happiness += 5;
            normalizeStatus();
        } else {
            System.out.println(getName() + " is too tired and unhappy. Let him take a sleep or feed him!");
        } 
    }

}