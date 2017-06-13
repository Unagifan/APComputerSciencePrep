package com.example.andykhuu.apcomputerscienceprep;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by frk_alkhuu on 5/25/2017.
 * This activity controls all the functions inside the unit page
 * Based off the unit pressed, read the related unit text file and generate a list of questions
 * Maps to Question Activity which handles actual quizzing
 */

public class UnitActivity extends AppCompatActivity {

    private static int currentUnitId;
    private String unitTitle;
    private String unitDescription;

    private List<String> unitData;
    private static List<Question> questions;

    private String[] numberOfQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unitlayout_main);

        currentUnitId = getIntent().getIntExtra("UNITID", 0);
        QuestionManager q = QuestionManager.getInstance();
        //Get all the strings which make up all the questions
        this.unitData = q.getUnitData(currentUnitId,this);
        questions = q.convertToQuestions(unitData);

        generateLayout();
    }

    /**
     *Map the questions to question activity and pass in the related question object
     * to question activity
     */
    private void designListView(){
        //determine how many questions there are and map them to the unit_layout's listview
        numberOfQuestions = new String[questions.size()];
        for(int i = 0; i < numberOfQuestions.length;i++){
            numberOfQuestions[i] = "Question " + i;
        }

        QuestionListAdapter num = new QuestionListAdapter(UnitActivity.this,numberOfQuestions);
        ListView listView = (ListView) findViewById(R.id.QuestionsList);
        listView.setAdapter(num);

        //Map Listview's questions to question view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Question temp = questions.get(position);
                Intent i = new Intent(UnitActivity.this,QuestionActivity.class);
                //Pass question object into question activity
                i.putExtra("QUESTION",  temp);
                startActivity(i);
            }
        });
    }

    /**
     * generateLayout() designs the unitlayout for the unit activity dynamically based on each
     * specific unit.
     * Layout is under file name - unitlayout_main.xml
     * Layout should modify title, description, and generate
     * a listview of question numbers. Each of which is mapped to its respective question.
     */
    private void generateLayout(){
        //retrieve the title of the unit
        unitTitle = unitData.get(0);
        //retrieve the description for the unit
        unitDescription = unitData.get(1);

        //Set the unit Title
        setTitle(unitTitle);
        //Set the unit description
        TextView description = (TextView) findViewById(R.id.Description);
        description.setText(unitDescription);

        designListView();
    }

    @Override
    public void onBackPressed(){
        Intent i = new Intent(UnitActivity.this,MainActivity.class);
        startActivity(i);
    }

    public static List<Question> getQuestions(){
        return questions;
    }

    public static int getCurrentUnitID(){
        return currentUnitId;
    }

}

