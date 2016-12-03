package br.com.mack.data.api;

import java.util.List;

import br.com.mack.valueobjects.Chef;
import br.com.mack.valueobjects.Concept;
import br.com.mack.valueobjects.Developer;
import br.com.mack.valueobjects.Recipe;
import br.com.mack.valueobjects.Restaurant;
import br.com.mack.valueobjects.Student;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by matheus on 01/12/16.
 */

public interface MackApiInterfaces {

//    =======CONCEPTS======
    @GET("/webservices/concepts/getConcepts")
    Observable<List<Concept>> getConcepts();

    @GET("/webservices/concepts/getChefsByConcept")
    Observable<List<Chef>> getChefsByConcept(
            @Query("concept_id") String conceptId
    );

    @GET("/webservices/concepts/getRestaurantsByConcept")
    Observable<List<Restaurant>> getRestaurantsByConcept(
            @Query("concept_id") String conceptId
    );

    @GET("/webservices/concepts/getRecipesByConcept")
    Observable<List<Recipe>> getRecipesByConcept(
            @Query("concept_id") String conceptId
    );
//    =====================

//    =======RECIPES=======
    @GET("/webservices/recipes/getRecipes")
    Observable<List<Recipe>> getRecipes();

    @GET("/webservices/recipes/findRecipe")
    Observable<Recipe> getRecipeById(
            @Query("recipe_id")String recipeId
    );
//    =====================

//    =====RESTAURANTS=====
    @GET("/webservices/restaurants/getRestaurants")
    Observable<List<Restaurant>> getRestaurants();

    @GET("/webservices/restaurants/findRestaurant")
    Observable<Restaurant> getRestaurantById(
            @Query("restaurant_id")String restaurantId
    );
//    =====================

//    ========USERS========
    @GET("/webservices/users/getChefs")
    Observable<List<Chef>> getChefs();

    @GET("/webservices/users/getStudents")
    Observable<List<Student>> getStudents();

    @GET("/webservices/users/getDevelopers")
    Observable<List<Developer>> getDevelopers();
//    =====================




}
