package com.uc.dompetku.activities;

public class AdapterUser {
    private String mTanggal, mKategori, mJumlah, mCatatan, mChoice;

    public AdapterUser(String tanggal, String kategori, String jumlah, String catatan, String choice){
        mTanggal = tanggal;
        mKategori = kategori;
        mJumlah = jumlah;
        mCatatan = catatan;
        mChoice = choice;

    }

    public AdapterUser(int name) {

    }

    public String getmTanggal() {
        return mTanggal;
    }

    public String getmKategori() {
        return mKategori;
    }

    public String getmJumlah() {
        return mJumlah;
    }

    public String getmCatatan() {
        return mCatatan;
    }

    public String getmChoice() {
        return mChoice;
    }
}
