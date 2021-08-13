package modules;

import modules.Animal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {

    @Test
    public void AnimalClassExists(){
        Animal animal = new Animal("Dog");
        Assertions.assertEquals(true, animal instanceof Animal);
    }
}
