package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class VillageDetailRequestModel {
    @SerializedName("villageCode")
    private String villageCode;

    public VillageDetailRequestModel(String villageCode) {
        this.villageCode = villageCode;
    }
}
