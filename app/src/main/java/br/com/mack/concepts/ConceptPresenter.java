package br.com.mack.concepts;

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

    @Inject
    public ConceptPresenter(Retrofit retrofit, ConceptContract.View mView){
        this.retrofit = retrofit;
        this.mView = mView;
    }

    @Override
    public void loadConcepts() {
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
                        mView.showConcepts(concepts);
                    }
                });
    }
}
