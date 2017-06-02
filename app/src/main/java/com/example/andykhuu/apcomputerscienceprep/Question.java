package com.example.andykhuu.apcomputerscienceprep;

import android.os.Parcelable;
import android.widget.TextView;

import java.io.File;

/**
 * Created by frk_alkhuu on 5/23/2017.
 * The Question class is the code for the object which is known as Question.
 * Hypothetically from the text file this should get and contain all the necessary contents
 * to make a single question work.
 * 1 Question String
 * A Array of Strings which contains the answers
 * A integer which is the index of the correct answer
 */

public class Question {

    private String question;
    private String[] answers = new String[5];
    private int correctAnswerIndex;

    public Question(String question, String answer1, String answer2,
                    String answer3, String answer4,
                    String answer5, int correctAnswerIndex){
        this.question = question;
        this.answers = new String[]{answer1,answer2,answer3,answer4,answer5};
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion(){
        return question;
    }

    public String[] getAnswers(){ return answers;}

    public int getCorrectAnswer(){
        return correctAnswerIndex;
    }
}
