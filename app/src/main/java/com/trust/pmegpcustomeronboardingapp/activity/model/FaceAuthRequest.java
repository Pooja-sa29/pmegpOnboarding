package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class FaceAuthRequest {
    @SerializedName("applId")
    private int applId;
    @SerializedName("status")
    private String status;
    @SerializedName("IsFinalAuthDone")
    private Boolean IsFinalAuthDone;

    public FaceAuthRequest(int applId, String status, Boolean isFinalAuthDone) {
        this.applId = applId;
        this.status = status;
        IsFinalAuthDone = isFinalAuthDone;
    }

    public int getApplId() {
        return applId;
    }

    public void setApplId(int applId) {
        this.applId = applId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getFinalAuthDone() {
        return IsFinalAuthDone;
    }

    public void setFinalAuthDone(Boolean finalAuthDone) {
        IsFinalAuthDone = finalAuthDone;
    }
}
