package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DPRUpdateRequest {
    @SerializedName("DPRDetail")
    private DRPMasterData.DPRDetail dprDetail;

    @SerializedName("Applicant")
    private ApplicantDPROnly applicant;

    @SerializedName("BuildingDetails")
    private List<DRPMasterData.BuildingDetail> buildingDetails;

    @SerializedName("MachineryDetails")
    private List<DRPMasterData.MachineryDetail> machineryDetails;

    @SerializedName("RawMaterials")
    private List<DRPMasterData.RawMaterial> rawMaterials;

    @SerializedName("WagesDetails")
    private List<DRPMasterData.WagesDetail> wagesDetails;

    @SerializedName("SalaryDetails")
    private List<DRPMasterData.SalaryDetail> salaryDetails;

    @SerializedName("DetailsOfSales")
    private List<DRPMasterData.DetailsOfSale> detailsOfSales;

    @SerializedName("MeansOfFinancing")
    private List<DRPMasterData.MeansOfFinancing> meansOfFinancing;

    @SerializedName("WorkingCapitalDetails")
    private List<DRPMasterData.WorkingCapitalDetail> workingCapitalDetails;

    @SerializedName("WorkingCapitalEstimate")
    private List<DRPMasterData.WorkingCapitalEstimate> workingCapitalEstimate;

    @SerializedName("PowerEstimateExpenditure")
    private List<DRPMasterData.PowerEstimateExpenditure> powerEstimateExpenditure;

    // --- Getters and setters ---

    public DRPMasterData.DPRDetail getDprDetail() {
        return dprDetail;
    }

    public void setDprDetail(DRPMasterData.DPRDetail dprDetail) {
        this.dprDetail = dprDetail;
    }

    public ApplicantDPROnly getApplicant() {
        return applicant;
    }

    public void setApplicant(ApplicantDPROnly applicant) {
        this.applicant = applicant;
    }

    public List<DRPMasterData.BuildingDetail> getBuildingDetails() {
        return buildingDetails;
    }

    public void setBuildingDetails(List<DRPMasterData.BuildingDetail> buildingDetails) {
        this.buildingDetails = buildingDetails;
    }

    public List<DRPMasterData.MachineryDetail> getMachineryDetails() {
        return machineryDetails;
    }

    public void setMachineryDetails(List<DRPMasterData.MachineryDetail> machineryDetails) {
        this.machineryDetails = machineryDetails;
    }

    public List<DRPMasterData.RawMaterial> getRawMaterials() {
        return rawMaterials;
    }

    public void setRawMaterials(List<DRPMasterData.RawMaterial> rawMaterials) {
        this.rawMaterials = rawMaterials;
    }

    public List<DRPMasterData.WagesDetail> getWagesDetails() {
        return wagesDetails;
    }

    public void setWagesDetails(List<DRPMasterData.WagesDetail> wagesDetails) {
        this.wagesDetails = wagesDetails;
    }

    public List<DRPMasterData.SalaryDetail> getSalaryDetails() {
        return salaryDetails;
    }

    public void setSalaryDetails(List<DRPMasterData.SalaryDetail> salaryDetails) {
        this.salaryDetails = salaryDetails;
    }

    public List<DRPMasterData.DetailsOfSale> getDetailsOfSales() {
        return detailsOfSales;
    }

    public void setDetailsOfSales(List<DRPMasterData.DetailsOfSale> detailsOfSales) {
        this.detailsOfSales = detailsOfSales;
    }

    public List<DRPMasterData.MeansOfFinancing> getMeansOfFinancing() {
        return meansOfFinancing;
    }

    public void setMeansOfFinancing(List<DRPMasterData.MeansOfFinancing> meansOfFinancing) {
        this.meansOfFinancing = meansOfFinancing;
    }

    public List<DRPMasterData.WorkingCapitalDetail> getWorkingCapitalDetails() {
        return workingCapitalDetails;
    }

    public void setWorkingCapitalDetails(List<DRPMasterData.WorkingCapitalDetail> workingCapitalDetails) {
        this.workingCapitalDetails = workingCapitalDetails;
    }

    public List<DRPMasterData.WorkingCapitalEstimate> getWorkingCapitalEstimate() {
        return workingCapitalEstimate;
    }

    public void setWorkingCapitalEstimate(List<DRPMasterData.WorkingCapitalEstimate> workingCapitalEstimate) {
        this.workingCapitalEstimate = workingCapitalEstimate;
    }

    public List<DRPMasterData.PowerEstimateExpenditure> getPowerEstimateExpenditure() {
        return powerEstimateExpenditure;
    }

    public void setPowerEstimateExpenditure(List<DRPMasterData.PowerEstimateExpenditure> powerEstimateExpenditure) {
        this.powerEstimateExpenditure = powerEstimateExpenditure;
    }
}
