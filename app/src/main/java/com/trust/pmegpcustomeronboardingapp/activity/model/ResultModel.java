package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class ResultModel {


    @SerializedName("success")
    private boolean success;
    @SerializedName("UserID")
    private String UserID;
    @SerializedName("password")
    private String password;
    @SerializedName("ApplID")
    private int ApplID;

    @SerializedName("message")
    private String message;



    public boolean isSuccess() { return success; }
    public String getUserID() { return UserID; }
    public String getPassword() { return password; }
    public int getApplID() { return ApplID; }
    public String getMessage() { return message; }
}
