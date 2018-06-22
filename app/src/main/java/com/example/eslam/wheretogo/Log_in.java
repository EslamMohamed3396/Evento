package com.example.eslam.wheretogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Log_in extends AppCompatActivity {

    private Button btn_signup, btn_log_in;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        btn_log_in = (Button) findViewById(R.id.btn_log_in);
        btn_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoToHomePage = new Intent(Log_in.this, Bottom_Bar.class);
                startActivity(GoToHomePage);
                finish();
            }
        });

        btn_signup = (Button) findViewById(R.id.btn_sign_up);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GoToSignUpPage = new Intent(Log_in.this, Sign_Up.class);
                startActivity(GoToSignUpPage);
            }
        });
    }
}
