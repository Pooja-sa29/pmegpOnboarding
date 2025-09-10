package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class UnitTypeIdModel {
     @SerializedName("ActivityType")
    int ActivityType;

    public UnitTypeIdModel(int activityType) {
        ActivityType = activityType;
    }

    public int getActivityType() {
        return ActivityType;
    }

    public void setActivityType(int activityType) {
        ActivityType = activityType;
    }
}
