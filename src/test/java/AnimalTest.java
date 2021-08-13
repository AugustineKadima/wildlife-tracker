import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {

    @Test
    public void AnimalClassExists(){
        Animal animal = new Animal();
        Assertions.assertEquals(true, animal instanceof Animal);
    }
}
