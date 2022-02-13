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

public class marah extends AppCompatActivity {

    Button button;
    CheckBox c1,c2,c3,c4,c5,c6,c7;
    FirebaseDatabase database;
    DatabaseReference reference;
    Member7 member7;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marah);

        reference = database.getInstance().getReference().child("Marah");

        member7 = new Member7();
        button = findViewById(R.id.button);
        c1= findViewById(R.id.berang);
        c2= findViewById(R.id.kesalhati);
        c3= findViewById(R.id.marah);
        c4= findViewById(R.id.bermusuh);
        c5= findViewById(R.id.terganggu);
        c6= findViewById(R.id.jengkel);
        c7= findViewById(R.id.benci);

        String m1 = "Berang";
        String m2 = "Kesal Hati";
        String m3 = "Marah";
        String m4 = "Bermusuh";
        String m5 = "Terganggu";
        String m6 = "Jengkel";
        String m7 = "Benci";
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
                    Toast.makeText(getApplicationContext(), "Berang Checked", Toast.LENGTH_SHORT).show();
                    member7.setMood1(m1);
                    reference.child(String.valueOf(i+1)).setValue(member7);
                }else {
                    ////
                }
                if (c2.isChecked()){
                    Toast.makeText(getApplicationContext(), "Kesal Hati Checked", Toast.LENGTH_SHORT).show();
                    member7.setMood2(m2);
                    reference.child(String.valueOf(i+1)).setValue(member7);
                }else {
                    ////
                }
                if (c3.isChecked()){
                    Toast.makeText(getApplicationContext(), "Marah Besar Checked", Toast.LENGTH_SHORT).show();
                    member7.setMood3(m3);
                    reference.child(String.valueOf(i+1)).setValue(member7);
                }else {
                    ////
                }
                if (c4.isChecked()){
                    Toast.makeText(getApplicationContext(), "Bermusuhan Checked", Toast.LENGTH_SHORT).show();
                    member7.setMood4(m4);
                    reference.child(String.valueOf(i+1)).setValue(member7);
                }else {
                    ////
                }
                if (c5.isChecked()){
                    Toast.makeText(getApplicationContext(), "Terganggu Checked", Toast.LENGTH_SHORT).show();
                    member7.setMood5(m5);
                    reference.child(String.valueOf(i+1)).setValue(member7);
                }else {
                    ////
                }
                if (c6.isChecked()){
                    Toast.makeText(getApplicationContext(), "Jengkel Checked", Toast.LENGTH_SHORT).show();
                    member7.setMood6(m6);
                    reference.child(String.valueOf(i+1)).setValue(member7);
                }else {
                    ////
                }
                if (c7.isChecked()){
                   Toast.makeText(getApplicationContext(), "Benci Checked", Toast.LENGTH_SHORT).show();
                    member7.setMood7(m7);
                    reference.child(String.valueOf(i+1)).setValue(member7);
                }else {
                    ////
                }
            }
        });
    }
}