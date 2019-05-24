package com.core.examen.mouleSeries.model;

import com.core.examen.moduleLetras.model.common.DatosLetras;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {



    @GET("/search/shows")
   Call<List<Example>> show(@Query("q") String text);

}