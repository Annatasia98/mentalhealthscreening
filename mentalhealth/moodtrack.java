package com.example.mentalhealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class moodtrack extends AppCompatActivity implements View.OnClickListener {

    public CardView moodtrack1, moodtrack2, moodtrack3, moodtrack4, moodtrack5, moodtrack6, moodtrack7, moodtrack8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moodtrack);

        moodtrack1 = (CardView) findViewById(R.id.gembira);
        moodtrack2= (CardView) findViewById(R.id.malu);
        moodtrack3 = (CardView) findViewById(R.id.cinta);
        moodtrack4 = (CardView) findViewById(R.id.jengkel);
        moodtrack5 = (CardView) findViewById(R.id.takut);
        moodtrack6 = (CardView) findViewById(R.id.sedih);
        moodtrack7 = (CardView) findViewById(R.id.marah);
        moodtrack8 = (CardView) findViewById(R.id.terkejut);

        moodtrack1.setOnClickListener(this);
        moodtrack2.setOnClickListener(this);
        moodtrack3.setOnClickListener(this);
        moodtrack4.setOnClickListener(this);
        moodtrack5.setOnClickListener(this);
        moodtrack6.setOnClickListener(this);
        moodtrack7.setOnClickListener(this);
        moodtrack8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.gembira:
                i = new Intent(this, happy.class);
                startActivity(i);
                break;

            case R.id.malu:
                i = new Intent(this, Malu.class);
                startActivity(i);
                break;

            case R.id.cinta:
                i = new Intent(this, cinta.class);
                startActivity(i);
                break;

            case R.id.jengkel:
                i = new Intent(this, jengkel.class);
                startActivity(i);
                break;

            case R.id.takut:
                i = new Intent(this, takut.class);
                startActivity(i);
                break;

            case R.id.sedih:
                i = new Intent(this, sedih.class);
                startActivity(i);
                break;

            case R.id.marah:
                i = new Intent(this, marah.class);
                startActivity(i);
                break;

            case R.id.terkejut:
                i = new Intent(this, terkejut.class);
                startActivity(i);
                break;

        }
    }
}