package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class AdharVerificationResponse {

    @SerializedName("success")
        private boolean success;
    @SerializedName("data")
        private AadhaarData data;

        public boolean isSuccess() { return success; }
        public void setSuccess(boolean success) { this.success = success; }

        public AadhaarData getData() { return data; }
        public void setData(AadhaarData data) { this.data = data; }



}
