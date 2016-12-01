package br.com.mack.api;

import java.util.List;

import br.com.mack.valueobjects.Chef;
import br.com.mack.valueobjects.Concept;
import br.com.mack.valueobjects.Recipe;
import br.com.mack.valueobjects.Restaurant;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by matheus on 01/12/16.
 */

public interface MackApiInterfaces {

//    =======CONCEPTS======
    @GET("/webservices/concepts/getConcepts")
    Call<List<Concept>> getConcepts();

    @GET("/webservices/concepts/getChefsByConcept")
    Call<List<Chef>> getChefsByConcept(
            @Query("concept_id") String conceptId
    );

    @GET("/webservices/concepts/getRestaurantsByConcept")
    Call<List<Restaurant>> getRestaurantsByConcept(
            @Query("concept_id") String conceptId
    );

    @GET("/webservices/concepts/getRecipesByConcept")
    Call<List<Recipe>> getRecipesByConcept(
            @Query("concept_id") String conceptId
    );
//    =====================

//    =======RECIPES=======
    @GET("/webservices/recipes/getRecipes")
    Call<List<Recipe>> getRecipe();

    @GET("/webservices/recipes/findRecipe")
    Call<Recipe> getRecipeById(
            @Query("recipe_id")String recipeId
    );
//    =====================

//    =====RESTAURANTS=====
    @GET("/webservices/restaurants/getRestaurants")
    Call<List<Restaurant>> getRestaurants();

    @GET("/webservices/restaurants/findRestaurant")
    Call<Restaurant> getRestaurantById(
            @Query("restaurant_id")String restaurantId
    );
//    =====================

//    ========USERS========
    @GET("/webservices/users/getChefs")
    Call<List<Restaurant>> getChefs();

    @GET("/webservices/users/getStudents")
    Call<List<Restaurant>> getStudents();

    @GET("/webservices/users/getDevelopers")
    Call<List<Restaurant>> getDevelopers();
//    =====================




}
