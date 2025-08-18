package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class StateModel {
    @SerializedName("State_Name")
private String stateName;

    @SerializedName("State_ID")
    private int stateId;
    @SerializedName("State_Code")
    private String stateCode;

    @SerializedName("State_Short_Code")
    private String stateShortCode;

    @SerializedName("Zone_Code")
    private String state_zone_code;



    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateName() { return stateName; }
    public String getStateCode() { return stateCode; }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateShortCode() { return stateShortCode; }

    public String getState_zone_code() {
        return state_zone_code;
    }

    public void setState_zone_code(String state_zone_code) {
        this.state_zone_code = state_zone_code;
    }
}
