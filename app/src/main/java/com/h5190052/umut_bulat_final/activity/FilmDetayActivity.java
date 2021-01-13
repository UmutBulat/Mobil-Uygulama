package com.h5190052.umut_bulat_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190052.umut_bulat_final.model.FilmModel;
import com.h5190052.umut_bulat_final.R;
import com.h5190052.umut_bulat_final.util.Constants;
import com.h5190052.umut_bulat_final.util.GlideUtil;
import com.h5190052.umut_bulat_final.util.ObjectUtil;

public class FilmDetayActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtBaslik;
    TextView txtAciklama;
    TextView txtBasrol;
    TextView txtPuan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detay);
        init();
    }



    private void init()
    {



        String tasinanFilmString =getIntent().getStringExtra(Constants.TIKLANAN_FİLM_TASINANIN_BASLIGI);
        FilmModel FilmModel = ObjectUtil.jsonStringToFilm(tasinanFilmString);
        imgKapak =findViewById(R.id.imgKapak);
        txtBaslik =findViewById(R.id.txtBaslik);
        txtBasrol =findViewById(R.id.txtBasrolAdi);
        txtPuan =findViewById(R.id.txtImdbPuan);
        txtAciklama=findViewById(R.id.txtAciklama);
        txtBaslik.setText(FilmModel.getFilmAdi());
        txtAciklama.setText(FilmModel.getAciklama());
        txtPuan.setText(FilmModel.getImdbPuani());
        txtBasrol.setText(FilmModel.getBasrolAdi());
        GlideUtil.resmiIndiripGoster(getApplicationContext(),FilmModel.getKapakUrl(),imgKapak);

    }

}