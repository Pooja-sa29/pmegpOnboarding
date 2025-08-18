package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class VillageRequest {
    @SerializedName("subDistrictCode")
    private String subDistrictCode;

    public VillageRequest(String subDistrictCode) {
        this.subDistrictCode = subDistrictCode;
    }
}
