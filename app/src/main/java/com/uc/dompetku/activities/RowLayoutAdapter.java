package com.uc.dompetku.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uc.dompetku.R;
import com.uc.dompetku.db.TransaksiHelper;
import com.uc.dompetku.model.User;

import java.util.ArrayList;

public class RowLayoutAdapter extends RecyclerView.Adapter<RowLayoutAdapter.ExampleViewHolder> {
    private ArrayList<User> mAdapterList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;


        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.tanggal_rv);
            mTextView2 = itemView.findViewById(R.id.kategori_rv);
            mTextView3 = itemView.findViewById(R.id.jumlah_rv);
        }
    }

    public RowLayoutAdapter(ArrayList<User> adapterList){
        mAdapterList = adapterList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        User currentItem = mAdapterList.get(position);
        holder.mTextView1.setText(currentItem.getmTanggal());
        holder.mTextView2.setText(currentItem.getmKategori());
        if (mAdapterList.get(position).getmChoice().equalsIgnoreCase("pemasukan")) {
            holder.mTextView3.setText("+Rp. " + currentItem.getmJumlah());
        } else {
            holder.mTextView3.setText("-Rp. " + currentItem.getmJumlah());
        }
    }

    @Override
    public int getItemCount() {
        return mAdapterList.size();
    }
}
