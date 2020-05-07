package com.uc.dompetku.db;

import android.provider.BaseColumns;

public class DatabaseConstruct {
    static final String TABLE_TRANSAKSI = "Transaksi";

    static final class TableColumns implements BaseColumns {
        static final String COLUMN_ID = "_id";
        static final String TANGGAL = "tanggal";
        static final String KATEGORI = "kategori";
        static final String JUMLAH = "jumlah";
        static final String CATATAN = "catatan";
        static final String CHOICE = "choice";
    }
}
