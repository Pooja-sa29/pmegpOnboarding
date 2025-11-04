package com.trust.pmegpcustomeronboardingapp.activity.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;


@Root(name = "AuthRes", strict = false)
public class FaceDetectionResult {

    @org.simpleframework.xml.Attribute(name = "ret", required = false)
    public String ret;

    @org.simpleframework.xml.Attribute(name = "code", required = false)
    public String code;

    @org.simpleframework.xml.Attribute(name = "info", required = false)
    public String info;

    @org.simpleframework.xml.Attribute(name = "ts", required = false)
    public String timestamp;

    @Attribute(name = "txn", required = false)
    public String txn;
}