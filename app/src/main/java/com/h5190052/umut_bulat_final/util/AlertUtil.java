package com.h5190052.umut_bulat_final.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AlertUtil {

    public  static  boolean internetVarmi(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && ((NetworkInfo) networkInfo).isAvailable() && networkInfo.isConnected()) {

            return true;
        } else {

     return false;
        }
    }
}
