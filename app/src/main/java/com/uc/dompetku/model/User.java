package com.uc.dompetku.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String tanggal;
    private String kategori;
    private String jumlah;

    public User(String tanggal, String kategori, String jumlah) {
        this.tanggal = tanggal;
        this.kategori = kategori;
        this.jumlah = jumlah;
    }

    public User(Parcel in) {
        tanggal = in.readString();
        kategori = in.readString();
        jumlah = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };


    public String getName() {
        return tanggal;
    }

    public void setName(String name) {
        this.tanggal = tanggal;
    }

    public String getAge() {
        return kategori;
    }

    public void setAge(String age) {
        this.kategori= kategori;
    }

    public String getAddress() {
        return jumlah;
    }

    public void setAddress(String address) {
        this.jumlah = jumlah;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tanggal);
        dest.writeString(kategori);
        dest.writeString(jumlah);
    }
}
