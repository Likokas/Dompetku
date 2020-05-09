package com.uc.dompetku.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.uc.dompetku.R;
import com.uc.dompetku.db.TransaksiHelper;
import com.uc.dompetku.model.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


public class LaporanFragment extends Fragment {

    public LaporanFragment() {
    }

    private ProgressBar progressBar;
    public TextView u_sementara, u_pemasukan, u_pengeluaran, u_total, u_hutang, u_total_akhir, datenow;
    String date;
    int sementara = 0;
    int pemasukan = 0;
    int pengeluaran = 0;
    int total = 0;
    int hutang = 0;
    int totalakhir = 0;
    private ArrayList<User> listsave;
    private TransaksiHelper transaksiHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_laporan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        u_sementara = view.findViewById(R.id.uang_sementara);
        u_pemasukan = view.findViewById(R.id.uang_pemasukan);
        u_pengeluaran = view.findViewById(R.id.uang_pengeluaran);
        u_total = view.findViewById(R.id.uang_total);
        u_hutang = view.findViewById(R.id.uang_hutang);
        u_total_akhir = view.findViewById(R.id.uang_total_akhir);
        datenow = view.findViewById(R.id.current);
        transaksiHelper = new TransaksiHelper(getActivity());
        listsave = transaksiHelper.allData();

        SimpleDateFormat dateF = new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault());
        date = dateF.format(Calendar.getInstance().getTime());
        datenow.setText(date);


        for (int i = 0; i < listsave.size(); i++) {
            if (listsave.get(i).getmChoice().equalsIgnoreCase("pemasukan")) {
                pemasukan += Integer.parseInt(listsave.get(i).getmJumlah());
            } else if (listsave.get(i).getmChoice().equalsIgnoreCase("pengeluaran")) {
                pengeluaran += Integer.parseInt(listsave.get(i).getmJumlah());
            } else if (listsave.get(i).getmChoice().equalsIgnoreCase("hutang")) {
                hutang += Integer.parseInt(listsave.get(i).getmJumlah());
            }
        }
        total = uTotal();
        totalakhir = uTotalAkhir();

        u_sementara.setText(String.valueOf("Rp. " + pemasukan));
        u_pengeluaran.setText(String.valueOf("Rp. " + pengeluaran));
        u_pemasukan.setText(String.valueOf(("Rp. " + pemasukan)));
        u_total.setText(String.valueOf(("Rp. " + total)));
        u_hutang.setText(String.valueOf(("Rp. " + hutang)));
        u_total_akhir.setText(String.valueOf(("Rp. " + totalakhir)));
    }

    public int uTotal(){
        int hasil = sementara + pemasukan - pengeluaran;
        return hasil;
    }

    public int uTotalAkhir(){
        int hasil = total - hutang;
        return hasil;
    }

}
