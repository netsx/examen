package com.core.examen.moduleLetras.myLyrics;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.core.examen.R;
import com.core.examen.moduleLetras.Letras;
import com.core.examen.moduleLetras.myLyrics.adapter.Adaptador;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Mis_Letras extends AppCompatActivity {


    SharedPreferences sharedpreferences;

    public static final String mypreference = "save";


    Adaptador adaptador;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis__letras);
        ButterKnife.bind(this);


        VerifySharedPreference();


    }


    public void VerifySharedPreference() {

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);


        if (sharedpreferences.getString("lyric", "").isEmpty()) {

            startActivity(new Intent(this, Letras.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        } else {

            lyrics.setText(sharedpreferences.getString("lyric", ""));
            song.setText(sharedpreferences.getString("title", ""));
            artista.setText(sharedpreferences.getString("artist", ""));

        }
    }

    @OnClick(R.id.delete)
    public void onViewClicked() {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.question);
        builder.setCancelable(true);

        builder.setPositiveButton(
                "Si",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences.Editor editor = sharedpreferences.edit();

                        editor.clear();
                        editor.commit() ;
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        startActivity(new Intent(Mis_Letras.this,Letras.class));

                    }
                });

        builder.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder.create();
        alert11.show();


    }
}
