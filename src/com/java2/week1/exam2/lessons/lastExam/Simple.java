package com.java2.week1.exam2.lessons.lastExam;

public class Simple{
    private String word;
    private String phrase;
    public Simple(int number, String w) {
        word = w;
        phrase = mystery(number, w);
    }
    String mystery(int num, String s) {
        String answer = "";
        for (int k=0; k<num; k++) {
            answer = answer + s;
        }
        return answer;
    }

    public String toString() {
        return phrase + " is " + word + " repeated";
    }
}