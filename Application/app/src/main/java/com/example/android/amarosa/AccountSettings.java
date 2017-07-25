package com.example.android.amarosa;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by bigdaddy on 7/24/17.
 */

public class AccountSettings extends AppCompatActivity {
    private Button mLogOut;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);
        mLogOut = (Button) findViewById(R.id.settings);
        mLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(),LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
