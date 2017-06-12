package com.example.andykhuu.apcomputerscienceprep;

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

    private int currentUnitId;
    private String unitTitle;
    private String unitDescription;

    private List<String> unitData;
    private List<Question> questions;

    private String[] numberOfQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unitlayout_main);
        //Get all the strings which make up all the questions
        this.unitData = getUnitData();
        questions = new ArrayList<>();

        //From unitData, convert the given string into question objects and put it into a list of questions.
        for(int i = 3; i < unitData.size()-1; i+=7){
            Question temp = new Question(unitData.get(i),unitData.get(i+1),unitData.get(i+2)
                    ,unitData.get(i+3),unitData.get(i+4),unitData.get(i+5),Integer.parseInt(unitData.get(i+6)),Integer.parseInt(unitData.get(2)));
            questions.add(temp);
        }
        generateLayout();
    }

    /**
     * Depending on the current unit pressed, retrieve the text file related to that unit and
     * read its content to a list
     * @return ArrayList of Strings which contains the questions data
     */
    private List<String> getUnitData(){
        try {
            //Get the current unit passed in
            currentUnitId = getIntent().getIntExtra("UNITID", 0);

            unitData = new ArrayList<>();
            InputStream is;
            //Base off the current Unit pressed, get the unit text file related.
            switch (currentUnitId) {
                case 0:
                    is = getResources().getAssets().open("Unit0Questions.txt");
                    break;
                case 1:
                    is = getResources().getAssets().open("Unit1Questions.txt");
                    break;
                case 2:
                    is = getResources().getAssets().open("Unit2Questions.txt");
                    break;
                case 3:
                    is = getResources().getAssets().open("Unit3Questions.txt");
                    break;
                case 4:
                    is = getResources().getAssets().open("Unit4Questions.txt");
                    break;
                case 5:
                    is = getResources().getAssets().open("Unit5Questions.txt");
                    break;
                case 6:
                    is = getResources().getAssets().open("Unit6Questions.txt");
                    break;
                default:
                    is = getResources().getAssets().open("Unit0Questions.txt");
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
     *Map the questions to question activity and pass in the related question object
     * to question activity
     */
    private void designListView(){
        //determine how many questions there are and map them to the unit_layout's listview
        numberOfQuestions = new String[questions.size()];
        for(int i = 0; i < numberOfQuestions.length;i++){
            numberOfQuestions[i] = "Question " + i;
        }

        ArrayAdapter<String> num = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,numberOfQuestions);
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
}

