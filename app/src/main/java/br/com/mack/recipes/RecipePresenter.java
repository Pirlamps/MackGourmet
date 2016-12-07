package br.com.mack.recipes;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.mack.data.api.MackApiInterfaces;
import br.com.mack.valueobjects.Recipe;
import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Amor on 03/12/2016.
 */

public class RecipePresenter implements RecipeContract.Presenter {

    private Retrofit retrofit;
    private RecipeContract.View mView;
    private SharedPreferences preferences;
    private Gson gson;

    @Inject
    public RecipePresenter(Retrofit retrofit, RecipeContract.View mView,SharedPreferences preferences){
        this.retrofit = retrofit;
        this.mView = mView;
        this.preferences = preferences;
        this.gson = new Gson();
    }


    @Override
    public void loadRecipes() {
        if(preferences.contains("Recipes")){
            String json = preferences.getString("Recipes","");
            Type listType = new TypeToken<ArrayList<Recipe>>(){}.getType();
            List<Recipe> recipes = gson.fromJson(json, listType);

            mView.showRecipes(recipes);
        }else
        retrofit.create(MackApiInterfaces.class).getRecipes().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Recipe>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Recipe> recipes) {
                        String json = gson.toJson(recipes);
                        preferences.edit().putString("Recipes",json).apply();;
                        mView.showRecipes(recipes);
                    }
                });
    }

    @Override
    public void refreshRecipes() {
        retrofit.create(MackApiInterfaces.class).getRecipes().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Recipe>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Recipe> recipes) {
                        String json = gson.toJson(recipes);
                        preferences.edit().putString("Recipes",json).apply();;
                        mView.showRecipes(recipes);
                    }
                });
    }


}
