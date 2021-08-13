package modules;

import java.util.ArrayList;

public class Animal{

    private int animalId;
    private String name;
    public static ArrayList<Animal> animals = new ArrayList<>();

    public Animal(String name) {
        this.animalId = animals.size();
        this.name = name;
        animals.add(this);
    }

    public int getAnimalId() {
        return animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ArrayList<Animal> getAnimals() {
        return animals;
    }

    public static void setAnimals(ArrayList<Animal> animals) {
        Animal.animals = animals;
    }
}
