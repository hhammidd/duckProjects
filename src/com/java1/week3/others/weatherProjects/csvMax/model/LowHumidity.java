package com.java1.week3.others.weatherProjects.csvMax.model;

public class LowHumidity {
    private double lowHumidity;
    private String timeOfDay;

    public LowHumidity() {
    }

    public LowHumidity(double lowHumidity, String timeOfDay) {
        this.lowHumidity = lowHumidity;
        this.timeOfDay = timeOfDay;
    }

    public double getLowHumidity() {
        return lowHumidity;
    }

    public void setLowHumidity(double lowHumidity) {
        this.lowHumidity = lowHumidity;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    @Override
    public String toString() {
        return "LowHumidity{" +
                "lowHumidity=" + lowHumidity +
                ", timeOfDay='" + timeOfDay + '\'' +
                '}';
    }
}
