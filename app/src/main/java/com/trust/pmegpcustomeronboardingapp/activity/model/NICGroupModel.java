package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class NICGroupModel {

    @SerializedName("NicCode")
    private String nic_code;
    @SerializedName("NicDesc")
    private String nic_desc;

    private boolean isChecked = false;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
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
}
