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

import butterknife.BindView;
import butterknife.ButterKnife;

public class Lyrics extends AppCompatActivity {

    @BindView(R.id.lyric)
    TextView lyric;



    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "save" ;
    private String valor;
    private String artist;
    private String title;

    private String artis;
    private String song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryDark));


        valor = getIntent().getStringExtra("lyric");
        artis = getIntent().getStringExtra("artist");
        song = getIntent().getStringExtra("title");

        lyric.setText(valor);

        toolbar.setTitle(song);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ResponseLetras( valor,view);
            }
        });
    }

    private void ResponseLetras(String save, View view) {

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
/*
        editor.putString(save, save);
        editor.putString("artist", valor);
        editor.putString(save, save);
        */

        editor.putString("lyric", valor);
        editor.putString("artist", artist);
        editor.putString("title", song);
        editor.commit();

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
