package com.core.examen.moduleLetras;

import com.core.examen.moduleLetras.model.Interactor;
import com.core.examen.moduleLetras.model.MainInteractor;

public class Presentador implements MainPresenter {

    private MainView vista;
    private MainInteractor interactor;

    public Presentador(MainView vista) {
        this.vista = vista;
        interactor= new Interactor(this);

    }

    @Override
    public void showResultado(String resultado) {

        if(vista!=null){

            vista.show(resultado);
        }
    }

    @Override
    public void enviarDatos(String artista, String titulo) {

        if(vista!= null){

            interactor.enviarDatos(artista,titulo);
        }

    }

    @Override
    public void showError(String error) {
        if(vista!= null){

            vista.showError(error);

        }


    }
}
