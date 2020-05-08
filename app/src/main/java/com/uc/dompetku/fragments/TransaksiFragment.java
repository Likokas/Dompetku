package com.uc.dompetku.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uc.dompetku.R;
import com.uc.dompetku.activities.ExampleDialog;
import com.uc.dompetku.db.TransaksiHelper;
import com.uc.dompetku.model.User;
import com.uc.dompetku.activities.DataActivity;
import com.uc.dompetku.activities.RowLayoutAdapter;
import com.uc.dompetku.utils.ItemClickSupport;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class TransaksiFragment extends Fragment {
//    ArrayList<User> AdapterList;
    FloatingActionButton button_tambah;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<User> listsave;
    private TransaksiHelper transaksiHelper;


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
        transaksiHelper = new TransaksiHelper(getActivity());
        listsave = transaksiHelper.allData();

        button_tambah = view.findViewById(R.id.button_add);
        button_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DataActivity.class);
                startActivity(intent);
            }
        });
        mRecyclerView = view.findViewById(R.id.rv_transaksi);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new RowLayoutAdapter(listsave);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                User.getcatatan = listsave.get(position).getmCatatan();
                User.getid = listsave.get(position).getmId();
                openDialog();
            }
        });
    }
    public void openDialog(){
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getActivity().getSupportFragmentManager(),"Dialog");
    }
}
