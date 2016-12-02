package br.com.mack;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import br.com.mack.data.component.DaggerNetComponent;
import br.com.mack.data.component.NetComponent;
import br.com.mack.data.module.AppModule;
import br.com.mack.data.module.NetModule;
import io.fabric.sdk.android.Fabric;

/**
 * Created by Amor on 02/12/2016.
 */

public class App extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        this.mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://mackgourmet.com.br/"))
                .build();

    }

    public NetComponent getmNetComponent(){
        return this.mNetComponent;
    }
}

