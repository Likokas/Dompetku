package com.uc.dompetku.model;

public class User {
    private String mId, mTanggal, mKategori, mJumlah, mCatatan, mChoice;
    public static String getcatatan, getid;

    public User( String tanggal, String kategori, String jumlah, String catatan, String choice){
        mTanggal = tanggal;
        mKategori = kategori;
        mJumlah = jumlah;
        mCatatan = catatan;
        mChoice = choice;
    }

    public User() {

    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public void setmTanggal(String mTanggal) {
        this.mTanggal = mTanggal;
    }

    public void setmKategori(String mKategori) {
        this.mKategori = mKategori;
    }

    public void setmJumlah(String mJumlah) {
        this.mJumlah = mJumlah;
    }

    public void setmCatatan(String mCatatan) {
        this.mCatatan = mCatatan;
    }

    public void setmChoice(String mChoice) {
        this.mChoice = mChoice;
    }

    public String getmId() {
        return mId;
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
