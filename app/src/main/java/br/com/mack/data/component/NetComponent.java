package br.com.mack.data.component;

import android.content.SharedPreferences;

import javax.inject.Singleton;

import br.com.mack.data.module.AppModule;
import br.com.mack.data.module.NetModule;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Amor on 02/12/2016.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
    SharedPreferences sharedPreferences();
}
