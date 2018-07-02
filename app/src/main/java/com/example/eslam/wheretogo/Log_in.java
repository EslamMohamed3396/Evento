package com.example.eslam.wheretogo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eslam.wheretogo.NetWorkConnection.LogIn.LogIn_NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class Log_in extends AppCompatActivity {

    private TextView btn_signup;
    private Button btn_log_in;
    private EditText mEmail;
    private EditText mPassword;
    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;
    public static final String PREFERENCES_ACCOUNT = "Prefs_Account";
    private static final String PREF_NAME = "pref_Name";
    private static final String PREF_PASS = "pref_Pass";
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        bindWidget();

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

    private boolean checkConnectivity() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        boolean isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();
        return isConnected;
    }

    private void bindWidget() {
        mEmail = (EditText) findViewById(R.id.ed_email);
        mPassword = (EditText) findViewById(R.id.ed_password);
        btn_log_in = (Button) findViewById(R.id.btn_log_in);
        if (!checkConnectivity()) {
            if (mToast != null) {
                mToast.cancel();
            }
            mToast = Toast.makeText(this, "NetWork is Not Available", Toast.LENGTH_SHORT);
            mToast.show();
        }
        mPref = getSharedPreferences(PREFERENCES_ACCOUNT, MODE_PRIVATE);
        String Name = mPref.getString(PREF_NAME, "");
        String Pass = mPref.getString(PREF_NAME, "");
        if ((!Name.isEmpty() && Name != null) && (!Pass.isEmpty() && Pass != null)) {
            Intent intent = new Intent(Log_in.this, Bottom_Bar.class);
            startActivity(intent);
            finish();
        }

    }

    private void cheackLogin() {
        if (checkConnectivity()) {
            String name = mEmail.getText().toString().trim().toLowerCase();
            String password = mPassword.getText().toString().trim().toLowerCase();
            if (validEmail(name) && validPassword(password)) {
                new Login_Task().execute(name, password);
            } else {
                if (!validEmail(name)) {
                    mEmail.setError(getResources().getString(R.string.invalidEmail));
                    mEmail.requestFocus();
                } else if (!validPassword(password)) {
                    mPassword.setError(getResources().getString(R.string.invalidPassword));
                    mPassword.requestFocus();
                }

            }
        } else {
            if (mToast != null) {
                mToast.cancel();
            }
            mToast = Toast.makeText(this, "NetWork is Not Available", Toast.LENGTH_SHORT);
            mToast.show();
        }

    }

    private boolean validEmail(String mEmail) {
      /*  String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{3,3})$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(mEmail);
        return matcher.matches();*/
        return true;
    }

    private boolean validPassword(String mPass) {
        return !mPass.isEmpty() && mPass != null && mPass.length() > 0;
    }

    class Login_Task extends AsyncTask<String, Void, String> {
        private String mName;
        private String mPass;

        @Override
        protected String doInBackground(String... strings) {
            mName = strings[0];
            mPass = strings[1];
            URL url = LogIn_NetworkUtils.createUrl(mName, mPass);
            String response = null;
            try {
                response = LogIn_NetworkUtils.makeHttpRequest(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (!s.isEmpty() && s != null) {
                Intent intent = new Intent(Log_in.this, Bottom_Bar.class);
                startActivity(intent);
                mEditor = mPref.edit();
                mEditor.putString(PREF_NAME, mName);
                mEditor.putString(PREF_PASS, mPass);
                mEditor.commit();
                finish();
            } else {
                if (mToast != null) {
                    mToast.cancel();
                }
                mToast = Toast.makeText(Log_in.this, "Please Sign Up", Toast.LENGTH_LONG);
                mToast.show();
            }
        }
    }
}

