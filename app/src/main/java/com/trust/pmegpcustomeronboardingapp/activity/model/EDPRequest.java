package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class EDPRequest {
    @SerializedName("stateCode")
    private String stateCode;

    public EDPRequest(String stateCode) {
        this.stateCode = stateCode;
    }
}
