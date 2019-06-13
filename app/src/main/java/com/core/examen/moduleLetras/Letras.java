package com.core.examen.moduleLetras;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.core.examen.MainActivity;
import com.core.examen.R;
import com.core.examen.moduleLetras.Response.Lyrics;
import com.core.examen.moduleLetras.myLyrics.Mis_Letras;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Letras extends AppCompatActivity implements MainView {

    @BindView(R.id.artist)
    EditText artist;
    @BindView(R.id.title_)
    EditText title;
    @BindView(R.id.btn_search)
    AppCompatButton btnSearch;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.btn_mysongs)
    AppCompatButton btnMysongs;
    private MainPresenter presenter;

    private  String ARTISTA ="SaveArtist";
    private String TITLE ="SaveTItle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letras);
        ButterKnife.bind(this);


        /**
         *
         * Inicio del presentor y activación de las vistas
         *
         * */
        mostrarView();

        if (savedInstanceState!=null){

            String ArtistSave = savedInstanceState.getString(ARTISTA);
            String TitleSave = savedInstanceState.getString(TITLE);

            title.setText(ArtistSave);
            artist.setText(TitleSave);

        }else {



        }


         presenter = new Presentador(this);
        progressBar.setVisibility(View.GONE);



    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);



        outState.putString(ARTISTA, artist.getText().toString());
        outState.putString(TITLE,title.getText().toString());
    }

    /*
    *
    *
    * Respuesta si es positiva la consulta y envio de datos
    * a la nueva activity
    *
    *
    * */
    @Override
    public void show(String resultado) {

        String artista=artist.getText().toString();
        String titulo = title.getText().toString();

        Intent activity = new Intent(this, Lyrics.class);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        activity.putExtra("artist", artista);
        activity.putExtra("title", titulo);
        activity.putExtra("lyric", resultado);
        startActivity(activity);


    }


    /*
     *
     *
     * Respuesta negativa a la consulta
     *
     *
     * */


    @Override
    public void showError(String error) {

        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        mostrarView();
    }




    private boolean ValidarFormulario() {

        boolean validacion = true;




        if (artist.getText().toString().trim().isEmpty()) {

            artist.setError(getResources().getString(R.string.error_empty));
            btnSearch.setVisibility(View.GONE);
            return false;
        }
        if (artist.length()<3) {

            artist.setError(getResources().getString(R.string.error_short_name));
            btnSearch.setVisibility(View.GONE);
            return false;
        }


        if (title.getText().toString().trim().isEmpty()) {

            title.setError(getResources().getString(R.string.error_empty));
            btnSearch.setVisibility(View.GONE);
            return false;
        }
        if (title.length()<3) {

            title.setError(getResources().getString(R.string.error_short_name));
            btnSearch.setVisibility(View.GONE);
            return false;
        }
        btnSearch.setVisibility(View.VISIBLE);
        return validacion;
    }


    private void ocultarView() {

        linearLayout.setVisibility(View.GONE);
        btnMysongs.setVisibility(View.GONE);
        btnSearch.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

    }

    private void mostrarView() {

        linearLayout.setVisibility(View.VISIBLE);
        btnMysongs.setVisibility(View.VISIBLE);
        btnSearch.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);



        artist.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ValidarFormulario();
            }
        });

        title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ValidarFormulario();
            }
        });


    }

    @OnClick({R.id.btn_search, R.id.btn_mysongs})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_search:

                if (ValidarFormulario() == true) {

                    ocultarView();

                    /**
                     *
                     * Envio de datos al presentador para su tratamiento
                     * y ocultación de vistas
                     *
                     * */
                    presenter.enviarDatos(artist.getText().toString().trim(),
                            title.getText().toString().trim());
                }

                break;
            case R.id.btn_mysongs:


                  // startActivity(new Intent(this, Mis_Letras.class));
                startActivity(new Intent(this, Mis_Letras.class));


                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        /*
        *
        *
        *
        * Regreso al menu principal y eliminación de la actividad
        *
        *
        * */
        startActivity(new Intent(this,MainActivity.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
