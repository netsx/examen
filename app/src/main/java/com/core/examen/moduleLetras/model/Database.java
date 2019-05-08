package com.core.examen.moduleLetras.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "lyrics_db";


    public DataBase(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(LetrasData.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + LetrasData.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }


    public long insertNote(String artista,String lyrics) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(LetrasData.COLUMN_ARTIST, artista);
        values.put(LetrasData.COLUMN_LYRIC, lyrics);

        // insert row
        long id = db.insert(LetrasData.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }
    public LetrasData getNote(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(LetrasData.TABLE_NAME,
                         new String[]{LetrasData.COLUMN_ID, LetrasData.COLUMN_ARTIST, LetrasData.COLUMN_LYRIC},
                LetrasData.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        LetrasData note = new LetrasData(
                cursor.getInt(cursor.getColumnIndex(LetrasData.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(LetrasData.COLUMN_ARTIST)),
                cursor.getString(cursor.getColumnIndex(LetrasData.COLUMN_LYRIC)));

        cursor.close();

        return note;
    }


    public List<LetrasData> getAllNotes() {
        List<LetrasData> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + LetrasData.TABLE_NAME + " ORDER BY " +
                LetrasData.COLUMN_ARTIST + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                LetrasData letras = new LetrasData();
                letras.setId(cursor.getInt(cursor.getColumnIndex(LetrasData.COLUMN_ID)));
                letras.setArtist(cursor.getString(cursor.getColumnIndex(LetrasData.COLUMN_ARTIST)));
                letras.setLyric(cursor.getString(cursor.getColumnIndex(LetrasData.COLUMN_LYRIC)));

                notes.add(letras);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public int getLyrics() {
        String countQuery = "SELECT  * FROM " + LetrasData.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public void deleteNote(LetrasData letras) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(LetrasData.TABLE_NAME, LetrasData.COLUMN_ID + " = ?",
                new String[]{String.valueOf(letras.getId())});
        db.close();
    }


}
