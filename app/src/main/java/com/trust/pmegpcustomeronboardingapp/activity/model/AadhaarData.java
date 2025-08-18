package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class AadhaarData {

    @SerializedName("dob")
        private String dob;
    @SerializedName("gender")
        private String gender;
    @SerializedName("name")
        private String name;
    @SerializedName("state")
        private String state;

    @SerializedName("dist")
    private String dist;
    @SerializedName("street")

    private String street;
    @SerializedName("subdist")

    private String subdist;
    @SerializedName("aadhaarNo")

    private String aadhaarNo;
    @SerializedName("pincode")

    private String pincode;
    @SerializedName("landmark")

    private String landmark;
    @SerializedName("loc")

    private String loc;
    @SerializedName("house")

    private String house;
    @SerializedName("ret")

    private String ret;



    public String getDob() { return dob; }
        public void setDob(String dob) { this.dob = dob; }

        public String getGender() { return gender; }
        public void setGender(String gender) { this.gender = gender; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getState() { return state; }
        public void setState(String state) { this.state = state; }

        public String getDist() { return dist; }
        public void setDist(String dist) { this.dist = dist; }

        public String getStreet() { return street; }
        public void setStreet(String street) { this.street = street; }

        public String getSubdist() { return subdist; }
        public void setSubdist(String subdist) { this.subdist = subdist; }

        public String getPincode() { return pincode; }
        public void setPincode(String pincode) { this.pincode = pincode; }

        public String getLandmark() { return landmark; }
        public void setLandmark(String landmark) { this.landmark = landmark; }

        public String getLoc() { return loc; }
        public void setLoc(String loc) { this.loc = loc; }

        public String getHouse() { return house; }
        public void setHouse(String house) { this.house = house; }

        public String getRet() { return ret; }
        public void setRet(String ret) { this.ret = ret; }

}
