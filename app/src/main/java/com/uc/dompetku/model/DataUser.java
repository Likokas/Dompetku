package com.uc.dompetku.model;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.uc.dompetku.R;
import com.uc.dompetku.activities.AdapterUser;

import java.util.ArrayList;

public class DataUser {
    public static ArrayList<AdapterUser> userdata = new ArrayList<>();
    public static final Dialog loadingDialog(Context context){
        final Dialog dialog = new Dialog(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.screen_loading, null);
        dialog.setContentView(dialogView);
        dialog.setCancelable(false);
        return dialog;
    }
}
