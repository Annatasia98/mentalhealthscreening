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

public class takut extends AppCompatActivity {

    Button button;
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
    FirebaseDatabase database;
    DatabaseReference reference;
    Member5 member5;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takut);

        reference = database.getInstance().getReference().child("Takut");

        member5 = new Member5();
        button = findViewById(R.id.button);
        c1= findViewById(R.id.panik);
        c2= findViewById(R.id.ngeri);
        c3= findViewById(R.id.waspada);
        c4= findViewById(R.id.waswas);
        c5= findViewById(R.id.takut);
        c6= findViewById(R.id.fobia);
        c7= findViewById(R.id.sedih);
        c8= findViewById(R.id.taktenang);
        c9= findViewById(R.id.gugup);
        c10= findViewById(R.id.cemas);

        String m1 = "Panik";
        String m2 = "Ngeri";
        String m3 = "Waspada";
        String m4 = "Was-was";
        String m5 = "Takut";
        String m6 = "Fobia";
        String m7 = "Sedih";
        String m8 = "Tidak Tenang";
        String m9 = "Gugup";
        String m10 = "Cemas";
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
                    Toast.makeText(getApplicationContext(), "Panik Checked", Toast.LENGTH_SHORT).show();

                    member5.setMood1(m1);
                    reference.child(String.valueOf(i+1)).setValue(member5);

                }else {
                    ////
                }
                if (c2.isChecked()){
                    Toast.makeText(getApplicationContext(), "Ngeri Checked", Toast.LENGTH_SHORT).show();
                    member5.setMood2(m2);
                    reference.child(String.valueOf(i+1)).setValue(member5);
                }else {
                    ////
                }
                if (c3.isChecked()){
                   Toast.makeText(getApplicationContext(), "Waspada Checked", Toast.LENGTH_SHORT).show();
                    member5.setMood3(m3);
                    reference.child(String.valueOf(i+1)).setValue(member5);
                }else {
                    ////
                }
                if (c4.isChecked()){
                    Toast.makeText(getApplicationContext(), "Was-was Checked", Toast.LENGTH_SHORT).show();
                    member5.setMood4(m4);
                    reference.child(String.valueOf(i+1)).setValue(member5);
                }else {
                    ////
                }
                if (c5.isChecked()){
                    Toast.makeText(getApplicationContext(), "Takut Checked", Toast.LENGTH_SHORT).show();
                    member5.setMood5(m5);
                    reference.child(String.valueOf(i+1)).setValue(member5);
                }else {
                    ////
                }
                if (c6.isChecked()){
                    Toast.makeText(getApplicationContext(), "Fobia Checked", Toast.LENGTH_SHORT).show();
                    member5.setMood6(m6);
                    reference.child(String.valueOf(i+1)).setValue(member5);
                }else {
                    ////
                }
                if (c7.isChecked()){
                    Toast.makeText(getApplicationContext(), "Sedih Checked", Toast.LENGTH_SHORT).show();
                    member5.setMood7(m7);
                    reference.child(String.valueOf(i+1)).setValue(member5);
                }else {
                    ////
                }
                if (c8.isChecked()){
                    Toast.makeText(getApplicationContext(), "Tidak Tenang Checked", Toast.LENGTH_SHORT).show();
                    member5.setMood8(m8);
                    reference.child(String.valueOf(i+1)).setValue(member5);
                }else {
                    ////
                }
                if (c9.isChecked()){
                    Toast.makeText(getApplicationContext(), "Gugup Checked", Toast.LENGTH_SHORT).show();
                    member5.setMood9(m9);
                    reference.child(String.valueOf(i+1)).setValue(member5);
                }else {
                    ////
                }
                if (c10.isChecked()){
                    Toast.makeText(getApplicationContext(), "Cemas Checked", Toast.LENGTH_SHORT).show();
                    member5.setMood10(m10);
                    reference.child(String.valueOf(i+1)).setValue(member5);
                }else {
                    ////
                }
            }
        });
    }
}