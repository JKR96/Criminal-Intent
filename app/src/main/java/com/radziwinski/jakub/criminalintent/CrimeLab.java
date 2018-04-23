package com.radziwinski.jakub.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;
    private static final int SIZE = 100;

    public static CrimeLab get(Context context) {
        if (sCrimeLab==null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        for (int i=0; i<SIZE; i++) {
            Crime crime = new Crime();
            crime.setTitle("Sprawa #" + i);
            crime.setSolved(i%2==0);
            mCrimes.add(crime);
        }
    }

    public List getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }

}
