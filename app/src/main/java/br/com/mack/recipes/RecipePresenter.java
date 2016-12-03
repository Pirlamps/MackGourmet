package br.com.mack.recipes;

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

    @Inject
    public RecipePresenter(Retrofit retrofit, RecipeContract.View mView){
        this.retrofit = retrofit;
        this.mView = mView;
    }


    @Override
    public void loadRecipes() {
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
                        mView.showRecipes(recipes);
                    }
                });
    }
}
