package com.example.eslam.wheretogo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

public class event_details extends AppCompatActivity {

    private TextView mName, mDescription, mLocation, mStart_Date, mEnd_Dat, mTopic, mType;
    private CircularImageView mEvent_Imag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        mName = (TextView) findViewById(R.id.txt_name);
        mDescription = (TextView) findViewById(R.id.txt_name);
        mLocation = (TextView) findViewById(R.id.txt_name);
        mStart_Date = (TextView) findViewById(R.id.txt_name);
        mEnd_Dat = (TextView) findViewById(R.id.txt_name);
        mTopic = (TextView) findViewById(R.id.txt_name);
        mType = (TextView) findViewById(R.id.txt_name);
        mEvent_Imag = (CircularImageView) findViewById(R.id.im_event_profile);
    }
}
