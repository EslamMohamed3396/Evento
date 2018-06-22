package com.example.eslam.wheretogo.NetWorkConnection;

import android.text.TextUtils;

import com.example.eslam.wheretogo.Model.Event_Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public final class NetworkUtils {

    private static final int READTIMEOUT = 10000;
    private static final int CONNECTTIMEOUT = 15000;
    private static final String REQUEST_METHOD_GET = "GET";
    private static final String REQUEST_METHOD_POST = "POST";

    public static URL createUrl(String mUrl) {
        URL url = null;
        try {
            url = new URL(mUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static String readFromStreamReader(InputStream inputStream) throws IOException {
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
            httpURLConnection.setRequestMethod(REQUEST_METHOD_GET);
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

    public static List<Event_Model> extractDataFromJson(String json) {
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        List<Event_Model> Data_event = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return Data_event;
    }

    public static List<Event_Model> extractEventData(String stringJson) {
        String response = "";
        URL url = null;
        url = createUrl(stringJson);
        List<Event_Model> event_models_Data;
        try {
            response = makeHttpRequest(url);

        } catch (IOException e) {
            e.printStackTrace();
        }
        event_models_Data = extractDataFromJson(response);
        return event_models_Data;
    }
}
