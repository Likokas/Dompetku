package com.uc.dompetku.activities;

import android.app.Dialog;
import android.app.DownloadManager;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.uc.dompetku.db.DatabaseConstruct;
import com.uc.dompetku.db.DatabaseHelper;
import com.uc.dompetku.db.TransaksiHelper;
import com.uc.dompetku.model.User;

import java.util.ArrayList;

public class ExampleDialog extends AppCompatDialogFragment {

    DatabaseHelper myDb;

    private ArrayList<User> listsave;
    private TransaksiHelper transaksiHelper;
    private String note, id;
    private int test;

    String tanggal, kategori, jumlah, catatan, date;


    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        note = User.getcatatan;



        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Catatan")
                .setMessage(note)
                .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if (test == 0) {
                            transaksiHelper = new TransaksiHelper(getActivity());
                            listsave = transaksiHelper.allData();
                            id = User.getid;
                            test =(transaksiHelper.delete(id));
                        }


                    }
                })
                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                            dialog.dismiss();
                    }
                });
            return builder.create();

    }
}
