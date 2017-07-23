package com.example.android.amarosa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateAccountPage extends AppCompatActivity {

    private Button mFinishCreateAccountButton; //had to create my button
    private Boolean accountVerified = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_page);

        mFinishCreateAccountButton = (Button) findViewById(R.id.finish_create_account_button);
        mFinishCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                what do you want to happen after the finish button is clicked
                this is the onclick listener
                 */




                if(accountVerified == true) {
                    Intent i = new Intent(v.getContext(), ProfilePage.class);
                    startActivity(i);
                }
                else{
                    //push something that says why it didnt work aka check username and password
                }
            }
        });


    }
}
