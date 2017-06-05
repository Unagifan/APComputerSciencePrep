package com.example.andykhuu.apcomputerscienceprep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by frk_alkhuu on 5/30/2017.
 * The question activity is the broad activity in which all questions should be mapped to.
 * Handles answer selection logic and determines what answer is pressed and whether or not it
 * is the correct answer
 */

public class QuestionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionlayout_main);
    }
}
