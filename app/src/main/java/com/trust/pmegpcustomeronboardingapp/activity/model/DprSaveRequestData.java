package com.trust.pmegpcustomeronboardingapp.activity.model;

import java.util.List;

public class DprSaveRequestData {


        private DRPMasterData.DPRDetail DPRDetail;
        private List<Applicant> Applicant;
        private List<DRPMasterData.BuildingDetail> BuildingDetails;
        private List<DRPMasterData.MachineryDetail> MachineryDetails;
        private List<DRPMasterData.WorkingCapitalDetail> WorkingCapitalDetails;
        private List<DRPMasterData.MeansOfFinancing> MeansOfFinancing;
        private List<DRPMasterData.DetailsOfSale> DetailsOfSales;
        private List<DRPMasterData.RawMaterial> RawMaterials;
        private List<DRPMasterData.WagesDetail> WagesDetails;
        private List<DRPMasterData.SalaryDetail> SalaryDetails;
        private List<DRPMasterData.WorkingCapitalEstimate> WorkingCapitalEstimate;
        private List<DRPMasterData.PowerEstimateExpenditure> PowerEstimateExpenditure;

        // Getters and Setters


    public DRPMasterData.DPRDetail getDPRDetail() {
        return DPRDetail;
    }

    public void setDPRDetail(DRPMasterData.DPRDetail DPRDetail) {
        this.DPRDetail = DPRDetail;
    }

    public List<DprSaveRequestData.Applicant> getApplicant() {
        return Applicant;
    }

    public void setApplicant(List<DprSaveRequestData.Applicant> applicant) {
        Applicant = applicant;
    }

    public List<DRPMasterData.BuildingDetail> getBuildingDetails() {
        return BuildingDetails;
    }

    public void setBuildingDetails(List<DRPMasterData.BuildingDetail> buildingDetails) {
        BuildingDetails = buildingDetails;
    }

    public List<DRPMasterData.MachineryDetail> getMachineryDetails() {
        return MachineryDetails;
    }

    public void setMachineryDetails(List<DRPMasterData.MachineryDetail> machineryDetails) {
        MachineryDetails = machineryDetails;
    }

    public List<DRPMasterData.WorkingCapitalDetail> getWorkingCapitalDetails() {
        return WorkingCapitalDetails;
    }

    public void setWorkingCapitalDetails(List<DRPMasterData.WorkingCapitalDetail> workingCapitalDetails) {
        WorkingCapitalDetails = workingCapitalDetails;
    }

    public List<DRPMasterData.MeansOfFinancing> getMeansOfFinancing() {
        return MeansOfFinancing;
    }

    public void setMeansOfFinancing(List<DRPMasterData.MeansOfFinancing> meansOfFinancing) {
        MeansOfFinancing = meansOfFinancing;
    }

    public List<DRPMasterData.DetailsOfSale> getDetailsOfSales() {
        return DetailsOfSales;
    }

    public void setDetailsOfSales(List<DRPMasterData.DetailsOfSale> detailsOfSales) {
        DetailsOfSales = detailsOfSales;
    }

    public List<DRPMasterData.RawMaterial> getRawMaterials() {
        return RawMaterials;
    }

    public void setRawMaterials(List<DRPMasterData.RawMaterial> rawMaterials) {
        RawMaterials = rawMaterials;
    }

    public List<DRPMasterData.WagesDetail> getWagesDetails() {
        return WagesDetails;
    }

    public void setWagesDetails(List<DRPMasterData.WagesDetail> wagesDetails) {
        WagesDetails = wagesDetails;
    }

    public List<DRPMasterData.SalaryDetail> getSalaryDetails() {
        return SalaryDetails;
    }

    public void setSalaryDetails(List<DRPMasterData.SalaryDetail> salaryDetails) {
        SalaryDetails = salaryDetails;
    }

    public List<DRPMasterData.WorkingCapitalEstimate> getWorkingCapitalEstimate() {
        return WorkingCapitalEstimate;
    }

    public void setWorkingCapitalEstimate(List<DRPMasterData.WorkingCapitalEstimate> workingCapitalEstimate) {
        WorkingCapitalEstimate = workingCapitalEstimate;
    }

    public List<DRPMasterData.PowerEstimateExpenditure> getPowerEstimateExpenditure() {
        return PowerEstimateExpenditure;
    }

    public void setPowerEstimateExpenditure(List<DRPMasterData.PowerEstimateExpenditure> powerEstimateExpenditure) {
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
            private int RatePerUnit;
            private int Quantity;
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


