package com.trust.pmegpcustomeronboardingapp.activity.model;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ScoreCard {

    @SerializedName("status")
    private boolean status;
    @SerializedName("applicant")
    private Applicant applicant;
    @SerializedName("scoreParameters")
    private List<ScoreParameter> scoreParameters;
    @SerializedName("scoreParameterList")
    private List<ScoreParameter> scoreParameterList;
    @SerializedName("scoreCategoryList")
    private List<ScoreParameter> scoreCategoryList;
    @SerializedName("scoreCardDetails")
    private List<ScoreCardDetail> scoreCardDetails;

    @SerializedName("maximumMarks")
    private String maximumMarks;
    @SerializedName("marksSecured")
    private String marksSecured;
    @SerializedName("isDeclrAccept")
    private String isDeclrAccept;


    // Getters and Setters


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public List<ScoreParameter> getScoreParameters() {
        return scoreParameters;
    }

    public void setScoreParameters(List<ScoreParameter> scoreParameters) {
        this.scoreParameters = scoreParameters;
    }

    public List<ScoreParameter> getScoreParameterList() {
        return scoreParameterList;
    }

    public void setScoreParameterList(List<ScoreParameter> scoreParameterList) {
        this.scoreParameterList = scoreParameterList;
    }

    public List<ScoreParameter> getScoreCategoryList() {
        return scoreCategoryList;
    }

    public void setScoreCategoryList(List<ScoreParameter> scoreCategoryList) {
        this.scoreCategoryList = scoreCategoryList;
    }

    public List<ScoreCardDetail> getScoreCardDetails() {
        return scoreCardDetails;
    }

    public String getMaximumMarks() {
        return maximumMarks;
    }

    public void setMaximumMarks(String maximumMarks) {
        this.maximumMarks = maximumMarks;
    }

    public String getMarksSecured() {
        return marksSecured;
    }

    public void setMarksSecured(String marksSecured) {
        this.marksSecured = marksSecured;
    }

    public String getIsDeclrAccept() {
        return isDeclrAccept;
    }

    public void setIsDeclrAccept(String isDeclrAccept) {
        this.isDeclrAccept = isDeclrAccept;
    }

    public void setScoreCardDetails(List<ScoreCardDetail> scoreCardDetails) {
        this.scoreCardDetails = scoreCardDetails;


    }

    public static class Applicant {
        @SerializedName("ApplName")
        private String ApplName;
        @SerializedName("ApplCode")
        private String ApplCode;
        @SerializedName("IsFinalSub")
        private int IsFinalSub;
        @SerializedName("SchemeWrkFlowID")
        private int SchemeWrkFlowID;
        @SerializedName("State_Code")
        private String State_Code;
        @SerializedName("State_Name")
        private String State_Name;

        // Getters and Setters

        public String getApplName() {
            return ApplName;
        }

        public void setApplName(String applName) {
            ApplName = applName;
        }

        public String getApplCode() {
            return ApplCode;
        }

        public void setApplCode(String applCode) {
            ApplCode = applCode;
        }

        public int getIsFinalSub() {
            return IsFinalSub;
        }

        public void setIsFinalSub(int isFinalSub) {
            IsFinalSub = isFinalSub;
        }

        public int getSchemeWrkFlowID() {
            return SchemeWrkFlowID;
        }

        public void setSchemeWrkFlowID(int schemeWrkFlowID) {
            SchemeWrkFlowID = schemeWrkFlowID;
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
    }

    public static class ScoreParameter {
        @SerializedName("ScrParamID")
        private int ScrParamID;
        @SerializedName("ScrCategory")
        private String ScrCategory;
        @SerializedName("ScrParameter")
        private String ScrParameter;
        @SerializedName("ScrCriteria")
        private String ScrCriteria;
        @SerializedName("MaxMarks")
        private int MaxMarks;
        @SerializedName("IsUpload")
        private boolean IsUpload;
        @SerializedName("IsManual")
        private boolean IsManual;
        @SerializedName("SrcCatSeq")
        private int SrcCatSeq;
        @SerializedName("SrcParamSeq")
        private int SrcParamSeq;
        @SerializedName("CreatedOn")
        private String CreatedOn;
        @SerializedName("ModifyOn")
        private String ModifyOn;
        @SerializedName("Seq")
        private int Seq;
        @SerializedName("FileLable")
        private String FileLable;

        private String uploadedFileName;
        private Uri uploadedFileUri;



        // Getters and Setter

        public Uri getUploadedFileUri() {
            return uploadedFileUri;
        }

        public void setUploadedFileUri(Uri uploadedFileUri) {
            this.uploadedFileUri = uploadedFileUri;
        }

        public int getScrParamID() {
            return ScrParamID;
        }

        public void setScrParamID(int scrParamID) {
            ScrParamID = scrParamID;
        }

        public String getScrCategory() {
            return ScrCategory;
        }

        public void setScrCategory(String scrCategory) {
            ScrCategory = scrCategory;
        }

        public String getScrParameter() {
            return ScrParameter;
        }

        public void setScrParameter(String scrParameter) {
            ScrParameter = scrParameter;
        }

        public String getScrCriteria() {
            return ScrCriteria;
        }

        public void setScrCriteria(String scrCriteria) {
            ScrCriteria = scrCriteria;
        }

        public int getMaxMarks() {
            return MaxMarks;
        }

        public void setMaxMarks(int maxMarks) {
            MaxMarks = maxMarks;
        }

        public boolean isUpload() {
            return IsUpload;
        }

        public String getUploadedFileName() {
            return uploadedFileName;
        }

        public void setUploadedFileName(String uploadedFileName) {
            this.uploadedFileName = uploadedFileName;
        }

        public void setUpload(boolean upload) {
            IsUpload = upload;
        }

        public boolean isManual() {
            return IsManual;
        }

        public void setManual(boolean manual) {
            IsManual = manual;
        }

        public int getSrcCatSeq() {
            return SrcCatSeq;
        }

        public void setSrcCatSeq(int srcCatSeq) {
            SrcCatSeq = srcCatSeq;
        }

        public int getSrcParamSeq() {
            return SrcParamSeq;
        }

        public void setSrcParamSeq(int srcParamSeq) {
            SrcParamSeq = srcParamSeq;
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

        public int getSeq() {
            return Seq;
        }

        public void setSeq(int seq) {
            Seq = seq;
        }

        public String getFileLable() {
            return FileLable;
        }

        public void setFileLable(String fileLable) {
            FileLable = fileLable;
        }
    }

    public static class ScoreCardDetail {

        @SerializedName("ApplScoreDetID")
        private int ApplScoreDetID;
        @SerializedName("ApplScoreID")
        private int ApplScoreID;
        @SerializedName("ApplID")
        private int ApplID;
        @SerializedName("ScoreParamID")
        private int ScoreParamID;
        @SerializedName("Remarks")
        private String Remarks;
        @SerializedName("DocPath")
        private String DocPath;

        @SerializedName("DocFileName")
        private String DocFileName;
        @SerializedName("CreatedOn")
        private String CreatedOn;
        @SerializedName("ModifyOn")
        private String ModifyOn;
        @SerializedName("IsParamSelect")
        private boolean IsParamSelect;
        @SerializedName("ScoreParamValues")
        private String ScoreParamValues;
        @SerializedName("TotMarksSecured")
        private int TotMarksSecured;
        @SerializedName("IsDeclrAccept")
        private boolean IsDeclrAccept;
        @SerializedName("ModifiedBy_NodalAgency")
        private String ModifiedBy_NodalAgency;
        @SerializedName("IsScoreVerified")
        private String IsScoreVerified;
        @SerializedName("schemeWrkFlowID")
        private int schemeWrkFlowID;

        // Getters and Setters

        public int getApplScoreDetID() {
            return ApplScoreDetID;
        }

        public void setApplScoreDetID(int applScoreDetID) {
            ApplScoreDetID = applScoreDetID;
        }

        public int getApplScoreID() {
            return ApplScoreID;
        }

        public void setApplScoreID(int applScoreID) {
            ApplScoreID = applScoreID;
        }

        public int getApplID() {
            return ApplID;
        }

        public void setApplID(int applID) {
            ApplID = applID;
        }

        public int getScoreParamID() {
            return ScoreParamID;
        }

        public void setScoreParamID(int scoreParamID) {
            ScoreParamID = scoreParamID;
        }

        public String getRemarks() {
            return Remarks;
        }

        public void setRemarks(String remarks) {
            Remarks = remarks;
        }

        public String getDocPath() {
            return DocPath;
        }

        public void setDocPath(String docPath) {
            DocPath = docPath;
        }

        public String getDocFileName() {
            return DocFileName;
        }

        public void setDocFileName(String docFileName) {
            DocFileName = docFileName;
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

        public boolean isParamSelect() {
            return IsParamSelect;
        }

        public void setParamSelect(boolean paramSelect) {
            IsParamSelect = paramSelect;
        }

        public String getScoreParamValues() {
            return ScoreParamValues;
        }

        public void setScoreParamValues(String scoreParamValues) {
            ScoreParamValues = scoreParamValues;
        }

        public int getTotMarksSecured() {
            return TotMarksSecured;
        }

        public void setTotMarksSecured(int totMarksSecured) {
            TotMarksSecured = totMarksSecured;
        }

        public boolean isDeclrAccept() {
            return IsDeclrAccept;
        }

        public void setDeclrAccept(boolean declrAccept) {
            IsDeclrAccept = declrAccept;
        }

        public String getModifiedBy_NodalAgency() {
            return ModifiedBy_NodalAgency;
        }

        public void setModifiedBy_NodalAgency(String modifiedBy_NodalAgency) {
            ModifiedBy_NodalAgency = modifiedBy_NodalAgency;
        }

        public String getIsScoreVerified() {
            return IsScoreVerified;
        }

        public void setIsScoreVerified(String isScoreVerified) {
            IsScoreVerified = isScoreVerified;
        }

        public int getSchemeWrkFlowID() {
            return schemeWrkFlowID;
        }

        public void setSchemeWrkFlowID(int schemeWrkFlowID) {
            this.schemeWrkFlowID = schemeWrkFlowID;
        }
    }

}
