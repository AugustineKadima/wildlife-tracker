package dao;

import modules.EndangeredAnimal;

import java.util.List;


public interface EndangeredAnimalDao {
    //create
    void add(EndangeredAnimalDao endangeredAnimalAnimal);
    //void addFoodtypeToRestaurant(Foodtype foodtype, Restaurant restaurant);

    //read
    List<EndangeredAnimalDao> getAll();
    // List<Restaurant> getAllRestaurantsForAFoodtype(int id);


    //update
    void update(int id, String animalName ,String health, String age, String location, String rangerName);

    //delete
    void deleteById(int id);
    void clearAll();
}
