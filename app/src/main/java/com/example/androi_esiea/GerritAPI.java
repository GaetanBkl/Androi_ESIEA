package com.example.androi_esiea;

import com.example.androi_esiea.Model.Films;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GerritAPI {
        @GET("films")
        Call<List<Films>> getFilms(@Query("films") String status);
}
