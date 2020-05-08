package com.uc.dompetku.activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.uc.dompetku.db.TransaksiHelper;
import com.uc.dompetku.model.User;

import java.util.ArrayList;

public class ExampleDialog extends AppCompatDialogFragment {
    private ArrayList<User> listsave;
    private TransaksiHelper transaksiHelper;
    private String note, id;

    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        note = User.getcatatan;

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Catatan")
                .setMessage(note)
                .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        transaksiHelper = new TransaksiHelper(getActivity());
                        listsave = transaksiHelper.allData();
                        id = User.getid;
                        transaksiHelper.delete(id);
                    }
                })
                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                });
            return builder.create();

    }
}
