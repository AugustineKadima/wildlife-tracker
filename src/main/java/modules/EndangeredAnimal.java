package modules;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EndangeredAnimal{

    private int id;
    private String name;
    private String health;
    private String age;
    public String location;
    private String rangerName;
    public static ArrayList<EndangeredAnimal> endangeredAnimals = new ArrayList<>();


    public EndangeredAnimal(String name ,String health, String age, String location, String rangerName ) {


        this.name = name;
        this.location = location;
        this.health = health;
        this.age = age;
        this.rangerName = rangerName;
        endangeredAnimals.add(this);
        this.id = endangeredAnimals.size();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndangeredAnimal that = (EndangeredAnimal) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(health, that.health) && Objects.equals(age, that.age) && Objects.equals(location, that.location) && Objects.equals(rangerName, that.rangerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, health, age, location, rangerName);
    }

    public static void clearEndageredAnimals() {
        endangeredAnimals.clear();
    }

    public int getAnimalId() {
        return id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals(name, health, age, location, rangerName) VALUES (:name, :health, :age, :location, :rangername );";
            con.createQuery(sql)
                    .addParameter("name", this.name)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .addParameter("location", this.location)
                    .addParameter("rangername", this.rangerName)
                    .executeUpdate();
        }
        catch (Sql2oException error){
            System.out.println("There was an error: " + error);
        }
    }
    public static List<EndangeredAnimal> getAll(){
        try(Connection con  = DB.sql2o.open()){
            String sql = "SELECT * FROM animals;";
            return con.createQuery(sql).executeAndFetch(EndangeredAnimal.class);
        }
    }
}
