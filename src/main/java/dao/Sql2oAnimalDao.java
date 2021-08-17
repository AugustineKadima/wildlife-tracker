//package dao;
//
//import modules.Animal;
//import org.sql2o.Connection;
//import org.sql2o.Sql2o;
//import org.sql2o.Sql2oException;
//
//import java.util.List;
//
//public class Sql2oAnimalDao implements AnimalDao {
//
//    private Sql2o sql2o;
//
//    public void Sql2oReviewDao(Sql2o sql2o) {
//        this.sql2o = sql2o;
//    }
//
//    @Override
//    public void add(Animal animal) {
//        String sql = "INSERT INTO animals (animalName) VALUES (:animalName)"; //if you change your model, be sure to update here as well!
//        try (Connection con = sql2o.open()) {
//            int id = (int) con.createQuery(sql, true)
//                    .bind(animal)
//                    .executeUpdate()
//                    .getKey();
//            animal.setAnimalId(id);
//        } catch (Sql2oException ex) {
//            System.out.println(ex);
//        }
//    }
//
//    @Override
//    public List<Animal> getAll() {
//        try (Connection con = sql2o.open()) {
//            return con.createQuery("SELECT * FROM animals")
//                    .executeAndFetch(Animal.class);
//        }
//
//
//    }
//
//    @Override
//    public void update(int id, String animalName) {
//
//    }
//
//    @Override
//    public void deleteById(int id) {
//        String sql = "DELETE from animals WHERE id=:id";
//        try (Connection con = sql2o.open()) {
//            con.createQuery(sql)
//                    .addParameter("id", id)
//                    .executeUpdate();
//        } catch (Sql2oException ex) {
//            System.out.println(ex);
//        }
//    }
//
//    @Override
//    public void clearAll() {
//        String sql = "DELETE from animals";
//        try (Connection con = sql2o.open()) {
//            con.createQuery(sql).executeUpdate();
//        } catch (Sql2oException ex) {
//            System.out.println(ex);
//        }
//    }
//}