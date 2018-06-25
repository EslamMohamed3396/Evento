package com.example.eslam.wheretogo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Create_Community extends AppCompatActivity {
    private Spinner mRoleSpinner;
    private Spinner mStateSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__community);
        mRoleSpinner = (Spinner) findViewById(R.id.spinner_role);
        mStateSpinner = (Spinner) findViewById(R.id.spinner_state);
        fillSpinner();
    }

    public void fillSpinner() {
        ArrayList<String> fillRole = new ArrayList<>();
        fillRole.add("Has Post");
        fillRole.add("No Post");
        ArrayList<String> fillState = new ArrayList<>();
        fillState.add("Open");
        fillState.add("Closed");
        fillState.add("Private");
        ArrayAdapter<String> roleSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fillRole);
        ArrayAdapter<String> stateSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fillState);
        roleSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mStateSpinner.setAdapter(stateSpinner);
        mRoleSpinner.setAdapter(roleSpinner);
    }
}
