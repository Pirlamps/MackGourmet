//package br.com.mack.data.manager;
//
//import java.util.List;
//
//import br.com.mack.utils.ApiFactory;
//import br.com.mack.valueobjects.Recipe;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
///**
// * Created by Amor on 01/12/2016.
// */
//
//public class RecipesManager {
//
////    TODO DELEGATE PARA VOLTAR OS OBJETOS PARA ACTIVITY E DOCUMENTAÇÃO DOS MÉTODOS
//
//    /**
//     *
//     */
//    public void getRecipes(){
//
//            Call<List<Recipe>> restCall = ApiFactory.buildAPI().getRecipes();
//            restCall.enqueue(new Callback<List<Recipe>>() {
//                @Override
//                public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
//                    System.out.println(":D");
//                }
//
//                @Override
//                public void onFailure(Call<List<Recipe>> call, Throwable t) {
//                    System.out.println(":(");
//                }
//            });
//
//        }
//
//    /**
//     *
//     * @param recipeId
//     */
//    public void getRecipeById(String recipeId){
//
//            Call<Recipe> restCall = ApiFactory.buildAPI().getRecipeById(recipeId);
//            restCall.enqueue(new Callback<Recipe>() {
//                @Override
//                public void onResponse(Call<Recipe> call, Response<Recipe> response) {
//                    System.out.println(":D");
//                }
//
//                @Override
//                public void onFailure(Call<Recipe> call, Throwable t) {
//                    System.out.println(":(");
//                }
//            });
//        }
//
//    /**
//     *
//     * @param conceptId
//     */
//    public void getRecipesByConcept(String conceptId){
//
//        Call<List<Recipe>> restCall = ApiFactory.buildAPI().getRecipesByConcept(conceptId);
//        restCall.enqueue(new Callback<List<Recipe>>() {
//            @Override
//            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
//                System.out.println(":D");
//            }
//
//            @Override
//            public void onFailure(Call<List<Recipe>> call, Throwable t) {
//                System.out.println(":(");
//            }
//        });
//    }
//}
