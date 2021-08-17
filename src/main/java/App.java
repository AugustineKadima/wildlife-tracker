import modules.EndangeredAnimal;
import modules.Sightings;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
//        port(getHerokuAssignedPort());
//        String connectionString = "jdbc:postgresql://localhost:5432/animal_tracker";
//        Sql2o sql2o = new Sql2o(connectionString, "sirkadima", "kadima123");

        String connectionString = "postgres://equcrtjgiuqdnv:32f74a1ac27fbb9c978d62c9a7c484c30afa3f53820c4eef732b56b219c65d6e@ec2-52-203-74-38.compute-1.amazonaws.com:5432/de32oaklddncai\n"; //!
        Sql2o sql2o = new Sql2o(connectionString, "\n" +
                "equcrtjgiuqdnv", "32f74a1ac27fbb9c978d62c9a7c484c30afa3f53820c4eef732b56b219c65d6e");

        staticFileLocation("/public");

        get("/", (request, response) ->{
            return new ModelAndView(new HashMap(), "layout.hbs");
        }, new HandlebarsTemplateEngine());

        get("/home.hbs", (request, response) ->{
            return new ModelAndView(new HashMap(), "home.hbs");
        }, new HandlebarsTemplateEngine());

        get("/trackedAnimals.hbs", (request, response) ->{
            return new ModelAndView(new HashMap(), "trackedAnimals.hbs");
        }, new HandlebarsTemplateEngine());

        get("/createNewAnimalTrackRecord.hbs", (request, response) ->{
            return new ModelAndView(new HashMap(), "createNewAnimalTrackRecord.hbs");
        }, new HandlebarsTemplateEngine());

        get("/home.hbs", (request, response) ->{
            return new ModelAndView(new HashMap(), "home.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings.hbs", (request, response) ->{
            return new ModelAndView(new HashMap(), "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        post("/trackedAnimals",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String  animalName = request.queryParams("name");
            String  location = request.queryParams("location");
            String  health = request.queryParams("health");
            String  rangerName = request.queryParams("rangerName");
            String  age = request.queryParams("age");
            EndangeredAnimal endangeredAnimal = new EndangeredAnimal(animalName, health, age, location, rangerName );
            endangeredAnimal.save();
            List<EndangeredAnimal> animalObj = EndangeredAnimal.getAll();
            model.put("animal", animalObj);
            return new ModelAndView(model, "/trackedAnimals.hbs");
        }, new HandlebarsTemplateEngine());


        post("/sightings", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            Sightings animal = new Sightings(name);
            animal.save();
            List<Sightings> siteObj = Sightings.getAll();
            model.put("sightings", siteObj);
            return new ModelAndView(model,"sightings.hbs");
        }, new HandlebarsTemplateEngine());




    }
}
