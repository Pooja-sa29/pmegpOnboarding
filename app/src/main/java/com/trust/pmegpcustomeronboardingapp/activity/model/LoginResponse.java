package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("status")
    private boolean status;

    @SerializedName("ApplCode")
    private String applCode;

    @SerializedName("ApplID")
    private int applID;

    @SerializedName("message")
    private String message;

    public boolean isSuccess() {
        return status;
    }

    public String getApplCode() {
        return applCode;
    }

    public int getApplID() {
        return applID;
    }

    public String getMessage() {
        return message;
    }
}
