package com.core.examen.mouleSeries;

import com.core.examen.mouleSeries.model.Example;

import java.util.ArrayList;

public class ShowInteractor implements InteractorShow{


    private ArrayList<Example> data = new ArrayList<>();
    ShowPresenter presenter;

    public ShowInteractor(ShowPresenter presenter) {
        this.presenter = presenter;

    }


    @Override
    public void sendData(String query) {



        if(query.isEmpty()){

            presenter.showError("");

        }else{


            presenter.showData(query);
        }




    }



}
