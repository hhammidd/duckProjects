package com.java2.week1.exam2.lessons;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordLengths {
    private static HashMap hm = new HashMap();

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("java2/week1/CommonWordsData/errors.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        List<String> wordsList = new ArrayList<>();
        while ( line != null){
            String[] subWords = line.split("\\s+");
            for (int i = 0;i<subWords.length; i++){
                if (!(subWords[i].equals(""))){
                    wordsList.addAll(Arrays.asList(subWords));

                }
                break;
            }
            line = reader.readLine();
        }
        int[] counts = new int[31];
        countWordLengths(wordsList, counts);
        System.out.println(indexOfMax(counts));
    }
    public static void countWordLengths(List<String> wordsList,int[] counts){
        // counts[k] --> NO words length k




        for (String word: wordsList){
            int wordLength = 0;
            StringBuilder sb = new StringBuilder(word);

            for (int k=0;k<sb.length();k++){
                if (k==0 && !Character.isLetter(sb.charAt(k))){
                    sb.deleteCharAt(k);
                }
                else if (k==sb.length()-1 && !Character.isLetter(sb.charAt(k))){
                    sb.deleteCharAt(k);
                }
                else{
                    wordLength++;
                }
            }
            String resultString = sb.toString();
            counts[wordLength]++;
            hm.put(resultString, wordLength);

        }

        for (int index = 0; index< counts.length; index++){
            if (counts[index] !=0){
                System.out.print(counts[index] + " words of length " + index + ": ");
                Set set = hm.entrySet();
                // Get an iterator
                Iterator i = set.iterator();
                // Display elements
                while(i.hasNext()) {
                    Map.Entry me = (Map.Entry)i.next();
                    if (me.getValue().equals(index))
                        System.out.print(me.getKey() + " ");
                }
                System.out.println();
            }
        }
    }

    public static int indexOfMax(int[] values){
        int max=0;
        for(int i=0; i< values.length;i++){
            if(values[i]>max){
                max = values[i];
            }
        }
        return max;
    }
}
