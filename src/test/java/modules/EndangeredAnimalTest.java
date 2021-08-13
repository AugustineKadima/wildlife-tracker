package modules;

import modules.EndangeredAnimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EndangeredAnimalTest {

    @Test
    public void EndangeredAnimalClassExists(){
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("bat", "healthy", "young");
        Assertions.assertEquals(true, endangeredAnimal instanceof EndangeredAnimal);
    }

    @Test
    public void EndangeredAnimalsAddedToArrayList(){
        EndangeredAnimal endangeredAnimal1 = new EndangeredAnimal("Sheep", "healthy", "young");
        EndangeredAnimal endangeredAnimal2 = new EndangeredAnimal("Cow", "healthy", "young");
        Assertions.assertEquals(2, EndangeredAnimal.getEndangeredAnimals().size());

    }

    @Test
    public void endangeredAnimalsInstantiatesWithAnIdOf1(){
        EndangeredAnimal.clearEndageredAnimals();
        EndangeredAnimal endangeredAnimal1 = new EndangeredAnimal("Sheep", "healthy", "young");
        Assertions.assertEquals(1, endangeredAnimal1.getAnimalId());

    }
}
