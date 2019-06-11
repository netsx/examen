package com.core.examen.mouleSeries;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.core.examen.MainActivity;
import com.core.examen.R;
import com.core.examen.mouleSeries.model.Example;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorShow extends RecyclerView.Adapter<AdaptadorShow.ViewHolder> {



    private List<Example> data = new ArrayList<>();

    private Context context;

    public AdaptadorShow(List<Example> data, Context context) {
        this.data = data;
        this.context = context;

    }

    @NonNull
    @Override
    public AdaptadorShow.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_letras, viewGroup, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorShow.ViewHolder viewHolder, final int i) {


           viewHolder.textView.setText(String.valueOf(data.get(i).getShow().getName()));


                try{


                    Glide
                            .with(viewHolder.imageView.getContext())
                            .load(data.get(i).getShow().getImage().getOriginal())
                            .centerCrop()
                            .placeholder(R.mipmap.ic_launcher)
                            .into(viewHolder.imageView);


                }catch (Exception e){

                    Log.e("TAG",e.getMessage());
                }

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MainActivity.class);

                intent.putExtra("id", data.get(i).getShow().getId());
              //  context.startActivity(intent);


                Toast.makeText(context,String.valueOf(data.get(i).getShow().getId()) ,Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public int getItemCount() {


        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private AppCompatTextView textView;
        private AppCompatImageView imageView;
        private CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);

            textView = (AppCompatTextView) itemView.findViewById(R.id.name);
            imageView = (AppCompatImageView) itemView.findViewById(R.id.imagen);
            cardView = (CardView)itemView.findViewById(R.id.cardviewshow);


            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                            Intent intent = new Intent(context, MainActivity.class);

                          //  context.startActivity(intent);


                }
            });
        }


    }
}




