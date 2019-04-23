package com.core.examen.mouleSeries;

import android.view.View;

public class ShowPresenter implements PresenterShow {


    ViewShow viewShow;
    InteractorShow interactorShow;

    public ShowPresenter(ViewShow viewShow) {

        this.viewShow = viewShow;
        interactorShow = new ShowInteractor(this);

        }

    @Override
    public void showRecycler() {

        if(viewShow!=null){

        }
    }

    @Override
    public void showError(String data) {


        if(viewShow!=null){

            viewShow.ShowData(data);
        }
    }

    @Override
    public void sendData(String string) {

        if(viewShow!= null) {


            interactorShow.sendData(string);

        }

    }


    @Override
    public void showData(String data) {

        if (viewShow != null) {

            viewShow.ShowData(data);
        }
    }


}
