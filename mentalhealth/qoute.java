package com.example.mentalhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class qoute extends AppCompatActivity {

    Random random = new Random();
    TextView textQout;
    Button buttonQoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qoute);

        textQout = findViewById(R.id.quoteText);
        buttonQoute = findViewById(R.id.buttonNext);

        buttonQoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayQoute();
            }
        });
        displayQoute();
    }

        public void displayQoute () {
            //random number between 1 and 10 (both inclusive)
            int randNum = random.nextInt((10 + 1) - 1) + 1;
            String randQoute = "";

            switch (randNum) {
                case 1:
                    randQoute = getString(R.string.qoute1);
                    break;
                case 2:
                    randQoute = getString(R.string.qoute2);
                    break;
                case 3:
                    randQoute = getString(R.string.qoute3);
                    break;
                case 4:
                    randQoute = getString(R.string.qoute4);
                    break;
                case 5:
                    randQoute = getString(R.string.qoute5);
                    break;
                case 6:
                    randQoute = getString(R.string.qoute6);
                    break;
                case 7:
                    randQoute = getString(R.string.qoute7);
                    break;
                case 8:
                    randQoute = getString(R.string.qoute8);
                    break;
                case 9:
                    randQoute = getString(R.string.qoute9);
                    break;
                case 10:
                    randQoute = getString(R.string.qoute10);
                    break;
            }
            textQout.setText(randQoute);

        }
    }