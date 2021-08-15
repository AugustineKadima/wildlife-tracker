package modules;

import java.util.ArrayList;
import java.util.Objects;

public class Animal{

    private int animalId;
    private String name;
    public static ArrayList<Animal> animals = new ArrayList<>();

    public Animal(String name) {
        this.name = name;
        animals.add(this);
        this.animalId = animals.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return animalId == animal.animalId && name.equals(animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalId, name);
    }

    public static void clearAnimals() {
        animals.clear();
    }

    public int getAnimalId() {
        return animalId;
    }
    public void setAnimalId(int animalId) {
        this.animalId = animalId;
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
