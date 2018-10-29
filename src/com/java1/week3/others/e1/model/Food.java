package com.java1.week3.others.e1.model;

public class Food {
    private String name;
    private String favoriteFood;
    private String favoriteColor;

    public Food() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", favoriteFood='" + favoriteFood + '\'' +
                ", favoriteColor='" + favoriteColor + '\'' +
                '}';
    }
}
