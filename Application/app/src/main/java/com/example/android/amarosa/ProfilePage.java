package com.example.android.amarosa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by brandonseager on 7/22/17.
 */

public class ProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);
        Toast.makeText(getApplicationContext(),"Successfully Signed In",Toast.LENGTH_LONG);
    }





}
