package com.example.eslam.wheretogo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Add_Event extends AppCompatActivity {
    private Button btn_Next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__event);
        btn_Next=(Button)findViewById(R.id.btn_next);
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GoTonextAddEventPage=new Intent(Add_Event.this,add_event_1.class);
                startActivity(GoTonextAddEventPage);
            }
        });


    }
}
