package com.trust.pmegpcustomeronboardingapp.activity.model;

import java.util.List;

public class PidDataModel {

    private CustOpts custOpts;
    private Data data;
    private DeviceInfo deviceInfo;
    private String hmac;
    private Resp resp;
    private Skey skey;

    public PidDataModel() {
    }
// Getters and Setters
    // -------------------

    public static class CustOpts {
        private List<Param> param;

        // Getters and Setters
        public List<Param> getParam() { return param; }
        public void setParam(List<Param> param) { this.param = param; }
    }

    public static class Param {
        private String name;
        private String value;

        // Getters and Setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getValue() { return value; }
        public void setValue(String value) { this.value = value; }
    }

    public static class Data {
        private String type;
        private String value;

        // Getters and Setters
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getValue() { return value; }
        public void setValue(String value) { this.value = value; }
    }

    public static class DeviceInfo {
        private String dc;
        private String dpId;
        private String mc;
        private String mi;
        private String rdsId;
        private String rdsVer;
        private AdditionalInfo additionalInfo;

        // Getters and Setters
        public String getDc() { return dc; }
        public void setDc(String dc) { this.dc = dc; }

        public String getDpId() { return dpId; }
        public void setDpId(String dpId) { this.dpId = dpId; }

        public String getMc() { return mc; }
        public void setMc(String mc) { this.mc = mc; }

        public String getMi() { return mi; }
        public void setMi(String mi) { this.mi = mi; }

        public String getRdsId() { return rdsId; }
        public void setRdsId(String rdsId) { this.rdsId = rdsId; }

        public String getRdsVer() { return rdsVer; }
        public void setRdsVer(String rdsVer) { this.rdsVer = rdsVer; }

        public AdditionalInfo getAdditionalInfo() { return additionalInfo; }
        public void setAdditionalInfo(AdditionalInfo additionalInfo) { this.additionalInfo = additionalInfo; }

        public static class AdditionalInfo {
            // Empty for now, as <Additional_Info/> has no content
        }
    }

    public static class Resp {
        private int errCode;
        private int fCount;
        private int fType;
        private int iCount;
        private int iType;
        private int nmPoints;
        private int pCount;
        private int pType;
        private int qScore;

        // Getters and Setters
        public int getErrCode() { return errCode; }
        public void setErrCode(int errCode) { this.errCode = errCode; }

        public int getFCount() { return fCount; }
        public void setFCount(int fCount) { this.fCount = fCount; }

        public int getFType() { return fType; }
        public void setFType(int fType) { this.fType = fType; }

        public int getICount() { return iCount; }
        public void setICount(int iCount) { this.iCount = iCount; }

        public int getIType() { return iType; }
        public void setIType(int iType) { this.iType = iType; }

        public int getNmPoints() { return nmPoints; }
        public void setNmPoints(int nmPoints) { this.nmPoints = nmPoints; }

        public int getPCount() { return pCount; }
        public void setPCount(int pCount) { this.pCount = pCount; }

        public int getPType() { return pType; }
        public void setPType(int pType) { this.pType = pType; }

        public int getQScore() { return qScore; }
        public void setQScore(int qScore) { this.qScore = qScore; }
    }

    public static class Skey {
        private String ci;
        private String value;

        // Getters and Setters
        public String getCi() { return ci; }
        public void setCi(String ci) { this.ci = ci; }

        public String getValue() { return value; }
        public void setValue(String value) { this.value = value; }
    }

    // Getters and Setters for main class
    public CustOpts getCustOpts() { return custOpts; }
    public void setCustOpts(CustOpts custOpts) { this.custOpts = custOpts; }

    public Data getData() { return data; }
    public void setData(Data data) { this.data = data; }

    public DeviceInfo getDeviceInfo() { return deviceInfo; }
    public void setDeviceInfo(DeviceInfo deviceInfo) { this.deviceInfo = deviceInfo; }

    public String getHmac() { return hmac; }
    public void setHmac(String hmac) { this.hmac = hmac; }

    public Resp getResp() { return resp; }
    public void setResp(Resp resp) { this.resp = resp; }

    public Skey getSkey() { return skey; }
    public void setSkey(Skey skey) { this.skey = skey; }
}
