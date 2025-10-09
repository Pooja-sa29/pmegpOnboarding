package com.trust.pmegpcustomeronboardingapp.activity.model;

import com.google.gson.annotations.SerializedName;
import com.trust.pmegpcustomeronboardingapp.activity.Interface.BaseDprItem;

import java.util.List;

public class DRPMasterData {
    @SerializedName("success")
        private boolean success;
    @SerializedName("data")
    private Data data;

        public boolean isSuccess() { return success; }
        public void setSuccess(boolean success) { this.success = success; }
        public Data getData() { return data; }
        public void setData(Data data) { this.data = data; }



    public static class Data {
            @SerializedName("DPRDetail")
            private DPRDetail DPRDetail;
            @SerializedName("Applicant")
            private Object Applicant;
            @SerializedName("BuildingDetails")
            private List<BuildingDetail> BuildingDetails;
            @SerializedName("MachineryDetails")
            private List<MachineryDetail> MachineryDetails;
            @SerializedName("WorkingCapitalDetails")
            private List<WorkingCapitalDetail> WorkingCapitalDetails;
            @SerializedName("MeansOfFinancing")
            private List<MeansOfFinancing> MeansOfFinancing;
            @SerializedName("DetailsOfSales")
            private List<DetailsOfSale> DetailsOfSales;
            @SerializedName("RawMaterials")
            private List<RawMaterial> RawMaterials;
            @SerializedName("WagesDetails")
            private List<WagesDetail> WagesDetails;
            @SerializedName("SalaryDetails")
            private List<SalaryDetail> SalaryDetails;
            @SerializedName("WorkingCapitalEstimate")
            private List<WorkingCapitalEstimate> WorkingCapitalEstimate;
            @SerializedName("PowerEstimateExpenditure")
            private List<PowerEstimateExpenditure> PowerEstimateExpenditure;

            // Getters and Setters
            public DPRDetail getDPRDetail() { return DPRDetail; }
            public void setDPRDetail(DPRDetail DPRDetail) { this.DPRDetail = DPRDetail; }
            public Object getApplicant() { return Applicant; }
            public void setApplicant(Object applicant) { Applicant = applicant; }
            public List<BuildingDetail> getBuildingDetails() { return BuildingDetails; }
            public void setBuildingDetails(List<BuildingDetail> buildingDetails) { BuildingDetails = buildingDetails; }
            public List<MachineryDetail> getMachineryDetails() { return MachineryDetails; }
            public void setMachineryDetails(List<MachineryDetail> machineryDetails) { MachineryDetails = machineryDetails; }
            public List<WorkingCapitalDetail> getWorkingCapitalDetails() { return WorkingCapitalDetails; }
            public void setWorkingCapitalDetails(List<WorkingCapitalDetail> workingCapitalDetails) { WorkingCapitalDetails = workingCapitalDetails; }
            public List<MeansOfFinancing> getMeansOfFinancing() { return MeansOfFinancing; }
            public void setMeansOfFinancing(List<MeansOfFinancing> meansOfFinancing) { MeansOfFinancing = meansOfFinancing; }
            public List<DetailsOfSale> getDetailsOfSales() { return DetailsOfSales; }
            public void setDetailsOfSales(List<DetailsOfSale> detailsOfSales) { DetailsOfSales = detailsOfSales; }
            public List<RawMaterial> getRawMaterials() { return RawMaterials; }
            public void setRawMaterials(List<RawMaterial> rawMaterials) { RawMaterials = rawMaterials; }
            public List<WagesDetail> getWagesDetails() { return WagesDetails; }
            public void setWagesDetails(List<WagesDetail> wagesDetails) { WagesDetails = wagesDetails; }
            public List<SalaryDetail> getSalaryDetails() { return SalaryDetails; }
            public void setSalaryDetails(List<SalaryDetail> salaryDetails) { SalaryDetails = salaryDetails; }
            public List<WorkingCapitalEstimate> getWorkingCapitalEstimate() { return WorkingCapitalEstimate; }
            public void setWorkingCapitalEstimate(List<WorkingCapitalEstimate> workingCapitalEstimate) { WorkingCapitalEstimate = workingCapitalEstimate; }
            public List<PowerEstimateExpenditure> getPowerEstimateExpenditure() { return PowerEstimateExpenditure; }
            public void setPowerEstimateExpenditure(List<PowerEstimateExpenditure> powerEstimateExpenditure) { PowerEstimateExpenditure = powerEstimateExpenditure; }
        }

