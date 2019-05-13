package com.core.examen.moduleLetras.myLyrics.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.core.examen.R;
import com.core.examen.moduleLetras.model.DataBase;
import com.core.examen.moduleLetras.model.LetrasData;
import com.core.examen.moduleLetras.myLyrics.adapter.Adaptador;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Recycler extends Fragment {


    @BindView(R.id.reciclador_letras)
    RecyclerView recicladorLetras;
    Unbinder unbinder;
    private Adaptador adaptador;

    private List<LetrasData> letras = new ArrayList<>();
    private DataBase dataBase;

    public Fragment_Recycler() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment__recycler, container, false);
        unbinder = ButterKnife.bind(this, view);

        // Inflate the layout for this fragment
        dataBase = new DataBase(getContext());
        letras.addAll(dataBase.getAllNotes());

        adaptador = new Adaptador(getContext(), letras);

        recicladorLetras.hasFixedSize();
        adaptador.notifyDataSetChanged();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());

       //recicladorLetras.removeViewAt(adaptador.getItemCount());

        adaptador.notifyItemRemoved(adaptador.getItemCount());
        adaptador.notifyItemRangeChanged(adaptador.getItemCount(), letras.size());


        recicladorLetras.setLayoutManager(mLayoutManager);
        recicladorLetras.setAdapter(adaptador);


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

