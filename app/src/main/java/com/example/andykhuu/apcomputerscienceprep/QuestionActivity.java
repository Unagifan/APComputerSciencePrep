package com.example.andykhuu.apcomputerscienceprep;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by frk_alkhuu on 5/30/2017.
 * The question activity is the broad activity in which all questions should be mapped to.
 * Handles answer selection logic and determines what answer is pressed and whether or not it
 * is the correct answer
 */

public class QuestionActivity extends AppCompatActivity {

    private Question QUESTION;
    private int correctAnswer;
    private int selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionlayout_main);

        //Retrieve Question Object
        QUESTION = getIntent().getParcelableExtra("QUESTION");
        //Determine which textView contains the correct answer
        correctAnswer = QUESTION.getCorrectAnswer();

        answerSelection();


    }

    private void answerSelection(){
        TextView question = (TextView) findViewById(R.id.question);
        question.setText(QUESTION.getQuestion());

        TextView answer0 = (TextView) findViewById(R.id.answer0);
        answer0.setText(QUESTION.getAnswers()[0]);
        answer0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 0;
            }
        });

        TextView answer1 = (TextView) findViewById(R.id.answer1);
        answer1.setText(QUESTION.getAnswers()[1]);
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 1;
            }
        });

        TextView answer2 = (TextView) findViewById(R.id.answer2);
        answer2.setText(QUESTION.getAnswers()[2]);
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 2;
            }
        });

        TextView answer3 = (TextView) findViewById(R.id.answer3);
        answer3.setText(QUESTION.getAnswers()[3]);
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 3;
            }
        });

        TextView answer4 = (TextView) findViewById(R.id.answer4);
        answer4.setText(QUESTION.getAnswers()[4]);
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 4;
            }
        });

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuestionActivity.this, SolutionActivity.class);
                if(selected ==  correctAnswer){
                    i.putExtra("CORRECT",true);
                    startActivity(i);
                }
                else if(selected >= 0 && selected <= 4){
                    i.putExtra("CORRECT",false);
                    startActivity(i);
                }
            }
        });
    }
}

