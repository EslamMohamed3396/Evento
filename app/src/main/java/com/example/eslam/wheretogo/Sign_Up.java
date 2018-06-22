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
import android.widget.Spinner;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.IOException;

public class Sign_Up extends AppCompatActivity {
    private static final int GALLERY = 1;
    String[] mGenderSpinner = {"Male", "Female", "Company"};
    private Button btn_sign_two;
    int[] mGenderSpinnerNumber = {0, 1, 2};
    String[] mCittySpinner = {"Cairo", "Alexandria", "Giza", "Port Said", "Suez", "Mansoura", "Tanta", "Ismailia", "Zagazig", "Damietta", "Aswan", "Minya", "Beni Suef", "Sohag"};
    int[] mCittySpinnerNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
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
    private Spinner spinner, spin;
    private int mGenderSelected, mCitySelected;
    AdapterView.OnItemSelectedListener onItemSelectedListener1 =
            new AdapterView.OnItemSelectedListener() {
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
        btn_sign_two = (Button) findViewById(R.id.btn_sign_up_two);
        btn_sign_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoToLoginPageTwo = new Intent(Sign_Up.this, Log_in.class);
                startActivity(GoToLoginPageTwo);
            }
        });


        circleImageView = (CircularImageView) findViewById(R.id.im_profile_signup);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickPhoto();
            }
        });

        spinner = (Spinner) findViewById(R.id.sp_city);
        spinner.setOnItemSelectedListener(onItemSelectedListener);

        spin = (Spinner) findViewById(R.id.spinner_Gender);//fetching view's id
        spin.setOnItemSelectedListener(onItemSelectedListener1);

        fillTheSpinner();

    }

    public void fillTheSpinner() {

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(Sign_Up.this,
                        android.R.layout.simple_spinner_item, mCittySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> adapter1 =
                new ArrayAdapter<String>(Sign_Up.this,
                        android.R.layout.simple_spinner_item, mGenderSpinner);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter1);
    }

    public void pickPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
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
