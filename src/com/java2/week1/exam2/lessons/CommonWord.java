package com.java2.week1.exam2.lessons;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonWord {

    public static void main(String[] args) throws IOException {
        countShakespeare();
    }

    static void countShakespeare() throws IOException {
        // start
        String[] plays = {"caesar.txt","errors.txt","hamlet.txt","likeit.txt","macbeth.txt","romeo.txt"};
        String[] common = getCommon();
        int[] counts = new int[common.length];
        for (int k=0;k<plays.length;k++){
            FileReader fr = new FileReader("java2/week1/CommonWordsData/" + plays[k]);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            List<String> wordsList = new ArrayList<>();
            while ( line != null){
                String[] subWords = line.split("\\s+");
                for (int i = 0;i<subWords.length; i++){
                    if (!(subWords[i].equals(""))){
                        wordsList.addAll(Arrays.asList(subWords));
                    }
                }
                line = reader.readLine();
            }


            countWords(reader,common,counts);
            System.out.println("done with " + plays[k]);
        }
        for (int k=0 ;k< common.length; k++){
            System.out.println(common[k] + "\t" + plays[k]);
        }
    }

    public int indexOf(String[] list, String word) {
        for (int k=0; k<list.length; k++) {
            if (list[k].equals(word)) {
                return k;
            }
        }
        return -1;
    }

    public static void countWords(BufferedReader reader, String[] common, int[] counts) throws IOException {
        String line = reader.readLine();

        String[] words = line.split("\\|");
        int index = 0;
        while (line != null){
            common[index] = line;
            index += 1;
            line = reader.readLine();
        }
        for (int i =0; i<common.length;i++){

        }

    }

    private static String[] getCommon() throws IOException {
        FileReader fr = new FileReader("java2/week1/CommonWordsData/common.txt");
        BufferedReader reader = new BufferedReader(fr);
        String[] common = new String[20];
        int index = 0;
        String line = reader.readLine();


        while (line != null){

            common[index] = line;
            index += 1;
            line = reader.readLine();
        }
        return common;
    }
}
