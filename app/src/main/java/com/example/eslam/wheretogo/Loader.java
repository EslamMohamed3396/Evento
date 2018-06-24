package com.example.eslam.wheretogo;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;


public class Loader extends AsyncTaskLoader<List<Object>> {
    private String mUrl;

    public Loader(Context context, String mUrl) {
        super(context);
        mUrl = mUrl;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Object> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        return null;
    }


}
