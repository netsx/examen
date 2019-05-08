package com.core.examen.moduleLetras.myLyrics;

public class Presentador_Letter implements Presenter {


    private View_Letter viewLetter;
    private Interactor_Letter interactor_letter;

    public Presentador_Letter(View_Letter viewLetter) {
        this.viewLetter = viewLetter;
        interactor_letter = new Interactor_Letter(this);
    }

    @Override
    public void onCreate() {

        if(viewLetter!= null){

        }
    }

    @Override
    public void onDestroy() {
        if(viewLetter!= null){

        }
    }

    @Override
    public void onShow() {
        if(viewLetter!= null){

interactor_letter.RecyclerShow();
            viewLetter.ShowRecycler();
        }
    }

    @Override
    public Void onError() {
        if(viewLetter!= null){

        }

        return null;
    }
}
