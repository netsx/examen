package com.core.examen.moduleLetras;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letras);
        ButterKnife.bind(this);


        mostrarView();

        presenter = new Presentador(this);
        progressBar.setVisibility(View.GONE);


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

        if (artist.getText().toString().isEmpty()) {

            artist.setError(getResources().getString(R.string.error_empty));
            return false;
        }

        if (title.getText().toString().isEmpty()) {

            artist.setError(getResources().getString(R.string.error_empty));
            return false;
        }

        return validacion;
    }


    private void ocultarView() {

        linearLayout.setVisibility(View.GONE);
        btnMysongs.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

    }

    private void mostrarView() {

        linearLayout.setVisibility(View.VISIBLE);
        btnMysongs.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);

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


                    startActivity(new Intent(this, Mis_Letras.class));


                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
