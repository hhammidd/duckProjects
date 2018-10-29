package com.java1.week3.others.exportCountry.model;

public class ExporterList {

    private String country;
    private String exports;
    private String value;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getExports() {
        return exports;
    }

    public void setExports(String exports) {
        this.exports = exports;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ExporterList{" +
                "country='" + country + '\'' +
                ", exports='" + exports + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
