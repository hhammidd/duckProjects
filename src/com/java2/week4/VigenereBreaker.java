package com.java2.week4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class VigenereBreaker {
    CaesarCracker crackers;
    /**
     *  which has three parameters—a String message, representing the encrypted message, an integer whichSlice,
     *  indicating the index the slice should start from, and an integer totalSlices, indicating the length of the key.
     *  This method returns a String consisting of every totalSlices-th character from message, starting at the whichSlice-th
     *  character.
     * @param message
     * @param whichSlice
     * @param totalSlices
     * @return
     */
    public String sliceString(String message, int whichSlice, int totalSlices) {

        StringBuilder thisSlice = new StringBuilder();

        for(int i = whichSlice;i<message.length();i+=totalSlices){

            thisSlice.append(message.substring(i,i+1));

        }

        return thisSlice.toString();
    }

    /**
     *his method should make use of the CaesarCracker class, as well as the sliceString method, to find the shift
     * for each index in the key.
     *  You should fill in the key (which is an array of integers) and return it. Test this method on the text fil
     * @param encrypted the encrypted message
     * @param klength the key length
     * @param mostCommon  most common character in the language of the message.
     * @return
     */
    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {

        //WRITE YOUR CODE HERE
        crackers=new CaesarCracker();
        int[] s= new int[klength];

        for(int i=0;i<klength;i++){
            s[i]=crackers.getKey(sliceString(encrypted,i,klength));
        }
        return s;
    }

    public HashSet<String> readDictionary(String fileName) throws IOException {
        FileReader fr = new FileReader("java2/week4/athens_keyflute.txt");
        BufferedReader reader = new BufferedReader(fr);
        List<String> lines = new ArrayList<>();
        String lineO = reader.readLine();
        while (lineO != null) {
            lines.add(lineO);
            lineO = reader.readLine();
        }
        HashSet<String> dictionary = new HashSet<String>();
        for (String line : lines) {
            line = line.toLowerCase();
            dictionary.add(line);
        }
        return dictionary;
    }

    public int countWords(String message, HashSet<String> dictionary) {
        int wordCount = 0;
        List<String> splitMessage = new ArrayList<String>(Arrays.asList(message.split("\\W")));
        for (int index=0;index < splitMessage.size();index++) {
            if (dictionary.contains(splitMessage.get(index).toLowerCase())) {
                wordCount++;
            }
        }
        return wordCount;
    }

    public void breakVigenere () throws IOException {
        //WRITE YOUR CODE HERE
        FileReader fr = new FileReader("java2/week4/athens_keyflute.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        StringBuilder contentBuilder = new StringBuilder();
        while (line != null) {
            contentBuilder.append(line);
            contentBuilder.append(System.getProperty("line.separator"));
            line = reader.readLine();
        }
        String s = contentBuilder.toString();

        HashMap<String, HashSet<String>> dictmap = new HashMap<>();

        List<String> dr = new ArrayList<>();
        for(String f: dr){
            String fname = f;

            //HashSet<String> dict= readDictionary(fd);
            //dictmap.put(fname,dict);
            System.out.println(fname);
        }


    }


    public HashSet<String> readDictionary(List<String> fr){

        HashSet<String> dict=new HashSet<String>();
        for(String line : fr){
            dict.add(line.toLowerCase());
        }
        return dict;
    }


}
