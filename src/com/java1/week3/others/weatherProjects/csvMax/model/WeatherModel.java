package com.java1.week3.others.weatherProjects.csvMax.model;

public class WeatherModel {

    private String timeEST;
    private double temperatureF;
    private String dewPointF;
    private String humidity;
    private String seaLevelPress;
    private String visibilityMph;
    private String windDirect;
    private String windSpeed;
    private String gustSpeed;
    private String precipitationIn;
    private String events;
    private String conditions;
    private String windDirDegrees;
    private String dateUtc;

    public WeatherModel() {
    }

    public WeatherModel(String timeEST, double temperatureF, String dewPointF, String humidity, String seaLevelPress, String visibilityMph, String windDirect, String windSpeed, String gustSpeed, String precipitationIn, String events, String conditions, String windDirDegrees, String dateUtc) {
        this.timeEST = timeEST;
        this.temperatureF = temperatureF;
        this.dewPointF = dewPointF;
        this.humidity = humidity;
        this.seaLevelPress = seaLevelPress;
        this.visibilityMph = visibilityMph;
        this.windDirect = windDirect;
        this.windSpeed = windSpeed;
        this.gustSpeed = gustSpeed;
        this.precipitationIn = precipitationIn;
        this.events = events;
        this.conditions = conditions;
        this.windDirDegrees = windDirDegrees;
        this.dateUtc = dateUtc;
    }

    public String getTimeEST() {
        return timeEST;
    }

    public void setTimeEST(String timeEST) {
        this.timeEST = timeEST;
    }

    public double getTemperatureF() {
        return temperatureF;
    }

    public void setTemperatureF(double temperatureF) {
        this.temperatureF = temperatureF;
    }

    public String getDewPointF() {
        return dewPointF;
    }

    public void setDewPointF(String dewPointF) {
        this.dewPointF = dewPointF;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getSeaLevelPress() {
        return seaLevelPress;
    }

    public void setSeaLevelPress(String seaLevelPress) {
        this.seaLevelPress = seaLevelPress;
    }

    public String getVisibilityMph() {
        return visibilityMph;
    }

    public void setVisibilityMph(String visibilityMph) {
        this.visibilityMph = visibilityMph;
    }

    public String getWindDirect() {
        return windDirect;
    }

    public void setWindDirect(String windDirect) {
        this.windDirect = windDirect;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getGustSpeed() {
        return gustSpeed;
    }

    public void setGustSpeed(String gustSpeed) {
        this.gustSpeed = gustSpeed;
    }

    public String getPrecipitationIn() {
        return precipitationIn;
    }

    public void setPrecipitationIn(String precipitationIn) {
        this.precipitationIn = precipitationIn;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getWindDirDegrees() {
        return windDirDegrees;
    }

    public void setWindDirDegrees(String windDirDegrees) {
        this.windDirDegrees = windDirDegrees;
    }

    public String getDateUtc() {
        return dateUtc;
    }

    public void setDateUtc(String dateUtc) {
        this.dateUtc = dateUtc;
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "timeEST='" + timeEST + '\'' +
                ", temperatureF=" + temperatureF +
                ", dewPointF='" + dewPointF + '\'' +
                ", humidity='" + humidity + '\'' +
                ", seaLevelPress='" + seaLevelPress + '\'' +
                ", visibilityMph='" + visibilityMph + '\'' +
                ", windDirect='" + windDirect + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", gustSpeed='" + gustSpeed + '\'' +
                ", precipitationIn='" + precipitationIn + '\'' +
                ", events='" + events + '\'' +
                ", conditions='" + conditions + '\'' +
                ", windDirDegrees='" + windDirDegrees + '\'' +
                ", dateUtc='" + dateUtc + '\'' +
                '}';
    }
}
