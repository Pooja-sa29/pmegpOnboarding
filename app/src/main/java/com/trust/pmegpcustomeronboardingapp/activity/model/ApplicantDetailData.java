package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApplicantDetailData {

    @SerializedName("ApplID")
    private int ApplID;
    @SerializedName("ApplCode")
    private String ApplCode;
    @SerializedName("AadharNo")
    private String AadharNo;
    @SerializedName("EIDNo")
    private String EIDNo;
    @SerializedName("ApplTitle")
    private String ApplTitle;
    @SerializedName("ApplName")
    private String ApplName;
    @SerializedName("AgencyID")
    private int AgencyID;

    @SerializedName("AgencyCode")
    private String AgencyCode;
    @SerializedName("StateID")
    private int StateID;
    @SerializedName("DistID")
    private int DistID;
    @SerializedName("AgencyOffID")
    private int AgencyOffID;
    @SerializedName("LegalType")
    private String LegalType;
    @SerializedName("Gender")
    private String Gender;
    @SerializedName("DateofBirth")
    private String DateofBirth;
    @SerializedName("Age")
    private int Age;
    @SerializedName("SocialCatID")
    private String SocialCatID;
    @SerializedName("SpecialCatID")
    private String SpecialCatID;
    @SerializedName("QualID")
    private String QualID;

    @SerializedName("QualDesc")
    private String QualDesc;
    @SerializedName("ComnAddress")
    private String ComnAddress;
    @SerializedName("ComnTaluka")
    private String ComnTaluka;
    @SerializedName("ComnDistrict")
    private String ComnDistrict;
    @SerializedName("ComnPin")
    private String ComnPin;
    @SerializedName("MobileNo1")
    private String MobileNo1;
    @SerializedName("MobileNo2")
    private String MobileNo2;
    @SerializedName("eMail")
    private String eMail;
    @SerializedName("PANNo")
    private String PANNo;
    @SerializedName("UnitLocation")
    private String UnitLocation;
    @SerializedName("UnitAddress")
    private String UnitAddress;
    @SerializedName("UnitTaluka")
    private String UnitTaluka;
    @SerializedName("UnitDistrict")
    private String UnitDistrict;
    @SerializedName("UnitPin")
    private String UnitPin;
    @SerializedName("UnitActivityType")
    private String UnitActivityType;
    @SerializedName("UnitActivityName")
    private String UnitActivityName;
    @SerializedName("ProdDescr")
    private String ProdDescr;
    @SerializedName("IsEDPTraining")
    private boolean IsEDPTraining;
    @SerializedName("EDPTrainingInst")
    private String EDPTrainingInst;
    @SerializedName("CapitalExpd")
    private double CapitalExpd;
    @SerializedName("WorkingCapital")
    private double WorkingCapital;
    @SerializedName("TotalProjectCost")
    private double TotalProjectCost;
    @SerializedName("Employment")
    private int Employment;
    @SerializedName("FinBankID1")
    private int FinBankID1;
    @SerializedName("FinBank1")
    private String FinBank1;
    @SerializedName("BankIFSC1")
    private String BankIFSC1;
    @SerializedName("BankBranch1")
    private String BankBranch1;
    @SerializedName("BankAddress1")
    private String BankAddress1;
    @SerializedName("BankDist1")
    private String BankDist1;
    @SerializedName("FinBankID2")
    private int FinBankID2;
    @SerializedName("FinBank2")
    private String FinBank2;
    @SerializedName("BankIFSC2")
    private String BankIFSC2;
    @SerializedName("BankBranch2")
    private String BankBranch2;
    @SerializedName("BankAddress2")
    private String BankAddress2;
    @SerializedName("BankDist2")
    private String BankDist2;
    @SerializedName("IsAvailCGTMSE")
    private boolean IsAvailCGTMSE;
    @SerializedName("PMEGPRef")
    private String PMEGPRef;
    @SerializedName("IsDeclrAccept")
    private boolean IsDeclrAccept;
    @SerializedName("FinalSubDate")
    private String FinalSubDate;
    @SerializedName("IsFinalSub")
    private Boolean IsFinalSub;
    @SerializedName("CreatedOn")
    private String CreatedOn;
    @SerializedName("ModifyOn")
    private String ModifyOn;
    @SerializedName("ModifyBy")
    private String ModifyBy;
    @SerializedName("IsAadharVerified")
    private int IsAadharVerified;
    @SerializedName("IsPanVerified")
    private int IsPanVerified;
    @SerializedName("AadharApiData")
    private String AadharApiData;
    @SerializedName("PanApiData")
    private String PanApiData;
    @SerializedName("IsUnitLocationSame")
    private boolean IsUnitLocationSame;
    @SerializedName("SchemeWrkFlowID")
    private int SchemeWrkFlowID;
    @SerializedName("IsAltnBank")
    private boolean IsAltnBank;
    @SerializedName("UserID")
    private String UserID;
    @SerializedName("UserType")
    private String UserType;
    @SerializedName("StateName")
    private String StateName;
    @SerializedName("DistrictName")
    private String DistrictName;
    @SerializedName("SchemeID")
    private int SchemeID;
    @SerializedName("SchemeDetID")
    private String SchemeDetID;
    @SerializedName("isUnderValidation")
    private String isUnderValidation;
    @SerializedName("isUnderVarification")
    private String isUnderVarification;
    @SerializedName("isMMDisbursementByVarification")
    private String isMMDisbursementByVarification;
    @SerializedName("isReferredBackByVarification")
    private String isReferredBackByVarification;
    @SerializedName("isReturnedBackByValidation")
    private String isReturnedBackByValidation;
    @SerializedName("isMMApprovedByValidation")
    private String isMMApprovedByValidation;
    @SerializedName("isRefferedImplementingOrBankByValidation")
    private String isRefferedImplementingOrBankByValidation;
    @SerializedName("isForwardedByImplementingOrBankToVerification")
    private String isForwardedByImplementingOrBankToVerification;
    @SerializedName("IsUnderAlternativeBank")
    private boolean IsUnderAlternativeBank;
    @SerializedName("IsAltBankRejected")
    private boolean IsAltBankRejected;
    @SerializedName("UnitActivityName2")
    private String UnitActivityName2;
    @SerializedName("ProdDescr2")
    private String ProdDescr2;
    @SerializedName("UnitActivityName3")
    private String UnitActivityName3;
    @SerializedName("ProdDescr3")
    private String ProdDescr3;
    @SerializedName("isCharAppliAccepted")
    private boolean isCharAppliAccepted;
    @SerializedName("ComnStateID")
    private int ComnStateID;
    @SerializedName("ComnStateName")
    private String ComnStateName;
    @SerializedName("IsApiHit")
    private String IsApiHit;
    @SerializedName("ApiHitCount")
    private String ApiHitCount;
    @SerializedName("IsApplClose")
    private String IsApplClose;
    @SerializedName("MaskAadharNo")
    private String MaskAadharNo;
    @SerializedName("State_Code")
    private String State_Code;
    @SerializedName("State_Name")
    private String State_Name;
    @SerializedName("lgdCode")
    private String lgdCode;
    @SerializedName("isPhyReverified")
    private String isPhyReverified;
    @SerializedName("IsApplUpdForRet")
    private String IsApplUpdForRet;
    @SerializedName("TrainingMode")
    private boolean TrainingMode;
    @SerializedName("isReturnedByBankAndForwadedByVar")
    private String isReturnedByBankAndForwadedByVar;
    @SerializedName("isReturnedByValAndForwadedByVar")
    private String isReturnedByValAndForwadedByVar;
    @SerializedName("Village_Name")
    private String Village_Name;
    @SerializedName("lgdCodeId")
    private int lgdCodeId;
    @SerializedName("IsGenerateChallan")
    private boolean IsGenerateChallan;
    @SerializedName("IsDPRVerified")
    private boolean IsDPRVerified;
    @SerializedName("t_BuildingDetails")

    private List<Object> t_BuildingDetails;
    @SerializedName("t_DetailsOfSales")
    private List<Object> t_DetailsOfSales;
    @SerializedName("t_MachineryDetails")
    private List<Object> t_MachineryDetails;
    @SerializedName("t_MeansOfFinancing")
    private List<Object> t_MeansOfFinancing;
    @SerializedName("t_PowerEstimateExpenditure")
    private List<Object> t_PowerEstimateExpenditure;
    @SerializedName("t_RawMaterials")
    private List<Object> t_RawMaterials;
    @SerializedName("t_WorkingCapitalDetails")
    private List<Object> t_WorkingCapitalDetails;
    @SerializedName("t_WorkingCapitalEstimate")
    private List<Object> t_WorkingCapitalEstimate;
    @SerializedName("t_SalaryDetails")
    private List<Object> t_SalaryDetails;
    @SerializedName("t_WagesDetails")
    private List<Object> t_WagesDetails;
    @SerializedName("t_DPRDetail")
    private List<Object> t_DPRDetail;

    public int getApplID() {
        return ApplID;
    }

    public void setApplID(int applID) {
        ApplID = applID;
    }

    public String getApplCode() {
        return ApplCode;
    }

    public void setApplCode(String applCode) {
        ApplCode = applCode;
    }

    public String getAadharNo() {
        return AadharNo;
    }

    public void setAadharNo(String aadharNo) {
        AadharNo = aadharNo;
    }

    public String getEIDNo() {
        return EIDNo;
    }

    public void setEIDNo(String EIDNo) {
        this.EIDNo = EIDNo;
    }

    public String getApplTitle() {
        return ApplTitle;
    }

    public void setApplTitle(String applTitle) {
        ApplTitle = applTitle;
    }

    public String getApplName() {
        return ApplName;
    }

    public void setApplName(String applName) {
        ApplName = applName;
    }

    public int getAgencyID() {
        return AgencyID;
    }

    public void setAgencyID(int agencyID) {
        AgencyID = agencyID;
    }

    public String getAgencyCode() {
        return AgencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        AgencyCode = agencyCode;
    }

    public int getStateID() {
        return StateID;
    }

    public void setStateID(int stateID) {
        StateID = stateID;
    }

    public int getDistID() {
        return DistID;
    }

    public void setDistID(int distID) {
        DistID = distID;
    }

    public int getAgencyOffID() {
        return AgencyOffID;
    }

    public void setAgencyOffID(int agencyOffID) {
        AgencyOffID = agencyOffID;
    }

    public String getLegalType() {
        return LegalType;
    }

    public void setLegalType(String legalType) {
        LegalType = legalType;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getDateofBirth() {
        return DateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        DateofBirth = dateofBirth;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getSocialCatID() {
        return SocialCatID;
    }

    public void setSocialCatID(String socialCatID) {
        SocialCatID = socialCatID;
    }

    public String getSpecialCatID() {
        return SpecialCatID;
    }

    public void setSpecialCatID(String specialCatID) {
        SpecialCatID = specialCatID;
    }

    public String getQualID() {
        return QualID;
    }

    public void setQualID(String qualID) {
        QualID = qualID;
    }

    public String getQualDesc() {
        return QualDesc;
    }

    public void setQualDesc(String qualDesc) {
        QualDesc = qualDesc;
    }

    public String getComnAddress() {
        return ComnAddress;
    }

    public void setComnAddress(String comnAddress) {
        ComnAddress = comnAddress;
    }

    public String getComnTaluka() {
        return ComnTaluka;
    }

    public void setComnTaluka(String comnTaluka) {
        ComnTaluka = comnTaluka;
    }

    public String getComnDistrict() {
        return ComnDistrict;
    }

    public void setComnDistrict(String comnDistrict) {
        ComnDistrict = comnDistrict;
    }

    public String getComnPin() {
        return ComnPin;
    }

    public void setComnPin(String comnPin) {
        ComnPin = comnPin;
    }

    public String getMobileNo1() {
        return MobileNo1;
    }

    public void setMobileNo1(String mobileNo1) {
        MobileNo1 = mobileNo1;
    }

    public String getMobileNo2() {
        return MobileNo2;
    }

    public void setMobileNo2(String mobileNo2) {
        MobileNo2 = mobileNo2;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPANNo() {
        return PANNo;
    }

    public void setPANNo(String PANNo) {
        this.PANNo = PANNo;
    }

    public String getUnitLocation() {
        return UnitLocation;
    }

    public void setUnitLocation(String unitLocation) {
        UnitLocation = unitLocation;
    }

    public String getUnitAddress() {
        return UnitAddress;
    }

    public void setUnitAddress(String unitAddress) {
        UnitAddress = unitAddress;
    }

    public String getUnitTaluka() {
        return UnitTaluka;
    }

    public void setUnitTaluka(String unitTaluka) {
        UnitTaluka = unitTaluka;
    }

    public String getUnitDistrict() {
        return UnitDistrict;
    }

    public void setUnitDistrict(String unitDistrict) {
        UnitDistrict = unitDistrict;
    }

    public String getUnitPin() {
        return UnitPin;
    }

    public void setUnitPin(String unitPin) {
        UnitPin = unitPin;
    }

    public String getUnitActivityType() {
        return UnitActivityType;
    }

    public void setUnitActivityType(String unitActivityType) {
        UnitActivityType = unitActivityType;
    }

    public String getUnitActivityName() {
        return UnitActivityName;
    }

    public void setUnitActivityName(String unitActivityName) {
        UnitActivityName = unitActivityName;
    }

    public String getProdDescr() {
        return ProdDescr;
    }

    public void setProdDescr(String prodDescr) {
        ProdDescr = prodDescr;
    }

    public boolean isEDPTraining() {
        return IsEDPTraining;
    }

    public void setEDPTraining(boolean EDPTraining) {
        IsEDPTraining = EDPTraining;
    }

    public String getEDPTrainingInst() {
        return EDPTrainingInst;
    }

    public void setEDPTrainingInst(String EDPTrainingInst) {
        this.EDPTrainingInst = EDPTrainingInst;
    }

    public double getCapitalExpd() {
        return CapitalExpd;
    }

    public void setCapitalExpd(double capitalExpd) {
        CapitalExpd = capitalExpd;
    }

    public double getWorkingCapital() {
        return WorkingCapital;
    }

    public void setWorkingCapital(double workingCapital) {
        WorkingCapital = workingCapital;
    }

    public double getTotalProjectCost() {
        return TotalProjectCost;
    }

    public void setTotalProjectCost(double totalProjectCost) {
        TotalProjectCost = totalProjectCost;
    }

    public int getEmployment() {
        return Employment;
    }

    public void setEmployment(int employment) {
        Employment = employment;
    }

    public int getFinBankID1() {
        return FinBankID1;
    }

    public void setFinBankID1(int finBankID1) {
        FinBankID1 = finBankID1;
    }

    public String getFinBank1() {
        return FinBank1;
    }

    public void setFinBank1(String finBank1) {
        FinBank1 = finBank1;
    }

    public String getBankIFSC1() {
        return BankIFSC1;
    }

    public void setBankIFSC1(String bankIFSC1) {
        BankIFSC1 = bankIFSC1;
    }

    public String getBankBranch1() {
        return BankBranch1;
    }

    public void setBankBranch1(String bankBranch1) {
        BankBranch1 = bankBranch1;
    }

    public String getBankAddress1() {
        return BankAddress1;
    }

    public void setBankAddress1(String bankAddress1) {
        BankAddress1 = bankAddress1;
    }

    public String getBankDist1() {
        return BankDist1;
    }

    public void setBankDist1(String bankDist1) {
        BankDist1 = bankDist1;
    }

    public int getFinBankID2() {
        return FinBankID2;
    }

    public void setFinBankID2(int finBankID2) {
        FinBankID2 = finBankID2;
    }

    public String getFinBank2() {
        return FinBank2;
    }

    public void setFinBank2(String finBank2) {
        FinBank2 = finBank2;
    }

    public String getBankIFSC2() {
        return BankIFSC2;
    }

    public void setBankIFSC2(String bankIFSC2) {
        BankIFSC2 = bankIFSC2;
    }

    public String getBankBranch2() {
        return BankBranch2;
    }

    public void setBankBranch2(String bankBranch2) {
        BankBranch2 = bankBranch2;
    }

    public String getBankAddress2() {
        return BankAddress2;
    }

    public void setBankAddress2(String bankAddress2) {
        BankAddress2 = bankAddress2;
    }

    public String getBankDist2() {
        return BankDist2;
    }

    public void setBankDist2(String bankDist2) {
        BankDist2 = bankDist2;
    }

    public boolean isAvailCGTMSE() {
        return IsAvailCGTMSE;
    }

    public void setAvailCGTMSE(boolean availCGTMSE) {
        IsAvailCGTMSE = availCGTMSE;
    }

    public String getPMEGPRef() {
        return PMEGPRef;
    }

    public void setPMEGPRef(String PMEGPRef) {
        this.PMEGPRef = PMEGPRef;
    }

    public boolean isDeclrAccept() {
        return IsDeclrAccept;
    }

    public void setDeclrAccept(boolean declrAccept) {
        IsDeclrAccept = declrAccept;
    }

    public String getFinalSubDate() {
        return FinalSubDate;
    }

    public void setFinalSubDate(String finalSubDate) {
        FinalSubDate = finalSubDate;
    }

    public Boolean getFinalSub() {
        return IsFinalSub;
    }

    public void setFinalSub(Boolean finalSub) {
        IsFinalSub = finalSub;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(String createdOn) {
        CreatedOn = createdOn;
    }

    public String getModifyOn() {
        return ModifyOn;
    }

    public void setModifyOn(String modifyOn) {
        ModifyOn = modifyOn;
    }

    public String getModifyBy() {
        return ModifyBy;
    }

    public void setModifyBy(String modifyBy) {
        ModifyBy = modifyBy;
    }

    public int getIsAadharVerified() {
        return IsAadharVerified;
    }

    public void setIsAadharVerified(int isAadharVerified) {
        IsAadharVerified = isAadharVerified;
    }

    public int getIsPanVerified() {
        return IsPanVerified;
    }

    public void setIsPanVerified(int isPanVerified) {
        IsPanVerified = isPanVerified;
    }

    public String getAadharApiData() {
        return AadharApiData;
    }

    public void setAadharApiData(String aadharApiData) {
        AadharApiData = aadharApiData;
    }

    public String getPanApiData() {
        return PanApiData;
    }

    public void setPanApiData(String panApiData) {
        PanApiData = panApiData;
    }

    public boolean isUnitLocationSame() {
        return IsUnitLocationSame;
    }

    public void setUnitLocationSame(boolean unitLocationSame) {
        IsUnitLocationSame = unitLocationSame;
    }

    public int getSchemeWrkFlowID() {
        return SchemeWrkFlowID;
    }

    public void setSchemeWrkFlowID(int schemeWrkFlowID) {
        SchemeWrkFlowID = schemeWrkFlowID;
    }

    public boolean isAltnBank() {
        return IsAltnBank;
    }

    public void setAltnBank(boolean altnBank) {
        IsAltnBank = altnBank;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public String getDistrictName() {
        return DistrictName;
    }

    public void setDistrictName(String districtName) {
        DistrictName = districtName;
    }

    public int getSchemeID() {
        return SchemeID;
    }

    public void setSchemeID(int schemeID) {
        SchemeID = schemeID;
    }

    public String getSchemeDetID() {
        return SchemeDetID;
    }

    public void setSchemeDetID(String schemeDetID) {
        SchemeDetID = schemeDetID;
    }

    public String getIsUnderValidation() {
        return isUnderValidation;
    }

    public void setIsUnderValidation(String isUnderValidation) {
        this.isUnderValidation = isUnderValidation;
    }

    public String getIsUnderVarification() {
        return isUnderVarification;
    }

    public void setIsUnderVarification(String isUnderVarification) {
        this.isUnderVarification = isUnderVarification;
    }

    public String getIsMMDisbursementByVarification() {
        return isMMDisbursementByVarification;
    }

    public void setIsMMDisbursementByVarification(String isMMDisbursementByVarification) {
        this.isMMDisbursementByVarification = isMMDisbursementByVarification;
    }

    public String getIsReferredBackByVarification() {
        return isReferredBackByVarification;
    }

    public void setIsReferredBackByVarification(String isReferredBackByVarification) {
        this.isReferredBackByVarification = isReferredBackByVarification;
    }

    public String getIsReturnedBackByValidation() {
        return isReturnedBackByValidation;
    }

    public void setIsReturnedBackByValidation(String isReturnedBackByValidation) {
        this.isReturnedBackByValidation = isReturnedBackByValidation;
    }

    public String getIsMMApprovedByValidation() {
        return isMMApprovedByValidation;
    }

    public void setIsMMApprovedByValidation(String isMMApprovedByValidation) {
        this.isMMApprovedByValidation = isMMApprovedByValidation;
    }

    public String getIsRefferedImplementingOrBankByValidation() {
        return isRefferedImplementingOrBankByValidation;
    }

    public void setIsRefferedImplementingOrBankByValidation(String isRefferedImplementingOrBankByValidation) {
        this.isRefferedImplementingOrBankByValidation = isRefferedImplementingOrBankByValidation;
    }

    public String getIsForwardedByImplementingOrBankToVerification() {
        return isForwardedByImplementingOrBankToVerification;
    }

    public void setIsForwardedByImplementingOrBankToVerification(String isForwardedByImplementingOrBankToVerification) {
        this.isForwardedByImplementingOrBankToVerification = isForwardedByImplementingOrBankToVerification;
    }

    public boolean isUnderAlternativeBank() {
        return IsUnderAlternativeBank;
    }

    public void setUnderAlternativeBank(boolean underAlternativeBank) {
        IsUnderAlternativeBank = underAlternativeBank;
    }

    public boolean isAltBankRejected() {
        return IsAltBankRejected;
    }

    public void setAltBankRejected(boolean altBankRejected) {
        IsAltBankRejected = altBankRejected;
    }

    public String getUnitActivityName2() {
        return UnitActivityName2;
    }

    public void setUnitActivityName2(String unitActivityName2) {
        UnitActivityName2 = unitActivityName2;
    }

    public String getProdDescr2() {
        return ProdDescr2;
    }

    public void setProdDescr2(String prodDescr2) {
        ProdDescr2 = prodDescr2;
    }

    public String getUnitActivityName3() {
        return UnitActivityName3;
    }

    public void setUnitActivityName3(String unitActivityName3) {
        UnitActivityName3 = unitActivityName3;
    }

    public String getProdDescr3() {
        return ProdDescr3;
    }

    public void setProdDescr3(String prodDescr3) {
        ProdDescr3 = prodDescr3;
    }

    public boolean isCharAppliAccepted() {
        return isCharAppliAccepted;
    }

    public void setCharAppliAccepted(boolean charAppliAccepted) {
        isCharAppliAccepted = charAppliAccepted;
    }

    public int getComnStateID() {
        return ComnStateID;
    }

    public void setComnStateID(int comnStateID) {
        ComnStateID = comnStateID;
    }

    public String getComnStateName() {
        return ComnStateName;
    }

    public void setComnStateName(String comnStateName) {
        ComnStateName = comnStateName;
    }

    public String getIsApiHit() {
        return IsApiHit;
    }

    public void setIsApiHit(String isApiHit) {
        IsApiHit = isApiHit;
    }

    public String getApiHitCount() {
        return ApiHitCount;
    }

    public void setApiHitCount(String apiHitCount) {
        ApiHitCount = apiHitCount;
    }

    public String getIsApplClose() {
        return IsApplClose;
    }

    public void setIsApplClose(String isApplClose) {
        IsApplClose = isApplClose;
    }

    public String getMaskAadharNo() {
        return MaskAadharNo;
    }

    public void setMaskAadharNo(String maskAadharNo) {
        MaskAadharNo = maskAadharNo;
    }

    public String getState_Code() {
        return State_Code;
    }

    public void setState_Code(String state_Code) {
        State_Code = state_Code;
    }

    public String getState_Name() {
        return State_Name;
    }

    public void setState_Name(String state_Name) {
        State_Name = state_Name;
    }

    public String getLgdCode() {
        return lgdCode;
    }

    public void setLgdCode(String lgdCode) {
        this.lgdCode = lgdCode;
    }

    public String getIsPhyReverified() {
        return isPhyReverified;
    }

    public void setIsPhyReverified(String isPhyReverified) {
        this.isPhyReverified = isPhyReverified;
    }

    public String getIsApplUpdForRet() {
        return IsApplUpdForRet;
    }

    public void setIsApplUpdForRet(String isApplUpdForRet) {
        IsApplUpdForRet = isApplUpdForRet;
    }

    public boolean isTrainingMode() {
        return TrainingMode;
    }

    public void setTrainingMode(boolean trainingMode) {
        TrainingMode = trainingMode;
    }

    public String getIsReturnedByBankAndForwadedByVar() {
        return isReturnedByBankAndForwadedByVar;
    }

    public void setIsReturnedByBankAndForwadedByVar(String isReturnedByBankAndForwadedByVar) {
        this.isReturnedByBankAndForwadedByVar = isReturnedByBankAndForwadedByVar;
    }

    public String getIsReturnedByValAndForwadedByVar() {
        return isReturnedByValAndForwadedByVar;
    }

    public void setIsReturnedByValAndForwadedByVar(String isReturnedByValAndForwadedByVar) {
        this.isReturnedByValAndForwadedByVar = isReturnedByValAndForwadedByVar;
    }

    public String getVillage_Name() {
        return Village_Name;
    }

    public void setVillage_Name(String village_Name) {
        Village_Name = village_Name;
    }

    public int getLgdCodeId() {
        return lgdCodeId;
    }

    public void setLgdCodeId(int lgdCodeId) {
        this.lgdCodeId = lgdCodeId;
    }

    public boolean isGenerateChallan() {
        return IsGenerateChallan;
    }

    public void setGenerateChallan(boolean generateChallan) {
        IsGenerateChallan = generateChallan;
    }

    public boolean isDPRVerified() {
        return IsDPRVerified;
    }

    public void setDPRVerified(boolean DPRVerified) {
        IsDPRVerified = DPRVerified;
    }

    public List<Object> getT_BuildingDetails() {
        return t_BuildingDetails;
    }

    public void setT_BuildingDetails(List<Object> t_BuildingDetails) {
        this.t_BuildingDetails = t_BuildingDetails;
    }

    public List<Object> getT_DetailsOfSales() {
        return t_DetailsOfSales;
    }

    public void setT_DetailsOfSales(List<Object> t_DetailsOfSales) {
        this.t_DetailsOfSales = t_DetailsOfSales;
    }

    public List<Object> getT_MachineryDetails() {
        return t_MachineryDetails;
    }

    public void setT_MachineryDetails(List<Object> t_MachineryDetails) {
        this.t_MachineryDetails = t_MachineryDetails;
    }

    public List<Object> getT_MeansOfFinancing() {
        return t_MeansOfFinancing;
    }

    public void setT_MeansOfFinancing(List<Object> t_MeansOfFinancing) {
        this.t_MeansOfFinancing = t_MeansOfFinancing;
    }

    public List<Object> getT_PowerEstimateExpenditure() {
        return t_PowerEstimateExpenditure;
    }

    public void setT_PowerEstimateExpenditure(List<Object> t_PowerEstimateExpenditure) {
        this.t_PowerEstimateExpenditure = t_PowerEstimateExpenditure;
    }

    public List<Object> getT_RawMaterials() {
        return t_RawMaterials;
    }

    public void setT_RawMaterials(List<Object> t_RawMaterials) {
        this.t_RawMaterials = t_RawMaterials;
    }

    public List<Object> getT_WorkingCapitalDetails() {
        return t_WorkingCapitalDetails;
    }

    public void setT_WorkingCapitalDetails(List<Object> t_WorkingCapitalDetails) {
        this.t_WorkingCapitalDetails = t_WorkingCapitalDetails;
    }

    public List<Object> getT_WorkingCapitalEstimate() {
        return t_WorkingCapitalEstimate;
    }

    public void setT_WorkingCapitalEstimate(List<Object> t_WorkingCapitalEstimate) {
        this.t_WorkingCapitalEstimate = t_WorkingCapitalEstimate;
    }

    public List<Object> getT_SalaryDetails() {
        return t_SalaryDetails;
    }

    public void setT_SalaryDetails(List<Object> t_SalaryDetails) {
        this.t_SalaryDetails = t_SalaryDetails;
    }

    public List<Object> getT_WagesDetails() {
        return t_WagesDetails;
    }

    public void setT_WagesDetails(List<Object> t_WagesDetails) {
        this.t_WagesDetails = t_WagesDetails;
    }

    public List<Object> getT_DPRDetail() {
        return t_DPRDetail;
    }

    public void setT_DPRDetail(List<Object> t_DPRDetail) {
        this.t_DPRDetail = t_DPRDetail;
    }
}
