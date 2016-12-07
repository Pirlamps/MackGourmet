package br.com.mack.concepts;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.mack.data.api.MackApiInterfaces;
import br.com.mack.valueobjects.Concept;
import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Amor on 03/12/2016.
 */

public class ConceptPresenter implements ConceptContract.Presenter{

    private Retrofit retrofit;
    private ConceptContract.View mView;
    private SharedPreferences preferences;
    private Gson gson;

    @Inject
    public ConceptPresenter(Retrofit retrofit, ConceptContract.View mView,SharedPreferences preferences){
        this.retrofit = retrofit;
        this.mView = mView;
        this.preferences = preferences;
        this.gson = new Gson();
    }

    @Override
    public void loadConcepts() {
        if(preferences.contains("Concepts")){
            String json = preferences.getString("Concepts","");
            Type listType = new TypeToken<ArrayList<Concept>>(){}.getType();
            List<Concept> concepts = gson.fromJson(json, listType);

            mView.showConcepts(concepts);
        }else
        retrofit.create(MackApiInterfaces.class).getConcepts().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Concept>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Concept> concepts) {
                        String json = gson.toJson(concepts);
                        preferences.edit().putString("Concepts",json).apply();
                        mView.showConcepts(concepts);
                    }
                });
    }

    @Override
    public void refreshConcepts() {
        retrofit.create(MackApiInterfaces.class).getConcepts().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Concept>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Concept> concepts) {
                        String json = gson.toJson(concepts);
                        preferences.edit().putString("Concepts",json).apply();
                        mView.showConcepts(concepts);
                    }
                });
    }
}
