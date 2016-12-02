package br.com.mack.manager;

import java.util.List;

import br.com.mack.utils.ApiFactory;
import br.com.mack.valueobjects.Restaurant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Amor on 01/12/2016.
 */

public class RestaurantsManager{

    //    TODO DELEGATE PARA VOLTAR OS OBJETOS PARA ACTIVITY E DOCUMENTAÇÃO DOS MÉTODOS

    /**
     *
     */
    public void getRestaurants(){

        Call<List<Restaurant>> restCall = ApiFactory.buildAPI().getRestaurants();
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
     * @param restaurantId
     */
    public void getRestaurantById(String restaurantId){
        Call<List<Restaurant>> restCall = ApiFactory.buildAPI().getRestaurantsByConcept(restaurantId);
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

}