        // DPRDetail
        public static class DPRDetail {
            @SerializedName("DPRDetailID")
            private int DPRDetailID;
            @SerializedName("ApplID")
            private int ApplID;
            @SerializedName("ApplCode")
            private String ApplCode;
            @SerializedName("OnBuilding")
            private String OnBuilding;
            @SerializedName("OnMachinery")
            private String OnMachinery;
            @SerializedName("Land")
            private String Land;
            @SerializedName("PowerRequirement")
            private String PowerRequirement;
            @SerializedName("RateOfInterest")
            private String RateOfInterest;
            @SerializedName("Introduction")
            private String Introduction;
            @SerializedName("AboutBeneficiary")
            private String AboutBeneficiary;
            @SerializedName("CreatedOn")
            private String CreatedOn;
            @SerializedName("ModifyOn")
            private String ModifyOn;
            @SerializedName("PayBackPeriod")
            private String PayBackPeriod;
            @SerializedName("ProjectImplementationPeriod")
            private String ProjectImplementationPeriod;
            @SerializedName("IntroductionOffice")
            private String IntroductionOffice;
            @SerializedName("AboutThePromoter")
            private String AboutThePromoter;
            @SerializedName("t_ApplicantData")
            private Object t_ApplicantData;

            // Getters and Setters

            public int getDPRDetailID() {
                return DPRDetailID;
            }

            public void setDPRDetailID(int DPRDetailID) {
                this.DPRDetailID = DPRDetailID;
            }

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

            public String getOnBuilding() {
                return OnBuilding;
            }

            public void setOnBuilding(String onBuilding) {
                OnBuilding = onBuilding;
            }

            public String getOnMachinery() {
                return OnMachinery;
            }

            public void setOnMachinery(String onMachinery) {
                OnMachinery = onMachinery;
            }

            public String getLand() {
                return Land;
            }

            public void setLand(String land) {
                Land = land;
            }

            public String getPowerRequirement() {
                return PowerRequirement;
            }

            public void setPowerRequirement(String powerRequirement) {
                PowerRequirement = powerRequirement;
            }

            public String getRateOfInterest() {
                return RateOfInterest;
            }

            public void setRateOfInterest(String rateOfInterest) {
                RateOfInterest = rateOfInterest;
            }

            public String getIntroduction() {
                return Introduction;
            }

            public void setIntroduction(String introduction) {
                Introduction = introduction;
            }

            public String getAboutBeneficiary() {
                return AboutBeneficiary;
            }

            public void setAboutBeneficiary(String aboutBeneficiary) {
                AboutBeneficiary = aboutBeneficiary;
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

            public String getPayBackPeriod() {
                return PayBackPeriod;
            }

            public void setPayBackPeriod(String payBackPeriod) {
                PayBackPeriod = payBackPeriod;
            }

            public String getProjectImplementationPeriod() {
                return ProjectImplementationPeriod;
            }

            public void setProjectImplementationPeriod(String projectImplementationPeriod) {
                ProjectImplementationPeriod = projectImplementationPeriod;
            }

            public String getIntroductionOffice() {
                return IntroductionOffice;
            }

            public void setIntroductionOffice(String introductionOffice) {
                IntroductionOffice = introductionOffice;
            }

            public String getAboutThePromoter() {
                return AboutThePromoter;
            }

            public void setAboutThePromoter(String aboutThePromoter) {
                AboutThePromoter = aboutThePromoter;
            }

            public Object getT_ApplicantData() {
                return t_ApplicantData;
            }

            public void setT_ApplicantData(Object t_ApplicantData) {
                this.t_ApplicantData = t_ApplicantData;
            }
        }

        // BuildingDetails
        public static class BuildingDetail implements BaseDprItem {
            @SerializedName("BuildingDetailID")
            private int BuildingDetailID;
            @SerializedName("ApplID")
            private int ApplID;
            @SerializedName("ApplCode")
            private String ApplCode;
            @SerializedName("Particulars")
            private String Particulars;
            @SerializedName("Area")
            private double Area;
            @SerializedName("RatePerSqFt")
            private double RatePerSqFt;
            @SerializedName("Amount")
            private double Amount;
            @SerializedName("CreatedOn")
            private String CreatedOn;
            @SerializedName("ModifyOn")
            private String ModifyOn;
            @SerializedName("t_ApplicantData")
            private Object t_ApplicantData;

