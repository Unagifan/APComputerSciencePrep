package com.example.andykhuu.apcomputerscienceprep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.util.Scanner;

/**
 * Created by frk_alkhuu on 5/25/2017.
 */

public class UnitActivity extends AppCompatActivity {

    private int currentUnitId;

    private File currentUnit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unitlayout_main);

        //Get the current unit needed
        currentUnitId = getIntent().getIntExtra("UNITID", 0);

        switch (currentUnitId) {
            case 0:
                currentUnit = new File("res/QuestionsFile/TestFile.txt");
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
        Scanner scanner = new Scanner(currentUnit);
    }
}
