package com.example.andykhuu.apcomputerscienceprep;

import android.widget.TextView;

import java.io.File;

/**
 * Created by frk_alkhuu on 5/23/2017.
 * The Question class is the code for the object which is known as Question.
 * Hypothetically from the text file this should get and contain all the necessary contents
 * to make a single question work.
 * 1 Question String
 * 5 Answer Strings
 */

public class Question {

    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correctAnswer;

    public Question(String question, String answer1, String answer2,
                    String answer3, String answer4,
                    String correctAnswer){
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer1(){
        return answer1;
    }

    public String getAnswer2(){
        return answer2;
    }

    public String getAnswer3(){return answer3;}

    public String getAnswer4(){
        return answer4;
    }

    public String getCorrectAnswer(){
        return correctAnswer;
    }
}
