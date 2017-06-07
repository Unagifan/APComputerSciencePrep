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

    private TextView question;
    private TextView answer0;
    private TextView answer1;
    private TextView answer2;
    private TextView answer3;
    private TextView answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionlayout_main);

        //Set selected to an unused value
        selected = -1;
        //Retrieve Question Object
        QUESTION = getIntent().getParcelableExtra("QUESTION");
        //Determine which feedbackText contains the correct answer
        correctAnswer = QUESTION.getCorrectAnswer();
        //Map questions and answers to layout and setup answer selection logic
        answerSelection();
    }

    /**
     * Fills out the layout for the question activity and sets up the answer selection logic/system
     */
    private void answerSelection(){
        question = (TextView) findViewById(R.id.question);
        question.setText(QUESTION.getQuestion());

        answer0 = (TextView) findViewById(R.id.answer0);
        answer0.setText(QUESTION.getAnswers()[0]);
        answer0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 0;
                nullBackground();
                answer0.setBackgroundResource(R.drawable.selectedborder);
            }
        });

        answer1 = (TextView) findViewById(R.id.answer1);
        answer1.setText(QUESTION.getAnswers()[1]);
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 1;
                nullBackground();
                answer1.setBackgroundResource(R.drawable.selectedborder);
            }
        });

        answer2 = (TextView) findViewById(R.id.answer2);
        answer2.setText(QUESTION.getAnswers()[2]);
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 2;
                nullBackground();
                answer2.setBackgroundResource(R.drawable.selectedborder);
            }
        });

        answer3 = (TextView) findViewById(R.id.answer3);
        answer3.setText(QUESTION.getAnswers()[3]);
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 3;
                nullBackground();
                answer3.setBackgroundResource(R.drawable.selectedborder);
            }
        });

        answer4 = (TextView) findViewById(R.id.answer4);
        answer4.setText(QUESTION.getAnswers()[4]);
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 4;
                nullBackground();
                answer4.setBackgroundResource(R.drawable.selectedborder);
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
                if(selected != -1) {
                    startActivity(i);
                }
            }
        });
    }
    private void nullBackground(){
        answer0.setBackground(null);
        answer1.setBackground(null);
        answer2.setBackground(null);
        answer3.setBackground(null);
        answer4.setBackground(null);
    }

}

