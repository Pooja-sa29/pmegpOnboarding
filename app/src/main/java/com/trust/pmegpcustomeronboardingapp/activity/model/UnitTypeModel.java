package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class UnitTypeModel {

    @SerializedName("SchemeID")
    private int schemeId;
    @SerializedName("ActivityType")
    private int activityType;

    @SerializedName("SchemeName")
    private String schemeName;

    public UnitTypeModel(int activityType) {
        this.activityType = activityType;
    }

    public UnitTypeModel() {
    }

    public int getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(int schemeId) {
        this.schemeId = schemeId;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public int getActivityType() {
        return activityType;
    }

    public void setActivityType(int activityType) {
        this.activityType = activityType;
    }
}
