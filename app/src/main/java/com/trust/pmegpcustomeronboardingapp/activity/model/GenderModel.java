package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class GenderModel {

    @SerializedName("LKDescription")
    private String lk_desc;

    public String getLk_desc() {
        return lk_desc;
    }

    public void setLk_desc(String lk_desc) {
        this.lk_desc = lk_desc;
    }
}
