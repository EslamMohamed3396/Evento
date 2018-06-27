package com.example.eslam.wheretogo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sign_Up_2 extends AppCompatActivity {

    private static final int GALLERY = 1;
    String[] mCittySpinner = {"Cairo", "Alexandria", "Giza", "Port Said", "Suez", "Mansoura", "Tanta", "Ismailia", "Zagazig", "Damietta", "Aswan", "Minya", "Beni Suef", "Sohag"};
    int[] mCittySpinnerNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private EditText mPersonName, mPhone, mAddress;
    private Spinner spinner;
    private int mCitySelected;
    AdapterView.OnItemSelectedListener onItemSelectedListener =
            new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    mCitySelected = mCittySpinnerNumber[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }

            };
    private CircularImageView circleImageView;
    private Button mSignUp, mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up_2);

        mPersonName = (EditText) findViewById(R.id.ed_person_name);
        mPhone = (EditText) findViewById(R.id.ed_phone);
        mAddress = (EditText) findViewById(R.id.ed_address);
        circleImageView = (CircularImageView) findViewById(R.id.im_profile_signup);
        mBack = (Button) findViewById(R.id.btn_back_sign_up_one);
        mSignUp = (Button) findViewById(R.id.btn_sign_up);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BackToSignUpPageOne = new Intent(Sign_Up_2.this, Sign_Up.class);
                startActivity(BackToSignUpPageOne);
            }
        });

        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInformation();
            }
        });
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickPhoto();
            }
        });
        spinner = (Spinner) findViewById(R.id.sp_city);
        spinner.setOnItemSelectedListener(onItemSelectedListener);
        fillTheSpinner();
    }

    private void checkInformation() {
        if (ValidPersonName() && ValidPhone() && ValidAddress()) {
            Intent GoToHomePageTwo = new Intent(Sign_Up_2.this, Bottom_Bar.class);
            startActivity(GoToHomePageTwo);
        }


    }

    private boolean ValidPhone() {
        String valid_Phone = "(010|011|012|015)(\\s*-?\\d){8}";
        Matcher matcher_phone = Pattern.compile(valid_Phone).matcher(mPhone.getText().toString());
        if (matcher_phone.matches()) {
            return true;
        } else {
            mPhone.setError(getResources().getString(R.string.invalidPhone));
            mPhone.requestFocus();
            return false;
        }

    }

    private boolean ValidAddress() {
        String valid_address = "[A-Za-z\\d]{10,}";
        Matcher matcher_address = Pattern.compile(valid_address).matcher(mAddress.getText().toString().toLowerCase());
        if (matcher_address.matches()) {
            return true;
        } else {
            mAddress.setError(getResources().getString(R.string.invalidAddress));
            mAddress.requestFocus();
            return false;
        }

    }

    private boolean ValidPersonName() {
        String valid_name = "[A-Za-z]{3,}";
        Matcher matcher_name = Pattern.compile(valid_name).matcher(mPersonName.getText().toString().toLowerCase());
        if (matcher_name.matches()) {
            return true;
        } else {
            mPersonName.setError(getResources().getString(R.string.invalidPersonName));
            mPersonName.requestFocus();
            return false;
        }

    }

    public void fillTheSpinner() {

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(Sign_Up_2.this,
                        android.R.layout.simple_spinner_item, mCittySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


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
}
