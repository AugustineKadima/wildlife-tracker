package modules;

import org.junit.jupiter.api.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SightingsTest {

    private static Connection conn;
    @BeforeAll
    public static void setUp() {
       String connection = "jdbc:postgresql://localhost:5432/animal_tracker_test";
       DB.sql2o = new Sql2o(connection, "sirkadima", "kadima123");


    }

    @AfterEach
    public void tearDown() {
        String sql = "DELETE FROM sightings *;";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        }

    }
//

//    @Test
//    public void nameIsSaved(){
//        Sightings sightings = new Sightings("Henry");
//        sightings.save();
//        assertEquals(Sightings.getAll().get(0).getName(), sightings.getName());
//    }

//    @Test
//    public void all_returnsAllInstancesOfName_true() {
//        Sightings site= new Sightings("Henry");
//        site.save();
//        Sightings site2 = new Sightings("Harriet");
//        site2.save();
//        assertEquals(true, Sightings.getAll().get(0).equals(site));
//        assertEquals(true, Sightings.getAll().get(1).equals(site2));
//    }
}
