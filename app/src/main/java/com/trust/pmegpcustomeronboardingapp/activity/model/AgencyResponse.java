package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class AgencyResponse {
    @SerializedName("AgencyOffID")
    private int agencyOffId;
    @SerializedName("AgencyTypeId")
    private int AgencyTypeId;
    @SerializedName("AgencyOffCode")
    private String AgencyOffCode;
    @SerializedName("AgencyOffName")
    private String AgencyOffName;
    @SerializedName("AgencyOffState")
    private String AgencyOffState;
    @SerializedName("AgencyOffDist")
    private String AgencyOffDist;
    @SerializedName("AgencyOffContactNo")
    private String AgencyOffContactNo;
    @SerializedName("AgencyOffContactEmail")
    private String AgencyOffContactEmail;


    public int getAgencyOffId() {
        return agencyOffId;
    }

    public void setAgencyOffId(int agencyOffId) {
        this.agencyOffId = agencyOffId;
    }

    public int getAgencyTypeId() {
        return AgencyTypeId;
    }

    public void setAgencyTypeId(int agencyTypeId) {
        AgencyTypeId = agencyTypeId;
    }

    public String getAgencyOffCode() {
        return AgencyOffCode;
    }

    public void setAgencyOffCode(String agencyOffCode) {
        AgencyOffCode = agencyOffCode;
    }

    public String getAgencyOffName() {
        return AgencyOffName;
    }

    public void setAgencyOffName(String agencyOffName) {
        AgencyOffName = agencyOffName;
    }

    public String getAgencyOffState() {
        return AgencyOffState;
    }

    public void setAgencyOffState(String agencyOffState) {
        AgencyOffState = agencyOffState;
    }

    public String getAgencyOffDist() {
        return AgencyOffDist;
    }

    public void setAgencyOffDist(String agencyOffDist) {
        AgencyOffDist = agencyOffDist;
    }

    public String getAgencyOffContactNo() {
        return AgencyOffContactNo;
    }

    public void setAgencyOffContactNo(String agencyOffContactNo) {
        AgencyOffContactNo = agencyOffContactNo;
    }

    public String getAgencyOffContactEmail() {
        return AgencyOffContactEmail;
    }

    public void setAgencyOffContactEmail(String agencyOffContactEmail) {
        AgencyOffContactEmail = agencyOffContactEmail;
    }
}
