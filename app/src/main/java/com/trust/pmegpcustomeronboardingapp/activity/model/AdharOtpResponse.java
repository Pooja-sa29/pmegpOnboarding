package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class AdharOtpResponse {

    @SerializedName("success")
    private boolean success;

    @SerializedName("guidKey")
    private String guidKey;

    @SerializedName("data")
    private Data data;

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getGuidKey() { return guidKey; }
    public void setGuidKey(String guidKey) { this.guidKey = guidKey; }

    public Data getData() { return data; }
    public void setData(Data data) { this.data = data; }

    // nested class for "data"
    public static class Data {
        @SerializedName("code")
        private String code;

        @SerializedName("description")
        private String description;

        public String getCode() { return code; }
        public void setCode(String code) { this.code = code; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
    }
}
