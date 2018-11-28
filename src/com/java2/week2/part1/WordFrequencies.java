package com.java2.week2.part1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    private void findUnique() throws IOException {
        myWords.clear();
        myFreqs.clear();
        FileReader fr = new FileReader("java2/week2/exam2/errors.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        List<String> wordsList = new ArrayList<>();
        while ( line != null){
            String[] subWords = line.split("\\s+");

            for (int i = 0; i<subWords.length; i++){
                if (!(subWords[i].equals(""))) {
                    wordsList.add(subWords[i]);
                }
            }

            line = reader.readLine();
        }
        for (String word : wordsList) {
            word = word.toLowerCase();
            int index = myWords.indexOf(word);
            if (index == -1) {
                myWords.add(word);
                myFreqs.add(1);
            }
            else {
                int freq = myFreqs.get(index);
                myFreqs.set(index, freq+1);
            }
        }
    }

    public void testfindUnique() throws IOException {
        findUnique();
        for (int k = 0; k < myWords.size(); k++) {
            System.out.println(myWords.get(k)+": "+myFreqs.get(k)+"\t");
        }
        int biggest = findIndexOfMax();
        System.out.println("The word with highest frequency is:--> "+myWords.get(biggest)+" <-- with "+myFreqs.get(biggest) + " Occur");
        System.out.println("The number of unique words are: "+myWords.size());

    }

    private int findIndexOfMax() {
        int current = myFreqs.get(0);
        int index = 0;
        for (int k = 0; k < myFreqs.size(); k++) {
            int newone = myFreqs.get(k);
            if (newone > current) {
                current = newone;
                index = k;
            }
        }
        return index;
    }
}
