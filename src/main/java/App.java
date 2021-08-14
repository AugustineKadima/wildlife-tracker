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

        get("/normalAnimal.hbs", (request, response) ->{
            return new ModelAndView(new HashMap(), "normalAnimal.hbs");
        }, new HandlebarsTemplateEngine());

        get("/endangeredAnimal.hbs", (request, response) ->{
            return new ModelAndView(new HashMap(), "endangeredAnimal.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
