package com.uc.dompetku.activities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class myDbAdapter {

    myDbHelper myhelper;

    public myDbAdapter(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String tanggal, String kategori, String jumlah, String catatan, String choice)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.TANGGAL, tanggal);
        contentValues.put(myDbHelper.KATEGORI, kategori);
        contentValues.put(myDbHelper.JUMLAH, jumlah);
        contentValues.put(myDbHelper.CATATAN, catatan);
        contentValues.put(myDbHelper.CHOICE, choice);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

//

    public List<User> allPlayers() {
        List<User> users = new ArrayList<>();
        String selectQuery = "SELECT * FROM user";
        SQLiteDatabase db = myhelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Log.e("tanggal", cursor.getString(1));
                User user = new User(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));

                users.add(user);
            } while (cursor.moveToNext());
        }

        db.close();
        Log.e("list", users.toString());
        return users;
    }


    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "myDatabase";    // Database Name
        private static final String TABLE_NAME = "user";   // Table Name
        private static final int DATABASE_Version = 1;   // Database Version
        private static final String UID="_id";
        private static final String TANGGAL = "tanggal";
        private static final String KATEGORI = "kategori";
        private static final String JUMLAH = "jumlah";
        private static final String CATATAN = "catatan";
        private static final String CHOICE = "choice";
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+TANGGAL+" VARCHAR(255) ,"+ KATEGORI+" VARCHAR(255), "+JUMLAH+" VARCHAR(225), "+CATATAN+" VARCHAR(225), "+CHOICE+" VARCHAR(225));";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
