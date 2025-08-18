package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class DistrictModel {

        @SerializedName("District_ID")
        private int districtId;

        @SerializedName("State_Code")
        private String stateCode;

    @SerializedName("District_Code")
        private String districtCode;

    @SerializedName("District_Name")
        private String districtName;

    public DistrictModel(String stateCode,String districtCode) {
        this.stateCode = stateCode;
        this.districtCode = districtCode;
    }

    public DistrictModel() {
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }




    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
