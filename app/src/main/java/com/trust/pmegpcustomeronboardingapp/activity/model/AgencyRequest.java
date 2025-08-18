package com.trust.pmegpcustomeronboardingapp.activity.model;

public class AgencyRequest {
    private int agencyTypeId;
    private int agencyOffStateID;
    private int agencyOffDistId;

    public AgencyRequest(int agencyTypeId, int agencyOffStateID, int agencyOffDistId) {
        this.agencyTypeId = agencyTypeId;
        this.agencyOffStateID = agencyOffStateID;
        this.agencyOffDistId = agencyOffDistId;
    }
}
