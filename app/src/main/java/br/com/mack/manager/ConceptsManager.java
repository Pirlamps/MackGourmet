package br.com.mack.manager;

import java.util.List;

import br.com.mack.api.MackApiInterfaces;
import br.com.mack.utils.ApiFactory;
import br.com.mack.utils.AppParameters;
import br.com.mack.valueobjects.Chef;
import br.com.mack.valueobjects.Concept;
import br.com.mack.valueobjects.Recipe;
import br.com.mack.valueobjects.Restaurant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by matheus on 01/12/16.
 */

public class ConceptsManager {

//    TODO DELEGATE PARA VOLTAR OS OBJETOS PARA ACTIVITY E DOCUMENTAÇÃO DOS MÉTODOS

    /**
     *
     */
    public void getConcepts() {

        Call<List<Concept>> restCall = ApiFactory.buildAPI().getConcepts();
        restCall.enqueue(new Callback<List<Concept>>() {
            @Override
            public void onResponse(Call<List<Concept>> call, Response<List<Concept>> response) {
                System.out.println(":D");
            }

            @Override
            public void onFailure(Call<List<Concept>> call, Throwable t) {
                System.out.println(":(");
            }
        });
    }

    /**
     *
     * @param conceptId
     */
    public void getChefsByConcept(String conceptId){

        Call<List<Chef>> restCall = ApiFactory.buildAPI().getChefsByConcept(conceptId);
        restCall.enqueue(new Callback<List<Chef>>() {
            @Override
            public void onResponse(Call<List<Chef>> call, Response<List<Chef>> response) {
                System.out.println(":D");
            }

            @Override
            public void onFailure(Call<List<Chef>> call, Throwable t) {
                System.out.println(":(");
            }
        });

    }

    /**
     *
     * @param conceptId
     */
    public void getRestaurantsByConcept(String conceptId){

        Call<List<Restaurant>> restCall = ApiFactory.buildAPI().getRestaurantsByConcept(conceptId);
        restCall.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                System.out.println(":D");
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                System.out.println(":(");
            }
        });
    }

    /**
     *
     * @param conceptId
     */
    public void getRecipesByConcept(String conceptId){

        Call<List<Recipe>> restCall = ApiFactory.buildAPI().getRecipesByConcept(conceptId);
        restCall.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                System.out.println(":D");
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                System.out.println(":(");
            }
        });
    }

}
