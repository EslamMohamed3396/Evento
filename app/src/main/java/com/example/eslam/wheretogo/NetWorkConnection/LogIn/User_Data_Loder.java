package com.example.eslam.wheretogo.NetWorkConnection.LogIn;

import android.content.AsyncTaskLoader;
import android.content.Context;


import com.example.eslam.wheretogo.Model.Get_User_Model;

import java.util.ArrayList;
import java.util.List;

public class User_Data_Loder extends AsyncTaskLoader<List<Get_User_Model>> {

    private Context context;

    public User_Data_Loder(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<Get_User_Model> loadInBackground() {
        List<Get_User_Model> user_models;
        user_models = GetUserData_NetWorkUtils.ExtractJsonFromNetwork();
        return user_models;
    }
}
