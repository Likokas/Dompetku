 package com.uc.dompetku.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.uc.dompetku.R;
import com.uc.dompetku.fragments.SettingFragment;
import com.uc.dompetku.fragments.TransaksiFragment;
import com.uc.dompetku.fragments.LaporanFragment;

 public class MainActivity extends AppCompatActivity {

     BottomNavigationView bottomNavigationView;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         bottomNavigationView = findViewById(R.id.bottom_nav_main);
         bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 Fragment fragment;
                 switch (item.getItemId()) {
                     case R.id.menu_laporan:
                         fragment = new LaporanFragment();
                         loadFragment(fragment);
                         return true;
                     case R.id.menu_transaksi:
                         fragment = new TransaksiFragment();
                         loadFragment(fragment);
                         return true;
                     case R.id.menu_setting:
                         fragment = new SettingFragment();
                         loadFragment(fragment);
                         return true;
                 }
                 return false;
             }
         });
     }
     private void loadFragment(Fragment fragment) {
         FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
         transaction.replace(R.id.frame_main, fragment);
         transaction.commit();
     }

     @Override
     protected void onStart() {
         super.onStart();
         bottomNavigationView.setSelectedItemId(R.id.menu_laporan);
         Fragment fragment = new LaporanFragment();
         loadFragment(fragment);
     }
 }