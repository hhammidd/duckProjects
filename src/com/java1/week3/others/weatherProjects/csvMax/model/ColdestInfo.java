package com.java1.week3.others.weatherProjects.csvMax.model;

public class ColdestInfo {
    private double coldestTemp;
    private String coldestHour;
    private String timeOfDay;

    public ColdestInfo() {
    }

    public ColdestInfo(double coldestTemp, String coldestHour, String timeOfDay) {
        this.coldestTemp = coldestTemp;
        this.coldestHour = coldestHour;
        this.timeOfDay = timeOfDay;
    }

    public double getColdestTemp() {
        return coldestTemp;
    }

    public void setColdestTemp(double coldestTemp) {
        this.coldestTemp = coldestTemp;
    }

    public String getColdestHour() {
        return coldestHour;
    }

    public void setColdestHour(String coldestHour) {
        this.coldestHour = coldestHour;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    @Override
    public String toString() {
        return "ColdestInfo{" +
                "coldestTemp=" + coldestTemp +
                ", coldestHour='" + coldestHour + '\'' +
                ", timeOfDay='" + timeOfDay + '\'' +
                '}';
    }
}
