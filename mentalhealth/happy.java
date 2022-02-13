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

import java.io.File;

public class happy extends AppCompatActivity {

    Button button;
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
    FirebaseDatabase database;
    DatabaseReference reference;
    Member member;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_happy);

        reference = database.getInstance().getReference().child("Gembira");

        member = new Member();
        button = findViewById(R.id.button);
        c1= findViewById(R.id.gembira);
        c2= findViewById(R.id.riang);
        c3= findViewById(R.id.puas);
        c4= findViewById(R.id.senang);
        c5= findViewById(R.id.terhibur);
        c6= findViewById(R.id.bangga);
        c7= findViewById(R.id.bahagia);
        c8= findViewById(R.id.terpesona);
        c9= findViewById(R.id.girang);
        c10= findViewById(R.id.dipenuhi);

        String m1 = "Gembira";
        String m2 = "Riang";
        String m3 = "Puas";
        String m4 = "Senang";
        String m5 = "Girang";
        String m6 = "Terpesona";
        String m7 = "Terhibur";
        String m8 = "Bangga";
        String m9 = "Rasa Dipenuhi";
        String m10 = "Bahagia";
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
                    Toast.makeText(getApplicationContext(), "Gembira Checked", Toast.LENGTH_SHORT).show();

                    member.setMood1(m1);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {
                    ////
                }
                if (c2.isChecked()){
                    Toast.makeText(getApplicationContext(), "Riang Checked", Toast.LENGTH_SHORT).show();

                    member.setMood2(m2);
                    reference.child(String.valueOf(i+1)).setValue(member);
                }else {
                    ////
                }
                if (c3.isChecked()){
                    Toast.makeText(getApplicationContext(), "Puas Checked", Toast.LENGTH_SHORT).show();

                    member.setMood3(m3);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {
                    ////
                }
                if (c4.isChecked()){
                    Toast.makeText(getApplicationContext(), "Senang Checked", Toast.LENGTH_SHORT).show();

                    member.setMood4(m4);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {
                    ////
                }
                if (c5.isChecked()){
                    Toast.makeText(getApplicationContext(), "Terhibur Checked", Toast.LENGTH_SHORT).show();

                    member.setMood5(m5);
                    reference.child(String.valueOf(i+1)).setValue(member);

                }else {
                    ////
                }
                if (c6.isChecked()){
                    Toast.makeText(getApplicationContext(), "Bangga Checked", Toast.LENGTH_SHORT).show();
                    member.setMood6(m6);
                    reference.child(String.valueOf(i+1)).setValue(member);
                }else {
                    ////
                }
                if (c7.isChecked()){
                    Toast.makeText(getApplicationContext(), "Bahagia Checked", Toast.LENGTH_SHORT).show();
                    member.setMood7(m7);
                    reference.child(String.valueOf(i+1)).setValue(member);
                }else {
                    ////
                }
                if (c8.isChecked()){
                    Toast.makeText(getApplicationContext(), "Terpesona Checked", Toast.LENGTH_SHORT).show();
                    member.setMood8(m8);
                    reference.child(String.valueOf(i+1)).setValue(member);
                }else {
                    ////
                }
                if (c9.isChecked()){
                    Toast.makeText(getApplicationContext(), "Girang Checked", Toast.LENGTH_SHORT).show();
                    member.setMood9(m9);
                    reference.child(String.valueOf(i+1)).setValue(member);
                }else {
                    ////
                }
                if (c10.isChecked()){
                    Toast.makeText(getApplicationContext(), "Rasa Dipenuhi Checked", Toast.LENGTH_SHORT).show();
                    member.setMood10(m10);
                    reference.child(String.valueOf(i+1)).setValue(member);
                }else {
                    ////
                }

            }
        });
    }
}