package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AgencyShortCodeResponse {
    @SerializedName("success")
    private boolean success;

    @SerializedName("data")
    private List<AgencyShortCodes> data;

    public boolean isSuccess() {
        return success;
    }

    public List<AgencyShortCodes> getData() {
        return data;
    }
}
