package modules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {

    @Test
    public void AnimalClassExists(){
        Animal animal = new Animal("Dog");
        Assertions.assertEquals(true, animal instanceof Animal);
    }

    @Test
    public void AnimalObjectsAreAddedToAnimalArrayList(){
        Animal animal1 = new Animal("Dog");
        Animal animal2 = new Animal("Cat");
        Animal animal3 = new Animal("Pig");
        Assertions.assertEquals(3, Animal.getAnimals().size());
    }

    @Test
    public void AnimalIdInstantiatesWithAValueOf1() throws Exception {
        Animal.clearAnimals();
        Animal animal = new Animal("Goat");
        Assertions.assertEquals(1, animal.getAnimalId());
    }
}
