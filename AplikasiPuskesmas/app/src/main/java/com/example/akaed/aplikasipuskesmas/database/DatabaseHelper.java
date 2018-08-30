package com.example.akaed.aplikasipuskesmas.database;

/**
 * Created by Cyber Pegasus on 8/30/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cyber Pegasus on 7/17/2018.
 */




public class DatabaseHelper extends SQLiteOpenHelper {

    //Constants for Database name, table name, and column names
    public static final String DB_NAME = "rekapDataPuskesma";
    public static final String TABLE_NAME = "dataKeluarga";
    public static final String COLUMN_NIK = "NIK";
    public static final String COLUMN_NAMA = "NAMA";
    public static final String COLUMN_BPJS = "BPJS";
    public static final String COLUMN_JK ="JENIS KELAMIN" ;
    public static final String COLUMN_AGAMA = "AGAMA";
    public static final String COLUMN_PENDIDIKAN = "PENDIDIKAN";
    public static final String COLUMN_PEKERJAAN = "PEKERJAAN";
    public static final String COLUMN_BERAT_BADAN = "BERAT_BADAN";
    public static final String COLUMN_TINGGI_BADAN = "TINGGI_BADAN";
    public static final String COLUMN_SISTOLE = "SISTOLE";
    public static final String COLUMN_DIASTOLE = "DIASTOLE";
    public static final String COLUMN_GULA_DARAH = "GULA DARAH";


    //database version
    private static final int DB_VERSION = 1;

    //Constructor
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //Membuat database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME
                + "(" + COLUMN_NIK + ","
                + COLUMN_NAMA + " VARCHAR,"
                + COLUMN_BPJS + " VARCHAR,"
                + COLUMN_JK + " VARCHAR,"
                + COLUMN_AGAMA + " VARCHAR,"
                + COLUMN_PENDIDIKAN+ " VARCHAR,"
                + COLUMN_PEKERJAAN + " VARCHAR,"
                + COLUMN_BERAT_BADAN + " DOUBLE,"
                + COLUMN_TINGGI_BADAN + " DOUBLE,"
                + COLUMN_SISTOLE + " DOUBLE,"
                + COLUMN_DIASTOLE + " DOUBLE,"
                + COLUMN_GULA_DARAH + " DOUBLE";

        db.execSQL(sql);
    }

    //upgrading the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Persons";
        db.execSQL(sql);
        onCreate(db);
    }

    public boolean addDataLokal(String nik, String nama, String bpjs, String jk,
                                String agama, String pendidikan, Double pekerjaan, Double bb,
                                Double tb, Double sistole, Double diastol, Double gula_darah) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NIK, nik);
        contentValues.put(COLUMN_NAMA, nama);
        contentValues.put(COLUMN_BPJS, bpjs);
        contentValues.put(COLUMN_JK, jk);
        contentValues.put(COLUMN_AGAMA, agama);
        contentValues.put(COLUMN_PENDIDIKAN, pendidikan);
        contentValues.put(COLUMN_PEKERJAAN, pekerjaan);
        contentValues.put(COLUMN_BERAT_BADAN, bb);
        contentValues.put(COLUMN_TINGGI_BADAN, tb);
        contentValues.put(COLUMN_SISTOLE, sistole);
        contentValues.put(COLUMN_DIASTOLE, diastol);
        contentValues.put(COLUMN_GULA_DARAH, gula_darah);


        long result =  db.insert(TABLE_NAME, null, contentValues);

        if (result == -1){
            return false;
        }else{
            return true;
        }

    }

    /*Metode ini mengambil dua argumen
    * Yang pertama adalah id dari nama untuk itu
    * kita harus memperbarui status sinkronisasi
    * dan yang kedua adalah status yang akan diubah
    * */

    /*

    public boolean updateDataStatus(int id, int status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_STATUS, status);
        db.update(TABLE_NAME, contentValues, COLUMN_ID + "=" + id, null);
        db.close();
        return true;
    }
*/

    /*
    * metode ini akan memberi kita semua data yang disimpan dalam sqlite
    * */
    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + COLUMN_NIK + " ASC;";
        Cursor c = db.rawQuery(sql, null);
        return c;
    }

    /*
    * metode ini untuk mendapatkan semua nama yang tidak disinkronkan
    * sehingga kita bisa menyinkronkannya dengan basis data
    * */
    public Cursor getDataKeluarga(String keluarga) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_NIK + " = "+ keluarga +"; ";
        Cursor c = db.rawQuery(sql, null);
        return c;
    }



}
