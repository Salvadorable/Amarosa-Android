package com.example.android.amarosa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by brandonseager on 7/22/17.
 */

public class ProfilePage extends AppCompatActivity {

    private Button mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        mSettings = (Button) findViewById(R.id.settings_button);

        mSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfilePage.this ,AccountSettings.class);
                startActivity(i);
            }
        });//end of the intent
        //Toast.makeText(getApplicationContext(),"Successfully Signed In",Toast.LENGTH_LONG).show();
    }






}
