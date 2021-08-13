package modules;

import java.util.ArrayList;

public class EndangeredAnimal extends Animal{

    private int id;
    private String health;
    private String age;
    public static ArrayList<EndangeredAnimal> endangeredAnimals = new ArrayList<>();


    public EndangeredAnimal(String name,String health, String age) {
        super(name);
        this.health = health;
        this.age = age;
        this.id = id;
    }

    @Override
    public int getId() {
        return endangeredAnimals.size();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
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
