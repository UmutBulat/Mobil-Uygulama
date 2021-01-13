package com.h5190052.umut_bulat_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.h5190052.umut_bulat_final.model.FilmModel;
import com.h5190052.umut_bulat_final.R;
import com.h5190052.umut_bulat_final.util.GlideUtil;

import java.util.List;

public class FilmAdaptor extends RecyclerView.Adapter<FilmViewHolder> {


    List<FilmModel> filmler;
    Context context;
    OnItemClickListener listener;
 public interface OnItemClickListener{
     void  onClick(int position);
 }

    public FilmAdaptor(List<FilmModel> filmler, Context context,OnItemClickListener listener) {
        this.filmler = filmler;
        this.context = context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_film,parent,false);
        return new FilmViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder viewHolder, int position) {

        viewHolder.txtTarih.setText(filmler.get(position).getCikisYili());
        viewHolder.txtFilmAdi.setText(filmler.get(position).getFilmAdi());
        GlideUtil.resmiIndiripGoster(context,filmler.get(position).getLogoUrl(),viewHolder.imgLogo);

    }

    @Override
    public int getItemCount() {
        return filmler.size();
    }
}
