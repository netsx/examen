package com.core.examen.moduleLetras.myLyrics.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.core.examen.R;
import com.core.examen.moduleLetras.model.common.DatosLetras;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyViewHolder> {


    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "save" ;

    Context context;
    ArrayList<DatosLetras> categoria;


    public Adaptador(Context c , ArrayList<DatosLetras> p)
    {

        context = c;
        categoria = p;
    }
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview_letras,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
      //  holder.title.setText(categoria.get(position).getCategoria_titulo());



    }

    @Override
    public int getItemCount() {
        return categoria.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView title,description;
        ImageView imageView;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.textview_letras);


        }
        public void onClick(final int position)
        {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()){


            }

        }
    }
}