package com.example.eslam.wheretogo.NetWorkConnection.LogIn;

import android.text.TextUtils;

import com.example.eslam.wheretogo.Model.Get_User_Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public final class JsonUtils {

    private static final String USER_NAME = "User_Name";
    private static final String EMAIL = "Email";
    private static final String PHONE = "phone";
    private static final String GENDER = "Gender";

    public static List<Get_User_Model> ExtractUserData(String json) {
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        List<Get_User_Model> user_models = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(json);
            String User_name = root.optString(USER_NAME);
            String Email = root.optString(EMAIL);
            String Phone = root.optString(PHONE);
            String Gender = root.optString(GENDER);
            user_models.add(new Get_User_Model(User_name, Email, Phone, Gender));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user_models;
    }
}
