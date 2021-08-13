package modules;

import java.util.ArrayList;

public class EndangeredAnimal extends Animal{

    private int id;
    private String health;
    private String age;
    public ArrayList<EndangeredAnimal> endangeredAnimals = new ArrayList<>();


    public EndangeredAnimal(String name,String health, String age) {
        super(name);
        this.health = health;
        this.age = age;
        this.id = endangeredAnimals.getSize();
    }

}
