package com.uc.dompetku.model;

public class User {

    private String tanggal, kategori, jumlah, catatan, choice;

    public User(String tanggal, String kategori, String jumlah, String catatan, String choice) {
        this.tanggal = tanggal;
        this.kategori = kategori;
        this.jumlah = jumlah;
        this.catatan = catatan;
        this.choice = choice;
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

    public String getUtanggal(String tanggal) {
        return tanggal;
    }

    public String getUkategori(String kategori) {
        return kategori;
    }

    public String getUjumlah(String jumlah) {
        return jumlah;
    }

    public String getUcatatan(String catatan) {
        return catatan;
    }

    public String getUchoice(String choice) {
        return choice;
    }

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

    public String setCatatan(String catatan) {
        return catatan;
    }

    public String setChoice(String choice) {
        return choice;
    }

}