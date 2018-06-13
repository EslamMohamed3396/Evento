package com.example.eslam.wheretogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Log_in extends AppCompatActivity {
    private TextView txt_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        txt_signup=findViewById(R.id.txt_sign_up);
        txt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoToSignUpPage = new Intent(Log_in.this, Home.class);
                startActivity(GoToSignUpPage);
            }
        });
    }
}
