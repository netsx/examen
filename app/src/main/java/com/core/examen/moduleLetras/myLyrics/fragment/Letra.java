package com.core.examen.moduleLetras.myLyrics.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.core.examen.R;
import com.core.examen.moduleLetras.model.DataBase;
import com.core.examen.moduleLetras.myLyrics.Mis_Letras;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Letra extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView2)
    TextView textView2;


    AlertDialog.Builder builder;
    @BindView(R.id.fab_)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letra);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        final int i = getIntent().getExtras().getInt("id");
        textView.setText(getIntent().getExtras().getString("artista"));
        textView2.setText(getIntent().getExtras().getString("letra"));



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Mis_Letras.class));
        finish();
    }




    @OnClick(R.id.fab_)
    public void onViewClicked() {

        final int i = getIntent().getExtras().getInt("id");
        DataBase dataBase = new DataBase(getApplicationContext());
                       dataBase.deleteNote(dataBase.getNote(i));
                       startActivity(new Intent(getApplicationContext(),Mis_Letras.class));
    }

    }