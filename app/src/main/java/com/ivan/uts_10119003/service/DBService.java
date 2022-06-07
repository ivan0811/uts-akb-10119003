package com.ivan.uts_10119003.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.ivan.uts_10119003.model.CatatanModel;

public class DBService extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "catatan.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "catatan";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_JUDUL = "catatan_judul";
    private static final String COLUMN_KATEGORI = "catatan_kategori";
    private static final String COLUMN_KONTEN = "catatan_konten";
    private static final String COLUMN_CREATED_AT = "catatan_created_at";

    public DBService(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_JUDUL + " TEXT, " +
                COLUMN_KATEGORI + " TEXT, " +
                COLUMN_KONTEN + " TEXT, " +
                COLUMN_CREATED_AT + " TEXT)";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addCatatan(CatatanModel catatanModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_JUDUL, catatanModel.getJudul());
        cv.put(COLUMN_KATEGORI, catatanModel.getKategori());
        cv.put(COLUMN_KONTEN, catatanModel.getKonten());
        cv.put(COLUMN_CREATED_AT, catatanModel.getCreated_at());

        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Gagal", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Berhasil Menambahkan Database", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public void updateData(CatatanModel catatanModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        String id = catatanModel.getJudul();

        System.out.println("id" + id);

        cv.put(COLUMN_JUDUL, catatanModel.getJudul());
        cv.put(COLUMN_KATEGORI, catatanModel.getKategori());
        cv.put(COLUMN_KONTEN, catatanModel.getKonten());
        cv.put(COLUMN_CREATED_AT, catatanModel.getCreated_at());

//            Cursor cursor = db.rawQuery("update "+ TABLE_NAME
//                    + " set " + COLUMN_JUDUL + "='"+catatanModel.getJudul()+"', "
//                    + COLUMN_KATEGORI + "='"+ catatanModel.getKategori() +"', "
//                    + COLUMN_KONTEN + "='"+catatanModel.getKonten()+"' where _id='"+id + "'", null);

            long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{id});
            if(result == -1){
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
            }

            System.out.println(result);
    }

    public void deleteOneRow(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }


}
