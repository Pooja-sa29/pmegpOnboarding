package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class VillageDetailModel {

    @SerializedName("Village_Code")
    private String villageCode;
    @SerializedName("Village_Name")
    private String villageName;
    public VillageDetailModel(String villageCode) {
        this.villageCode = villageCode;
    }
    public String getVillageCode() {
        return villageCode;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }
}
