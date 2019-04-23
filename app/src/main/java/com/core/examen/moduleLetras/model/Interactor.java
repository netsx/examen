package com.core.examen.moduleLetras.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.core.examen.moduleLetras.Letras;
import com.core.examen.moduleLetras.retrofit.ApiInterface;
import com.core.examen.moduleLetras.Presentador;
import com.core.examen.moduleLetras.model.common.DatosLetras;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_WORLD_READABLE;

public class Interactor implements MainInteractor{

    Presentador presentador;



    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    Context _context;




    public Interactor(Presentador presentador) {
        this.presentador = presentador;

    }




    @Override
    public void enviarDatos(final String artista, String title) {




            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.lyrics.ovh/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            //lamada a la interface que ocupara el metodo y los valores para recuperar datos
            ApiInterface request = retrofit.create(ApiInterface.class);


            Call<DatosLetras> call = request.groupList(artista,title);
            call.enqueue(new Callback<DatosLetras>() {
               @Override
               public void onResponse(Call<DatosLetras> call, Response<DatosLetras> response) {

                   DatosLetras datosLetras = response.body();

                   presentador.showResultado( datosLetras.getLyrics().toString());


               }

               @Override
               public void onFailure(Call<DatosLetras> call, Throwable t) {

                   presentador.showError("Error al conectar al servidor");

               }
           });




    }



}
