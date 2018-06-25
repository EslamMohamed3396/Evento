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
import android.widget.ImageView;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Add_Event extends AppCompatActivity {
    private Button btn_Next;
    private static final int GALLERY = 1;
    private ImageView mPhoto_Event;
    private EditText mEventNme;
    private EditText mEventLocation;
    private EditText mEventDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__event);
        btn_Next = (Button) findViewById(R.id.btn_next);
        mPhoto_Event = (ImageView) findViewById(R.id.image_Event);
        mEventNme = (EditText) findViewById(R.id.ed_create_new_event);
        mEventLocation = (EditText) findViewById(R.id.ed_event_location);
        mEventDescription = (EditText) findViewById(R.id.ed_event_description);

        mPhoto_Event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickPhoto();
            }
        });
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });

    }

    private void next() {
        String name = mEventNme.getText().toString().toLowerCase();
        String location = mEventLocation.getText().toString().toLowerCase();
        String desc = mEventDescription.getText().toString().toLowerCase();
        if (validEventReqiuerd(name, location, desc)) {
            Intent intent = new Intent(Add_Event.this, add_event_1.class);
            startActivity(intent);
        }
    }

    private boolean validEventReqiuerd(String name, String loc, String desc) {
        String namePattern = "[A-Za-z]{4,}";
        Pattern pattern = Pattern.compile(namePattern);
        Matcher matcher = pattern.matcher(name + "" + loc + "" + desc);
        return matcher.matches();
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
                    mPhoto_Event.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
