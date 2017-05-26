package com.example.andykhuu.apcomputerscienceprep;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    private List<String> unitData;
    private List<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unitlayout_main);
        this.unitData = getUnitData();
        questions = new ArrayList<>();

        for(int i = 0; i < unitData.size()-1; i+=4){
            Question temp = new Question(unitData.get(i),unitData.get(i+1),unitData.get(i+2)
                    ,unitData.get(i+3),unitData.get(i+4),unitData.get(i+5));
            questions.add(temp);
        }

    }

    /**
     * Depending on the current unit pressed retrieve the text file related to that unit and
     * read its content to a list
     * @return ArrayList of Strings which contains the questions
     */
    private List<String> getUnitData(){
        try {
            //Get the current unit passed in
            currentUnitId = getIntent().getIntExtra("UNITID", 0);

            unitData = new ArrayList<>();
            InputStream is;
            //Base off the current Unit pressed, get the unit text file related.
            switch (currentUnitId) {
                case 0:
                    is = getResources().getAssets().open("testFile.txt");
                    break;
                case 1:
                    is = getResources().getAssets().open("testFile.txt");
                    break;
                case 2:
                    is = getResources().getAssets().open("testFile.txt");
                    break;
                case 3:
                    is = getResources().getAssets().open("testFile.txt");
                    break;
                case 4:
                    is = getResources().getAssets().open("testFile.txt");
                    break;
                case 5:
                    is = getResources().getAssets().open("testFile.txt");
                    break;
                case 6:
                    is = getResources().getAssets().open("testFile.txt");
                    break;
                default:
                    is = getResources().getAssets().open("testFile.txt");
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null)
                unitData.add(line);

        }catch(IOException e){
            e.printStackTrace();
        }
        return unitData;
    }
}

