package com.uc.dompetku.activities;

public class User {
    private String tanggal, kategori;
    private String jumlah;

    public User( String tanggal, String kategori, String jumlah) {
        this.tanggal = tanggal;
        this.kategori = kategori;
        this.jumlah = jumlah;
    }

//    protected User(Parcel in) {
//        name = in.readString();
//        address = in.readString();
//        age = in.readString();
//    }

//    public static final Creator<User> CREATOR = new Creator<User>() {
//        @Override
//        public User createFromParcel(Parcel in) {
//            return new User(in);
//        }
//
//        @Override
//        public User[] newArray(int size) {
//            return new User[size];
//        }
//    };

    public String getTanggal() {
        return tanggal;
    }

    public String getKategori() { return kategori; }

    public String getJumlah() { return jumlah; }

//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(name);
//        dest.writeString(address);
//        dest.writeString(age);
//    }

    public String setTanggal(String tanggal) {
        return tanggal;
    }

    public String setKategori(String kategori) {
        return kategori;
    }

    public String setJumlah(String jumlah) {
        return jumlah;
    }
}

