package com.example.eslam.wheretogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Sign_Up extends AppCompatActivity {

    private Button btn_sign_two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);

        btn_sign_two = findViewById(R.id.btn_sign_up_two);
        btn_sign_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoToSignUpPageTwo = new Intent(Sign_Up.this, Home.class);
                startActivity(GoToSignUpPageTwo);
            }
        });
    }
}
