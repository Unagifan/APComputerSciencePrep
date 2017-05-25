package com.example.andykhuu.apcomputerscienceprep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by frk_alkhuu on 5/25/2017.
 */

public class UnitActivity extends AppCompatActivity {

    private int currentUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unitlayout_main);

        currentUnit = (int) getIntent().getIntExtra("UNITID", 0);

        switch (currentUnit) {
            case 0:
            case 1:
                System.out.println();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
}
