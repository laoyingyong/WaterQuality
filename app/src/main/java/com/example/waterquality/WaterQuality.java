package com.example.waterquality;

public class WaterQuality
{
    private String siteName;
    private String dateTime;
    private String pH;
    private String DO;
    private String NH4;
    private String CODMn;
    private String TOC;
    private String level;
    private String attribute;
    private String status;


    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getpH() {
        return pH;
    }

    public void setpH(String pH) {
        this.pH = pH;
    }

    public String getDO() {
        return DO;
    }

    public void setDO(String DO) {
        this.DO = DO;
    }

    public String getNH4() {
        return NH4;
    }

    public void setNH4(String NH4) {
        this.NH4 = NH4;
    }

    public String getCODMn() {
        return CODMn;
    }

    public void setCODMn(String CODMn) {
        this.CODMn = CODMn;
    }

    public String getTOC() {
        return TOC;
    }

    public void setTOC(String TOC) {
        this.TOC = TOC;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
