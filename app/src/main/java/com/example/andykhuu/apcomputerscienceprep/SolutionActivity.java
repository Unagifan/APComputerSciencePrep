package com.example.andykhuu.apcomputerscienceprep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by frk_alkhuu on 6/5/2017.
 */

public class SolutionActivity extends AppCompatActivity {
    ImageView image;
    TextView feedbackText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solutionlayout_main);
        boolean isCorrect = getIntent().getBooleanExtra("CORRECT", false);

        image = (ImageView) findViewById(R.id.solutionImageView);
        feedbackText = (TextView) findViewById(R.id.feedbackText);
        //Set correct/incorrect message and image
        if(isCorrect){
            image.setImageResource(R.drawable.ic_thumbsup);
            feedbackText.setText("Correct!");
        } else {
            image.setImageResource(R.drawable.ic_thumbsdown);
            feedbackText.setText("Incorrect. You are wrong because you chose the wrong answer.");
        }

    }

}
