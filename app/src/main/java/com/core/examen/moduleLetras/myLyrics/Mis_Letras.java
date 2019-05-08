package com.core.examen.moduleLetras.myLyrics;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.core.examen.R;
import com.core.examen.moduleLetras.Letras;
import com.core.examen.moduleLetras.model.DataBase;
import com.core.examen.moduleLetras.model.LetrasData;
import com.core.examen.moduleLetras.myLyrics.adapter.Adaptador;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Mis_Letras extends AppCompatActivity {


    @BindView(R.id.lyrics)
    TextView lyrics;
    @BindView(R.id.delete)
    Button delete;
    @BindView(R.id.linearLayout2)
    LinearLayout linearLayout2;
    @BindView(R.id.artista)
    TextView artista;
    @BindView(R.id.song)
    TextView song;
    @BindView(R.id.reciclador_letras)
    RecyclerView recicladorLetras;

    Adaptador adaptador;
   // private List<LetrasData> letras  ;

    private List<LetrasData> letras = new ArrayList<>();
    private DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis__letras);
        ButterKnife.bind(this);


        dataBase = new DataBase(this);

        letras.addAll(dataBase.getAllNotes());


     //   notesList.addAll(db.getAllNotes());

        adaptador = new Adaptador(this,letras);

        recicladorLetras.hasFixedSize();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recicladorLetras.setLayoutManager(mLayoutManager);
        recicladorLetras.setAdapter(adaptador);
    }



    @OnClick(R.id.delete)
    public void onViewClicked() {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.question);
        builder.setCancelable(true);

        builder.setPositiveButton(
                R.string.yes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {



                    }
                });

        builder.setNegativeButton(
                R.string.no,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder.create();
        alert11.show();


    }
}
