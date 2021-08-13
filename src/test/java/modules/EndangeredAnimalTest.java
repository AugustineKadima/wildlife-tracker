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
}
