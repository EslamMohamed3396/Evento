package com.example.eslam.wheretogo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class add_event_1 extends AppCompatActivity {

    String[] mTopicSpinner = {"Sport", "Music", "Movie", "Gaming", "Travling"};
    int[] mTopicSpinnerNumber = {1, 2, 3, 4, 5};
    String[] mTypeSpinner = {"Football", "hip hop", "hunger game", "hon", "paries"};
    int[] mTypeSpinnerNumber = {1, 2, 3, 4, 5};
    String[] mListingSpinner = {"Public", "Private"};
    int[] mListingSpinnerNumber = {1, 2};
    AdapterView.OnItemSelectedListener onItemSelectedListener1 = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            mTypeSelected = mTypeSpinnerNumber[position];
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
    AdapterView.OnItemSelectedListener onItemSelectedListener2 = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            mListingSelected = mListingSpinnerNumber[position];
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
    private Spinner spinnerTopic, spinnerType, spinnerLisiting;
    private int mTopicSelected, mTypeSelected, mListingSelected;
    AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            mTopicSelected = mTopicSpinnerNumber[position];
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event_1);
        spinnerTopic = (Spinner) findViewById(R.id.sp_topic);
        spinnerType = (Spinner) findViewById(R.id.sp_type);
        spinnerLisiting = (Spinner) findViewById(R.id.sp_Listing);

        spinnerLisiting.setOnItemSelectedListener(onItemSelectedListener2);
        spinnerType.setOnItemSelectedListener(onItemSelectedListener1);
        spinnerTopic.setOnItemSelectedListener(onItemSelectedListener);
        fillTheSpinner();

    }

    public void fillTheSpinner() {

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(add_event_1.this,
                        android.R.layout.simple_spinner_item, mTopicSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTopic.setAdapter(adapter);


        ArrayAdapter<String> adapter1 =
                new ArrayAdapter<String>(add_event_1.this,
                        android.R.layout.simple_spinner_item, mTypeSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(adapter1);


        ArrayAdapter<String> adapter2 =
                new ArrayAdapter<String>(add_event_1.this,
                        android.R.layout.simple_spinner_item, mListingSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLisiting.setAdapter(adapter2);

    }
}
