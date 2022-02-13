package com.example.mentalhealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "TAG";
    private TextView banner, registeruser;
    private EditText editTextFullName, editTextPhoneNo, editTextEmail, editTextPassword;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;
    private FirebaseFirestore fstore;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        banner = (TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);

        registeruser = (Button) findViewById(R.id.registerUser);
        registeruser.setOnClickListener(this);

        editTextFullName = (EditText) findViewById(R.id.FullName);
        editTextPhoneNo = (EditText) findViewById(R.id.phoneNo);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.banner:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.registerUser:
                registeruser();
                break;
        }
    }


    private void registeruser() {
        String email= editTextEmail.getText().toString().trim();
        String password= editTextPassword.getText().toString().trim();
        String fullname= editTextFullName.getText().toString().trim();
        String phoneNo= editTextPhoneNo.getText().toString().trim();

        if(fullname.isEmpty()) {
            editTextFullName.setError("Nama Penuh diperlukan");
            editTextFullName.requestFocus();
            return;
        }
            if(phoneNo.isEmpty()){
                editTextPhoneNo.setError("No tel diperlukan");
                editTextPhoneNo.requestFocus();
                return;
        }
        if(email.isEmpty()){
            editTextEmail.setError("Email diperlukan");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Masukkan Email yang Sah!");
            editTextEmail.requestFocus();
            return;
        }


        if(password.isEmpty()){
            editTextPassword.setError("Kata Laluan diperlukan");
            editTextPassword.requestFocus();
            return;
        }
        if(password.length() <6){
            editTextPassword.setError("Min KataLaluan 6 digit");
            editTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.GONE);
       mAuth.createUserWithEmailAndPassword(email,password)
               .addOnCompleteListener(new OnCompleteListener< AuthResult >() {
                   @Override
                   public void onComplete(@NonNull Task< AuthResult > task) {

                       if (task.isSuccessful()) {
                           User user = new User(fullname, phoneNo, email);

                           FirebaseDatabase.getInstance().getReference("Users")
                                   .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                   .setValue(user).addOnCompleteListener(new OnCompleteListener< Void >() {
                               @Override
                               public void onComplete(@NonNull Task< Void > task) {

                                   if (task.isSuccessful()) {
                                       Toast.makeText(RegisterUser.this, "Pengguna berjaya mendaftar!", Toast.LENGTH_LONG).show();
                                       userID = mAuth.getCurrentUser().getUid();
                                       DocumentReference documentReference = fstore.collection("Users").document(userID);
                                       Map<String,Object> user = new HashMap<>();
                                       user.put("fName",fullname);
                                       user.put("email",email);
                                       user.put("phone",phoneNo);
                                       documentReference.set(user).addOnSuccessListener(new OnSuccessListener< Void >() {
                                           @Override
                                           public void onSuccess(Void aVoid) {
                                               Log.d(TAG,"onSuccess: Pengguna profile dicipta untuk "+userID);
                                           }
                                       });
                                       progressBar.setVisibility((View.GONE));

                                       // redirect to login layout!
                                   } else {
                                       Toast.makeText(RegisterUser.this, "Cuba lagi!", Toast.LENGTH_LONG).show();
                                       progressBar.setVisibility(View.GONE);
                                   }
                               }
                           });

                       }else{
                           Toast.makeText(RegisterUser.this, "Gagal Mendaftar", Toast.LENGTH_LONG).show();
                           progressBar.setVisibility(View.GONE);
                       }
                   }


                });

    }



    }