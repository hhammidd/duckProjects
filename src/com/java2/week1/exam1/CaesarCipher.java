package com.java2.week1.exam1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        Utils utils = new Utils();
        utils.digitTest();
        String encryptedStr = encrypt("First Legion", 23);
        testCaesar();
        encryptTwoKeys("First Legion",23,17);
    }

    public static String encryptTwoKeys(String input, int key1, int key2){
        //StringBuilder encrypted = new StringBuilder(input);
        String newEncrypted = "";
        for (int i =0; i<input.length(); i++){
            char ch = input.charAt(i);
            String stringOfChar = String.valueOf(ch);
            if (i%2 == 0){
                newEncrypted += encrypt(stringOfChar,key1);
            } else {
                newEncrypted += encrypt(stringOfChar, key2);
            }
        }
        return newEncrypted;
    }

    public static void testCaesar() throws IOException {
        // read the file
        FileReader fr = new FileReader("GRch38dnapart.fa");
        BufferedReader reader = new BufferedReader(fr);

        //FileResource fr = new FileResource();

        //File file = new File();
        String geneText = "";
        String line = reader.readLine();
        while (line != null){
            geneText += line;
            line = reader.readLine();
        }

        System.out.println(geneText);
        // after read the file
        String message = "";
        int key = 0;
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }

    public static String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String encryptedStr = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String shiftedalphabet =  alphabet.substring(key) + alphabet.substring(0,key);

        for (int i = 0; i<encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            if (Character.isUpperCase(currChar)){
                int idx = alphabet.indexOf(currChar);
                if (idx != -1){
                    char newChar = shiftedalphabet.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            } else {
                int idx = alphabet.indexOf(Character.toUpperCase(currChar));
                if (idx != -1){
                    char newChar = shiftedalphabet.charAt(idx);
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                }
            }

        }
        // encryptedStr = “CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”
        return encrypted.toString();
    }




}
