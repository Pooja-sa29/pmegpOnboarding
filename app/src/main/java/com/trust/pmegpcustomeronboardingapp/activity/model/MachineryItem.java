package com.trust.pmegpcustomeronboardingapp.activity.model;

public class MachineryItem {

    private String particulars;
    private String area;
    private String rate;
    private String amount;

    public MachineryItem(String particulars, String area, String rate, String amount) {
        this.particulars = particulars;
        this.area = area;
        this.rate = rate;
        this.amount = amount;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
