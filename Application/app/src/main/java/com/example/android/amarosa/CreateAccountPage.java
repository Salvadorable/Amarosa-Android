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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccountPage extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button mFinishCreateAccountButton; //had to create my button
    private EditText mEmail;
    private EditText mPassword;
    private EditText mBirthday;
    private EditText mName;
    private Button mGender1;
    private Button mGender2;
    private Button mGender3;
    private ProgressDialog progress;
    private Boolean accountVerified = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_page);

        mAuth = FirebaseAuth.getInstance();
        mFinishCreateAccountButton = (Button) findViewById(R.id.finish_create_account_button);
        mEmail = (EditText) findViewById(R.id.new_user_email);
        mPassword = (EditText) findViewById(R.id.new_user_password);
        mBirthday = (EditText) findViewById(R.id.new_user_birthday);
        mGender1 = (Button) findViewById(R.id.gender1);
        mGender2 = (Button) findViewById(R.id.gender2);
        mGender3 = (Button) findViewById(R.id.gender3);
        progress = new ProgressDialog(this);
        mFinishCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
                Intent i = new Intent(v.getContext(), ProfilePage.class);
                startActivity(i);
            }
        });
    }
    private void registerUser(){
        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),"Your Password Or Email is Blank",Toast.LENGTH_LONG);
            return;
        }
        //lets show a progressbar
        ProgressDialog.show(getApplicationContext(),"Register","Registering User...");
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Successfully Registered User moving to Profile Page",Toast.LENGTH_LONG);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Failed to Register User, Something went wrong",Toast.LENGTH_LONG);                }
            }
        });
    }
}
