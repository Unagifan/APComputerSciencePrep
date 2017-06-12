package com.example.andykhuu.apcomputerscienceprep;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by frk_alkhuu on 6/5/2017.
 */

public class SolutionActivity extends AppCompatActivity {
    ImageView image;
    TextView feedbackText;
    Button back;
    int UnitID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solutionlayout_main);
        boolean isCorrect = getIntent().getBooleanExtra("CORRECT", false);
        UnitID = getIntent().getIntExtra("UNITID",1);

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

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SolutionActivity.this,UnitActivity.class);
                i.putExtra("UNITID",UnitID);
                startActivity(i);
            }
        });

    }

}
