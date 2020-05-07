package com.uc.dompetku.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.uc.dompetku.model.User;

import java.util.ArrayList;
import java.util.List;

import com.uc.dompetku.db.DatabaseConstruct.TableColumns;

import static com.uc.dompetku.db.DatabaseConstruct.TABLE_TRANSAKSI;

public class TransaksiHelper {
    private static final String DATABASE_TABLE = TABLE_TRANSAKSI;
    private static DatabaseHelper databaseHelper;
    private static SQLiteDatabase database;
    private static TransaksiHelper INSTANCE;

    public TransaksiHelper(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public static TransaksiHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TransaksiHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    public void open() throws SQLException {
        database = databaseHelper.getWritableDatabase();
    }

    public void close() {
        databaseHelper.close();
        if (database.isOpen()) {
            database.close();
        }
    }

    public long insertData(User user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableColumns.TANGGAL, user.getmTanggal());
        contentValues.put(TableColumns.KATEGORI, user.getmKategori());
        contentValues.put(TableColumns.JUMLAH, user.getmJumlah());
        contentValues.put(TableColumns.CATATAN, user.getmCatatan());
        contentValues.put(TableColumns.CHOICE, user.getmChoice());
        return database.insert(DATABASE_TABLE, null, contentValues);
    }

    public ArrayList<User> allData() {
        ArrayList<User> users = new ArrayList<>();
        User user;
        Cursor cursor = database.query(DATABASE_TABLE, null, null, null, null, null, TableColumns._ID + " DESC", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            do {
                user = new User();
                user.setmId(cursor.getString(cursor.getColumnIndexOrThrow(TableColumns._ID)));
                user.setmTanggal(cursor.getString(cursor.getColumnIndexOrThrow(TableColumns.TANGGAL)));
                user.setmKategori(cursor.getString(cursor.getColumnIndexOrThrow(TableColumns.KATEGORI)));
                user.setmJumlah(cursor.getString(cursor.getColumnIndexOrThrow(TableColumns.JUMLAH)));
                user.setmCatatan(cursor.getString(cursor.getColumnIndexOrThrow(TableColumns.CATATAN)));
                user.setmChoice(cursor.getString(cursor.getColumnIndexOrThrow(TableColumns.CHOICE)));
                users.add(user);
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return users;
    }

    public int delete(String id){
        return database.delete(DATABASE_TABLE, TableColumns._ID + " = '" + id + "'", null);
    }
}


