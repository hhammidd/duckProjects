package com.java3.week3.lesson;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MarkovRunner {




    public void runMarkovZero() throws IOException {

        String st = getText();


        MarkovZero markov = new MarkovZero();
        markov.setMyRandom(1024);
        markov.setTraining(st);

        for (int k=0; k< 3; k++){
            String text = markov.getRandonText(500);
            printOut(text);
        }
    }

    public static void main(String[] args) throws IOException {
        MarkovRunner mr = new MarkovRunner();
        mr.runMarkovZero();
    }

    private void printOut(String s) {
        String[] words = s.split("\\s");
        int psize =0;
        System.out.println("----------------------");
        for (int k =0; k < words.length; k++){
            System.out.println(words[k] + " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n---------------------");
    }

    private String getText() throws IOException {
        FileReader fr = new FileReader("java3/testText.txt");
        BufferedReader reader = new BufferedReader(fr);
        String lineO = reader.readLine();
        List<String> lines = new ArrayList<>();

        while ( lineO != null){
            if (!(lineO.isEmpty())){
                lines.add(lineO);
            }
            lineO = reader.readLine();
        }

        return lines.toString();
    }



}
