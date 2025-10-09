package com.trust.pmegpcustomeronboardingapp.activity.model;

import java.util.List;

public class DprSaveRequestData {


        private DPRDetail DPRDetail;
        private List<Applicant> Applicant;
        private List<BuildingDetail> BuildingDetails;
        private List<MachineryDetail> MachineryDetails;
        private List<WorkingCapitalDetail> WorkingCapitalDetails;
        private List<MeansOfFinancing> MeansOfFinancing;
        private List<DetailsOfSales> DetailsOfSales;
        private List<RawMaterial> RawMaterials;
        private List<WagesDetail> WagesDetails;
        private List<SalaryDetail> SalaryDetails;
        private List<WorkingCapitalEstimate> WorkingCapitalEstimate;
        private List<PowerEstimateExpenditure> PowerEstimateExpenditure;

        // Getters and Setters


    public DprSaveRequestData.DPRDetail getDPRDetail() {
        return DPRDetail;
    }

    public void setDPRDetail(DprSaveRequestData.DPRDetail DPRDetail) {
        this.DPRDetail = DPRDetail;
    }

    public List<DprSaveRequestData.Applicant> getApplicant() {
        return Applicant;
    }

    public void setApplicant(List<DprSaveRequestData.Applicant> applicant) {
        Applicant = applicant;
    }

    public List<BuildingDetail> getBuildingDetails() {
        return BuildingDetails;
    }

    public void setBuildingDetails(List<BuildingDetail> buildingDetails) {
        BuildingDetails = buildingDetails;
    }

    public List<MachineryDetail> getMachineryDetails() {
        return MachineryDetails;
    }

    public void setMachineryDetails(List<MachineryDetail> machineryDetails) {
        MachineryDetails = machineryDetails;
    }

    public List<WorkingCapitalDetail> getWorkingCapitalDetails() {
        return WorkingCapitalDetails;
    }

    public void setWorkingCapitalDetails(List<WorkingCapitalDetail> workingCapitalDetails) {
        WorkingCapitalDetails = workingCapitalDetails;
    }

    public List<DprSaveRequestData.MeansOfFinancing> getMeansOfFinancing() {
        return MeansOfFinancing;
    }

    public void setMeansOfFinancing(List<DprSaveRequestData.MeansOfFinancing> meansOfFinancing) {
        MeansOfFinancing = meansOfFinancing;
    }

    public List<DprSaveRequestData.DetailsOfSales> getDetailsOfSales() {
        return DetailsOfSales;
    }

    public void setDetailsOfSales(List<DprSaveRequestData.DetailsOfSales> detailsOfSales) {
        DetailsOfSales = detailsOfSales;
    }

    public List<RawMaterial> getRawMaterials() {
        return RawMaterials;
    }

    public void setRawMaterials(List<RawMaterial> rawMaterials) {
        RawMaterials = rawMaterials;
    }

    public List<WagesDetail> getWagesDetails() {
        return WagesDetails;
    }

    public void setWagesDetails(List<WagesDetail> wagesDetails) {
        WagesDetails = wagesDetails;
    }

    public List<SalaryDetail> getSalaryDetails() {
        return SalaryDetails;
    }

    public void setSalaryDetails(List<SalaryDetail> salaryDetails) {
        SalaryDetails = salaryDetails;
    }

    public List<DprSaveRequestData.WorkingCapitalEstimate> getWorkingCapitalEstimate() {
        return WorkingCapitalEstimate;
    }

    public void setWorkingCapitalEstimate(List<DprSaveRequestData.WorkingCapitalEstimate> workingCapitalEstimate) {
        WorkingCapitalEstimate = workingCapitalEstimate;
    }

    public List<DprSaveRequestData.PowerEstimateExpenditure> getPowerEstimateExpenditure() {
        return PowerEstimateExpenditure;
    }

    public void setPowerEstimateExpenditure(List<DprSaveRequestData.PowerEstimateExpenditure> powerEstimateExpenditure) {
        PowerEstimateExpenditure = powerEstimateExpenditure;
    }

