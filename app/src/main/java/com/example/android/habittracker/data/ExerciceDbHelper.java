package com.example.android.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.habittracker.data.ExerciceContract.ExerciceEntry;

/**
 * Created by Maks on 26/07/2017.
 */

public class ExerciceDbHelper extends SQLiteOpenHelper {

    // Name of the database
    public static final String DATABASE_NAME = "workout.db";

    // Version of the database - if you update schema, you must increment this
    public static final int DATABASE_VERSION = 1;

    public ExerciceDbHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // String that cointains the SQL statement to create the exercices table
        String SQL_CREATE_EXERCICES_TABLE =  "CREATE TABLE " + ExerciceEntry.TABLE_NAME + " ("
                + ExerciceEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ExerciceEntry.COLUMN_EXERCICE_DAY + " INTEGER NOT NULL, "
                + ExerciceEntry.COLUMN_EXERCICE_PUSHUPS + " INTEGER NOT NULL DEFAULT 0, "
                + ExerciceEntry.COLUMN_EXERCICE_CRUNCH + " INTEGER NOT NULL DEFAULT 0, "
                + ExerciceEntry.COLUMN_EXERCICE_DIFFICULTY + " TEXT);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_EXERCICES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Nothing to be done as of now.
    }
}
