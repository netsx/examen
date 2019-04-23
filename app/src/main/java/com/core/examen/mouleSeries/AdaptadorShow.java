package com.core.examen.mouleSeries;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.core.examen.R;
import com.core.examen.mouleSeries.model.Example;
import com.core.examen.mouleSeries.model.Image;
import com.core.examen.mouleSeries.model.Show;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorShow extends RecyclerView.Adapter<AdaptadorShow.ViewHolder> {



    private List<Show> data = new ArrayList<>();


    public AdaptadorShow(List<Show> data) {
        this.data = data;

    }

    @NonNull
    @Override
    public AdaptadorShow.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_letras, viewGroup, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorShow.ViewHolder viewHolder, int i) {


           viewHolder.textView.setText(String.valueOf(data.get(i).getName()));
   //     viewHolder.textView.setText(imagen.get(i).getMedium());



    }

    @Override
    public int getItemCount() {
        if(data != null){
            return data.size();
        } else {
            return 0;
        }

     //   return show.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.name);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }
}




