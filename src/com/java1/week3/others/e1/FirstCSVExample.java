package com.java1.week3.others.e1;

import com.java1.week3.others.e1.model.Food;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FirstCSVExample {
    public static void main(String[] args) {
    FirstCSVExample f = new FirstCSVExample();
    f.readFood();
    }

    public void readFood() {
        InputStream inputStream = null;
        BufferedReader br = null;

        List<Food> foodList = new ArrayList<Food>();
        Food food = null;
        String csvFile = "foods.csv";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            String line = br.readLine();
            String cvsSplitBy = ",";

            int processedRows = 0;

            while ((line = br.readLine()) != null) {
                // here for canceling "" from csv
                // use comma as separator
                String[] csvFields = line.split(cvsSplitBy);
                food = new Food();

                food.setName(csvFields[0]);
                food.setFavoriteColor(csvFields[1]);
                food.setFavoriteFood(csvFields[2]);

                foodList.add(food);
                // another ways
//                System.out.println("csvFields [code= " + csvFields[4].trim() + " , name=" + csvFields[5].trim() + "]");
                processedRows++;
                System.out.println(foodList);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
