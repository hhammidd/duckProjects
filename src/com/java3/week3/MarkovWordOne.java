package com.java3.week3;

import com.java3.AMarkovWord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MarkovWordOne extends AMarkovWord {
    public MarkovWordOne() {
        super(1);
    }
    public MarkovWordOne(int n) {
        super(n);
    }


    private int indexOf(String[] words, String target, int start) {

        for (int i=start; i<words.length; i++) {

            if (words[i].equals(target)) return i;
        }

        return -1;
    }

    private ArrayList<String> getFollows(String key) {

        ArrayList<String> follows = new ArrayList<String>();
        int index = indexOf(myText, key, 0);

        while (index!=-1) {
            follows.add(myText[index+1]);
            index = indexOf(myText, key, index+1);
        }

        return follows;
    }

    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-1);  // random word to start with
        String key = myText[index];
        sb.append(key);
        sb.append(" ");
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
//		    System.out.println(key+":\t"+follows);
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = next;
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) throws IOException {
        MarkovWordOne markov = new MarkovWordOne();
        markov.setRandom(365);

        FileReader fr = new FileReader("java3/data/romeo.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        StringBuilder contentBuilder = new StringBuilder();
        while ( line != null){
            contentBuilder.append(line);
            contentBuilder.append(" ");
            line = reader.readLine();
        }
        String st = contentBuilder.toString();

        markov.setTraining(st);
        String str = markov.getRandomText(20);
        System.out.println(str);
    }
}
