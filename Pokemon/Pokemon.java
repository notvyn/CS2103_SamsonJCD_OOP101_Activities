/* Scenario:
You need to create a simple Java program to digitize a Pokémon trainer's team. You will model the core characteristics of a Pokémon and ensure their health points (HP) cannot be changed arbitrarily by outside forces.
*/

/* Requirements:
name (String)
dexNum (String) - e.g., "#0257"
level (int)
type1 (String)
type2 (String) - Can be null or empty if the Pokémon only has one type.
hp (int)
*/

/* Access modifier
private - for the class only 
public - use by other class/es
protected - restricted to family only
*/

import java.util.Scanner;

class Pokemon {
    // Attributes
    // Syntax: modifier dataType varName = value; 
    private String name;
    private String dexNum;
    private int level;
    private String type1;
    private String type2;
    private int hp;

    public static void main(String[] args) {
        // className varName = new Pokemon();
        // Pokemon pikachu = new Pokemon(); // create instance of Pokemon

        // pikachu.name = "Pikachu";
        // pikachu.dexNum = "#0025";
        // pikachu.level = 1;
        // pikachu.type1 = "Electric";
        // pikachu.hp = 200;

        // // print - no new line
        // // println - new line 
        // // printf - "%s", name
        // System.out.println("--- POKEMON ---");
        // System.out.println("name: " + pikachu.name);
        // System.out.println("dexNum: " + pikachu.dexNum);
        // System.out.printf("level: %d\n", pikachu.level);
        // System.out.println("Type: " + pikachu.type1); // Type: Electric 
        // System.out.print("Hp: " + pikachu.hp); // Hp: 200

        // Scanner input = new Scanner(System.in);

        // Pokemon pokemon1 = new Pokemon();

        // System.out.println("Enter your Pokemon:");
        
        // System.out.print("Name: ");
        // pokemon1.name = input.nextLine();
        // System.out.print("dexNum: ");
        // pokemon1.dexNum = input.nextLine();
        // System.out.print("level: ");
        // pokemon1.level = input.nextInt();
        // input.nextLine();
        // System.out.print("Type 1: ");
        // pokemon1.type1 = input.nextLine();
        // System.out.print("Type 2: ");
        // pokemon1.type2 = input.nextLine();
        // System.out.print("Hp: ");
        // pokemon1.hp = input.nextInt();
        // input.nextLine();

        // System.out.println("\n--- POKEMON ---");
        // System.out.println("name: " + pokemon1.name);
        // System.out.println("dexNum: " + pokemon1.dexNum);
        // System.out.printf("level: %d\n", pokemon1.level);
        // System.out.println("Type: " + pokemon1.type1); // Type: Electric 
        // System.out.print("Hp: " + pokemon1.hp); // Hp: 200

        Scanner heehee = new Scanner(System.in);
        Pokemon pokemon2 = new Pokemon();

        System.out.println("Enter your Pokemon:");
        System.out.print("Name: ");
        pokemon2.name = heehee.nextLine(); 
        System.out.print("DexNum: ");
        pokemon2.dexNum = heehee.nextLine(); 
        System.out.print("Level: ");
        pokemon2.level = heehee.nextInt(); // 1"\n", pokemon2.level = 1, "\n"
        heehee.nextLine(); 
        System.out.print("Type 1: ");
        pokemon2.type1 = heehee.nextLine();
        System.out.print("Type 2: ");
        pokemon2.type2 = heehee.nextLine(); 
        System.out.print("Hp: ");
        pokemon2.hp = heehee.nextInt();
        heehee.nextLine(); 

        System.out.println("\n--- POKEMON ---");
        System.out.println("name: " + pokemon2.name);
        System.out.println("dexNum: " + pokemon2.dexNum);
        System.out.printf("level: %d\n", pokemon2.level);
        System.out.println("Type: " + pokemon2.type1); // Type: Electric 
        System.out.print("Hp: " + pokemon2.hp); // Hp: 200

    }


}