    public static class DPRDetail {
            private int ApplID;
            private String ApplCode;
            private String OnBuilding;
            private String OnMachinery;
            private String Land;
            private String PowerRequirement;
            private String RateOfInterest;
            private String Introduction;
            private String AboutBeneficiary;
            private String CreatedOn;
            private String ModifyOn;
            private String PayBackPeriod;
            private String ProjectImplementationPeriod;
            private String IntroductionOffice;
            private String AboutThePromoter;

            // Getters and Setters

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
    }

        public static class Applicant {
            private int ApplID;
            private String ApplCode;
            private boolean IsDPRVerified;

            // Getters and Setters

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

            public boolean isDPRVerified() {
                return IsDPRVerified;
            }

            public void setDPRVerified(boolean DPRVerified) {
                IsDPRVerified = DPRVerified;
            }
        }

        public static class BuildingDetail {
            private int ApplID;
            private String ApplCode;
            private String Particulars;
            private double Area;
            private double RatePerSqFt;
            private double Amount;
            private String CreatedOn;
            private String ModifyOn;

            // Getters and Setters

            public int getApplID() {
                return ApplID;
            }

            public void setApplID(int applID) {
                ApplID = applID;
            }

            public String getParticulars() {
                return Particulars;
            }

            public void setParticulars(String particulars) {
                Particulars = particulars;
            }

            public String getApplCode() {
                return ApplCode;
            }

            public void setApplCode(String applCode) {
                ApplCode = applCode;
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
        }

        public static class MachineryDetail {
            private int ApplID;
            private String ApplCode;
            private String Particulars;
            private int Quantity;
            private double Rate;
            private double Amount;
            private String CreatedOn;
            private String ModifyOn;

            // Getters and Setters

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
        }

        public static class WorkingCapitalDetail {
            private int ApplID;
            private String ApplCode;
            private String Particulars;
            private double Amount;
            private String CreatedOn;
            private String ModifyOn;

            // Getters and Setters

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
        }

        public static class MeansOfFinancing {
            private int ApplID;
            private String ApplCode;
            private String Particulars;
            private double Percentage;
            private String CreatedOn;
            private String ModifyOn;

            // Getters and Setters

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
        }

        public static class DetailsOfSales {
            private int ApplID;
            private String ApplCode;
            private String Particulars;
            private double RatePerUnit;
            private double Quantity;
            private double Amount;
            private String CreatedOn;
            private String ModifyOn;

            // Getters and Setters

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

            public double getRatePerUnit() {
                return RatePerUnit;
            }

            public void setRatePerUnit(double ratePerUnit) {
                RatePerUnit = ratePerUnit;
            }

            public double getQuantity() {
                return Quantity;
            }

            public void setQuantity(double quantity) {
                Quantity = quantity;
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
        }

        public static class RawMaterial {
            private int ApplID;
            private String ApplCode;
            private String Particulars;
            private double Unit;
            private double RatePerUnit;
            private double RequiredUnit;
            private double Amount;
            private String CreatedOn;
            private String ModifyOn;

            // Getters and Setters

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
        }

        public static class WagesDetail {
            private int ApplID;
            private String ApplCode;
            private String Particulars;
            private int NoOfWorkers;
            private double WagesPerMonth;
            private double Amount;
            private String CreatedOn;
            private String ModifyOn;

            // Getters and Setters

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
        }

        public static class SalaryDetail {
            private int ApplID;
            private String ApplCode;
            private String Particulars;
            private int NoOfStaff;
            private double WagesPerMonth;
            private double Amount;
            private String CreatedOn;
            private String ModifyOn;

            // Getters and Setters

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
        }

        public static class WorkingCapitalEstimate {
            private int ApplID;
            private String ApplCode;
            private String Particulars;
            private int NoOfDays;
            private String CreatedOn;
            private String ModifyOn;

            // Getters and Setters

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
        }

        public static class PowerEstimateExpenditure {
            private int ApplID;
            private String ApplCode;
            private String Particulars;
            private double Cost;
            private double AmountInRs;
            private String CreatedOn;
            private String ModifyOn;

            // Getters and Setters

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
        }
    }


