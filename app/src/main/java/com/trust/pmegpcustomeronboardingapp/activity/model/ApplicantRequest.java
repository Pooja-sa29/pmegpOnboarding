package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class ApplicantRequest {
    @SerializedName("ApplID")
    private int ApplID;

    public ApplicantRequest(int applID) {
        ApplID = applID;
    }
}
