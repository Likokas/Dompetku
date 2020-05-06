package com.uc.dompetku.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uc.dompetku.R;
import com.uc.dompetku.activities.AdapterUser;
import com.uc.dompetku.activities.DataActivity;
import com.uc.dompetku.activities.RowLayoutAdapter;

import com.uc.dompetku.activities.User;
import com.uc.dompetku.activities.myDbAdapter;
import com.uc.dompetku.model.DataUser;

import java.util.ArrayList;
import java.util.List;


public class TransaksiFragment extends Fragment {
    ArrayList<AdapterUser> AdapterList;
    FloatingActionButton button_tambah;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private myDbAdapter db;
    private List<User> listStudent = new ArrayList<>();


    public TransaksiFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_transaksi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button_tambah = view.findViewById(R.id.button_add);
        button_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DataActivity.class);
                startActivity(intent);
            }
        });
        AdapterList = DataUser.userdata;
        mRecyclerView = view.findViewById(R.id.rv_transaksi);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new RowLayoutAdapter(AdapterList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
