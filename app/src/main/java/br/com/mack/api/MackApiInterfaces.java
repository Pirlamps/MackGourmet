package br.com.mack.api;

import java.util.List;

import br.com.mack.valueobjects.Concept;
import br.com.mack.valueobjects.Recipe;
import br.com.mack.valueobjects.Restaurant;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by matheus on 01/12/16.
 */

public interface MackApiInterfaces {

//    =======CONCEPTS======
    @GET("/webservices/concepts/getConcepts")
    Call<List<Concept>> getConcepts();
//    =====================

//    =======RECIPES=======
    @GET("/webservices/recipes/getRecipes")
    Call<List<Recipe>> getRecipe();
//    =====================

//    =====RESTAURANTS=====
    @GET("/webservices/restaurants/getRestaurants")
    Call<List<Restaurant>> getRestaurants();
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
