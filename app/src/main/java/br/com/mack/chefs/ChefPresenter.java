package br.com.mack.chefs;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import br.com.mack.data.api.MackApiInterfaces;
import br.com.mack.valueobjects.Chef;
import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Amor on 03/12/2016.
 */

public class ChefPresenter implements ChefContract.Presenter{

    private Retrofit retrofit;
    private ChefContract.View mView;
    private SharedPreferences preferences;
    private Gson gson;

    @Inject
    public ChefPresenter(Retrofit retrofit, ChefContract.View mView,SharedPreferences preferences){
        this.retrofit = retrofit;
        this.mView = mView;
        this.preferences = preferences;
        this.gson = new Gson();

    }

    @Override
    public void loadChefs() {
        if(preferences.contains("Chefs")){
            String json = preferences.getString("Chefs","");
            Type listType = new TypeToken<ArrayList<Chef>>(){}.getType();
            List<Chef> chefs = gson.fromJson(json, listType);

            mView.showChefs(chefs);
        }else
        retrofit.create(MackApiInterfaces.class).getChefs().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Chef>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Chef> chefs) {
                        Collections.sort(chefs, new ChefComparator());
                        String json = gson.toJson(chefs);
                        preferences.edit().putString("Chefs",json).apply();

                        mView.showChefs(chefs);

                    }
                });
    }

    @Override
    public void refreshChefs() {
        retrofit.create(MackApiInterfaces.class).getChefs().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Chef>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Chef> chefs) {
                        Collections.sort(chefs, new ChefComparator());
                        String json = gson.toJson(chefs);
                        preferences.edit().putString("Chefs",json).apply();;
                        mView.showChefs(chefs);

                    }
                });
    }

    private class ChefComparator implements Comparator<Chef>{

        @Override
        public int compare(Chef chef, Chef t1) {
            return chef.getName().compareTo(t1.getName());
        }
    }
}
