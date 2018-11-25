package com.java2.week2.part1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CharactersInPlay {
    private ArrayList<Integer> myFreqs;
    private ArrayList<String> myWords;

    public CharactersInPlay() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    private void update(String person) {
        //person = person.toLowerCase();
        int index = myWords.indexOf(person);
        if (index == -1) {
            myWords.add(person);
            myFreqs.add(1);
        }
        else {
            int freq = myFreqs.get(index);
            myFreqs.set(index, freq+1);
        }
    }

    private void findAllCharacters() throws IOException {
        FileReader fr = new FileReader("java2/week2/exam1/likeit.txt");
        BufferedReader reader = new BufferedReader(fr);
        String lineO = reader.readLine();
        List<String> lines = new ArrayList<>();
        while ( lineO != null){
            lines.add(lineO);
            lineO = reader.readLine();
        }

        for (String line: lines) {
            int index = line.indexOf(".");
            if (index > -1) {
                int nonblank = 0;
                while (nonblank < index) {
                    if (!line.substring(nonblank, nonblank+1).equals(" ")) break;
                    else nonblank = nonblank + 1;
                }
                String person = line.substring(nonblank, index);
                update(person);
            }
        }
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

    private void charactersWithNumParts(int num1, int num2) {
        for (int k = 0; k < myWords.size(); k++) {
            if (myFreqs.get(k)>=num1 && myFreqs.get(k) <= num2)
                System.out.println(myWords.get(k) + ": "+ myFreqs.get(k)+ "\t");
        }
    }

    public void testfindAllCharacters() throws IOException {
        findAllCharacters();
        charactersWithNumParts(10, 150);
        int biggest = findIndexOfMax();
        System.out.println("The word with highest frequency is: "+myWords.get(biggest)+" with "+myFreqs.get(biggest));
    }
}
