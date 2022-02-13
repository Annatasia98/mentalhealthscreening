package com.example.mentalhealth;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class keresahan extends AppCompatActivity {

    private TextView optionA, optionB, optionC, optionD;
    private TextView questionnumber, question, score;
    private TextView checkout1, checkout2;
    int currentIndex;
    int mscore;
    int qn=1;
    ProgressBar progressBar;

    int CurrentQuestion, CurrentOptionA, CurrentOptionB, CurrentOptionC, CurrentOptionD;



    private answerclass[] questionBank= new answerclass[]{
            new answerclass(R.string.resah1, R.string.resah1_A, R.string.resah1_B, R.string.resah1_C, R.string.resah1_D, R.string.answer_r1),
            new answerclass(R.string.resah2, R.string.resah2_A, R.string.resah2_B, R.string.resah2_C, R.string.resah2_D, R.string.answer_r2),
            new answerclass(R.string.resah3, R.string.resah3_A, R.string.resah3_B, R.string.resah3_C, R.string.resah3_D, R.string.answer_r3),
            new answerclass(R.string.resah4, R.string.resah4_A, R.string.resah4_B, R.string.resah4_C, R.string.resah4_D, R.string.answer_r4),
            new answerclass(R.string.resah5, R.string.resah5_A, R.string.resah5_B, R.string.resah5_C, R.string.resah5_D, R.string.answer_r5),
            new answerclass(R.string.resah6, R.string.resah6_A, R.string.resah6_B, R.string.resah6_C, R.string.resah6_D, R.string.answer_r6),
            new answerclass(R.string.resah7, R.string.resah7_A, R.string.resah1_B, R.string.resah1_C, R.string.resah1_D, R.string.answer_r1),
    };

    final int PROGRESS_BAR = (int) Math.ceil(100/questionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keresahan);

        optionA=findViewById(R.id.optionA);
        optionB=findViewById(R.id.optionB);
        optionC=findViewById(R.id.optionC);
        optionD=findViewById(R.id.optionD);


        question=findViewById(R.id.question);
        score=findViewById(R.id.score);
        questionnumber=findViewById(R.id.QuestionNumber);

        checkout1=findViewById(R.id.selectedoption);
        checkout2=findViewById(R.id.CorrectAnswer);
        progressBar=findViewById(R.id.progress_Bar);

        CurrentQuestion=questionBank[currentIndex].getQuestionID();
        question.setText(CurrentQuestion);
        CurrentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);
        CurrentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);
        CurrentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);
        CurrentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);

        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionA);
                updateQuestion();

            }
        });

        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionB);
                updateQuestion();

            }
        });

        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionC);
                updateQuestion();

            }
        });

        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionD);
                updateQuestion();

            }
        });





    }

    private void checkAnswer(int userSelection) {

        int correctanswer=questionBank[currentIndex].getAnswerID();

        checkout1.setText(userSelection);
        checkout2.setText(correctanswer);

        String m= checkout1.getText().toString().trim();
        String n= checkout2.getText().toString().trim();

        if(m.equals(n))
        {
            Toast.makeText(getApplicationContext(), "Kurang Bagus", Toast.LENGTH_SHORT).show();
            mscore=mscore+1;
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Bagus", Toast.LENGTH_SHORT).show();
        }



    }

    private void updateQuestion() {

        currentIndex=(currentIndex+1)%questionBank.length;

        if(currentIndex==0)
        {
            AlertDialog.Builder alert= new AlertDialog.Builder(this);
            alert.setTitle("Tamat");
            alert.setCancelable(false);
            alert.setMessage("Kondisi Anda "+ mscore +"\n"+ "\n"+ "'Kondisi melebihi 4, Sangat Teruk'");
            alert.setPositiveButton("Tutup", new  DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            alert.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mscore=0;
                    qn=1;
                    progressBar.setProgress(0);
                    score.setText("Kondisi Anda= " + mscore + "/" +questionBank.length);
                    questionnumber.setText(qn + "/" + questionBank.length + "Soalan");
                }
            });

            alert.show();
        }

        CurrentQuestion=questionBank[currentIndex].getQuestionID();
        question.setText(CurrentQuestion);
        CurrentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);
        CurrentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);
        CurrentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);
        CurrentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);

        qn=qn+1;

        if (qn<=questionBank.length)
        {
            questionnumber.setText(qn + "/" + questionBank.length + "Soalan");
        }
        score.setText("Kondisi Anda =  " + mscore + "/" +questionBank.length);
        progressBar.incrementProgressBy(PROGRESS_BAR);


    }

}