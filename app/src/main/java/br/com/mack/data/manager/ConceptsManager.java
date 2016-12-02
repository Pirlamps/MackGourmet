package br.com.mack.data.manager;

import java.util.List;

import br.com.mack.utils.ApiFactory;
import br.com.mack.valueobjects.Concept;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by matheus on 01/12/16.
 */

public class ConceptsManager {

//    TODO DELEGATE PARA VOLTAR OS OBJETOS PARA ACTIVITY E DOCUMENTAÇÃO DOS MÉTODOS

    /**
     *
     */
    public void getConcepts() {

        Call<List<Concept>> restCall = ApiFactory.buildAPI().getConcepts();
        restCall.enqueue(new Callback<List<Concept>>() {
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
