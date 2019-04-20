package com.core.examen.moduleLetras.myLyrics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.core.examen.R;
import com.core.examen.moduleLetras.myLyrics.adapter.Adaptador;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Mis_Letras extends AppCompatActivity {


    SharedPreferences sharedpreferences;

    public static final String mypreference = "save";


    Adaptador adaptador;
    @BindView(R.id.lyrics)
    TextView lyrics;
    @BindView(R.id.reciclador)
    RecyclerView reciclador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis__letras);
        ButterKnife.bind(this);


        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        lyrics.setText(sharedpreferences.getString("artist", ""));


    }
}
