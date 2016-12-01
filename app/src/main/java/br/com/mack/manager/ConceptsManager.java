package br.com.mack.manager;

import java.util.List;

import br.com.mack.api.MackApiInterfaces;
import br.com.mack.valueobjects.Concept;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by matheus on 01/12/16.
 */

public class ConceptsManager {

    public void productCall() {
//        Setando listener da chamada


//        Construção do retrofit2
        Retrofit adapter = new Retrofit.Builder().baseUrl("http://mackgourmet.com.br/").addConverterFactory(GsonConverterFactory.create()).build();
        MackApiInterfaces apiInterfaces = adapter.create(MackApiInterfaces.class);

//        Realização da chamada Rest
        Call<List<Concept>> getConcepts = apiInterfaces.getConcepts();

//        Espera a volta do serviço
        getConcepts.enqueue(new Callback<List<Concept>>() {
            @Override
            public void onResponse(Call<List<Concept>> call, Response<List<Concept>> response) {
                System.out.println(":D");
            }

            @Override
            public void onFailure(Call<List<Concept>> call, Throwable t) {
                System.out.println(":(");
            }
        });
    }
}
