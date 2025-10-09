package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class ApplicantDPROnly {
    @SerializedName("IsDPRVerified")
    private int isDPRVerified;

    public ApplicantDPROnly(int isDPRVerified) {
        this.isDPRVerified = isDPRVerified;
    }
}
