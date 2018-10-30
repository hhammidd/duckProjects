package com.java1.week4.model;

public class BabyNames {
    private String name;
    private String gender;
    private String nomBorn;

    public BabyNames() {
    }

    public BabyNames(String name, String gender, String nomBorn) {
        this.name = name;
        this.gender = gender;
        this.nomBorn = nomBorn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNomBorn() {
        return nomBorn;
    }

    public void setNomBorn(String nomBorn) {
        this.nomBorn = nomBorn;
    }

    @Override
    public String toString() {
        return "BabyNames{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", nomBorn='" + nomBorn + '\'' +
                '}';
    }
}
