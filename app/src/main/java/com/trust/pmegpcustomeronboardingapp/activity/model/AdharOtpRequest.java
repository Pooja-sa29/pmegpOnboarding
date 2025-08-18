package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class AdharOtpRequest {
    @SerializedName("aadhaarNo")
    String aadhaarNo;
    @SerializedName("AadharOTP")
    String otp;
    @SerializedName("guidKey")
    String guidKey;

    public String getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(String aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getGuidKey() {
        return guidKey;
    }

    public void setGuidKey(String guidKey) {
        this.guidKey = guidKey;
    }
}