            public int getBuildingDetailID() {
                return BuildingDetailID;
            }

            public void setBuildingDetailID(int buildingDetailID) {
                BuildingDetailID = buildingDetailID;
            }

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

            public String getParticulars() {
                return Particulars;
            }

            public void setParticulars(String particulars) {
                Particulars = particulars;
            }

            public double getArea() {
                return Area;
            }

            public void setArea(double area) {
                Area = area;
            }

            public double getRatePerSqFt() {
                return RatePerSqFt;
            }

            public void setRatePerSqFt(double ratePerSqFt) {
                RatePerSqFt = ratePerSqFt;
            }

            public double getAmount() {
                return Amount;
            }

            public void setAmount(double amount) {
                Amount = amount;
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

            public Object getT_ApplicantData() {
                return t_ApplicantData;
            }

            public void setT_ApplicantData(Object t_ApplicantData) {
                this.t_ApplicantData = t_ApplicantData;
            }
        }

        // MachineryDetails
        public static class MachineryDetail implements BaseDprItem{
            @SerializedName("MachineryDetailID")
            private int MachineryDetailID;
            @SerializedName("ApplID")
            private int ApplID;
            @SerializedName("ApplCode")
            private String ApplCode;
            @SerializedName("Particulars")
            private String Particulars;
            @SerializedName("Quantity")
            private int Quantity;
            @SerializedName("Rate")
            private double Rate;
            @SerializedName("Amount")
            private double Amount;
            @SerializedName("CreatedOn")
            private String CreatedOn;
            @SerializedName("ModifyOn")
            private String ModifyOn;
            @SerializedName("t_ApplicantData")
            private Object t_ApplicantData;

            public int getMachineryDetailID() {
                return MachineryDetailID;
            }

            public void setMachineryDetailID(int machineryDetailID) {
                MachineryDetailID = machineryDetailID;
            }

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

            public String getParticulars() {
                return Particulars;
            }

            public void setParticulars(String particulars) {
                Particulars = particulars;
            }

            public int getQuantity() {
                return Quantity;
            }

            public void setQuantity(int quantity) {
                Quantity = quantity;
            }

            public double getRate() {
                return Rate;
            }

            public void setRate(double rate) {
                Rate = rate;
            }

            public double getAmount() {
                return Amount;
            }

            public void setAmount(double amount) {
                Amount = amount;
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

            public Object getT_ApplicantData() {
                return t_ApplicantData;
            }

            public void setT_ApplicantData(Object t_ApplicantData) {
                this.t_ApplicantData = t_ApplicantData;
            }
        }

        // WorkingCapitalDetails
        public static class WorkingCapitalDetail implements BaseDprItem{
            @SerializedName("WorkingCapitalID")
            private int WorkingCapitalID;
            @SerializedName("ApplID")
            private int ApplID;
            @SerializedName("ApplCode")
            private String ApplCode;
            @SerializedName("Particulars")
            private String Particulars;
            @SerializedName("Amount")
            private double Amount;
            @SerializedName("CreatedOn")
            private String CreatedOn;
            @SerializedName("ModifyOn")
            private String ModifyOn;
            @SerializedName("t_ApplicantData")
            private Object t_ApplicantData;

            public WorkingCapitalDetail(String particulars, double amount) {
                Particulars = particulars;
                Amount = amount;
            }

            public WorkingCapitalDetail() {
            }

            public int getWorkingCapitalID() {
                return WorkingCapitalID;
            }

            public void setWorkingCapitalID(int workingCapitalID) {
                WorkingCapitalID = workingCapitalID;
            }

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

            public String getParticulars() {
                return Particulars;
            }

            public void setParticulars(String particulars) {
                Particulars = particulars;
            }

            public double getAmount() {
                return Amount;
            }

            public void setAmount(double amount) {
                Amount = amount;
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

            public Object getT_ApplicantData() {
                return t_ApplicantData;
            }

            public void setT_ApplicantData(Object t_ApplicantData) {
                this.t_ApplicantData = t_ApplicantData;
            }
        }

