package modules;

import java.util.ArrayList;

public class EndangeredAnimal{

    private int endangeredId;
    private String animalName;
    private String health;
    private String age;
    public String location;
    private String rangerName;
    public static ArrayList<EndangeredAnimal> endangeredAnimals = new ArrayList<>();


    public EndangeredAnimal(String animalName ,String health, String age, String location, String rangerName ) {

        this.animalName = animalName;
        this.location = location;
        this.health = health;
        this.age = age;
        this.rangerName = rangerName;
        endangeredAnimals.add(this);
        this.endangeredId = endangeredAnimals.size();

    }

    public static void clearEndageredAnimals() {
        endangeredAnimals.clear();
    }

    public int getAnimalId() {
        return endangeredId ;
    }

    public void setEndangeredId(int endangeredId) {
        this.endangeredId = endangeredId;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static ArrayList<EndangeredAnimal> getEndangeredAnimals() {
        return endangeredAnimals;
    }

    public void setEndangeredAnimals(ArrayList<EndangeredAnimal> endangeredAnimals) {
        this.endangeredAnimals = endangeredAnimals;
    }
}
