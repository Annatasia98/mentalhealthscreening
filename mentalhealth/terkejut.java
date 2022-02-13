package com.example.mentalhealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class terkejut extends AppCompatActivity {

    Button button;
    CheckBox c1,c2,c3,c4;
    FirebaseDatabase database;
    DatabaseReference reference;
    Member8 member8;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terkejut);

        reference = database.getInstance().getReference().child("Terkejut");

        member8 = new Member8();
        button = findViewById(R.id.button);
        c1= findViewById(R.id.terpana);
        c2= findViewById(R.id.terkesima);
        c3= findViewById(R.id.takjub);
        c4= findViewById(R.id.terkejut);

        String m1 = "Terpana";
        String m2 = "Terkesima";
        String m3 = "Takjub";
        String m4 = "Terkejut";
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c1.isChecked()){
                   Toast.makeText(getApplicationContext(), "Terpana Checked", Toast.LENGTH_SHORT).show();
                    member8.setMood1(m1);
                    reference.child(String.valueOf(i+1)).setValue(member8);
                }else {
                    ////
                }
                if (c2.isChecked()){
                    Toast.makeText(getApplicationContext(), "Terkesima Checked", Toast.LENGTH_SHORT).show();
                    member8.setMood2(m2);
                    reference.child(String.valueOf(i+1)).setValue(member8);
                }else {
                    ////
                }
                if (c3.isChecked()){
                    Toast.makeText(getApplicationContext(), "Takjub Checked", Toast.LENGTH_SHORT).show();
                    member8.setMood3(m3);
                    reference.child(String.valueOf(i+1)).setValue(member8);
                }else {
                    ////
                }
                if (c4.isChecked()){
                    Toast.makeText(getApplicationContext(), "Terkejut Checked", Toast.LENGTH_SHORT).show();
                    member8.setMood4(m4);
                    reference.child(String.valueOf(i+1)).setValue(member8);
                }else {
                    ////
                }
            }
        });
    }
}