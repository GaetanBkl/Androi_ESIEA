package com.example.androi_esiea.Controller;

import com.example.androi_esiea.Model.Films;
import com.example.androi_esiea.GerritAPI;
import com.example.androi_esiea.View.MainActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<List<Films>>{
    static final String BASE_URL = "https://ghibliapi.herokuapp.com/";

    private MainActivity view;
    private GerritAPI api;

    public Controller(MainActivity view, GerritAPI api) {
        this.view = view;
        this.api = api;
    }

    public void start() {
        Call<List<Films>> call = api.getFilms("status:open");
        call.enqueue(this);
    }

    public static GerritAPI getAPI() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(GerritAPI.class);

    }


    @Override
    public void onResponse(Call<List<Films>> call, Response<List<Films>> response) {
        if(response.isSuccessful()) {
            List<Films> filmsList = response.body();
            //changesList.forEach(change -> System.out.println(change.subject));
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Films>> call, Throwable t) {
        t.printStackTrace();
    }
}
