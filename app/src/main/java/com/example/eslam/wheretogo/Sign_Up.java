package com.example.eslam.wheretogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sign_Up extends AppCompatActivity {

    private EditText mEmail, mPassword, mConfirmPassword, mUserName;
    String[] mGenderSpinner = {"Male", "Female", "Company"};
    int[] mGenderSpinnerNumber = {0, 1, 2};
    private Button btn_sign_two;
    private Spinner spin;
    private int mGenderSelected;
    AdapterView.OnItemSelectedListener onItemSelectedListener1 = new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    mGenderSelected = mGenderSpinnerNumber[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }

            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);

        mEmail = (EditText) findViewById(R.id.ed_email);
        mPassword = (EditText) findViewById(R.id.ed_password);
        mConfirmPassword = (EditText) findViewById(R.id.ed_confirm_password);
        mUserName = (EditText) findViewById(R.id.ed_user_name);

        btn_sign_two = (Button) findViewById(R.id.btn_sign_up_two);
        btn_sign_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkInformation();
            }
        });
        spin = (Spinner) findViewById(R.id.spinner_Gender);//fetching view's id
        spin.setOnItemSelectedListener(onItemSelectedListener1);
        fillTheSpinner();

    }

    private void checkInformation() {
        if (ValidUserName() && ValidEmail() && ValidPassword() &&
                ValidConfirmPassword()) {
            Intent GoToSignUPPageTwo = new Intent(Sign_Up.this, Sign_Up_2.class);
            startActivity(GoToSignUPPageTwo);
        }
    }

    private boolean ValidEmail() {
        String valid_email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{3,3})$";
        Matcher matcher_email = Pattern.compile(valid_email).matcher(mEmail.getText().toString().toLowerCase());
        if (matcher_email.matches()) {
            return true;
        } else {
            mEmail.setError(getResources().getString(R.string.invalidEmail));
            mEmail.requestFocus();
            return false;
        }
    }

    private boolean ValidUserName() {

        if (mUserName.length() > 0) {
            return true;
        } else {
            mUserName.setError(getResources().getString(R.string.invalid));
            mUserName.requestFocus();
            return false;
        }


    }

    private boolean ValidPassword() {
        if (mPassword.length() > 6) {
            return true;
        } else {
            mPassword.setError(getResources().getString(R.string.invalidPassword));
            mPassword.requestFocus();
            return false;
        }

    }

    private boolean ValidConfirmPassword() {

        if (mPassword.getText().toString().equals(mConfirmPassword.getText().toString())) {
            return true;
        } else {
            mConfirmPassword.setError(getResources().getString(R.string.invalidConfirmPassword));
            mConfirmPassword.requestFocus();
            return false;
        }
    }

    public void fillTheSpinner() {


        ArrayAdapter<String> adapter1 =
                new ArrayAdapter<String>(Sign_Up.this,
                        android.R.layout.simple_spinner_item, mGenderSpinner);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter1);
    }


}
