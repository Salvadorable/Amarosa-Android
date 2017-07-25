package com.example.android.amarosa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.core.Context;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateAccountPage extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private Button mFinishCreateAccountButton; //had to create my button
    private EditText mEmail;
    private EditText mPassword;
    private EditText mBirthday;
    private EditText mName;
    private Button mGender1;
    private Button mGender2;
    private Button mGender3;
    private ProgressDialog progress;//we need to figure out the new progress dialog

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_page);

        mDatabase = FirebaseDatabase.getInstance().getReference("users");
        mAuth = FirebaseAuth.getInstance();
        mFinishCreateAccountButton = (Button) findViewById(R.id.finish_create_account_button);
        mEmail = (EditText) findViewById(R.id.new_user_email);
        mPassword = (EditText) findViewById(R.id.new_user_password);
        mBirthday = (EditText) findViewById(R.id.new_user_birthday);
        mName = (EditText) findViewById(R.id.new_user_name);
        mGender1 = (Button) findViewById(R.id.gender1);
        mGender2 = (Button) findViewById(R.id.gender2);
        mGender3 = (Button) findViewById(R.id.gender3);
        //progress = new ProgressDialog(this);

        mFinishCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }
    private void registerUser(){

        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        String birthday = mBirthday.getText().toString().trim();
        String name = mName.getText().toString().trim();

        if(email.isEmpty()){
            Toast.makeText(CreateAccountPage.this,"You need to put in a Email Account",Toast.LENGTH_LONG).show();
            return;
        }
        else if(password.isEmpty()){
            Toast.makeText(CreateAccountPage.this,"You need to put in a Password",Toast.LENGTH_LONG).show();
            return;
        }
        else if(birthday.isEmpty()){
            Toast.makeText(CreateAccountPage.this,"You need to put in a Birthday",Toast.LENGTH_LONG).show();
            return;
        }
        else if(name.isEmpty()){
            Toast.makeText(CreateAccountPage.this,"You need to put in your Name",Toast.LENGTH_LONG).show();
            return;
        }
        /*
        This is where we add to the Database
         */
        String id = mDatabase.push().getKey();
        mDatabase.child(id).child("Email").setValue(email);
        mDatabase.child(id).child("Password").setValue(password);
        mDatabase.child(id).child("Birthday").setValue(birthday);
        mDatabase.child(id).child("Name").setValue(name);

        //lets show a progressbar

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Successfully Registered User",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Failed to Register the User, Something went wrong please Try Again",Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
    }
}
