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

public class Malu extends AppCompatActivity {

    Button button;
    CheckBox c1,c2,c3,c4,c5,c6,c7;
    FirebaseDatabase database;
    DatabaseReference reference;
    Member2 member2;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malu);

        reference = database.getInstance().getReference().child("Malu");

        member2 = new Member2();
        button = findViewById(R.id.button);
        c1= findViewById(R.id.kesal);
        c2= findViewById(R.id.hancur);
        c3= findViewById(R.id.sesal);
        c4= findViewById(R.id.hina);
        c5= findViewById(R.id.maluhati);
        c6= findViewById(R.id.bersalah);
        c7= findViewById(R.id.aib);

        String m1 = "Kesal";
        String m2 = "Hancur";
        String m3 = "Sesal";
        String m4 = "Hina";
        String m5 = "Malu Hati";
        String m6 = "Bersalah";
        String m7 = "Aib";
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
                    Toast.makeText(getApplicationContext(), "Kesal Checked", Toast.LENGTH_SHORT).show();
                    member2.setMood1(m1);
                    reference.child(String.valueOf(i+1)).setValue(member2);

                }else {
                    ////
                }
                if (c2.isChecked()){
                    Toast.makeText(getApplicationContext(), "Hancur Lebur Checked", Toast.LENGTH_SHORT).show();

                    member2.setMood2(m2);
                    reference.child(String.valueOf(i+1)).setValue(member2);

                }else {
                    ////
                }
                if (c3.isChecked()){
                    Toast.makeText(getApplicationContext(), "Sesal Checked", Toast.LENGTH_SHORT).show();
                    member2.setMood3(m3);
                    reference.child(String.valueOf(i+1)).setValue(member2);
                }else {
                    ////
                }
                if (c4.isChecked()){
                    Toast.makeText(getApplicationContext(), "Hina Checked", Toast.LENGTH_SHORT).show();
                    member2.setMood4(m4);
                    reference.child(String.valueOf(i+1)).setValue(member2);
                }else {
                    ////
                }
                if (c5.isChecked()){
                    Toast.makeText(getApplicationContext(), "Malu Hati Checked", Toast.LENGTH_SHORT).show();
                    member2.setMood5(m5);
                    reference.child(String.valueOf(i+1)).setValue(member2);
                }else {
                    ////
                }
                if (c6.isChecked()){
                    Toast.makeText(getApplicationContext(), "Bersalah Checked", Toast.LENGTH_SHORT).show();
                    member2.setMood6(m6);
                    reference.child(String.valueOf(i+1)).setValue(member2);
                }else {
                    ////
                }
                if (c7.isChecked()){
                    Toast.makeText(getApplicationContext(), "Aib Checked", Toast.LENGTH_SHORT).show();
                    member2.setMood7(m7);
                    reference.child(String.valueOf(i+1)).setValue(member2);
                }else {
                    ////
                }
            }
        });
    }
}