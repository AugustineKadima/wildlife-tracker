package modules;

import modules.EndangeredAnimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class EndangeredAnimalTest {

    @BeforeAll
    public static void databaseOpens(){
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/animal_tracker_test", "sirkadima", "kadima123");
    }

    @AfterEach
    public void deletesDatabaseObjects() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM animals *";
            con.createQuery(sql).executeUpdate();
        }
    }

    @Test
    public void EndangeredAnimalClassExists(){
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("bat", "healthy", "young","Naks", "John");
        Assertions.assertEquals(true, endangeredAnimal instanceof EndangeredAnimal);
    }

    @Test
    public void EndangeredAnimalsAddedToArrayList(){
        EndangeredAnimal.clearEndageredAnimals();
        EndangeredAnimal endangeredAnimal1 = new EndangeredAnimal("Sheep", "healthy", "young","Eld", "John");
        EndangeredAnimal endangeredAnimal2 = new EndangeredAnimal("Cow", "healthy", "young","Nai", "Snow");
        Assertions.assertEquals(2, EndangeredAnimal.getEndangeredAnimals().size());

    }

    @Test
    public void endangeredAnimalsInstantiatesWithAnIdOf1(){
        EndangeredAnimal.clearEndageredAnimals();
        EndangeredAnimal endangeredAnimal1 = new EndangeredAnimal("Sheep", "healthy", "young", "Kenya", "Ivar");
        Assertions.assertEquals(1, endangeredAnimal1.getAnimalId());

    }

    @Test
    public void dataSavedToTheDatabase(){
        EndangeredAnimal endangeredAnimal1 = new EndangeredAnimal("Sheep", "healthy", "young", "Kenya", "Ivar");
        endangeredAnimal1.save();
        Assertions.assertEquals(true, EndangeredAnimal.getAll().get(0).equals(endangeredAnimal1));
    }
}
