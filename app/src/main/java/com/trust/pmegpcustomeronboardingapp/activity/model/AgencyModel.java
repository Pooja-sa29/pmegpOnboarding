package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class AgencyModel {
    @SerializedName("Agency_ID")
    private int agencyId;

    @SerializedName("Agency_Code")
    private String agency_code;

    public AgencyModel(int agencyId) {
        this.agencyId = agencyId;
    }

    public AgencyModel() {
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgency_code() {
        return agency_code;
    }

    public void setAgency_code(String agency_code) {
        this.agency_code = agency_code;
    }
}
