package com.techinee.assign03_02_6206021621066;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText midScore, finalScore, homeworkScore;
    private Button btnCal;
    private TextView totalScore, Grade;

    private final String totalString = "คะแนนรวม : ";
    private final String gradeString = "เกรดที่ได้ : ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        midScore = (EditText) findViewById(R.id.midScore);
        finalScore = (EditText) findViewById(R.id.finalScore);
        homeworkScore = (EditText) findViewById(R.id.homeworkScore);

        btnCal = (Button) findViewById(R.id.btnCal);
        btnCal.setOnClickListener(this);

        totalScore = (TextView) findViewById(R.id.totalScore);
        Grade = (TextView) findViewById(R.id.Grade);

    }

    @Override
    public void onClick(View v) {

        int convertmidScoreToInt, convertfinalScoreToInt, converthomeworkScoreToInt;

        if (midScore.getText().toString().equals("")) {
            Toast.makeText(this, "ยังไม่ได้ป้อนคะแนนกลางภาค", Toast.LENGTH_SHORT).show();
            return;
        } else {
            convertmidScoreToInt = Integer.parseInt(midScore.getText().toString());
            if (convertmidScoreToInt > 30) {
                Toast.makeText(this, "กรุณาป้อนคะแนนกลางภาคไม่เกิน 30 ", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        if (finalScore.getText().toString().equals("")) {
            Toast.makeText(this, "ยังไม่ได้ป้อนคะแนนปลายภาค", Toast.LENGTH_SHORT).show();
            return;
        } else {
            convertfinalScoreToInt = Integer.parseInt(finalScore.getText().toString());
            if (convertfinalScoreToInt > 40) {
                Toast.makeText(this, "กรุณาป้อนคะแนนปลายภาคไม่เกิน 40 ", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        if (homeworkScore.getText().toString().equals("")) {
            Toast.makeText(this, "ยังไม่ได้ป้อนคะแนนการบ้าน", Toast.LENGTH_SHORT).show();
            return;
        } else {
            converthomeworkScoreToInt = Integer.parseInt(homeworkScore.getText().toString());
            if (converthomeworkScoreToInt > 40) {
                Toast.makeText(this, "กรุณาป้อนคะแนนการบ้านไม่เกิน 30 ", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        calGrade(convertmidScoreToInt, convertfinalScoreToInt, converthomeworkScoreToInt);
    }

    public void calGrade(int midterm, int finalterm, int homwork) {
        int calScore = midterm + finalterm + homwork;
        String grade;
        totalScore.setText(totalString + calScore);
        if(calScore >= 80){
            grade = "A";
        }
        else if(calScore >= 75){
            grade = "B+";
        }
        else if(calScore >= 70){
            grade = "B";
        }
        else if(calScore >= 65){
            grade = "C+";
        }
        else if(calScore >= 60){
            grade = "C";
        }
        else if(calScore >= 55){
            grade = "D+";
        }
        else if(calScore >= 50){
            grade = "D";
        }
        else grade = "F";

        Grade.setText(gradeString + grade);
    }
}