package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EDPResponse {
    @SerializedName("success")
    private boolean success;

    @SerializedName("data")
    private List<EDPDetails> data;

    public boolean isSuccess() {
        return success;
    }

    public List<EDPDetails> getData() {
        return data;
    }
}
