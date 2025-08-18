package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class SpecialCategory {
    @SerializedName("LKDescription")
    private String lk_desc;

    @SerializedName("LKShortCode")
    private String lk_shortCode;

    public String getLk_desc() {
        return lk_desc;
    }

    public void setLk_desc(String lk_desc) {
        this.lk_desc = lk_desc;
    }

    public String getLk_shortCode() {
        return lk_shortCode;
    }

    public void setLk_shortCode(String lk_shortCode) {
        this.lk_shortCode = lk_shortCode;
    }
}
