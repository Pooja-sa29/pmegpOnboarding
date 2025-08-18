package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class SubDistrictResponce {
    @SerializedName("District_ID")
    private int districtId;
    @SerializedName("District_Code")
    private int district_code;
    @SerializedName("SubDistrict_ID")
    private int subdistrinct_id;


    @SerializedName("SubDistrict_Code")
    private int subdistrict_code;
    @SerializedName("SubDistrict_Name")
    private String subdistrict_name;

    public SubDistrictResponce setSubdistrictCode(int subdistrictCode) {
        this.subdistrict_code = subdistrictCode;
        return this;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getDistrict_code() {
        return district_code;
    }

    public void setDistrict_code(int district_code) {
        this.district_code = district_code;
    }

    public int getSubdistrinct_id() {
        return subdistrinct_id;
    }

    public void setSubdistrinct_id(int subdistrinct_id) {
        this.subdistrinct_id = subdistrinct_id;
    }

    public int getSubdistrict_code() {
        return subdistrict_code;
    }

    public void setSubdistrict_code(int subdistrict_code) {
        this.subdistrict_code = subdistrict_code;
    }

    public String getSubdistrict_name() {
        return subdistrict_name;
    }

    public void setSubdistrict_name(String subdistrict_name) {
        this.subdistrict_name = subdistrict_name;
    }
}
