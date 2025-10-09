package com.trust.pmegpcustomeronboardingapp.activity.model;

public class PidDataModel {
    private PidData PidData;
    private String aadhaarNo;

    public PidDataModel(PidData pidData, String aadhaarNo) {
        this.PidData = pidData;
        this.aadhaarNo = aadhaarNo;
    }

    public PidData getPidData() {
        return PidData;
    }

    public void setPidData(PidData pidData) {
        this.PidData = pidData;
    }

    public String getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(String aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public class PidData {
        private CustOpts CustOpts;
        private Data Data;

        public PidData(CustOpts custOpts, Data data) {
            this.CustOpts = custOpts;
            this.Data = data;
        }

        public CustOpts getCustOpts() {
            return CustOpts;
        }

        public void setCustOpts(CustOpts custOpts) {
            this.CustOpts = custOpts;
        }

        public Data getData() {
            return Data;
        }

        public void setData(Data data) {
            this.Data = data;
        }
    }


    public class CustOpts {
        private String txnId;
        private String txnStatus;
        private String responseCode;
        private String faceRdVersionWithEnv;
        private String clientComputeTime;
        private String serverComputeTime;
        private String networkLatencyTime;

        public CustOpts(String txnId, String txnStatus, String responseCode, String faceRdVersionWithEnv,
                        String clientComputeTime, String serverComputeTime, String networkLatencyTime) {
            this.txnId = txnId;
            this.txnStatus = txnStatus;
            this.responseCode = responseCode;
            this.faceRdVersionWithEnv = faceRdVersionWithEnv;
            this.clientComputeTime = clientComputeTime;
            this.serverComputeTime = serverComputeTime;
            this.networkLatencyTime = networkLatencyTime;
        }

        public String getTxnId() { return txnId; }
        public String getTxnStatus() { return txnStatus; }
        public String getResponseCode() { return responseCode; }
        public String getFaceRdVersionWithEnv() { return faceRdVersionWithEnv; }
        public String getClientComputeTime() { return clientComputeTime; }
        public String getServerComputeTime() { return serverComputeTime; }
        public String getNetworkLatencyTime() { return networkLatencyTime; }
    }

    public class Data {
        private String type;
        private String value;

        public Data(String type, String value) {
            this.type = type;
            this.value = value;
        }

        public String getType() { return type; }
        public String getValue() { return value; }
    }

}
