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

public class sedih extends AppCompatActivity {

    Button button;
    CheckBox c1,c2,c3,c4,c5;
    FirebaseDatabase database;
    DatabaseReference reference;
    Member6 member6;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sedih);

        reference = database.getInstance().getReference().child("Sedih");

        member6 = new Member6();
        button = findViewById(R.id.button);
        c1= findViewById(R.id.depresi);
        c2= findViewById(R.id.kesepian);
        c3= findViewById(R.id.pedih);
        c4= findViewById(R.id.ditolak);
        c5= findViewById(R.id.muram);

        String m1 = "Depresi";
        String m2 = "Kesepian";
        String m3 = "Pedih";
        String m4 = "Ditolak";
        String m5 = "Muram";
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
                    Toast.makeText(getApplicationContext(), "Depresi Checked", Toast.LENGTH_SHORT).show();
                    member6.setMood1(m1);
                    reference.child(String.valueOf(i+1)).setValue(member6);
                }else {
                    ////
                }
                if (c2.isChecked()){
                    Toast.makeText(getApplicationContext(), "Kesepian Checked", Toast.LENGTH_SHORT).show();
                    member6.setMood2(m2);
                    reference.child(String.valueOf(i+1)).setValue(member6);
                }else {
                    ////
                }
                if (c3.isChecked()){
                    Toast.makeText(getApplicationContext(), "Pedih Checked", Toast.LENGTH_SHORT).show();
                    member6.setMood3(m3);
                    reference.child(String.valueOf(i+1)).setValue(member6);
                }else {
                    ////
                }
                if (c4.isChecked()){
                    Toast.makeText(getApplicationContext(), "Ditolak Checked", Toast.LENGTH_SHORT).show();
                    member6.setMood4(m4);
                    reference.child(String.valueOf(i+1)).setValue(member6);
                }else {
                    ////
                }
                if (c5.isChecked()){
                    Toast.makeText(getApplicationContext(), "Muram Checked", Toast.LENGTH_SHORT).show();
                    member6.setMood5(m5);
                    reference.child(String.valueOf(i+1)).setValue(member6);
                }else {
                    ////
                }
            }
        });
    }
}