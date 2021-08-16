package dao;

import modules.EndangeredAnimal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oEndangeredAnimal implements EndangeredAnimalDao {

    private Sql2o sql2o;

    public void Sql2oEndangeredAnimalDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(EndangeredAnimal endangeredAnimal) {
        String sql = "INSERT INTO animals (endangeredId, animalName, health, age, location, rangerName) VALUES (:endangeredId, :animalName, :health, :age, :location, :rangerName )"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(endangeredAnimal)
                    .executeUpdate()
                    .getKey();
            endangeredAnimal.setEndangeredId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<EndangeredAnimal> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM endangered_animals")
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }

    @Override
    public void update(int id, String animalName, String health, String age, String location, String rangerName) {

    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from endangered_animals WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from endangered_animals";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
