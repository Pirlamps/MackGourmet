package br.com.mack.utils;

import br.com.mack.api.MackApiInterfaces;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Amor on 01/12/2016.
 */

public class ApiFactory {

    private static MackApiInterfaces apiInterface;

    public static MackApiInterfaces buildAPI(){
        if(apiInterface == null) {
            Retrofit adapter = new Retrofit.Builder().baseUrl(AppParameters.URL_API_MACKGOURMET).addConverterFactory(GsonConverterFactory.create()).build();
            apiInterface = adapter.create(MackApiInterfaces.class);
        }
        return apiInterface;
    }
}
