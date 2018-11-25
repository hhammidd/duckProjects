package com.java2.week1.exam2.lessons;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CasesarBreaker {

    public static void main(String[] args) throws IOException {
        //test_countLetters();
        halfOfString("s",2);
        test_countLetters();
        test_decryptTwoKeys();

    }

    public static String decryptTwoKeys(String encrypted){
        CaesarCipher cc1 = new CaesarCipher();
        CaesarCipher cc2 = new CaesarCipher();

        String message1 = halfOfString(encrypted,0);
        String message2 = halfOfString(encrypted,1);
        StringBuilder theAnswer = new StringBuilder(encrypted);
        int key1= getKey(message1);
        int key2= getKey(message2);

        String d_message1=cc1.encrypt(message1,(26-key1));
        String d_message2=cc1.encrypt(message2,(26-key2));

        //build up the final answer

        for (int k=0; k<(message1.length());k++){
            theAnswer.setCharAt((2*k), d_message1.charAt(k) );
        }

        for (int k=0; k<(message2.length());k++){
            theAnswer.setCharAt((2*k)+1, d_message2.charAt(k) );
        }

        System.out.println(key1+" "+key2+" " + theAnswer.toString());


        return theAnswer.toString();
    }

    public static void test_decryptTwoKeys() throws IOException {
        FileReader fr = new FileReader("java2/week1/CommonWordsData/mysteryTwoKeysQuiz.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        List<String> wordsList = new ArrayList<>();
        StringBuilder contentBuilder = new StringBuilder();
        while ( line != null){
            contentBuilder.append(line);
            line = reader.readLine();
        }
        String message = contentBuilder.toString();
        String d_TwoKeyMessage = decryptTwoKeys(message);

        System.out.println(message);
        System.out.println(d_TwoKeyMessage);
    }

    public String decrypt(String encrypted){
        CaesarCipher cc1 = new CaesarCipher();
        int key = getKey(encrypted);
        return cc1.encrypt(encrypted,(26-key));
    }

    public static int maxIndex(int[] values){
        int maxLength =0;
        int indexOfMax =0;

        for (int k=0; k<values.length; k++){
            if (values[k]>maxLength){
                maxLength =values[k];
                indexOfMax = k;
            }
        }
        return indexOfMax;
    }

    public static int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];

        for(int k=0; k<message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1){
                counts[dex] +=1;
            }
        }
        return counts;
    }

    public static void test_countLetters() throws IOException {
        //FileResource resource = new FileResource("data/romeo.txt");
        //FileResource resource = new FileResource("data/wordsLotsOfEs.txt");
        FileReader fr = new FileReader("java2/week1/CommonWordsData/smallHamlet.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        List<String> wordsList = new ArrayList<>();
        StringBuilder contentBuilder = new StringBuilder();
        while ( line != null){
            contentBuilder.append(line);
            line = reader.readLine();
        }
        String message = contentBuilder.toString();

        //int[] counts = countLetters(message);
        //System.out.println("Most common length is " + maxIndex(counts));
    }

    public void test_decrypt(){
        //FileResource resource = new FileResource("data/smallHamlet.txt");
        //FileResource resource = new FileResource("data/wordsLotsOfEs.txt");
        String message = "";

        CaesarCipher cc = new CaesarCipher();
        String encrypted = cc.encrypt(message, 20);
        String decrypted = decrypt(encrypted);
        System.out.println(encrypted + "   " + decrypted);
    }

    public static String halfOfString(String message, int start){


        String halfMessage = "";
        for (int i= start; i<message.length(); i=i+2){
            halfMessage = halfMessage + message.charAt(i);
        }
        return halfMessage;
    }

    public void test_halfOfString(){
        //FileResource resource = new FileResource("data/smallHamlet.txt");
        //FileResource resource = new FileResource("data/wordsLotsOfEs.txt");
        String message = "";
        System.out.println(message);
        //System.out.println(halfOfString(message, 0));
        //System.out.println(halfOfString(message, 1));

        CaesarCipher cc = new CaesarCipher();
        String encrypted = cc.encrypt(halfOfString(message, 0), 20);
        String decrypted = decrypt(encrypted);
        System.out.println(encrypted);
        System.out.println(decrypted);
    }
    public static int getKey(String e_message){
        int[] freqs = countLetters(e_message);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex-4;
        if (maxDex < 4) {
            dkey = 26 - (4-maxDex);
        }
        return dkey;
    }

    public void test_getKey(){
        //FileResource resource = new FileResource("data/smallHamlet.txt");
        //FileResource resource = new FileResource("data/wordsLotsOfEs.txt");
        String message = "";
        CaesarCipher cc = new CaesarCipher();
        String e_message = cc.encrypt(message, 5);
        System.out.println(getKey(e_message) + " is the key for: " + message + " to: " + e_message);

    }


}
