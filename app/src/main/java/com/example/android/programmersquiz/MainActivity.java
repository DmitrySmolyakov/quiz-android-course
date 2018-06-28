package com.example.android.programmersquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        int rightAnswerCounter = 0;

        RadioGroup q1RadioGroup = (RadioGroup)findViewById(R.id.question_1_radio_group);
        int q1CheckedIndex = q1RadioGroup.indexOfChild(q1RadioGroup.findViewById(q1RadioGroup.getCheckedRadioButtonId()));
        if (q1CheckedIndex == 1) rightAnswerCounter++;

        CheckBox cb1 = (CheckBox)findViewById(R.id.cb_1);
        CheckBox cb2 = (CheckBox)findViewById(R.id.cb_2);
        CheckBox cb3 = (CheckBox)findViewById(R.id.cb_3);
        CheckBox cb4 = (CheckBox)findViewById(R.id.cb_4);
        if (cb1.isChecked() && cb2.isChecked() && !cb3.isChecked() && cb4.isChecked()) {
            rightAnswerCounter++;
        }

        EditText question3 = (EditText)findViewById(R.id.question_3);
        if (question3.getText().toString().equals("Sun Microsystems")) {
            rightAnswerCounter++;
        }

        RadioGroup q4RadioGroup = (RadioGroup)findViewById(R.id.question_4_radio_group);
        int q4CheckedIndex = q4RadioGroup.indexOfChild(q4RadioGroup.findViewById(q4RadioGroup.getCheckedRadioButtonId()));
        if (q4CheckedIndex == 1) rightAnswerCounter++;

        String resultText = "You answered on " + rightAnswerCounter + " from 4 questions.";
        if (rightAnswerCounter <= 2) {
            resultText = resultText + " Please, try to improve your result";
        } else if (rightAnswerCounter == 3) {
            resultText = resultText + " Not bad, but it could be better";
        } else {
            resultText = "Excellent work! " + resultText;
        }

        Toast.makeText(this, resultText,
                Toast.LENGTH_LONG).show();
    }
}
