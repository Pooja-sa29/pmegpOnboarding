package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class BankDetailResponce {
    @SerializedName("BranchListId")
    private int BranchListId;
    @SerializedName("BankListId")
    private int BankListId;
    @SerializedName("BankCode")
    private String BankCode;

    @SerializedName("BankName")
    private String bankName;
    @SerializedName("BankShortCode")
    private String BankShortCode;
    @SerializedName("BranchCode")
    private String BranchCode;
    @SerializedName("BranchName")
    private String BranchName;
    @SerializedName("IFSCCode")
    private String IFSCCode;
    @SerializedName("MICRCode")
    private String MICRCode;
    @SerializedName("Address")
    private String Address;
    @SerializedName("CityCode")
    private String CityCode;
    @SerializedName("CityName")
    private String CityName;
    @SerializedName("State")
    private String State;
    @SerializedName("STDCode")
    private String STDCode;
    @SerializedName("Phone")
    private String Phone;

    @SerializedName("StateId")
    private int StateId;


    public int getBankListId() {
        return BankListId;
    }

    public void setBankListId(int bankListId) {
        BankListId = bankListId;
    }

    public String getBranchName() {
        return BranchName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    public String getMICRCode() {
        return MICRCode;
    }

    public void setMICRCode(String MICRCode) {
        this.MICRCode = MICRCode;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }
}
