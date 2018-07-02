package com.example.eslam.wheretogo.Model;

public class Get_User_Model {
    private String mUserName;
    private String mEmail;
    private String mPhone;
    private String mGender;

    public Get_User_Model(String mUserName, String mEmail, String mPhone, String mGender) {
        this.mUserName = mUserName;
        this.mEmail = mEmail;
        this.mPhone = mPhone;
        this.mGender = mGender;
    }

    public String getmUserName() {
        return mUserName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public String getmPhone() {
        return mPhone;
    }

    public String getmGender() {
        return mGender;
    }
}
