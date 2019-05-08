package com.core.examen.moduleLetras.Response;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.core.examen.R;
import com.core.examen.moduleLetras.Letras;
import com.core.examen.moduleLetras.model.DataBase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Lyrics extends AppCompatActivity {

    @BindView(R.id.lyric)
    TextView lyric;

    private String letra;
    private String artista;
    private String titulo;

    private DataBase dataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dataBase = new DataBase(this);
       // toolbar.setTitleTextColor(getResources().getColor(R.color.design_default_color_primary));


        letra = getIntent().getStringExtra("lyric");
        artista = getIntent().getStringExtra("artist");
        titulo = getIntent().getStringExtra("title");

        lyric.setText(letra);

        toolbar.setTitle(artista);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ResponseLetras( artista+" - "+ titulo , letra,view);
            }
        });
    }

    private void ResponseLetras(String artista,String letra, View view) {



        dataBase.insertNote(artista,letra );

        Snackbar.make(view, R.string.success, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        Intent activity = new Intent(this, Letras.class);
        startActivity(activity);
    }
}
