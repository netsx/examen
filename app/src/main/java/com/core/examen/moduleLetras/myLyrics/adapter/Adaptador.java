package com.core.examen.moduleLetras.myLyrics.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.core.examen.R;
import com.core.examen.moduleLetras.model.LetrasData;
import com.core.examen.moduleLetras.myLyrics.Mis_Letras;
import com.core.examen.moduleLetras.myLyrics.fragment.Letra;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyViewHolder> {

    private Context context;
    private List<LetrasData> letrasData;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView artista;
        public TextView letra;
        public CardView cardView;



        public MyViewHolder(View view) {

            super(view);

            artista = view.findViewById(R.id.text_Artist);
            letra = view.findViewById(R.id.text_letter);
            cardView= view.findViewById(R.id.cardView);
            }


    }


    public Adaptador(Context context, List<LetrasData> letrasData) {
        this.context = context;
        this.letrasData = letrasData;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_letter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
       final LetrasData letra = letrasData.get(position);

        holder.artista.setText(letra.getArtist());
        holder.letra.setText(letra.getLyric());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent i = new Intent(context, Letra.class);
          

                i.putExtra("id", letra.getId());
                i.putExtra("artista", letra.getArtist());
                i.putExtra("letra",letra.getLyric());

                context.startActivity(i);
                ((Activity)context).finish();

                /*
                FragmentManager fm ;

                Bundle args = new Bundle();
                args.putInt("id", letra.getId());
                args.putString("letra", letra.getLyric());
                createSimpleDialog(letra.getArtist(),letra.getLyric());
*/
/*
               AppCompatActivity activity = (AppCompatActivity) holder.cardView.getContext();
                Fragment myFragment = new FragmentLetter();
                Bundle args = new Bundle();
                args.putInt("id", letra.getId());
                args.putString("letra", letra.getLyric());
                myFragment.setArguments(args);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame, myFragment).addToBackStack(null).commit();

*/
            }
        });




    }

    @Override
    public int getItemCount() {
        return letrasData.size();
    }

    public void switchContent(int id, Fragment fragment) {
        if (context == null)
            return;
        if (context instanceof Mis_Letras) {
            Mis_Letras mainActivity = (Mis_Letras) context;
            Fragment frag = fragment;

        }

    }

}