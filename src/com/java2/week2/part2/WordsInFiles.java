package com.java2.week2.part2;
import java.util.*;
import java.io.*;

public class WordsInFiles {
    private HashMap<String, ArrayList<String>> map;
    //private ArrayList<String> arraylist;

    public WordsInFiles() {
        map = new HashMap<String, ArrayList<String>>();
        //arraylist = new ArrayList<String>();
    }

    private void addWordsFromFile(String name) throws IOException {
        FileReader fr = new FileReader("java2/week2/exam2/"+name);

        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        List<String> wordsList = new ArrayList<>();
        while ( line != null){
            String[] subWords = line.split("\\s+");
            if (!(subWords.equals(""))) {
                wordsList.addAll(Arrays.asList(subWords));
            }
            line = reader.readLine();
        }
        for (String word : wordsList) {
            //if (word.equals("tree")) sad = 1;
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<String>());
                map.get(word).add(name);
            }
            else if (map.containsKey(word)) {
                if (!map.get(word).contains(name)) map.get(word).add(name);
            }
        }
        //if (sad == 1) System.out.println(name);
    }

    private void buildWordFileMap() throws IOException {
        map.clear();
        //DirectoryResource dr = new DirectoryResource();
        List<String> dr = new ArrayList<>();
        dr.add("brief1.txt");
        dr.add("brief2.txt");
        dr.add("brief3.txt");
        dr.add("brief4.txt");

        for (String f: dr) {
            addWordsFromFile(f);
        }

    }

    private int maxNumber() {
        int current = 0;
        int largest = 0;

        for (String word: map.keySet()) {
            current = map.get(word).size();
            if (largest < current) largest = current;
        }

        return largest;
    }

    private ArrayList<String> wordsInNumFiles(int number) {
        int current = 0;
        ArrayList<String> list = new ArrayList<String>();
        for (String word: map.keySet()) {
            current = map.get(word).size();
            if (current==number) list.add(word);
        }
        return list;
    }

    private void printFilesIn(String word) {
        System.out.println("The files contain "+word+" are(is): \t");
        ArrayList<String> list = new ArrayList<String>();
        for (String current: map.keySet()) {
            if (current==word) list = map.get(current);
        }
        for (int k = 0; k < list.size(); k++) {
            System.out.println(list.get(k)+"\t");
        }
    }

    public void test() throws IOException {
        buildWordFileMap();
        int max = maxNumber();
        ArrayList<String> list = wordsInNumFiles(max);
        System.out.println("The greatest number of files a word appears in is "+max+", and there are "+list.size()+ " such words: ");
        for (int k = 0; k < list.size(); k++) {
            System.out.println(list.get(k)+" ");
        }
        System.out.println("\t");
        for (int k = 0; k < list.size(); k++) {
            printFilesIn(list.get(k));
        }


    }
}
