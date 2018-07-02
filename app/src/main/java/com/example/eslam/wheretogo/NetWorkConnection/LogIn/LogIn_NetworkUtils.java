package com.example.eslam.wheretogo.NetWorkConnection.LogIn;

import android.net.Uri;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public final class LogIn_NetworkUtils {
    private static final int READTIMEOUT = 10000;
    private static final int CONNECTTIMEOUT = 15000;
    private static final String REQUEST_METHOD_POST = "POST";


    private static final String URL_LOGIN = "http://events.bstest.online/api/user/Login";
    private static final String USERNAME_LOGIN = "username";
    private static final String PASSWORD_LOGIN = "password";

    public static URL createUrl(String mName, String mPass) {
        Uri uri = Uri.parse(URL_LOGIN).
                buildUpon().appendQueryParameter(USERNAME_LOGIN, mName)
                .appendQueryParameter(PASSWORD_LOGIN, mPass)
                .build();
        URL url = null;
        try {
            url = new URL(uri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    private static String readFromStreamReader(InputStream inputStream) throws IOException {
        String line = "";
        StringBuilder builder = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader streamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);

            }
        }
        return builder.toString();
    }

    public static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        if (jsonResponse == null) {
            return null;
        }
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(REQUEST_METHOD_POST);
            httpURLConnection.setConnectTimeout(CONNECTTIMEOUT);
            httpURLConnection.setReadTimeout(READTIMEOUT);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == httpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                jsonResponse = readFromStreamReader(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }
}
