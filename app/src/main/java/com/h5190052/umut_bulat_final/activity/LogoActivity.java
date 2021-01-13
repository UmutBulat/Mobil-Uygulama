package com.h5190052.umut_bulat_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;

import com.h5190052.umut_bulat_final.R;
import com.h5190052.umut_bulat_final.util.AlertUtil;

public class LogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init () {

internetKontrol();
    }

    private void internetKontrol(){;
     if(AlertUtil.internetVarmi(getApplicationContext()))
    {
       sayfaGecisi();
    }
     else
    {
        internetYok();
    }
}

    private void internetYok() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(R.string.baglantikontorl).setPositiveButton("Evet", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {

                startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));


            }
        });
        builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {

                finish();


            }
        });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    private void sayfaGecisi(){
        CountDownTimer countDownTimer=new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent MovieActivity=new Intent(getApplicationContext(), MovieActivity.class );
                startActivity(MovieActivity);
                finish();

            }
        }.start();

    }

}