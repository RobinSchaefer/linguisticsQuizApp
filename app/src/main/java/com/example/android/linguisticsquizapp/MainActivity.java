package com.example.android.linguisticsquizapp;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    int numberOfQuestions = 8;
    int numberOfCheckQuestions = 2;

    public void evaluateResults (View view) {

        // This method is applied when "submit" is pressed

        Boolean[] buttonArray = evaluateCorrectButtons();

        int points = calculateResults(buttonArray);

        String resultsMessage = createResultsMessage(points, numberOfQuestions, numberOfCheckQuestions);

        Toast toast = Toast.makeText(this, resultsMessage, Toast.LENGTH_LONG);
        toast.show();

    }

    public Boolean [] evaluateCorrectButtons (){

        //the method retrieves all the given answers and transfers them into booleans

        // question 1
        RadioButton radioButton1c = findViewById(R.id.question1_c);
        Boolean isPressed1c = radioButton1c.isChecked();

        //question 2
        RadioButton radioButton2b = findViewById(R.id.question2_b);
        Boolean isPressed2b = radioButton2b.isChecked();

        //question 3
        EditText question3Input = (EditText) findViewById(R.id.question3_input);
        String question3Answer = question3Input.getText().toString().trim().toLowerCase();
        Boolean question3Correct = false;
        String correctAnswer = "morphology";
        if (question3Answer.equals(correctAnswer)) {
            question3Correct = true;
        };

        //question 4
        RadioButton radioButton4b = findViewById(R.id.question4_b);
        Boolean isPressed4b = radioButton4b.isChecked();

        // question 5
        CheckBox checkBox5a = findViewById(R.id.question5_a);
        Boolean isPressed5a = checkBox5a.isChecked();

        CheckBox checkBox5b = findViewById(R.id.question5_b);
        Boolean isPressed5b = checkBox5b.isChecked();

        CheckBox checkBox5c = findViewById(R.id.question5_c);
        Boolean isPressed5c = checkBox5c.isChecked();

        CheckBox checkBox5d = findViewById(R.id.question5_d);
        Boolean isPressed5d = checkBox5d.isChecked();

        //question 6
        RadioButton radioButton6d = findViewById(R.id.question6_d);
        Boolean isPressed6d = radioButton6d.isChecked();

        //question 7
        RadioButton radioButton7c = findViewById(R.id.question7_c);
        Boolean isPressed7c = radioButton7c.isChecked();

        // question 8
        CheckBox checkBox8a = findViewById(R.id.question8_a);
        Boolean isPressed8a = checkBox8a.isChecked();

        CheckBox checkBox8b = findViewById(R.id.question8_b);
        Boolean isPressed8b = checkBox8b.isChecked();

        CheckBox checkBox8c = findViewById(R.id.question8_c);
        Boolean isPressed8c = checkBox8c.isChecked();

        CheckBox checkBox8d = findViewById(R.id.question8_d);
        Boolean isPressed8d = checkBox8d.isChecked();


        // stores the answers booleans into an array (for calculateResults())
        Boolean[] answerBooleans = {isPressed1c, isPressed2b, question3Correct, isPressed4b, isPressed5a, isPressed5d, isPressed6d, isPressed7c, isPressed8b, isPressed8d};
        return answerBooleans;
    }

    public int calculateResults (Boolean[] answerBooleans) {
        int points = 0;
        // calculate the number of scored points
        for (Boolean answer: answerBooleans) {
            if (answer) {
                points += 1;
            }
        }
        return points;
    }

    public String createResultsMessage (int points, int numberOfQuestions, int numberOfCheckQuestions) {

        // get name of participant for text message
        EditText nameInput = (EditText) findViewById(R.id.input_name);
        String candidateName = nameInput.getText().toString();

        // calculate the number of possible points
        int numberOfPoints = numberOfQuestions + numberOfCheckQuestions;
        String resultsMessage;

        // create message depending on point number
        if (points >= 7) {
            resultsMessage = "Congrats, " + candidateName + "!\n";
            resultsMessage += "You received " + points + " out of " + numberOfPoints + " points!";
        } else {
            resultsMessage = "Okay " + candidateName + ",\n";
            resultsMessage += "You received " + points + " out of " + numberOfPoints + " points!\n";
            resultsMessage += "You should work harder ;)";
        }

        return resultsMessage;
    }

    public void resetQuiz (View view){

        // clear edit texts
        EditText nameInput = (EditText) findViewById(R.id.input_name);
        nameInput.getText().clear();

        EditText question3Input = (EditText) findViewById(R.id.question3_input);
        question3Input.getText().clear();

        // Clear radio groups
        RadioGroup radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup1.clearCheck();

        RadioGroup radioGroup2 = findViewById(R.id.radioGroup2);
        radioGroup2.clearCheck();

        RadioGroup radioGroup4 = findViewById(R.id.radioGroup4);
        radioGroup4.clearCheck();

        RadioGroup radioGroup6 = findViewById(R.id.radioGroup6);
        radioGroup6.clearCheck();

        RadioGroup radioGroup7 = findViewById(R.id.radioGroup7);
        radioGroup7.clearCheck();

        // Clear check boxes
        CheckBox checkBox5a = findViewById(R.id.question5_a);
        checkBox5a.setChecked(false);

        CheckBox checkBox5b = findViewById(R.id.question5_b);
        checkBox5b.setChecked(false);

        CheckBox checkBox5c = findViewById(R.id.question5_c);
        checkBox5c.setChecked(false);

        CheckBox checkBox5d = findViewById(R.id.question5_d);
        checkBox5d.setChecked(false);

        CheckBox checkBox8a = findViewById(R.id.question8_a);
        checkBox8a.setChecked(false);

        CheckBox checkBox8b = findViewById(R.id.question8_b);
        checkBox8b.setChecked(false);

        CheckBox checkBox8c = findViewById(R.id.question8_c);
        checkBox8c.setChecked(false);

        CheckBox checkBox8d = findViewById(R.id.question8_d);
        checkBox8d.setChecked(false);

    }
}
