package PetSimulator;

import java.io.*;

public class SaveManager {
    private static final String SAVE_FILE = "pet_save.dat";

    public static void savePet(Pet pet) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            oos.writeObject(pet);
        } catch (IOException e) {
            System.err.println("Failed saving pet data.");
        }
    }

    public static Pet loadPet() {
        File file = new File(SAVE_FILE);

        if (!file.exists()) {
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
            Pet loadedPet = (Pet) ois.readObject();
            return loadedPet;
        } catch (IOException e) {
            System.err.println("Save File not Found.");
            return null;
        } catch (ClassNotFoundException e) {
            System.err.println("Class Pet not Found.");
            return null;
        }
    }
}
