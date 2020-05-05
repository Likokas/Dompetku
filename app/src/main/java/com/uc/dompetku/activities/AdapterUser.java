package com.uc.dompetku.activities;

public class AdapterUser {
    private String mTanggal, mKategori, mJumlah;

    public AdapterUser(String tanggal, String kategori, String jumlah){
        mTanggal = tanggal;
        mKategori = kategori;
        mJumlah = jumlah;
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
}