        // MeansOfFinancing
        public static class MeansOfFinancing implements BaseDprItem{
            @SerializedName("MeansOfFinancingID")
            private int MeansOfFinancingID;
            @SerializedName("ApplID")
            private int ApplID;
            @SerializedName("ApplCode")
            private String ApplCode;
            @SerializedName("Particulars")
            private String Particulars;
            @SerializedName("Percentage")
            private double Percentage;
            @SerializedName("CreatedOn")
            private String CreatedOn;
            @SerializedName("ModifyOn")
            private String ModifyOn;
            @SerializedName("t_ApplicantData")
            private Object t_ApplicantData;

            public MeansOfFinancing(String particulars, double percentage) {
                Particulars = particulars;
                Percentage = percentage;
            }

            public MeansOfFinancing() {
            }

            public int getMeansOfFinancingID() {
                return MeansOfFinancingID;
            }

            public void setMeansOfFinancingID(int meansOfFinancingID) {
                MeansOfFinancingID = meansOfFinancingID;
            }

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

            public String getParticulars() {
                return Particulars;
            }

            public void setParticulars(String particulars) {
                Particulars = particulars;
            }

            public double getPercentage() {
                return Percentage;
            }

            public void setPercentage(double percentage) {
                Percentage = percentage;
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

            public Object getT_ApplicantData() {
                return t_ApplicantData;
            }

            public void setT_ApplicantData(Object t_ApplicantData) {
                this.t_ApplicantData = t_ApplicantData;
            }
        }

        // DetailsOfSales
        public static class DetailsOfSale implements BaseDprItem{

            @SerializedName("SalesDetailID")
            private int SalesDetailID;
            @SerializedName("ApplID")
            private int ApplID;
            @SerializedName("ApplCode")
            private String ApplCode;
            @SerializedName("Particulars")
            private String Particulars;
            @SerializedName("RatePerUnit")
            private int RatePerUnit;
            @SerializedName("Quantity")
            private int Quantity;
            @SerializedName("Amount")
            private double Amount;
            @SerializedName("CreatedOn")
            private String CreatedOn;
            @SerializedName("ModifyOn")
            private String ModifyOn;
            @SerializedName("t_ApplicantData")
            private Object t_ApplicantData;

            public DetailsOfSale(String particulars, int ratePerUnit, int quantity, double amount) {
                Particulars = particulars;
                RatePerUnit = ratePerUnit;
                Quantity = quantity;
                Amount = amount;
            }

            public DetailsOfSale() {
            }

            public int getSalesDetailID() {
                return SalesDetailID;
            }

            public void setSalesDetailID(int salesDetailID) {
                SalesDetailID = salesDetailID;
            }

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

            public String getParticulars() {
                return Particulars;
            }

            public void setParticulars(String particulars) {
                Particulars = particulars;
            }

            public int getRatePerUnit() {
                return RatePerUnit;
            }

            public void setRatePerUnit(int ratePerUnit) {
                RatePerUnit = ratePerUnit;
            }

            public int getQuantity() {
                return Quantity;
            }

            public void setQuantity(int quantity) {
                Quantity = quantity;
            }

            public Double getAmount() {
                return Amount;
            }

            public void setAmount(double amount) {
                Amount = amount;
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

            public Object getT_ApplicantData() {
                return t_ApplicantData;
            }

            public void setT_ApplicantData(Object t_ApplicantData) {
                this.t_ApplicantData = t_ApplicantData;
            }
        }

        // RawMaterials
        public static class RawMaterial implements BaseDprItem{
            @SerializedName("RawMaterialID")
            private int RawMaterialID;
            @SerializedName("ApplID")
            private int ApplID;
            @SerializedName("ApplCode")
            private String ApplCode;
            @SerializedName("Particulars")
            private String Particulars;
            @SerializedName("Unit")
            private double Unit;
            @SerializedName("RatePerUnit")
            private double RatePerUnit;
            @SerializedName("RequiredUnit")
            private double RequiredUnit;
            @SerializedName("Amount")
            private double Amount;
            @SerializedName("CreatedOn")
            private String CreatedOn;
            @SerializedName("ModifyOn")
            private String ModifyOn;
            @SerializedName("t_ApplicantData")
            private Object t_ApplicantData;

            public RawMaterial(String particulars, double unit, double ratePerUnit, double requiredUnit, double amount) {
                Particulars = particulars;
                Unit = unit;
                RatePerUnit = ratePerUnit;
                RequiredUnit = requiredUnit;
                Amount = amount;
            }

