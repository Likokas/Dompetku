package com.uc.dompetku.model;

public class User{
    private String tanggal;
    private String kategori;
    private String jumlah;
    private String catatan;

    public User(String tanggal, String kategori, String jumlah, String catatan) {
        this.tanggal = tanggal;
        this.kategori = kategori;
        this.jumlah = jumlah;
        this.catatan = catatan;
    }
    public String getTanggal() {
        return tanggal;
    }

    public String getKategori() {
        return kategori;
    }

    public String getJumlah() {
        return jumlah;
    }

    public String getCatatan() { return catatan;}

    public String setTanggal(String tanggal) {
        return tanggal;
    }

    public String setKategori(String kategori) {
        return kategori;
    }

    public String setJumlah(String jumlah) { return jumlah; }

    public String setCatatan(String catatan) { return catatan; }


    }

