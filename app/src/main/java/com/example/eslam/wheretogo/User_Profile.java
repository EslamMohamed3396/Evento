package com.example.eslam.wheretogo;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.eslam.wheretogo.Model.Get_User_Model;
import com.example.eslam.wheretogo.NetWorkConnection.LogIn.User_Data_Loder;

import java.util.ArrayList;
import java.util.List;

public class User_Profile extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Get_User_Model>> {
    private TextView tv_name;
    private TextView tv_email;
    private TextView tv_phone;
    private TextView tv_gender;
    private static final int USER_LOADER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__profile);
        bindWidget();

    }

    private void bindWidget() {
        tv_name = (TextView) findViewById(R.id.txt_name);
        tv_email = (TextView) findViewById(R.id.txt_email);
        tv_phone = (TextView) findViewById(R.id.txt_phone);
        tv_gender = (TextView) findViewById(R.id.txt_gender);
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(USER_LOADER_ID, null, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_edit:
                Intent goToEditUserPage = new Intent(this, Edit_User_Profile.class);
                startActivity(goToEditUserPage);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<List<Get_User_Model>> onCreateLoader(int i, Bundle bundle) {
        return new User_Data_Loder(this);
    }

    @Override
    public void onLoadFinished(Loader<List<Get_User_Model>> loader, List<Get_User_Model> get_user_models) {

       /* get_user_models = new ArrayList<>();
        Get_User_Model userModel;
        for (int i = 0; i < get_user_models.size(); i++) {
            userModel = get_user_models.get(i);
            tv_name.setText(userModel.getmUserName());
            tv_email.setText(userModel.getmEmail());
            tv_phone.setText(userModel.getmPhone());
            tv_gender.setText(userModel.getmGender());
        }
*/
    }

    @Override
    public void onLoaderReset(Loader<List<Get_User_Model>> loader) {

    }
}
