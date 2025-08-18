package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class BankModel {

    @SerializedName("BankListId")
    private int bankListId;
    @SerializedName("BankName")
    private String bankName;

    @SerializedName("BankCode")
    private String bankCode;

    public int getBankListId() {
        return bankListId;
    }

    public void setBankListId(int bankListId) {
        this.bankListId = bankListId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
}
