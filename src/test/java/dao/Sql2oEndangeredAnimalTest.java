//package dao;
//
//import modules.EndangeredAnimal;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.sql2o.Connection;
//import org.sql2o.Sql2o;
//
//public class Sql2oEndangeredAnimalTest {
//    private Connection con;
//    private EndangeredAnimal endangeredAnimal;
//
//    @BeforeAll
//    public void setUp() throws Exception {
//        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
//        Sql2o sql2o = new Sql2o(connectionString, "", "");
//        EndangeredAnimalDao = new Sql2oEndangeredDao(sql2o);
//
//        con = sql2o.open();
//    }
//
//    @AfterAll
//    public void tearDown() throws Exception {
//        con.close();
//    }
//}
