package com.core.examen.moduleLetras.myLyrics;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.core.examen.R;
import com.core.examen.moduleLetras.model.common.DatosLetras;
import com.core.examen.moduleLetras.myLyrics.adapter.Adaptador;

import java.util.ArrayList;
import java.util.List;

public class Mis_Letras extends AppCompatActivity {


    SharedPreferences sharedpreferences;

    public static final String mypreference = "save";



    Adaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis__letras);




        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        Toast.makeText(this,sharedpreferences.getString( "artist","").toString(),Toast.LENGTH_LONG).show();

    }
}
