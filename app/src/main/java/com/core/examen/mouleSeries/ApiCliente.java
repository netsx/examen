package com.core.examen.mouleSeries;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCliente {

    public static String BASE_URL ="http://api.tvmaze.com/";
    private static Retrofit retrofit;

    public void TvMazeApiClient(){

    }
    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
