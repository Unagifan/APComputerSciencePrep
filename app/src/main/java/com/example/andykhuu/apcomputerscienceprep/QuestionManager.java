package com.example.andykhuu.apcomputerscienceprep;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by frk_alkhuu on 6/12/2017.
 */

public class QuestionManager{
    private static QuestionManager instance = null;
    private static List<Question> unitZeroUnanswered;
    private static List<Question> unitOneUnanswered;
    private static List<Question> unitTwoUnanswered;
    private static List<Question> unitThreeUnanswered;
    private static List<Question> unitFourUnanswered;
    private static List<Question> unitFiveUnanswered;
    private static List<Question> unitSixUnanswered;

    protected QuestionManager() {
        unitZeroUnanswered = convertToQuestions(getUnitData(0,MainActivity.getContext()));
        unitOneUnanswered = convertToQuestions(getUnitData(1,MainActivity.getContext()));
        unitTwoUnanswered = convertToQuestions(getUnitData(2,MainActivity.getContext()));
        unitThreeUnanswered = convertToQuestions(getUnitData(3,MainActivity.getContext()));
        unitFourUnanswered = convertToQuestions(getUnitData(4,MainActivity.getContext()));
        unitFiveUnanswered = convertToQuestions(getUnitData(5,MainActivity.getContext()));
        unitSixUnanswered = convertToQuestions(getUnitData(6,MainActivity.getContext()));
    }
    public static QuestionManager getInstance() {
        if(instance == null) {
            instance = new QuestionManager();
        }
        return instance;
    }

    /**
     * Depending on the current unit pressed, retrieve the text file related to that unit and
     * read its content to a list
     * @return ArrayList of Strings which contains the questions data
     */
    public List<String> getUnitData(int unitID, Context c){
        ArrayList<String> unitData = new ArrayList<>();
        try {
            //Get the current unit passed in
            int currentUnitId = unitID;

            InputStream is;
            //Base off the current Unit pressed, get the unit text file related.
            switch (currentUnitId) {
                case 0:
                    is = c.getAssets().open("Unit0Questions.txt");
                    break;
                case 1:
                    is = c.getAssets().open("Unit1Questions.txt");
                    break;
                case 2:
                    is = c.getAssets().open("Unit2Questions.txt");
                    break;
                case 3:
                    is = c.getAssets().open("Unit3Questions.txt");
                    break;
                case 4:
                    is = c.getAssets().open("Unit4Questions.txt");
                    break;
                case 5:
                    is = c.getAssets().open("Unit5Questions.txt");
                    break;
                case 6:
                    is = c.getAssets().open("Unit6Questions.txt");
                    break;
                default:
                    is = c.getAssets().open("Unit0Questions.txt");
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

    /**
     * Convert the given raw data into a list of questions
     * @param unitData
     * @return
     */
    public static List<Question> convertToQuestions(List<String> unitData){
        ArrayList<Question> questions = new ArrayList<>();
        //From unitData, convert the given string into question objects and put it into a list of questions.
        for(int i = 3; i < unitData.size()-1; i+=7){
            Question temp = new Question(unitData.get(i),unitData.get(i+1),unitData.get(i+2)
                    ,unitData.get(i+3),unitData.get(i+4),unitData.get(i+5),Integer.parseInt(unitData.get(i+6)),Integer.parseInt(unitData.get(2)));
            questions.add(temp);
        }
        return questions;
    }

    public void removeQuestion(Question q, int unitID){
        switch(unitID) {
            case 0:
                if (unitZeroUnanswered.contains(q)) {
                    unitZeroUnanswered.remove(q);
                }
                break;
            case 1:
                if (unitOneUnanswered.contains(q)) {
                    unitOneUnanswered.remove(q);
                }
                break;
            case 2:
                if (unitTwoUnanswered.contains(q)) {
                    unitTwoUnanswered.remove(q);
                }
                break;
            case 3:
                if (unitThreeUnanswered.contains(q)) {
                    unitThreeUnanswered.remove(q);
                }
                break;
            case 4:
                if (unitFourUnanswered.contains(q)) {
                    unitFourUnanswered.remove(q);
                }
                break;
            case 5:
                if (unitFiveUnanswered.contains(q)) {
                    unitFiveUnanswered.remove(q);
                }
                break;
            case 6:
                if (unitSixUnanswered.contains(q)) {
                    unitSixUnanswered.remove(q);
                }
                break;
            default:
        }
    }
    public static List<Question> getUnansweredQuestions(int i){
        switch(i) {
            case 0:
                return unitZeroUnanswered;
            case 1:
                return unitOneUnanswered;
            case 2:
                return unitTwoUnanswered;
            case 3:
                return unitThreeUnanswered;
            case 4:
                return unitFourUnanswered;
            case 5:
                return unitFiveUnanswered;
            case 6:
                return unitSixUnanswered;
            default:
        }
        return unitZeroUnanswered;
    }

    public static List<Question> getUnitZeroUnanswered(){
        return unitZeroUnanswered;
    }
    public static List<Question> getUnitOneUnanswered(){ return unitOneUnanswered;}
    public static List<Question> getUnitTwoUnanswered(){ return unitTwoUnanswered;}
    public static List<Question> getUnitThreeUnanswered(){ return unitThreeUnanswered;}
    public static List<Question> getUnitFourUnanswered(){ return unitFourUnanswered;}
    public static List<Question> getUnitFiveUnanswered(){ return unitFiveUnanswered;}
    public static List<Question> getUnitSixUnanswered(){ return unitSixUnanswered;}





}
