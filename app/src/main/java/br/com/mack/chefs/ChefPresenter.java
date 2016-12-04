package br.com.mack.chefs;

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

    @Inject
    public ChefPresenter(Retrofit retrofit, ChefContract.View mView){
        this.retrofit = retrofit;
        this.mView = mView;
    }

    @Override
    public void loadChefs() {
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
                        mView.showChefs(chefs);

                    }
                });
    }
}
