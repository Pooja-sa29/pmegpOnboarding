package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class VillageDetailResponse {

    @SerializedName("Village_Code")
    private String villageCode;

    @SerializedName("Village_Name")
    private String villageName;

    @SerializedName("Pincode")
    private String pincode;

    @SerializedName("Rural_Urban")
    private String ruralUrban;

    @SerializedName("SubDistrict_Code")
    private String subDistrictCode;

    @SerializedName("lgdCodeId")
    private int lgdCodeId;




    public String getVillageCode() {
        return villageCode;
    }

    public String getVillageName() {
        return villageName;
    }

    public String getPincode() {
        return pincode;
    }

    public String getRuralUrban() {
        return ruralUrban;
    }

    public String getSubDistrictCode() {
        return subDistrictCode;
    }

    public int getLgdCodeId() {
        return lgdCodeId;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setRuralUrban(String ruralUrban) {
        this.ruralUrban = ruralUrban;
    }

    public void setSubDistrictCode(String subDistrictCode) {
        this.subDistrictCode = subDistrictCode;
    }

    public void setLgdCodeId(int lgdCodeId) {
        this.lgdCodeId = lgdCodeId;
    }
}
