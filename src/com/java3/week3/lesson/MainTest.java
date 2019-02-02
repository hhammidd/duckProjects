package com.java3.week3.lesson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainTest {
    private static Random myRandom;

    public static void main(String[] args) {

        //getFollows('t');
        int numChar = 0;
        //getRandomText(numChar);
    }

    /*
    private static String getRandomText(int numChar) {


        //int index = myRandom.nextInt(myText.length()-1);
        //String key = myText.substring(index, index+1);
        String key = "a";

        int index = 1;
        int numChars = 13;
        StringBuilder sb = new StringBuilder();
        sb.append(key);

        for (int k=0; k< numChars-1; k++){

            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0 ){
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = next;
        }

        return sb.toString();
    }

    private static ArrayList<String> getFollows(Character key) {

        String test = "this is an attempt";
        int index = 0;

        int pos = 0;

        List<String> follows = new ArrayList<>();

        for (int k =0; k <test.length() ; k++){

            index = test.indexOf(key);
            if (index != -1){
                char nextChar = test.charAt(index+1);
                follows.add(String.valueOf(nextChar));
                pos = index+1;
            } else
                break;

        }

        System.out.println(follows);

        return follows;
    }
*/

}
