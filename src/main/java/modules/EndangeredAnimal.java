package modules;

import java.util.ArrayList;

public class EndangeredAnimal extends Animal{

    private int endangeredId;
    private String health;
    private String age;
    private String rangerName;
    public static ArrayList<EndangeredAnimal> endangeredAnimals = new ArrayList<>();


    public EndangeredAnimal(String name,String health, String age, String rangerName ) {
        super(name);
        this.health = health;
        this.age = age;
        this.rangerName = rangerName;
        endangeredAnimals.add(this);
        this.endangeredId = endangeredAnimals.size();

    }

    public static void clearEndageredAnimals() {
        endangeredAnimals.clear();
    }

    @Override
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
