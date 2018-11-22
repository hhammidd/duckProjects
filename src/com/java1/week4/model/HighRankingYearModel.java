package com.java1.week4.model;

public class HighRankingYearModel {
    private int year;
    private int ranking;

    public HighRankingYearModel() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "HighRankingYearModel{" +
                "year=" + year +
                ", ranking=" + ranking +
                '}';
    }
}
