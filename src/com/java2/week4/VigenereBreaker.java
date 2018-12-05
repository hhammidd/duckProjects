package com.java2.week4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class VigenereBreaker {
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
     * @param mostCommon
     * @return
     */
    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {

        System.out.println(mostCommon);
        //WRITE YOUR CODE HERE
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker(mostCommon);

        for (int i=0; i<klength;i++) {
            String slice = sliceString(encrypted, i, klength);
            key[i] = cc.getKey(slice);
        }

        return key;
    }

    public HashSet<String> readDictionary(String fileName) throws IOException {
        FileReader fr = new FileReader("java2/week4/" + fileName);
        BufferedReader reader = new BufferedReader(fr);
        HashSet<String> dictionary = new HashSet<String>();
        String lineO = reader.readLine();
        while (lineO != null) {
            dictionary.add(lineO.toLowerCase());
            lineO = reader.readLine();
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
        FileReader fr = new FileReader("java2/week4/athens_keyflute.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        List<String> lines = new ArrayList<>();
        StringBuilder contentBuilder = new StringBuilder();
        while ( line != null){
            if (!line.equals("")) {
                lines.add(line);
                contentBuilder.append(line);
                contentBuilder.append("\n");
            }
            line = reader.readLine();
        }
        String encrypted = String.valueOf(lines).substring(1,String.valueOf(lines).length()-1);
        int[] decryptKeys = tryKeyLength(encrypted,5,'e');
        VigenereCipher vigCipher = new VigenereCipher(decryptKeys);
        String message = vigCipher.decrypt(encrypted);
        System.out.println("This is message: " +message);

        /*
        //WRITE YOUR CODE HERE
        HashMap<String,HashSet<String>> dictionaries = new HashMap<String,HashSet<String>>();

        List<String> dicNamesList = new ArrayList<>();
        dicNamesList.add("athens_keyflute.txt");

        for(String dicName: dicNamesList){
            String fname = dicName;
            HashSet<String> dict= readDictionary(dicName);
            dictionaries.put(fname,dict);
            System.out.println("Reading in " + fname + " dictionary...");
        }


        FileReader fr = new FileReader("java2/week4/athens_keyflute.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        StringBuilder contentBuilder = new StringBuilder();
        while ( line != null){
            contentBuilder.append(line);
            contentBuilder.append(" ");
            //contentBuilder.append(System.getProperty("line.separator"));
            line = reader.readLine();
        }
        String encryptedFile = contentBuilder.toString();

        breakForAllLanguages(encryptedFile,dictionaries);

        */
    }

    private void breakForAllLanguages(String encryptedFile, HashMap<String, HashSet<String>> languages) {
        int currentHigh = 0;
        String decryptedMessage = "";
        String usedLanguage = "";
        for (String currentLanguage : languages.keySet()) {
            String message = breakForLanguage(encryptedFile,languages.get(currentLanguage));
            int currentWordCount = countWords(message,languages.get(currentLanguage));
            if (currentWordCount > currentHigh) {
                decryptedMessage = message;
                currentHigh = currentWordCount;
                usedLanguage = currentLanguage;
            }
        }
        System.out.println(decryptedMessage);
        System.out.println("Language: "+usedLanguage);
    }

    private String breakForLanguage(String encrypted, HashSet<String> dictionary) {
        String decrypted = "";
        int highestWordCount = 0;
        int correctKeyLength = 0;
        for (int index=1; index < 100; index++) {
            char commonChar = mostCommonCharIn(dictionary);
            int[] currentKeys = tryKeyLength(encrypted, index, commonChar);
            VigenereCipher vigCipher = new VigenereCipher(currentKeys);
            String message = vigCipher.decrypt(encrypted);
            int currentWordCount = countWords(message, dictionary);
            if (currentWordCount > highestWordCount) {
                highestWordCount = currentWordCount;
                correctKeyLength = index;
                decrypted = message;
            }
        }
        System.out.println("Key length: "+correctKeyLength);
        System.out.println("Word count: "+highestWordCount);
        return decrypted;
    }

    private char mostCommonCharIn(HashSet<String> dictionary) {
        HashMap<Character,Integer> characterCounter = new HashMap<Character,Integer>();
        for (String word : dictionary) {
            char[] letters = word.toCharArray();
            for (int index=0;index<letters.length;index++) {
                if (!characterCounter.containsKey(letters[index])) {
                    characterCounter.put(letters[index],1);
                }
                else {
                    characterCounter.replace(letters[index],characterCounter.get(letters[index])+1);
                }
            }
        }
        int highestCount = 0;
        char mostUsedChar = '\0';
        for (Character character : characterCounter.keySet()) {
            if (characterCounter.get(character) > highestCount) {
                highestCount = characterCounter.get(character);
                mostUsedChar = character;
            }
        }
        return mostUsedChar;
    }


}