            public RawMaterial() {
            }

            public int getRawMaterialID() {
                return RawMaterialID;
            }

            public void setRawMaterialID(int rawMaterialID) {
                RawMaterialID = rawMaterialID;
            }

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

            public String getParticulars() {
                return Particulars;
            }

            public void setParticulars(String particulars) {
                Particulars = particulars;
            }

            public double getUnit() {
                return Unit;
            }

            public void setUnit(double unit) {
                Unit = unit;
            }

            public double getRatePerUnit() {
                return RatePerUnit;
            }

            public void setRatePerUnit(double ratePerUnit) {
                RatePerUnit = ratePerUnit;
            }

            public double getRequiredUnit() {
                return RequiredUnit;
            }

            public void setRequiredUnit(double requiredUnit) {
                RequiredUnit = requiredUnit;
            }

            public double getAmount() {
                return Amount;
            }

            public void setAmount(double amount) {
                Amount = amount;
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

            public Object getT_ApplicantData() {
                return t_ApplicantData;
            }

            public void setT_ApplicantData(Object t_ApplicantData) {
                this.t_ApplicantData = t_ApplicantData;
            }
        }

        // WagesDetails
        public static class WagesDetail implements BaseDprItem{
            @SerializedName("WagesDetailID")
            private int WagesDetailID;
            @SerializedName("ApplID")
            private int ApplID;
            @SerializedName("ApplCode")
            private String ApplCode;
            @SerializedName("Particulars")
            private String Particulars;
            @SerializedName("NoOfWorkers")
            private int NoOfWorkers;
            @SerializedName("WagesPerMonth")
            private double WagesPerMonth;
            @SerializedName("Amount")
            private double Amount;
            @SerializedName("CreatedOn")
            private String CreatedOn;
            @SerializedName("ModifyOn")
            private String ModifyOn;
            @SerializedName("t_ApplicantData")
            private Object t_ApplicantData;

            public WagesDetail(String particulars, int noOfWorkers, double wagesPerMonth, double amount) {
                Particulars = particulars;
                NoOfWorkers = noOfWorkers;
                WagesPerMonth = wagesPerMonth;
                Amount = amount;
            }

            public WagesDetail() {
            }

            public int getWagesDetailID() {
                return WagesDetailID;
            }

            public void setWagesDetailID(int wagesDetailID) {
                WagesDetailID = wagesDetailID;
            }

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

            public String getParticulars() {
                return Particulars;
            }

            public void setParticulars(String particulars) {
                Particulars = particulars;
            }

            public int getNoOfWorkers() {
                return NoOfWorkers;
            }

            public void setNoOfWorkers(int noOfWorkers) {
                NoOfWorkers = noOfWorkers;
            }

            public double getWagesPerMonth() {
                return WagesPerMonth;
            }

            public void setWagesPerMonth(double wagesPerMonth) {
                WagesPerMonth = wagesPerMonth;
            }

            public double getAmount() {
                return Amount;
            }

            public void setAmount(double amount) {
                Amount = amount;
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

            public Object getT_ApplicantData() {
                return t_ApplicantData;
            }

            public void setT_ApplicantData(Object t_ApplicantData) {
                this.t_ApplicantData = t_ApplicantData;
            }
        }

        // SalaryDetails
        public static class SalaryDetail implements BaseDprItem{
            @SerializedName("SalaryDetailID")
            private int SalaryDetailID;
            @SerializedName("ApplID")
            private int ApplID;
            @SerializedName("ApplCode")
            private String ApplCode;
            @SerializedName("Particulars")
            private String Particulars;
            @SerializedName("NoOfStaff")
            private int NoOfStaff;
            @SerializedName("WagesPerMonth")
            private double WagesPerMonth;
            @SerializedName("Amount")
            private double Amount;
            @SerializedName("CreatedOn")
            private String CreatedOn;
            @SerializedName("ModifyOn")
            private String ModifyOn;
            @SerializedName("t_ApplicantData")
            private Object t_ApplicantData;

            public SalaryDetail(String particulars, int noOfStaff, double wagesPerMonth, double amount) {
                Particulars = particulars;
                NoOfStaff = noOfStaff;
                WagesPerMonth = wagesPerMonth;
                Amount = amount;
            }

            public SalaryDetail() {
            }

            public int getSalaryDetailID() {
                return SalaryDetailID;
            }

