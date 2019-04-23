package com.core.examen.mouleSeries;

import android.util.Log;

import com.core.examen.R;
import com.core.examen.mouleSeries.model.ApiInterface;
import com.core.examen.mouleSeries.model.Image;
import com.core.examen.mouleSeries.model.RetrofitClient;
import com.core.examen.mouleSeries.model.Show;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

public class ShowInteractor implements InteractorShow{


    private ArrayList<Show> data = new ArrayList<>();
    private ArrayList<Image> images = new ArrayList<>();
    ShowPresenter presenter;

    public ShowInteractor(ShowPresenter presenter) {
        this.presenter = presenter;

    }


    @Override
    public void sendData(String query) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.tvmaze.com/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        //lamada a la interface que ocupara el metodo y los valores para recuperar datos
    ApiInterface request = retrofit.create(ApiInterface.class);


        Call<List<Show>> call = request.show(query);

        call.enqueue(new Callback<List<Show>>() {
            @Override
            public void onResponse(Call<List<Show>> call, Response<List<Show>> response) {
                //Log.i("onResponse", response.message());
                Log.i("autolog", "onResponse");


                data = new ArrayList<>(response.body());

                  if(data.isEmpty()){
                    presenter.showError("No se han encontrado datos");


                }else {

//                          presenter.showData(data.get(1).);

                  }
            }

            @Override
            public void onFailure(Call<List<Show>> call, Throwable t) {
                Log.i("autolog", t.getMessage());
                presenter.showError(t.getMessage());
            }
        });





    }



}
