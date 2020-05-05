package com.uc.dompetku.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.uc.dompetku.R;
import com.uc.dompetku.fragments.LaporanFragment;
import com.uc.dompetku.model.DataUser;

public class DataActivity extends AppCompatActivity implements TextWatcher {
    TextInputLayout input_tanggal, input_kategori, input_jumlah, input_catatan;
    Button button_save;
    String tanggal, kategori, jumlah, catatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_data);
        input_tanggal = findViewById(R.id.input_tanggal);
        input_kategori = findViewById(R.id.input_kategori);
        input_jumlah = findViewById(R.id.input_jumlah);
        input_catatan = findViewById(R.id.input_catatan);
        button_save = findViewById(R.id.btn_save);

        input_tanggal.getEditText().addTextChangedListener(this);
        input_kategori.getEditText().addTextChangedListener(this);
        input_jumlah.getEditText().addTextChangedListener(this);
        input_catatan.getEditText().addTextChangedListener(this);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(DataActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.screen_loading);
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                DataUser.userdata.add(new AdapterUser(tanggal, kategori, jumlah));
                Intent intent = new Intent(DataActivity.this, MainActivity.class);
//                intent.putExtra("dataUser", orang);
//                intent.putExtra("buttonfinish", "123");
                startActivity(intent);
                finish();
            }
        });
        Intent intent = new Intent(DataActivity.this, LaporanFragment.class);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        tanggal = input_tanggal.getEditText().getText().toString().trim();
        kategori = input_kategori.getEditText().getText().toString().trim();
        jumlah = input_jumlah.getEditText().getText().toString().trim();

        if (!tanggal.isEmpty() && !kategori.isEmpty() && !jumlah.isEmpty()) {
            button_save.setEnabled(true);
        }
        else{
            button_save.setEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
