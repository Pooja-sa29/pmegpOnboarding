package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

public class ApplicantInfoModel {
    @SerializedName("ApplID")
    private String applID;

    @SerializedName("ApplCode")
    private String applCode;

    @SerializedName("AadharNo")
    private String aadharNo;

    @SerializedName("ApplTitle")
    private int applTitle;

    @SerializedName("ApplName")
    private String applName;

    @SerializedName("AgencyID")
    private String agencyID;

    @SerializedName("AgencyCode")
    private String agencyCode;

    @SerializedName("StateID")
    private String stateID;

    @SerializedName("StateName")
    private String stateName;

    @SerializedName("ComnStateID")
    private String comnStateID;

    @SerializedName("ComnStateName")
    private String comnStateName;

    @SerializedName("DistID")
    private String distID;

    @SerializedName("DistrictName")
    private String districtName;

    @SerializedName("AgencyOffID")
    private String agencyOffID;

    @SerializedName("LegalType")
    private String legalType;

    @SerializedName("Gender")
    private String gender;

    @SerializedName("DateofBirth")
    private String dateOfBirth; // keep as String for simplicity

    @SerializedName("Age")
    private String age;

    @SerializedName("SocialCatID")
    private String socialCatID;

    @SerializedName("SpecialCatID")
    private String specialCatID;

    @SerializedName("QualID")
    private String qualID;

    @SerializedName("QualDesc")
    private String qualDesc;

    @SerializedName("ComnAddress")
    private String comnAddress;

    @SerializedName("ComnTaluka")
    private String comnTaluka;

    @SerializedName("ComnDistrict")
    private String comnDistrict;

    @SerializedName("ComnPin")
    private String comnPin;

    @SerializedName("MobileNo1")
    private String mobileNo1;

    @SerializedName("MobileNo2")
    private String mobileNo2;

    @SerializedName("eMail")
    private String email;

    @SerializedName("PANNo")
    private String panNo;

    @SerializedName("UnitLocation")
    private String unitLocation;

    @SerializedName("UnitAddress")
    private String unitAddress;

    @SerializedName("UnitTaluka")
    private String unitTaluka;

    @SerializedName("Village_Name")
    private String villageName;

    @SerializedName("lgdCodeId")
    private String lgdCodeId;

    @SerializedName("UnitDistrict")
    private String unitDistrict;

    @SerializedName("lgdCode")
    private String lgdCode;

    @SerializedName("UnitPin")
    private String unitPin;

    @SerializedName("UnitActivityTypeId")
    private String unitActivityTypeId;

    @SerializedName("IsEDPTraining")
    private boolean isEDPTraining;

    @SerializedName("IsUnitLocationSame")
    private boolean isUnitLocationSame;

    @SerializedName("EDPTrainingInst")
    private String edpTrainingInst;

    @SerializedName("CapitalExpd")
    private String capitalExpd;

    @SerializedName("WorkingCapital")
    private String workingCapital;

    @SerializedName("TotalProjectCost")
    private String totalProjectCost;

    @SerializedName("Employment")
    private String employment;

    @SerializedName("FinBankID1")
    private String finBankID1;

    @SerializedName("FinBank1")
    private String finBank1;

    @SerializedName("BankIFSC1")
    private String bankIFSC1;

    @SerializedName("BankBranch1")
    private String bankBranch1;

    @SerializedName("BankAddress1")
    private String bankAddress1;

    @SerializedName("BankDist1")
    private String bankDist1;

    @SerializedName("FinBankID2")
    private String finBankID2;

    @SerializedName("FinBank2")
    private String finBank2;

    @SerializedName("BankIFSC2")
    private String bankIFSC2;

    @SerializedName("BankBranch2")
    private String bankBranch2;

    @SerializedName("BankAddress2")
    private String bankAddress2;

    @SerializedName("BankDist2")
    private String bankDist2;

    @SerializedName("IsAvailCGTMSE")
    private boolean isAvailCGTMSE;

    @SerializedName("PMEGPRef")
    private String pmegpRef;

    @SerializedName("IsAadharVerified")
    private int isAadharVerified;

    @SerializedName("IsPanVerified")
    private int isPanVerified;

    @SerializedName("IsDeclrAccept")
    private boolean isDeclrAccept;

    @SerializedName("SchemeID")
    private String schemeID;

    @SerializedName("isCharAppliAccepted")
    private boolean isCharAppliAccepted;

    @SerializedName("State_Code")
    private String stateCode;

