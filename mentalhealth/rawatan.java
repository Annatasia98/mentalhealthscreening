package com.example.mentalhealth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class rawatan extends AppCompatActivity implements View.OnClickListener {

    public CardView bernafas, diary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rawatan);

        bernafas = (CardView) findViewById(R.id.bernafas);
        diary = (CardView) findViewById(R.id.diary);

        bernafas.setOnClickListener(this);
        diary.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.bernafas:
                i = new Intent(this, bernafas.class);
                startActivity(i);
                break;

            case R.id.diary:
                i = new Intent(this, diary.class);
                startActivity(i);
                break;
        }

    }
}