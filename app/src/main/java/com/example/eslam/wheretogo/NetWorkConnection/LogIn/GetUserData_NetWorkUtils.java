package com.example.eslam.wheretogo.NetWorkConnection.LogIn;

import com.example.eslam.wheretogo.Model.Get_User_Model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public final class GetUserData_NetWorkUtils {

    private static final String URL_GET_USER = "http://events.bstest.online/api/user/Getuserdata";

    private static URL Create_URL() {
        URL url = null;
        try {
            url = new URL(URL_GET_USER);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static List<Get_User_Model> ExtractJsonFromNetwork() {

        String jsonResponse = null;
        URL url = Create_URL();
        try {
            jsonResponse = LogIn_NetworkUtils.makeHttpRequest(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Get_User_Model> user_models = JsonUtils.ExtractUserData(jsonResponse);

        return user_models;
    }
}
