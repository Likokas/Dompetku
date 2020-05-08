package com.uc.dompetku.activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.uc.dompetku.db.DatabaseHelper;
import com.uc.dompetku.db.TransaksiHelper;
import com.uc.dompetku.model.User;

import java.util.ArrayList;

public class CautionDialog extends AppCompatDialogFragment {

    DatabaseHelper myDb;

    private ArrayList<User> listsave;
    private TransaksiHelper transaksiHelper;
    private String note, id;

    String tanggal, kategori, jumlah, catatan, date;


    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Warning")
                .setMessage("Are you sure you want to delete?")
                .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        transaksiHelper = new TransaksiHelper(getActivity());
                        listsave = transaksiHelper.allData();
                        transaksiHelper.deleteAll();
                    }
                })
                .setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                            dialog.dismiss();
                    }
                });
            return builder.create();

    }
}