    @SerializedName("State_Name")
    private String state_Name;

    public String getApplID() {
        return applID;
    }

    public void setApplID(String applID) {
        this.applID = applID;
    }

    public String getApplCode() {
        return applCode;
    }

    public void setApplCode(String applCode) {
        this.applCode = applCode;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public int getApplTitle() {
        return applTitle;
    }

    public void setApplTitle(int applTitle) {
        this.applTitle = applTitle;
    }

    public String getApplName() {
        return applName;
    }

    public void setApplName(String applName) {
        this.applName = applName;
    }

    public String getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(String agencyID) {
        this.agencyID = agencyID;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public String getStateID() {
        return stateID;
    }

    public void setStateID(String stateID) {
        this.stateID = stateID;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getComnStateID() {
        return comnStateID;
    }

    public void setComnStateID(String comnStateID) {
        this.comnStateID = comnStateID;
    }

    public String getComnStateName() {
        return comnStateName;
    }

    public void setComnStateName(String comnStateName) {
        this.comnStateName = comnStateName;
    }

    public String getDistID() {
        return distID;
    }

    public void setDistID(String distID) {
        this.distID = distID;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getAgencyOffID() {
        return agencyOffID;
    }

    public void setAgencyOffID(String agencyOffID) {
        this.agencyOffID = agencyOffID;
    }

    public String getLegalType() {
        return legalType;
    }

    public void setLegalType(String legalType) {
        this.legalType = legalType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSocialCatID() {
        return socialCatID;
    }

    public void setSocialCatID(String socialCatID) {
        this.socialCatID = socialCatID;
    }

    public String getSpecialCatID() {
        return specialCatID;
    }

    public void setSpecialCatID(String specialCatID) {
        this.specialCatID = specialCatID;
    }

    public String getQualID() {
        return qualID;
    }

    public void setQualID(String qualID) {
        this.qualID = qualID;
    }

    public String getQualDesc() {
        return qualDesc;
    }

    public void setQualDesc(String qualDesc) {
        this.qualDesc = qualDesc;
    }

    public String getComnAddress() {
        return comnAddress;
    }

    public void setComnAddress(String comnAddress) {
        this.comnAddress = comnAddress;
    }

    public String getComnTaluka() {
        return comnTaluka;
    }

    public void setComnTaluka(String comnTaluka) {
        this.comnTaluka = comnTaluka;
    }

    public String getComnDistrict() {
        return comnDistrict;
    }

    public void setComnDistrict(String comnDistrict) {
        this.comnDistrict = comnDistrict;
    }

    public String getComnPin() {
        return comnPin;
    }

    public void setComnPin(String comnPin) {
        this.comnPin = comnPin;
    }

    public String getMobileNo1() {
        return mobileNo1;
    }

    public void setMobileNo1(String mobileNo1) {
        this.mobileNo1 = mobileNo1;
    }

    public String getMobileNo2() {
        return mobileNo2;
    }

    public void setMobileNo2(String mobileNo2) {
        this.mobileNo2 = mobileNo2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getUnitLocation() {
        return unitLocation;
    }

    public void setUnitLocation(String unitLocation) {
        this.unitLocation = unitLocation;
    }

    public String getUnitAddress() {
        return unitAddress;
    }

    public void setUnitAddress(String unitAddress) {
        this.unitAddress = unitAddress;
    }

    public String getUnitTaluka() {
        return unitTaluka;
    }

    public void setUnitTaluka(String unitTaluka) {
        this.unitTaluka = unitTaluka;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getLgdCodeId() {
        return lgdCodeId;
    }

    public void setLgdCodeId(String lgdCodeId) {
        this.lgdCodeId = lgdCodeId;
    }

    public String getUnitDistrict() {
        return unitDistrict;
    }

    public void setUnitDistrict(String unitDistrict) {
        this.unitDistrict = unitDistrict;
    }

    public String getLgdCode() {
        return lgdCode;
    }

    public void setLgdCode(String lgdCode) {
        this.lgdCode = lgdCode;
    }

    public String getUnitPin() {
        return unitPin;
    }

    public void setUnitPin(String unitPin) {
        this.unitPin = unitPin;
    }

    public String getUnitActivityTypeId() {
        return unitActivityTypeId;
    }

    public void setUnitActivityTypeId(String unitActivityTypeId) {
        this.unitActivityTypeId = unitActivityTypeId;
    }

    public boolean isEDPTraining() {
        return isEDPTraining;
    }

    public void setEDPTraining(boolean EDPTraining) {
        isEDPTraining = EDPTraining;
    }

    public boolean isUnitLocationSame() {
        return isUnitLocationSame;
    }

    public void setUnitLocationSame(boolean unitLocationSame) {
        isUnitLocationSame = unitLocationSame;
    }

    public String getEdpTrainingInst() {
        return edpTrainingInst;
    }

    public void setEdpTrainingInst(String edpTrainingInst) {
        this.edpTrainingInst = edpTrainingInst;
    }

    public String getCapitalExpd() {
        return capitalExpd;
    }

    public void setCapitalExpd(String capitalExpd) {
        this.capitalExpd = capitalExpd;
    }

    public String getWorkingCapital() {
        return workingCapital;
    }

    public void setWorkingCapital(String workingCapital) {
        this.workingCapital = workingCapital;
    }

    public String getTotalProjectCost() {
        return totalProjectCost;
    }

    public void setTotalProjectCost(String totalProjectCost) {
        this.totalProjectCost = totalProjectCost;
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public String getFinBankID1() {
        return finBankID1;
    }

    public void setFinBankID1(String finBankID1) {
        this.finBankID1 = finBankID1;
    }

    public String getFinBank1() {
        return finBank1;
    }

    public void setFinBank1(String finBank1) {
        this.finBank1 = finBank1;
    }

    public String getBankIFSC1() {
        return bankIFSC1;
    }

    public void setBankIFSC1(String bankIFSC1) {
        this.bankIFSC1 = bankIFSC1;
    }

    public String getBankBranch1() {
        return bankBranch1;
    }

    public void setBankBranch1(String bankBranch1) {
        this.bankBranch1 = bankBranch1;
    }

    public String getBankAddress1() {
        return bankAddress1;
    }

    public void setBankAddress1(String bankAddress1) {
        this.bankAddress1 = bankAddress1;
    }

    public String getBankDist1() {
        return bankDist1;
    }

    public void setBankDist1(String bankDist1) {
        this.bankDist1 = bankDist1;
    }

    public String getFinBankID2() {
        return finBankID2;
    }

    public void setFinBankID2(String finBankID2) {
        this.finBankID2 = finBankID2;
    }

    public String getFinBank2() {
        return finBank2;
    }

    public void setFinBank2(String finBank2) {
        this.finBank2 = finBank2;
    }

    public String getBankIFSC2() {
        return bankIFSC2;
    }

    public void setBankIFSC2(String bankIFSC2) {
        this.bankIFSC2 = bankIFSC2;
    }

    public String getBankBranch2() {
        return bankBranch2;
    }

    public void setBankBranch2(String bankBranch2) {
        this.bankBranch2 = bankBranch2;
    }

    public String getBankAddress2() {
        return bankAddress2;
    }

    public void setBankAddress2(String bankAddress2) {
        this.bankAddress2 = bankAddress2;
    }

    public String getBankDist2() {
        return bankDist2;
    }

    public void setBankDist2(String bankDist2) {
        this.bankDist2 = bankDist2;
    }

    public boolean isAvailCGTMSE() {
        return isAvailCGTMSE;
    }

    public void setAvailCGTMSE(boolean availCGTMSE) {
        isAvailCGTMSE = availCGTMSE;
    }

    public String getPmegpRef() {
        return pmegpRef;
    }

    public void setPmegpRef(String pmegpRef) {
        this.pmegpRef = pmegpRef;
    }

    public int getIsAadharVerified() {
        return isAadharVerified;
    }

    public void setIsAadharVerified(int isAadharVerified) {
        this.isAadharVerified = isAadharVerified;
    }

    public int getIsPanVerified() {
        return isPanVerified;
    }

    public void setIsPanVerified(int isPanVerified) {
        this.isPanVerified = isPanVerified;
    }

    public boolean isDeclrAccept() {
        return isDeclrAccept;
    }

    public void setDeclrAccept(boolean declrAccept) {
        isDeclrAccept = declrAccept;
    }

    public String getSchemeID() {
        return schemeID;
    }

    public void setSchemeID(String schemeID) {
        this.schemeID = schemeID;
    }

    public boolean isCharAppliAccepted() {
        return isCharAppliAccepted;
    }

    public void setCharAppliAccepted(boolean charAppliAccepted) {
        isCharAppliAccepted = charAppliAccepted;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getState_Name() {
        return state_Name;
    }

    public void setState_Name(String state_Name) {
        this.state_Name = state_Name;
    }
}
