package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("data")
    String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
