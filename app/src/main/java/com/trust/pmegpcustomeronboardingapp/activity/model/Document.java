package com.trust.pmegpcustomeronboardingapp.activity.model;

public class Document {

    private int srNo;
    private String fileName;

    public Document(int srNo, String fileName) {
        this.srNo = srNo;
        this.fileName = fileName;
    }

    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
