package modules;

import org.junit.jupiter.api.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SightingsTest {

    private static Connection conn;
    @BeforeEach
    public void setUp() {
        String connection = "jdbc:postgresql://localhost:5432/sightings_test";
        Sql2o sql2o = new Sql2o(connection, "sirkadima", "kadima123");
        conn = sql2o.open();
    }

    @AfterEach
    public void tearDown() {
       Sightings.clearAll();
    }


//    @Test
//    public void save_insertsObjectIntoDatabase_Person() {
//        Sightings sightings = new Sightings("Henry");
//        sightings.save();
//        Assertions.assertTrue(Sightings.getAll().get(0).equals(sightings));
//    }

    @Test
    public void nameIsSaved(){
        Sightings sightings = new Sightings("Henry");
        sightings.save();
        assertEquals("Henry",sightings.getName());
    }

    @Test
    public void all_returnsAllInstancesOfPerson_true() {
        Sightings site= new Sightings("Henry");
        site.save();
        Sightings site2 = new Sightings("Harriet");
        site2.save();
        assertEquals(true, Sightings.getAll().get(0).equals(site));
        assertEquals(true, Sightings.getAll().get(1).equals(site2));
    }
}
