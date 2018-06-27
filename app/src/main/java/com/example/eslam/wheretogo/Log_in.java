package com.example.eslam.wheretogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Log_in extends AppCompatActivity {

    private TextView btn_signup;
    private Button btn_log_in;
    private EditText mEmail;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        mEmail = (EditText) findViewById(R.id.ed_email);
        mPassword = (EditText) findViewById(R.id.ed_password);
        btn_log_in = (Button) findViewById(R.id.btn_log_in);
        btn_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cheackLogin();
            }
        });

        btn_signup = (TextView) findViewById(R.id.tv_sign_up);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GoToSignUpPage = new Intent(Log_in.this, Sign_Up.class);
                startActivity(GoToSignUpPage);
            }
        });
    }

    private void cheackLogin() {
        if (validEmail(mEmail.getText().toString().toLowerCase()) && validPassword(mPassword.getText().toString().toLowerCase())) {
            Intent GoToHomePage = new Intent(Log_in.this, Bottom_Bar.class);
            startActivity(GoToHomePage);
              finish();

        } else {
            if (!validEmail(mEmail.getText().toString())) {
                mEmail.setError(getResources().getString(R.string.invalidEmail));
                mEmail.requestFocus();
            } else if (!validPassword(mPassword.getText().toString())) {
                mPassword.setError(getResources().getString(R.string.invalidPassword));
                mPassword.requestFocus();
            }

        }

    }

    private boolean validEmail(String mEmail) {
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{3,3})$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(mEmail);
        return matcher.matches();
    }

    private boolean validPassword(String mPass) {

        return !mPass.isEmpty() && mPass != null && mPass.length() > 6;
    }
}
