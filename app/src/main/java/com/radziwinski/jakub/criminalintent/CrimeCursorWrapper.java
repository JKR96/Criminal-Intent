package com.radziwinski.jakub.criminalintent;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.Date;
import java.util.UUID;

public class CrimeCursorWrapper extends CursorWrapper {

    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeDbSchema.CrimeTable.COLS.UUID));
        String title = getString(getColumnIndex(CrimeDbSchema.CrimeTable.COLS.TITLE));
        long date = getLong(getColumnIndex(CrimeDbSchema.CrimeTable.COLS.DATE));
        int isSolved = getInt(getColumnIndex(CrimeDbSchema.CrimeTable.COLS.SOLVED));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setDate(new Date(date));
        crime.setSolved(isSolved!=0);

        return null;
    }
}
