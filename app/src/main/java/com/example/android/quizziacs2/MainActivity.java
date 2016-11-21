package com.example.android.quizziacs2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
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

    public void results(View view) {
        int totalScore = 0;
//question 1 checker
        RadioGroup options = (RadioGroup) findViewById(R.id.answer1_options);
        RadioButton selectedOption = (RadioButton) findViewById(options.getCheckedRadioButtonId());
        if (selectedOption == findViewById(R.id.jeoffery)) totalScore++;
        //question 2 checker
        RadioGroup options2 = (RadioGroup) findViewById(R.id.answer2_options);
        RadioButton selectedOption2 = (RadioButton) findViewById(options2.getCheckedRadioButtonId());
        if (selectedOption2 == findViewById(R.id.ober)) totalScore++;
        //question 3 checker
        RadioGroup options3 = (RadioGroup) findViewById(R.id.answer3_options);
        RadioButton selectedOption3 = (RadioButton) findViewById(options3.getCheckedRadioButtonId());
        if (selectedOption3 == findViewById(R.id.hound)) totalScore++;
        //question 4 checker
        RadioGroup options4 = (RadioGroup) findViewById(R.id.answer4_options);
        RadioButton selectedOption4 = (RadioButton) findViewById(options4.getCheckedRadioButtonId());
        if (selectedOption4 == findViewById(R.id.jamie)) totalScore++;

        //question 5 checker CheckBoxes
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.d1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.d2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.d3);
        if (checkBox1.isChecked()) {
            totalScore++;
        }
        if (checkBox2.isChecked()) {
            totalScore++;
        }
        if (checkBox3.isChecked()) {
            totalScore++;
        }

        //set strings to compare the user answer with the correct one
        EditText answer = ((EditText) findViewById(R.id.freeAnswer));
        String userAnswer = answer.getText().toString();
        String correctAnswer = getString(R.string.freeAnswer);
        // if correct then toast shows "Right" and adds +1 to the totalScore
        if ((userAnswer.equals(correctAnswer)) || (userAnswer.equals(correctAnswer.toLowerCase()))) {
            totalScore++;
        }

        //toast created to show user the results of his/her score out of 5
        if(totalScore >= 5) {
            Toast toast = Toast.makeText(this, "All Hail King/Queen of the North! " + totalScore + " out of 7!" + " (Possible 8pts)", Toast.LENGTH_LONG);
            //toast is centered on the screen
            toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
            //displays the toast
            toast.show();
        } else if (totalScore < 5) {
            Toast toast = Toast.makeText(this, "Watch More Game of Thrones! " + totalScore + " out of 7!" + " (Possible 8pts)", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
            //displays the toast
            toast.show();
        }
    }
}

