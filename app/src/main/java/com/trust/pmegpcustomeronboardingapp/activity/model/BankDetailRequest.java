package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class BankDetailRequest {


    @SerializedName("bankListId")
    int bankListId;
    @SerializedName("CityName")
    String cityName;


    public BankDetailRequest(int bankListId, String cityName) {
        this.bankListId = bankListId;
        this.cityName = cityName;
    }

    public BankDetailRequest() {
    }

    public int getBankListId() {
        return bankListId;
    }

    public void setBankListId(int bankListId) {
        this.bankListId = bankListId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
