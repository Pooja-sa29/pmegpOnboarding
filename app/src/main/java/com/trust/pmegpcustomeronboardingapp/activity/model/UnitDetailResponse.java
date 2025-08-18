package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class UnitDetailResponse {
    @SerializedName("status")
    private boolean status;
    @SerializedName("data")
    private VillageDetailResponse data;


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public VillageDetailResponse getData() {
        return data;
    }

    public void setData(VillageDetailResponse data) {
        this.data = data;
    }
}
