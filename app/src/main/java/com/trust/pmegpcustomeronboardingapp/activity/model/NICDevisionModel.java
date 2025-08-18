package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class NICDevisionModel {

    @SerializedName("NIC_DataID")
    private int nic_id;
    @SerializedName("NicCode")
    private String nic_code;
    @SerializedName("NicDesc")
    private String nic_desc;

    @SerializedName("ActivityType")
    private int nic_activityType;

    public NICDevisionModel(String nic_code) {
        this.nic_code = nic_code;
    }

    public int getNic_id() {
        return nic_id;
    }

    public void setNic_id(int nic_id) {
        this.nic_id = nic_id;
    }

    public String getNic_code() {
        return nic_code;
    }

    public void setNic_code(String nic_code) {
        this.nic_code = nic_code;
    }

    public String getNic_desc() {
        return nic_desc;
    }

    public void setNic_desc(String nic_desc) {
        this.nic_desc = nic_desc;
    }



    public int getNic_activityType() {
        return nic_activityType;
    }

    public void setNic_activityType(int nic_activityType) {
        this.nic_activityType = nic_activityType;
    }
}
