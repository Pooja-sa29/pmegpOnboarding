package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class EDPDetails {

     @SerializedName("Off_Name")
      String off_name;
    @SerializedName("Address")
     String address;
    @SerializedName("District_Name")
     String district;
    @SerializedName("State_Name")
     String state;
    @SerializedName("TEL_NO")
     String contact;
    @SerializedName("Off_Code")
     String off_code;

    public String getOff_name() {
        return off_name;
    }

    public void setOff_name(String off_name) {
        this.off_name = off_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getOff_code() {
        return off_code;
    }

    public void setOff_code(String off_code) {
        this.off_code = off_code;
    }
}
