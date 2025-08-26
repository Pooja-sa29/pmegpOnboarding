package com.trust.pmegpcustomeronboardingapp.activity.model;

public class DPRResponse {
    private boolean success;
    private DPRDetailData data;

    // Getters and setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public DPRDetailData getData() { return data; }
    public void setData(DPRDetailData data) { this.data = data; }
}
