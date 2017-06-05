package com.example.andykhuu.apcomputerscienceprep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by frk_alkhuu on 5/30/2017.
 * The question activity is the broad activity in which all questions should be mapped to.
 * Handles answer selection logic and determines what answer is pressed and whether or not it
 * is the correct answer
 */

public class QuestionActivity extends AppCompatActivity {

    private Question QUESTION;
    private TextView correctAnswer;
    private TextView selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionlayout_main);

        //Retrieve Question Object
        QUESTION = getIntent().getParcelableExtra("QUESTION");
        //Determine which textView contains the correct answer
        int temp = getResources().getIdentifier("answer" + QUESTION.getCorrectAnswer(),"id",getPackageName());
        correctAnswer = (TextView) findViewById(temp);

        TextView question = (TextView) findViewById(R.id.question);
        question.setText(QUESTION.getQuestion());

        TextView answer0 = (TextView) findViewById(R.id.answer0);
        answer0.setText(QUESTION.getAnswers()[0]);
        answer0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        TextView answer1 = (TextView) findViewById(R.id.answer1);
        answer1.setText(QUESTION.getAnswers()[1]);

        TextView answer2 = (TextView) findViewById(R.id.answer2);
        answer2.setText(QUESTION.getAnswers()[2]);

        TextView answer3 = (TextView) findViewById(R.id.answer3);
        answer3.setText(QUESTION.getAnswers()[3]);

        TextView answer4 = (TextView) findViewById(R.id.answer4);
        answer4.setText(QUESTION.getAnswers()[4]);

    }
}

