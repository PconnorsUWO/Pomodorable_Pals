package frontend;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import backend.*;
public class Testing {
    private Pet pet;
        public Testing(String petName) {
            this.pet = loadPetData(petName);
        }
        public Pet loadPetData(String petName) {
        try (BufferedReader br = new BufferedReader(new FileReader("../data_handling/pets_data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields[0].equals(petName)) {
                    // Extract pet data from the CSV line
                    String name = fields[0];
                    int type = Integer.parseInt(fields[1]);
                    int health = Integer.parseInt(fields[2]);
                    int sleep = Integer.parseInt(fields[3]);
                    int fullness = Integer.parseInt(fields[4]);
                    int happiness = Integer.parseInt(fields[5]);
                    int sleepEffectiveness = Integer.parseInt(fields[6]);
                    int playEffectiveness = Integer.parseInt(fields[7]);


                    Pet pet = new Pet(name, type, sleepEffectiveness, playEffectiveness);
                    pet.setHealth(health);
                    pet.setSleep(sleep);
                    pet.setFullness(fullness);
                    pet.setHappiness(happiness);
                    return pet;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;  
    }  
    public static void main(String[] args) {
        Testing test = new Testing("Buddy");
        System.out.println(test.pet.getName());
    }
}   
