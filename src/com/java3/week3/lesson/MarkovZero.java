package com.java3.week3.lesson;

import java.util.Random;
//https://github.com/polde-live/duke-java-3/blob/master/src/week3/MarkovZero.java
public class MarkovZero {
    private Random myRandom;
    private String myText;

    public MarkovZero() {
        myRandom = new Random();
    }



    public void setMyRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setMyText(String s) {
        this.myText = s;
    }

    public void setTraining(String s){
        myText = s.trim();
    }

    public String getRandonText(int numChars){
        if (myText == null) return "";

        StringBuilder sb = new StringBuilder();
        for (int k=0; k< numChars; k++){
            int index = myRandom.nextInt(myText.length());
            sb.append(myText.charAt(index));
        }
        return sb.toString();
    }
}
