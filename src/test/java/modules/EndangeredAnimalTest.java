package modules;

import modules.EndangeredAnimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class EndangeredAnimalTest {

    private static Connection conn;
    @BeforeAll
    public static void databaseOpens(){
        String connection = "jdbc:postgresql://localhost:5432/animals_test";
        Sql2o sql2o = new Sql2o(connection, "sirkadima", "kadima123");
        conn = sql2o.open();    }

    @AfterEach
    public void deletesDatabaseObjects() {
       EndangeredAnimal.clearAll();
    }
//
    @Test
    public void EndangeredAnimalClassExists(){
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("bat", "healthy", "young","Naks", "John");
        Assertions.assertEquals(true, endangeredAnimal instanceof EndangeredAnimal);
    }

//    @Test
//    public void EndangeredAnimalsAddedToArrayList(){
//        EndangeredAnimal.clearEndageredAnimals();
//        EndangeredAnimal endangeredAnimal1 = new EndangeredAnimal("Sheep", "healthy", "young","Eld", "John");
//        EndangeredAnimal endangeredAnimal2 = new EndangeredAnimal("Cow", "healthy", "young","Nai", "Snow");
//        Assertions.assertEquals(2, EndangeredAnimal.getEndangeredAnimals().size());
//
//    }

//    @Test
//    public void endangeredAnimalsInstantiatesWithAnIdOf1(){
//        EndangeredAnimal.clearEndageredAnimals();
//        EndangeredAnimal endangeredAnimal1 = new EndangeredAnimal("Sheep", "healthy", "young", "Kenya", "Ivar");
//        Assertions.assertEquals(1, endangeredAnimal1.getAnimalId());
//
//    }

//    @Test
//    public void dataSavedToTheDatabase(){
//        EndangeredAnimal endangeredAnimal1 = new EndangeredAnimal("Sheep", "healthy", "young", "Kenya", "Ivar");
//        endangeredAnimal1.save();
//        Assertions.assertEquals(true, EndangeredAnimal.getAll().get(0).equals(endangeredAnimal1));
//    }
}
