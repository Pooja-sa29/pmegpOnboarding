package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApplicantDataModel {


    @SerializedName("AadharNo")
    private String aadharNo;

    @SerializedName("ApplTitle")
    private String applTitle;

    @SerializedName("ApplName")
    private String applName;

    @SerializedName("AgencyID")
    private int agencyID;

    @SerializedName("AgencyCode")
    private String agencyCode;

    @SerializedName("nodalCode")
    private String nodalCode;

    @SerializedName("StateID")
    private int stateID;

    @SerializedName("DistID")
    private int distID;

    @SerializedName("stateCode")
    private String stateCode;

    @SerializedName("AgencyOffID")
    private int agencyOffID;

    @SerializedName("LegalType")
    private String legalType;

    @SerializedName("Gender")
    private String gender;

    @SerializedName("DateofBirth")
    private String dateofBirth;

    @SerializedName("Age")
    private int age;

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
    private String eMail;

    @SerializedName("PANNo")
    private String panNo;

    @SerializedName("UnitLocation")
    private String unitLocation;

    @SerializedName("UnitAddress")
    private String unitAddress;

    @SerializedName("UnitTaluka")
    private String unitTaluka;

    @SerializedName("UnitDistrict")
    private String unitDistrict;

    @SerializedName("UnitPin")
    private String unitPin;

    @SerializedName("UnitActivityType")
    private String unitActivityType = "";

    @SerializedName("UnitActivityName")
    private String unitActivityName;

    @SerializedName("ProdDescr")
    private String prodDescr;

    @SerializedName("IsEDPTraining")
    private int isEDPTraining;

    @SerializedName("EDPTrainingInst")
    private String edpTrainingInst;

    @SerializedName("CapitalExpd")
    private double capitalExpd;

    @SerializedName("WorkingCapital")
    private double workingCapital;

    @SerializedName("TotalProjectCost")
    private double totalProjectCost;

    @SerializedName("Employment")
    private int employment;

    @SerializedName("FinBankID1")
    private int finBankID1;

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
    private int finBankID2;

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
    private int isAvailCGTMSE;

    @SerializedName("PMEGPRef")
    private String pmegpRef;

    @SerializedName("IsDeclrAccept")
    private int isDeclrAccept;

    @SerializedName("FinalSubDate")
    private String finalSubDate = "";

    @SerializedName("IsFinalSub")
    private Integer isFinalSub = 0;

    @SerializedName("CreatedOn")
    private String createdOn;

    @SerializedName("ModifyOn")
    private String modifyOn = "";

    @SerializedName("ModifyBy")
    private String modifyBy = "";

    @SerializedName("IsAadharVerified")
    private int isAadharVerified;

    @SerializedName("IsPanVerified")
    private int isPanVerified;

    @SerializedName("IsUnitLocationSame")
    private int isUnitLocationSame;

    @SerializedName("SchemeWrkFlowID")
    private int schemeWrkFlowID;

    @SerializedName("IsAltnBank")
    private int isAltnBank;

    @SerializedName("UserType")
    private String userType;

    @SerializedName("StateName")
    private String stateName;

    @SerializedName("DistrictName")
    private String districtName;

    @SerializedName("SchemeID")
    private int schemeID;

    @SerializedName("IsUnderAlternativeBank")
    private int isUnderAlternativeBank;

    @SerializedName("IsAltBankRejected")
    private int isAltBankRejected;

    @SerializedName("UnitActivityName2")
    private String unitActivityName2;

    @SerializedName("ProdDescr2")
    private String prodDescr2;

    @SerializedName("UnitActivityName3")
    private String unitActivityName3;

    @SerializedName("ProdDescr3")
    private String prodDescr3;

    @SerializedName("isCharAppliAccepted")
    private int isCharAppliAccepted;

    @SerializedName("ComnStateID")
    private int comnStateID;

    @SerializedName("ComnStateName")
    private String comnStateName;

    @SerializedName("MaskAadharNo")
    private String maskAadharNo;

    @SerializedName("State_Code")
    private int state_Code;

    @SerializedName("State_Name")
    private String state_Name;

    @SerializedName("lgdCode")
    private int lgdCode;

    @SerializedName("TrainingMode")
    private int trainingMode;

    @SerializedName("Village_Name")
    private String villageName;

    @SerializedName("lgdCodeId")
    private int lgdCodeId;

    @SerializedName("IsGenerateChallan")
    private int isGenerateChallan;

    @SerializedName("IsDPRVerified")
    private int isDPRVerified;

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getApplTitle() {
        return applTitle;
    }

    public void setApplTitle(String applTitle) {
        this.applTitle = applTitle;
    }

    public String getApplName() {
        return applName;
    }

    public void setApplName(String applName) {
        this.applName = applName;
    }

    public int getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(int agencyID) {
        this.agencyID = agencyID;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public String getNodalCode() {
        return nodalCode;
    }

    public void setNodalCode(String nodalCode) {
        this.nodalCode = nodalCode;
    }

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    public int getDistID() {
        return distID;
    }

    public void setDistID(int distID) {
        this.distID = distID;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public int getAgencyOffID() {
        return agencyOffID;
    }

    public void setAgencyOffID(int agencyOffID) {
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

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
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

    public String getUnitDistrict() {
        return unitDistrict;
    }

    public void setUnitDistrict(String unitDistrict) {
        this.unitDistrict = unitDistrict;
    }

    public String getUnitPin() {
        return unitPin;
    }

    public void setUnitPin(String unitPin) {
        this.unitPin = unitPin;
    }

    public String getUnitActivityType() {
        return unitActivityType;
    }

    public void setUnitActivityType(String unitActivityType) {
        this.unitActivityType = unitActivityType;
    }

    public String getUnitActivityName() {
        return unitActivityName;
    }

    public void setUnitActivityName(String unitActivityName) {
        this.unitActivityName = unitActivityName;
    }

    public String getProdDescr() {
        return prodDescr;
    }

    public void setProdDescr(String prodDescr) {
        this.prodDescr = prodDescr;
    }

    public int getIsEDPTraining() {
        return isEDPTraining;
    }

    public void setIsEDPTraining(int isEDPTraining) {
        this.isEDPTraining = isEDPTraining;
    }

    public String getEdpTrainingInst() {
        return edpTrainingInst;
    }

    public void setEdpTrainingInst(String edpTrainingInst) {
        this.edpTrainingInst = edpTrainingInst;
    }

    public double getCapitalExpd() {
        return capitalExpd;
    }

    public void setCapitalExpd(double capitalExpd) {
        this.capitalExpd = capitalExpd;
    }

    public double getWorkingCapital() {
        return workingCapital;
    }

    public void setWorkingCapital(double workingCapital) {
        this.workingCapital = workingCapital;
    }

    public double getTotalProjectCost() {
        return totalProjectCost;
    }

    public void setTotalProjectCost(double totalProjectCost) {
        this.totalProjectCost = totalProjectCost;
    }

    public int getEmployment() {
        return employment;
    }

    public void setEmployment(int employment) {
        this.employment = employment;
    }

    public int getFinBankID1() {
        return finBankID1;
    }

    public void setFinBankID1(int finBankID1) {
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

    public int getFinBankID2() {
        return finBankID2;
    }

    public void setFinBankID2(int finBankID2) {
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

    public int getIsAvailCGTMSE() {
        return isAvailCGTMSE;
    }

    public void setIsAvailCGTMSE(int isAvailCGTMSE) {
        this.isAvailCGTMSE = isAvailCGTMSE;
    }

    public String getPmegpRef() {
        return pmegpRef;
    }

    public void setPmegpRef(String pmegpRef) {
        this.pmegpRef = pmegpRef;
    }

    public int getIsDeclrAccept() {
        return isDeclrAccept;
    }

    public void setIsDeclrAccept(int isDeclrAccept) {
        this.isDeclrAccept = isDeclrAccept;
    }

    public String getFinalSubDate() {
        return finalSubDate;
    }

    public void setFinalSubDate(String finalSubDate) {
        this.finalSubDate = finalSubDate;
    }

    public Integer getIsFinalSub() {
        return isFinalSub;
    }

    public void setIsFinalSub(Integer isFinalSub) {
        this.isFinalSub = isFinalSub;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifyOn() {
        return modifyOn;
    }

    public void setModifyOn(String modifyOn) {
        this.modifyOn = modifyOn;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
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

    public int getIsUnitLocationSame() {
        return isUnitLocationSame;
    }

    public void setIsUnitLocationSame(int isUnitLocationSame) {
        this.isUnitLocationSame = isUnitLocationSame;
    }

    public int getSchemeWrkFlowID() {
        return schemeWrkFlowID;
    }

    public void setSchemeWrkFlowID(int schemeWrkFlowID) {
        this.schemeWrkFlowID = schemeWrkFlowID;
    }

    public int getIsAltnBank() {
        return isAltnBank;
    }

    public void setIsAltnBank(int isAltnBank) {
        this.isAltnBank = isAltnBank;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public int getSchemeID() {
        return schemeID;
    }

    public void setSchemeID(int schemeID) {
        this.schemeID = schemeID;
    }

    public int getIsUnderAlternativeBank() {
        return isUnderAlternativeBank;
    }

    public void setIsUnderAlternativeBank(int isUnderAlternativeBank) {
        this.isUnderAlternativeBank = isUnderAlternativeBank;
    }

    public int getIsAltBankRejected() {
        return isAltBankRejected;
    }

    public void setIsAltBankRejected(int isAltBankRejected) {
        this.isAltBankRejected = isAltBankRejected;
    }

    public String getUnitActivityName2() {
        return unitActivityName2;
    }

    public void setUnitActivityName2(String unitActivityName2) {
        this.unitActivityName2 = unitActivityName2;
    }

    public String getProdDescr2() {
        return prodDescr2;
    }

    public void setProdDescr2(String prodDescr2) {
        this.prodDescr2 = prodDescr2;
    }

    public String getUnitActivityName3() {
        return unitActivityName3;
    }

    public void setUnitActivityName3(String unitActivityName3) {
        this.unitActivityName3 = unitActivityName3;
    }

    public String getProdDescr3() {
        return prodDescr3;
    }

    public void setProdDescr3(String prodDescr3) {
        this.prodDescr3 = prodDescr3;
    }

    public int getIsCharAppliAccepted() {
        return isCharAppliAccepted;
    }

    public void setIsCharAppliAccepted(int isCharAppliAccepted) {
        this.isCharAppliAccepted = isCharAppliAccepted;
    }

    public int getComnStateID() {
        return comnStateID;
    }

    public void setComnStateID(int comnStateID) {
        this.comnStateID = comnStateID;
    }

    public String getComnStateName() {
        return comnStateName;
    }

    public void setComnStateName(String comnStateName) {
        this.comnStateName = comnStateName;
    }

    public String getMaskAadharNo() {
        return maskAadharNo;
    }

    public void setMaskAadharNo(String maskAadharNo) {
        this.maskAadharNo = maskAadharNo;
    }

    public int getState_Code() {
        return state_Code;
    }

    public void setState_Code(int state_Code) {
        this.state_Code = state_Code;
    }

    public String getState_Name() {
        return state_Name;
    }

    public void setState_Name(String state_Name) {
        this.state_Name = state_Name;
    }

    public int getLgdCode() {
        return lgdCode;
    }

    public void setLgdCode(int lgdCode) {
        this.lgdCode = lgdCode;
    }

    public int getTrainingMode() {
        return trainingMode;
    }

    public void setTrainingMode(int trainingMode) {
        this.trainingMode = trainingMode;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public int getLgdCodeId() {
        return lgdCodeId;
    }

    public void setLgdCodeId(int lgdCodeId) {
        this.lgdCodeId = lgdCodeId;
    }

    public int getIsGenerateChallan() {
        return isGenerateChallan;
    }

    public void setIsGenerateChallan(int isGenerateChallan) {
        this.isGenerateChallan = isGenerateChallan;
    }

    public int getIsDPRVerified() {
        return isDPRVerified;
    }

    public void setIsDPRVerified(int isDPRVerified) {
        this.isDPRVerified = isDPRVerified;
    }
}