package com.uc.dompetku.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.uc.dompetku.db.DatabaseConstruct.TableColumns;

import static androidx.constraintlayout.widget.Constraints.TAG;
import static com.uc.dompetku.db.DatabaseConstruct.TABLE_TRANSAKSI;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_dompetku";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_TRANSAKSI = "CREATE TABLE " + TABLE_TRANSAKSI + " ( "
            + TableColumns.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TableColumns.TANGGAL + " TEXT NOT NULL, "
            + TableColumns.KATEGORI + " TEXT NOT NULL, "
            + TableColumns.JUMLAH + " TEXT NOT NULL, "
            + TableColumns.CATATAN + " TEXT, "
            + TableColumns.CHOICE + " TEXT NOT NULL)";


    DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TRANSAKSI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSAKSI);
        onCreate(db);
    }
    public Integer deleteName(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(CREATE_TABLE_TRANSAKSI, "COLUMN_ID = ?", new String[] {String.valueOf(deleteName())});
    }
}
