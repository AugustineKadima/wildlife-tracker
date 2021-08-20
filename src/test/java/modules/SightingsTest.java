package modules;

import org.junit.jupiter.api.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SightingsTest {

    private static Connection conn;
    @BeforeAll
    public static void setUp() {
       String connection = "jdbc:postgresql://localhost:5432/animals_test";
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
    @Test
    public void instaceIsOfClass(){
        Sightings sightings = new Sightings("Komarok");
        Assertions.assertEquals(true, sightings instanceof Sightings);
    }

    @Test
    public void variablesAssignable(){
        Sightings sightings = new Sightings("Ololua");
        sightings.setName("Maasai mara");
        sightings.setId(1);
        Assertions.assertEquals("Maasai mara", sightings.getName());
        Assertions.assertEquals(1, sightings.getId());
    }

    @Test
    public void nameIsSaved(){
        Sightings sightings = new Sightings("Henry");
        sightings.save();
        assertEquals(Sightings.getAll().get(0).getName(), sightings.getName());
    }


}
