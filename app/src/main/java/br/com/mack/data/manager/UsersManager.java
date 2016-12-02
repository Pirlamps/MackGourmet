package br.com.mack.data.manager;

import java.util.List;

import br.com.mack.utils.ApiFactory;
import br.com.mack.valueobjects.Chef;
import br.com.mack.valueobjects.Developer;
import br.com.mack.valueobjects.Student;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Amor on 01/12/2016.
 */

public class UsersManager {

//    TODO DELEGATE PARA VOLTAR OS OBJETOS PARA ACTIVITY E DOCUMENTAÇÃO DOS MÉTODOS


    public void getStudents(){

        Call<List<Student>> restCall = ApiFactory.buildAPI().getStudents();
        restCall.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                System.out.println(":D");
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                System.out.println(":(");
            }
        });

    }

    public void getDevelopers(){
        Call<List<Developer>> restCall = ApiFactory.buildAPI().getDevelopers();
        restCall.enqueue(new Callback<List<Developer>>() {
            @Override
            public void onResponse(Call<List<Developer>> call, Response<List<Developer>> response) {
                System.out.println(":D");
            }

            @Override
            public void onFailure(Call<List<Developer>> call, Throwable t) {
                System.out.println(":(");
            }
        });

    }

    public void getChefs(){
        Call<List<Chef>> restCall = ApiFactory.buildAPI().getChefs();
        restCall.enqueue(new Callback<List<Chef>>() {
            @Override
            public void onResponse(Call<List<Chef>> call, Response<List<Chef>> response) {
                System.out.println(":D");
            }

            @Override
            public void onFailure(Call<List<Chef>> call, Throwable t) {
                System.out.println(":(");
            }
        });

    }

    /**
     *
     * @param conceptId
     */
    public void getChefsByConcept(String conceptId){

        Call<List<Chef>> restCall = ApiFactory.buildAPI().getChefsByConcept(conceptId);
        restCall.enqueue(new Callback<List<Chef>>() {
            @Override
            public void onResponse(Call<List<Chef>> call, Response<List<Chef>> response) {
                System.out.println(":D");
            }

            @Override
            public void onFailure(Call<List<Chef>> call, Throwable t) {
                System.out.println(":(");
            }
        });

    }
}
