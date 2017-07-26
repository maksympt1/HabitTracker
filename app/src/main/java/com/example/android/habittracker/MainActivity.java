package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.habittracker.data.ExerciceContract.ExerciceEntry;
import com.example.android.habittracker.data.ExerciceDbHelper;

public class MainActivity extends AppCompatActivity {

    private ExerciceDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new ExerciceDbHelper(this);
    }

    private Cursor displayDatabaseInfo() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Columns to use
        String[] projection = {
                ExerciceEntry.COLUMN_EXERCICE_DAY,
                ExerciceEntry.COLUMN_EXERCICE_PUSHUPS,
                ExerciceEntry.COLUMN_EXERCICE_CRUNCH,
                ExerciceEntry.COLUMN_EXERCICE_DIFFICULTY};

        // Perform a query on exercices table.
        Cursor cursor = db.query(
                ExerciceEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);

        return cursor;
    }

    private void insertExercice() {
        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and Toto's pet attributes are the values.
        ContentValues values = new ContentValues();
        values.put(ExerciceEntry.COLUMN_EXERCICE_DAY, 1);
        values.put(ExerciceEntry.COLUMN_EXERCICE_PUSHUPS, 20);
        values.put(ExerciceEntry.COLUMN_EXERCICE_DIFFICULTY, "hard");

        db.insert(ExerciceEntry.TABLE_NAME, null, values);
    }
}
