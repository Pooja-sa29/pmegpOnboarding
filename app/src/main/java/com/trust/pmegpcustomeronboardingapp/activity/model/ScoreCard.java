package com.trust.pmegpcustomeronboardingapp.activity.model;

import java.util.List;

public class ScoreCard {

        private boolean status;
        private Applicant applicant;
        private List<ScoreParameter> scoreParameters;
        private List<ScoreParameter> scoreParameterList;
        private List<ScoreParameter> scoreCategoryList;
        private List<ScoreCardDetail> scoreCardDetails;

        // Getters and Setters

        public static class Applicant {
            private String ApplName;
            private String ApplCode;
            private int IsFinalSub;
            private int SchemeWrkFlowID;
            private String State_Code;
            private String State_Name;

            // Getters and Setters
        }

        public static class ScoreParameter {
            private int ScrParamID;
            private String ScrCategory;
            private String ScrParameter;
            private String ScrCriteria;
            private int MaxMarks;
            private boolean IsUpload;
            private boolean IsManual;
            private int SrcCatSeq;
            private int SrcParamSeq;
            private String CreatedOn;
            private String ModifyOn;
            private int Seq;
            private String FileLable;

            // Getters and Setters
        }

        public static class ScoreCardDetail {
            private int ApplScoreDetID;
            private int ApplScoreID;
            private int ApplID;
            private int ScoreParamID;
            private String Remarks;
            private String DocPath;
            private String DocFileName;
            private String CreatedOn;
            private String ModifyOn;
            private boolean IsParamSelect;
            private String ScoreParamValues;
            private int TotMarksSecured;
            private boolean IsDeclrAccept;
            private String ModifiedBy_NodalAgency;
            private String IsScoreVerified;
            private int schemeWrkFlowID;

            // Getters and Setters
        }

}
