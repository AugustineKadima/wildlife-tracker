import modules.EndangeredAnimal;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

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

        post("/trackedAnimals",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String  animalName = request.queryParams("animalName");
            String  location = request.queryParams("location");
            String  health = request.queryParams("health");
            String  rangerName = request.queryParams("rangerName");
            EndangeredAnimal endangeredAnimal = new EndangeredAnimal(animalName, location, health, rangerName );
            List<EndangeredAnimal> animalObj = EndangeredAnimal.getEndangeredAnimals();
            model.put("animal", animalObj);
            return new ModelAndView(model, "/trackedAnimals.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
