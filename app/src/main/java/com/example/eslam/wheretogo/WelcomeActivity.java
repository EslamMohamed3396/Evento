package com.example.eslam.wheretogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    private Button log_btn, sign_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        log_btn = (Button) findViewById(R.id.btn_log_in1);
        log_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log_int = new Intent(WelcomeActivity.this, Log_in.class);
                startActivity(log_int);
            }
        });

        sign_btn = (Button) findViewById(R.id.btn_sign_up1);
        sign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log_int = new Intent(WelcomeActivity.this, Sign_Up.class);
                startActivity(log_int);
            }
        });

    }

}
