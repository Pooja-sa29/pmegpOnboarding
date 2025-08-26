package com.trust.pmegpcustomeronboardingapp.activity.model;

public class ApplicationResponse {

    private boolean success;
    private ApplicantDetailData data;

    // Getters and setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public ApplicantDetailData getData() { return data; }
    public void setData(ApplicantDetailData data) { this.data = data; }
}
