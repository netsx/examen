package com.core.examen.moduleLetras.myLyrics;

public class Interactor_Letter implements Interactor {



    private Presentador_Letter presentador_letter;
    private Interactor_Letter interactor_letter;



    public Interactor_Letter(Presentador_Letter presentador_letter ) {
        this.presentador_letter = presentador_letter;

    }

    @Override
    public void RecyclerShow() {


        presentador_letter.onShow();
    }
}
