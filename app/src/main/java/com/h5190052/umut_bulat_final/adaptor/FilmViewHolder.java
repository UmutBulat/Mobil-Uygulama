package com.h5190052.umut_bulat_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.h5190052.umut_bulat_final.R;


public class FilmViewHolder extends RecyclerView.ViewHolder {

    ImageView imgLogo;
    TextView txtFilmAdi;
    TextView txtTarih;


    public FilmViewHolder(@NonNull View itemView, FilmAdaptor.OnItemClickListener listener) {
        super(itemView);

        imgLogo =itemView.findViewById(R.id.imgFilmLogo);
        txtFilmAdi =itemView.findViewById(R.id.txtFilmAdi);
        txtTarih =itemView.findViewById(R.id.txtTarih);

itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
           listener.onClick(getAdapterPosition());
    }
});

    }
}
