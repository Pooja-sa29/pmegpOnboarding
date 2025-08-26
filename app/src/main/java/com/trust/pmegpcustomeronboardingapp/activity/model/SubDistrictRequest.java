package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class SubDistrictRequest {
    @SerializedName("District_Code")
    private String districtCode;

    public SubDistrictRequest(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }
}
