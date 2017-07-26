package com.example.android.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by Maks on 26/07/2017.
 */

public final class ExerciceContract {
    public static final class ExerciceEntry implements BaseColumns {
        public final static String TABLE_NAME = "Exercices";

        public final static String _ID = "id";
        public final static String COLUMN_EXERCICE_DAY = "day";
        public final static String COLUMN_EXERCICE_PUSHUPS = "pushups";
        public final static String COLUMN_EXERCICE_CRUNCH = "crunches";
        public final static String COLUMN_EXERCICE_DIFFICULTY = "difficulty";
    }
}
