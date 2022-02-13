package com.example.mentalhealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class dass extends AppCompatActivity implements View.OnClickListener {

    public CardView murung, resah, stress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dass);

        murung = (CardView) findViewById(R.id.depress);
        resah = (CardView) findViewById(R.id.anxiety);
        stress = (CardView) findViewById(R.id.stress);

        murung.setOnClickListener(this);
        resah.setOnClickListener(this);
        stress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.depress:
                i = new Intent(this, kemurungan.class);
                startActivity(i);
                break;

            case R.id.anxiety:
                i = new Intent(this, keresahan.class);
                startActivity(i);
                break;

            case R.id.stress:
                i = new Intent(this, stress.class);
                startActivity(i);
                break;


        }
    }
}