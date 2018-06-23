package com.example.eslam.wheretogo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class Bottom_Bar extends AppCompatActivity {
    private Fragment mFragment = null;
    private BottomNavigationView mNavigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    int id = item.getItemId();
                    switch (id) {
                        case R.id.home:
                            mFragment = new Home_Fragment();
                            setFragment(mFragment);
                            return true;
                        case R.id.my_events:
                            mFragment = new Event_Fragment();
                            setFragment(mFragment);
                            return true;
                        case R.id.my_communities:
                            mFragment = new Community_Fragment();
                            setFragment(mFragment);
                            return true;
                        case R.id.search:
                            mFragment = new Search_Fragment();
                            setFragment(mFragment);
                            return true;
                        default:
                            return false;
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar);
        mFragment = new Home_Fragment();
        setFragment(mFragment);
        mNavigationView = (BottomNavigationView) findViewById(R.id.navigation_bottom);
        mNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setFragment(Fragment mFragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame, mFragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_profile:
                Intent intent = new Intent(Bottom_Bar.this, User_Profile.class);
                startActivity(intent);
                return true;
            case R.id.menu_logout:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
