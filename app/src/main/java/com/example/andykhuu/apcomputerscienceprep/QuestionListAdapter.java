package com.example.andykhuu.apcomputerscienceprep;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.example.andykhuu.apcomputerscienceprep.R.drawable.ic_menu_camera;

/**
 * Created by Andy Khuu on 6/12/2017.
 */

public class QuestionListAdapter extends ArrayAdapter<String> {

    public QuestionListAdapter(Context context, String[] numberOfQuestions) {
        super(context, 0 ,numberOfQuestions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        String questionNum = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.unitlayout_single, parent, false);
        }

        TextView question = (TextView) convertView.findViewById(R.id.questionNum);
        ImageView check = (ImageView) convertView.findViewById(R.id.answeredOrNot);

        question.setText(questionNum);

        List<Question> full = UnitActivity.getQuestions();
        List<Question> unanswered = QuestionManager.getUnansweredQuestions(UnitActivity.getCurrentUnitID());

        if(unanswered.contains(full.get(position))){
        }
        else {
            check.setImageResource(R.drawable.check);
        }
        return convertView;
    }
}
