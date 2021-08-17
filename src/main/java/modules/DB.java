package modules;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DB {
    public static String connection = "jdbc:postgresql://localhost:5432/animal_tracker";
    public static Sql2o sql2o = new Sql2o(connection, "sirkadima", "kadima123");


}
