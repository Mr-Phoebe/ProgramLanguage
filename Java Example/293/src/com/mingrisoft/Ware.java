package com.mingrisoft;


public class Ware {
    private String SID;
    private String sName;
    private String spec;
    private String casing;
    private String unit;
    private String sDate;
    private int amout;
    public String getSID() {
        return SID;
    }
    public void setSID(String sID) {
        SID = sID;
    }
    public String getsName() {
        return sName;
    }
    public void setsName(String sName) {
        this.sName = sName;
    }
    public String getSpec() {
        return spec;
    }
    public void setSpec(String spec) {
        this.spec = spec;
    }
    public String getCasing() {
        return casing;
    }
    public void setCasing(String casing) {
        this.casing = casing;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getsDate() {
        return sDate;
    }
    public void setsDate(String sDate) {
        this.sDate = sDate;
    }
    public int getAmout() {
        return amout;
    }
    public void setAmout(int amout) {
        this.amout = amout;
    }    
}
