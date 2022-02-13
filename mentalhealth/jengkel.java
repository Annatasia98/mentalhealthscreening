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

public class jengkel extends AppCompatActivity {

    Button button;
    CheckBox c1,c2,c3,c4,c5,c6,c7;
    FirebaseDatabase database;
    DatabaseReference reference;
    Member4 member4;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jengkel);

        reference = database.getInstance().getReference().child("Jengkel");

        member4 = new Member4();
        button = findViewById(R.id.button);
        c1= findViewById(R.id.benci);
        c2= findViewById(R.id.jijik);
        c3= findViewById(R.id.muntah);
        c4= findViewById(R.id.muak);
        c5= findViewById(R.id.mual);
        c6= findViewById(R.id.hina);
        c7= findViewById(R.id.taksuka);

        String m1 = "Benci";
        String m2 = "Jijik";
        String m3 = "Muntah";
        String m4 = "Muak";
        String m5 = "Mual";
        String m6 = "Hina";
        String m7 = "Tidak Suka";
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
                    Toast.makeText(getApplicationContext(), "Benci Checked", Toast.LENGTH_SHORT).show();
                    member4.setMood1(m1);
                    reference.child(String.valueOf(i+1)).setValue(member4);

                }else {
                    ////
                }
                if (c2.isChecked()){
                    Toast.makeText(getApplicationContext(), "Jijik Checked", Toast.LENGTH_SHORT).show();
                    member4.setMood2(m2);
                    reference.child(String.valueOf(i+1)).setValue(member4);

                }else {
                    ////
                }
                if (c3.isChecked()){
                    Toast.makeText(getApplicationContext(), "Mahu Muntah Checked", Toast.LENGTH_SHORT).show();
                    member4.setMood3(m3);
                    reference.child(String.valueOf(i+1)).setValue(member4);

                }else {
                    ////
                }
                if (c4.isChecked()){
                    Toast.makeText(getApplicationContext(), "Muak Checked", Toast.LENGTH_SHORT).show();
                    member4.setMood4(m4);
                    reference.child(String.valueOf(i+1)).setValue(member4);

                }else {
                    ////
                }
                if (c5.isChecked()){
                    Toast.makeText(getApplicationContext(), "Mual Checked", Toast.LENGTH_SHORT).show();
                    member4.setMood5(m5);
                    reference.child(String.valueOf(i+1)).setValue(member4);

                }else {
                    ////
                }
                if (c6.isChecked()){
                    Toast.makeText(getApplicationContext(), "Hina Checked", Toast.LENGTH_SHORT).show();
                    member4.setMood6(m6);
                    reference.child(String.valueOf(i+1)).setValue(member4);

                }else {
                    ////
                }
                if (c7.isChecked()){
                    Toast.makeText(getApplicationContext(), "Tidak Suka Checked", Toast.LENGTH_SHORT).show();
                    member4.setMood7(m7);
                    reference.child(String.valueOf(i+1)).setValue(member4);
                }else {
                    ////
                }
            }
        });
    }
}