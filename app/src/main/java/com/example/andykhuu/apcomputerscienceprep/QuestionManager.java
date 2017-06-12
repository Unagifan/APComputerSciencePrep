package com.example.andykhuu.apcomputerscienceprep;

import java.util.List;

/**
 * Created by frk_alkhuu on 6/12/2017.
 */

public class QuestionManager{
    private static QuestionManager instance = null;
    private List<Question> unitZeroUnanswered;
    private List<Question> unitOneUnanswered;
    private List<Question> unitTwoUnanswered;
    private List<Question> unitThreeUnanswered;
    private List<Question> unitFourUnanswered;
    private List<Question> unitFiveUnanswered;
    private List<Question> unitSixUnanswered;

    protected QuestionManager() {

        // Exists only to defeat instantiation.
    }
    public static QuestionManager getInstance() {
        if(instance == null) {
            instance = new QuestionManager();
        }
        return instance;
    }

}