            public void setSalaryDetailID(int salaryDetailID) {
                SalaryDetailID = salaryDetailID;
            }

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

            public String getParticulars() {
                return Particulars;
            }

            public void setParticulars(String particulars) {
                Particulars = particulars;
            }

            public int getNoOfStaff() {
                return NoOfStaff;
            }

            public void setNoOfStaff(int noOfStaff) {
                NoOfStaff = noOfStaff;
            }

            public double getWagesPerMonth() {
                return WagesPerMonth;
            }

            public void setWagesPerMonth(double wagesPerMonth) {
                WagesPerMonth = wagesPerMonth;
            }

            public double getAmount() {
                return Amount;
            }

            public void setAmount(double amount) {
                Amount = amount;
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

            public Object getT_ApplicantData() {
                return t_ApplicantData;
            }

            public void setT_ApplicantData(Object t_ApplicantData) {
                this.t_ApplicantData = t_ApplicantData;
            }
        }

        // WorkingCapitalEstimate
        public static class WorkingCapitalEstimate implements BaseDprItem{
            @SerializedName("WorkingCapitalEstimateID")
            private int WorkingCapitalEstimateID;
            @SerializedName("ApplID")
            private int ApplID;
            @SerializedName("ApplCode")
            private String ApplCode;
            @SerializedName("Particulars")
            private String Particulars;
            @SerializedName("NoOfDays")
            private int NoOfDays;
            @SerializedName("CreatedOn")
            private String CreatedOn;
            @SerializedName("ModifyOn")
            private String ModifyOn;
            @SerializedName("t_ApplicantData")
            private Object t_ApplicantData;

            public WorkingCapitalEstimate(String particulars, int noOfDays) {
                Particulars = particulars;
                NoOfDays = noOfDays;
            }

            public WorkingCapitalEstimate() {
            }

            public int getWorkingCapitalEstimateID() {
                return WorkingCapitalEstimateID;
            }

            public void setWorkingCapitalEstimateID(int workingCapitalEstimateID) {
                WorkingCapitalEstimateID = workingCapitalEstimateID;
            }

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

            public String getParticulars() {
                return Particulars;
            }

            public void setParticulars(String particulars) {
                Particulars = particulars;
            }

            public int getNoOfDays() {
                return NoOfDays;
            }

            public void setNoOfDays(int noOfDays) {
                NoOfDays = noOfDays;
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

            public Object getT_ApplicantData() {
                return t_ApplicantData;
            }

            public void setT_ApplicantData(Object t_ApplicantData) {
                this.t_ApplicantData = t_ApplicantData;
            }
        }

        // PowerEstimateExpenditure
        public static class PowerEstimateExpenditure implements BaseDprItem{
            @SerializedName("PowerEstimateID")
            private int PowerEstimateID;
            @SerializedName("ApplID")
            private int ApplID;
            @SerializedName("ApplCode")
            private String ApplCode;
            @SerializedName("Particulars")
            private String Particulars;
            @SerializedName("Cost")
            private double Cost;
            @SerializedName("AmountInRs")
            private double AmountInRs;
            @SerializedName("CreatedOn")
            private String CreatedOn;
            @SerializedName("ModifyOn")
            private String ModifyOn;
            @SerializedName("t_ApplicantData")
            private Object t_ApplicantData;


            public PowerEstimateExpenditure(String particulars, double cost, double amountInRs) {
                Particulars = particulars;
                Cost = cost;
                AmountInRs = amountInRs;
            }

            public PowerEstimateExpenditure() {
            }

            public int getPowerEstimateID() {
                return PowerEstimateID;
            }

            public void setPowerEstimateID(int powerEstimateID) {
                PowerEstimateID = powerEstimateID;
            }

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

            public String getParticulars() {
                return Particulars;
            }

            public void setParticulars(String particulars) {
                Particulars = particulars;
            }

            public double getCost() {
                return Cost;
            }

            public void setCost(double cost) {
                Cost = cost;
            }

            public double getAmountInRs() {
                return AmountInRs;
            }

            public void setAmountInRs(double amountInRs) {
                AmountInRs = amountInRs;
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

            public Object getT_ApplicantData() {
                return t_ApplicantData;
            }

            public void setT_ApplicantData(Object t_ApplicantData) {
                this.t_ApplicantData = t_ApplicantData;
            }
        }

}
