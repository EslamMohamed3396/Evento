package com.example.eslam.wheretogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Sign_Up extends AppCompatActivity {

    private Button btn_sign_two;
    String[] text1 = {"Male", "Female", "Company"};
    int[] val1 = {0, 1, 2};
    String[] text = {"Cairo", "Alexandria", "Giza", "Port Said", "Suez", "Mansoura", "Tanta", "Ismailia", "Zagazig", "Damietta", "Aswan", "Minya", "Beni Suef", "Sohag"};
    int[] val = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    AdapterView.OnItemSelectedListener onItemSelectedListener1 =
            new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    in = val1[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }

            };
    private Spinner spinner, spin;
    private int in1, in;
    AdapterView.OnItemSelectedListener onItemSelectedListener =
            new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    in1 = val[position];
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
                Intent GoToSignUpPageTwo = new Intent(Sign_Up.this, Home.class);
                startActivity(GoToSignUpPageTwo);
            }
        });

        spinner = (Spinner) findViewById(R.id.sp_city);
        spinner.setOnItemSelectedListener(onItemSelectedListener);

        spin = (Spinner) findViewById(R.id.spinner_Gender);//fetching view's id
        spin.setOnItemSelectedListener(onItemSelectedListener1);


        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(Sign_Up.this,
                        android.R.layout.simple_spinner_item, text);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> adapter1 =
                new ArrayAdapter<String>(Sign_Up.this,
                        android.R.layout.simple_spinner_item, text1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter1);

    }


}
