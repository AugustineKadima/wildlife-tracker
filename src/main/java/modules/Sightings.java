package modules;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.Objects;

public class Sightings {
    private int id;
    private String name;

    public Sightings(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sightings sightings = (Sightings) o;
        return id == sightings.id && name.equals(sightings.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings(name) VALUES (:name);";
            con.createQuery(sql)
                    .addParameter("name", name)
                    .executeUpdate();
        } catch (Sql2oException error) {
            System.out.println("There was an error: " + error);
        }
    }

    public static List<Sightings> getAll(){
        try(Connection con  = DB.sql2o.open()){
            String sql = "SELECT * FROM sightings;";
            return con.createQuery(sql).executeAndFetch(Sightings.class);
        }
    }

    public static void clearAll(){
        String sql = "DELETE FROM sightings *;";
        try (Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ey) {
            System.out.println(ey);
        }
    }
    }

