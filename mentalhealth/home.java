package com.example.mentalhealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home extends AppCompatActivity implements View.OnClickListener {

    public CardView dass, mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dass = (CardView) findViewById(R.id.dass);
        mood = (CardView) findViewById(R.id.mood);

        dass.setOnClickListener(this);
        mood.setOnClickListener(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
               switch (menuItem.getItemId()){
                   case R.id.tool:
                   startActivity(new Intent(getApplicationContext(),ToolActivity.class));
                   overridePendingTransition(0,0);
                   return true;
                   case R.id.home:
                       return true;
                   case R.id.profile:
                       startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                       overridePendingTransition(0,0);
                       return true;
               }
               return false;
            }
        });
    }
                @Override
                public void onClick(View v) {
                    Intent i;

                    switch (v.getId()) {
                        case R.id.dass:
                            i = new Intent(this, dass.class);
                            startActivity(i);
                            break;

                        case R.id.mood:
                            i = new Intent(this, moodtrack.class);
                            startActivity(i);
                            break;
                    }

                }

            }


