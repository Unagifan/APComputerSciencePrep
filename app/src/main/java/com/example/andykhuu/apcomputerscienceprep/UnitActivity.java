package com.example.andykhuu.apcomputerscienceprep;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by frk_alkhuu on 5/25/2017.
 */

public class UnitActivity extends AppCompatActivity {

    private int currentUnitId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unitlayout_main);

        //Get the current unit passed in
        currentUnitId = getIntent().getIntExtra("UNITID", 0);

        List<String> mLines = new ArrayList<>();
        InputStream is = null;
        //Base off the current Unit pressed, get the unit text file related.
        switch (currentUnitId) {
            case 0:
                 is = getResources().getAssets().open("testFile.txt");
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = reader.readLine()) != null)
            mLines.add(line);

    }
}
