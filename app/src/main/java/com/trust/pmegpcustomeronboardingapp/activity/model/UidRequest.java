package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class UidRequest {
    @SerializedName("aadhaarNo")
    String aadhaarNo;

    public UidRequest(String aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public String getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(String aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }
}
