package com.example.mentalhealth;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class cinta extends AppCompatActivity {

    Button button;
    CheckBox c1, c2, c3, c4, c5, c6, c7, c8, c9;
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseFirestore db;
    Member3 member3;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinta);

        reference = database.getInstance().getReference().child("Cinta");
        db=FirebaseFirestore.getInstance();


        member3 = new Member3();
        button = findViewById(R.id.button);
        c1 = findViewById(R.id.kasih);
        c2 = findViewById(R.id.bakti);
        c3 = findViewById(R.id.persahabatan);
        c4 = findViewById(R.id.hati);
        c5 = findViewById(R.id.jatuhcinta);
        c6 = findViewById(R.id.hormat);
        c7 = findViewById(R.id.kepercayaan);
        c8 = findViewById(R.id.penerimaan);
        c9 = findViewById(R.id.kedekatan);

        String m1 = "Kasih";
        String m2 = "Bakti";
        String m3 = "Persahabatan";
        String m4 = "Hati";
        String m5 = "Jatuh Cinta";
        String m6 = "Hormat";
        String m7 = "Kepercayaan";
        String m8 = "Penerimaan";
        String m9 = "Kedekatan";
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

                if (c1.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Kasih Checked", Toast.LENGTH_SHORT).show();
                    member3.setMood1(m1);
                    reference.child(String.valueOf(i + 1)).setValue(member3);

                } else {
                    ////
                }
                if (c2.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Bakti Checked", Toast.LENGTH_SHORT).show();
                    member3.setMood2(m2);
                    reference.child(String.valueOf(i + 1)).setValue(member3);

                } else {
                    ////
                }
                if (c3.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Persahabatan Checked", Toast.LENGTH_SHORT).show();
                    member3.setMood3(m3);
                    reference.child(String.valueOf(i + 1)).setValue(member3);

                } else {
                    ////
                }
                if (c4.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Kebaikan Hati Checked", Toast.LENGTH_SHORT).show();
                    member3.setMood4(m4);
                    reference.child(String.valueOf(i + 1)).setValue(member3);
                } else {
                    ////
                }
                if (c5.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Jatuh Cinta Checked", Toast.LENGTH_SHORT).show();
                    member3.setMood5(m5);
                    reference.child(String.valueOf(i + 1)).setValue(member3);
                } else {
                    ////
                }
                if (c6.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Hormat Checked", Toast.LENGTH_SHORT).show();
                    member3.setMood6(m6);
                    reference.child(String.valueOf(i + 1)).setValue(member3);
                } else {
                    ////
                }
                if (c7.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Kepercayaan Checked", Toast.LENGTH_SHORT).show();
                    member3.setMood7(m7);
                    reference.child(String.valueOf(i + 1)).setValue(member3);
                } else {
                    ////
                }
                if (c8.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Penerimaan Checked", Toast.LENGTH_SHORT).show();
                    member3.setMood8(m8);
                    reference.child(String.valueOf(i + 1)).setValue(member3);
                } else {
                    ////
                }
                if (c9.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Kedekatan Checked", Toast.LENGTH_SHORT).show();
                    member3.setMood9(m9);
                    reference.child(String.valueOf(i + 1)).setValue(member3);
                } else {
                    ////
                }
            }
        });
    }
}