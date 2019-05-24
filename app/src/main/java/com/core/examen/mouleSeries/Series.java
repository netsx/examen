package com.core.examen.mouleSeries;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.core.examen.R;
import com.core.examen.mouleSeries.model.ApiInterface;
import com.core.examen.mouleSeries.model.Example;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Series extends AppCompatActivity implements ViewShow {

    AdaptadorShow adaptadorShow;

    private List<Example> data = new ArrayList<>();


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.progressBar2)
    ProgressBar progressBar2;
    @BindView(R.id.reciclador)
    RecyclerView reciclador;


    private ShowPresenter presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressBar2.setVisibility(View.GONE);
        presentador = new ShowPresenter(this);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                searchView.setIconified(true);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                presentador.sendData(newText);


                return true;
            }
        });
    }


    @Override
    public void showRecycler() {

    }

    @Override
    public void ShowData(String data) {

        retro(data);

    }

    @Override
    public void ShowError(String error) {
        Toast.makeText(Series.this, error, Toast.LENGTH_SHORT).show();


    }

    public void retro(String query) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.tvmaze.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        //lamada a la interface que ocupara el metodo y los valores para recuperar datos
        ApiInterface request = retrofit.create(ApiInterface.class);


        Call<List<Example>> call = request.show(query);


     call.enqueue(new Callback<List<Example>>() {
         @Override
         public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {

             Log.d("TAG",response.body().toString());
             data = response.body();
             StaggeredGridLayoutManager _sGridLayoutManager =
                     new StaggeredGridLayoutManager(3,
                             StaggeredGridLayoutManager.VERTICAL);

             adaptadorShow = new AdaptadorShow(data, getApplicationContext());


             reciclador.hasFixedSize();
             reciclador.setLayoutManager(_sGridLayoutManager);
             reciclador.setAdapter(adaptadorShow);
         }

         @Override
         public void onFailure(Call<List<Example>> call, Throwable t) {

             Log.e("TAG",t.getMessage());

         }
     });

    }
}
