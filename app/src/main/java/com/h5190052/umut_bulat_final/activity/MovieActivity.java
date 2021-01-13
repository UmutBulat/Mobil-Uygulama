package com.h5190052.umut_bulat_final.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.h5190052.umut_bulat_final.model.FilmModel;
import com.h5190052.umut_bulat_final.R;
import com.h5190052.umut_bulat_final.adaptor.FilmAdaptor;
import com.h5190052.umut_bulat_final.network.Service;
import com.h5190052.umut_bulat_final.util.Constants;
import com.h5190052.umut_bulat_final.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MovieActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        init();
    }

    private  void  init()
    {
        filmlerGetir();
    }

    void  filmlerGetir()
    {
        new Service().getServiceApi().filmleriGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<FilmModel>>() {

                    List<FilmModel> filmler=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<FilmModel> filmlist) {
                        Log.e("RETROFIT","onNext : ");
                        filmler=filmlist;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");

                        if(filmler.size()>0) {


                            initRecycleView(filmler);
                        }
                    }
                });
    }


    private  void  initRecycleView(List<FilmModel> filmList)
    {
        recyclerView =findViewById(R.id.rcvFilmler);
        FilmAdaptor fAdaptor =new FilmAdaptor(filmList, getApplicationContext(), new FilmAdaptor.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                FilmModel tıklananfilm=filmList.get(position);
         detayGecis(tıklananfilm);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(fAdaptor);

    }
    private  void detayGecis(FilmModel tıklananfilm){
        Intent FilmDetayActivityIntent=new Intent(getApplicationContext(), FilmDetayActivity.class );
        String tiklananFilmString= ObjectUtil.filmToJsonString(tıklananfilm);
        FilmDetayActivityIntent.putExtra(Constants.TIKLANAN_FİLM_TASINANIN_BASLIGI,tiklananFilmString);
        startActivity(FilmDetayActivityIntent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

            alertDialogBuilder.setTitle("Uyarı!");
            alertDialogBuilder.setMessage(R.string.cikisdialog);
            alertDialogBuilder.setCancelable(false);


            alertDialogBuilder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }

            });
            alertDialogBuilder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();

                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }
        return super.onKeyDown(keyCode, event);
    }
}