package com.example.eslam.wheretogo.Model;

public class Event_Model {
    private String mDescreption;
    private int mImage;

    public Event_Model(String mDescreption, int mImage) {
        this.mDescreption = mDescreption;
        this.mImage = mImage;
    }

    public String getmDescreption() {
        return mDescreption;
    }

    public int getmImage() {
        return mImage;
    }
}
