package com.uc.dompetku.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.uc.dompetku.R;
import com.uc.dompetku.db.TransaksiHelper;
import com.uc.dompetku.model.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DataActivity extends AppCompatActivity implements TextWatcher {
    TextInputLayout input_kategori, input_jumlah, input_catatan;
    String tanggal;
    String kategori;
    String jumlah;
    String catatan;
    String date;
    EditText input_tanggal;
    RadioButton r_pemasukan, r_pengeluaran, r_hutang;
    RadioButton r_button;
    RadioGroup r_group;
    Button button_save;
    private TransaksiHelper transaksiHelper;
    Toolbar toolbar;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_data);
        input_tanggal = findViewById(R.id.input_tanggal);
        input_kategori = findViewById(R.id.input_kategori);
        input_jumlah = findViewById(R.id.input_jumlah);
        input_catatan = findViewById(R.id.input_catatan);
        r_pemasukan = findViewById(R.id.radio_pemasukan);
        r_pengeluaran = findViewById(R.id.radio_pengeluaran);
        r_hutang = findViewById(R.id.radio_hutang);
        r_group = findViewById(R.id.r_group);
        button_save = findViewById(R.id.btn_save);
        transaksiHelper = TransaksiHelper.getInstance(DataActivity.this);

        SimpleDateFormat dateF = new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault());
        date = dateF.format(Calendar.getInstance().getTime());
        input_tanggal.setText(date);

        input_kategori.getEditText().addTextChangedListener(this);
        input_jumlah.getEditText().addTextChangedListener(this);
        input_catatan.getEditText().addTextChangedListener(this);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = r_group.getCheckedRadioButtonId();
                r_button = (RadioButton) findViewById(selectedId);
                String choice = r_button.getText().toString();
                ProgressDialog progressDialog = new ProgressDialog(DataActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.screen_loading);
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                User user = new User(tanggal, kategori, jumlah, catatan, choice);
                long result = transaksiHelper.insertData(user);
                if(result > 0) {
                    Intent intent = new Intent(DataActivity.this, MainActivity.class);
                    intent.putExtra("ready", "filled");
                    startActivity(intent);
                    finish();
                }
                else{
                    progressDialog.dismiss();
                    Toast.makeText(DataActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        toolbar = findViewById(R.id.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("ready", "filled");
                startActivity(intent);
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        tanggal = input_tanggal.getText().toString().trim();
        kategori = input_kategori.getEditText().getText().toString().trim();
        jumlah = input_jumlah.getEditText().getText().toString().trim();
        catatan = input_catatan.getEditText().getText().toString().trim();

        if (!tanggal.isEmpty() && !kategori.isEmpty() && !jumlah.isEmpty() && !catatan.isEmpty()) {
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
