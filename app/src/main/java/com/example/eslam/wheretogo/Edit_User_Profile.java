package com.example.eslam.wheretogo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Edit_User_Profile extends AppCompatActivity {
    private static final int GALLERY = 1;
    private CircularImageView circleImageView;
    private EditText mName;
    private EditText mPhone;
    private EditText mEmail;
    private EditText mOldPass;
    private EditText mNewPass;
    private EditText mConfirmPass;
    private Button mSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__user__profile);
        mName = (EditText) findViewById(R.id.ed_pesonal_name_edit);
        mPhone = (EditText) findViewById(R.id.ed_phone_edit);
        mEmail = (EditText) findViewById(R.id.ed_email_edit);
        mOldPass = (EditText) findViewById(R.id.ed_oldpass_edit);
        mNewPass = (EditText) findViewById(R.id.ed_newpass_edit);
        mSave = (Button) findViewById(R.id.btn_save);
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cheackInformation();
            }
        });
        mConfirmPass = (EditText) findViewById(R.id.ed_confirm_pass_edit);
        circleImageView = (CircularImageView) findViewById(R.id.im_profile_edit);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickPhoto();
            }
        });
    }

    public void pickPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {

                Uri uri = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                    circleImageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void cheackInformation() {
        String name = mName.getText().toString();
        String email = mEmail.getText().toString();
        String phone = mPhone.getText().toString();
        String older_pass = mOldPass.getText().toString().toLowerCase();
        String new_pass = mNewPass.getText().toString().toLowerCase();
        String confirm_pass = mConfirmPass.getText().toString().toLowerCase();
        if (validName(name)
                && validEmail(email)
                && validPhone(phone)
                && validPassword(older_pass)
                && validPassword(new_pass)
                && validPassword(confirm_pass)) {
            Intent GoToHomePage = new Intent(Edit_User_Profile.this, User_Profile.class);
            startActivity(GoToHomePage);
            //  finish();

        } else {
            if (!validName(name)) {
                mName.setError(getResources().getString(R.string.invalidName));
                mName.requestFocus();
            } else if (!validEmail(email)) {
                mEmail.setError(getResources().getString(R.string.invalidEmail));
                mEmail.requestFocus();
            } else if (!validPhone(phone)) {
                mPhone.setError(getResources().getString(R.string.invalidPhone));
                mPhone.requestFocus();
            } else if (!validPassword(older_pass)) {
                mOldPass.setError(getResources().getString(R.string.invalidPassword));
                mOldPass.requestFocus();
            } else if (!validPassword(new_pass)) {
                mNewPass.setError(getResources().getString(R.string.invalidPassword));
                mNewPass.requestFocus();
            } else if (!validPassword(confirm_pass)) {
                mConfirmPass.setError(getResources().getString(R.string.invalidPassword));
                mConfirmPass.requestFocus();
            }

        }
    }

    private boolean validPhone(String phone) {
        String phonePattern = "(010|011|012)(\\s*-?\\d){8}";
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(String.valueOf(phone));
        return matcher.matches();

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

    private boolean validName(String name) {
        String namePattern = "[A-Za-z]{3,}";
        Pattern pattern = Pattern.compile(namePattern);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
