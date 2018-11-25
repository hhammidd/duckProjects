package com.java2.week2.part2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CodonCount {
    private HashMap<String, Integer> map;

    public CodonCount() {
        map = new HashMap<String, Integer>();
    }

    private void buildCodonMap(int start, String dna) {
        map.clear();
        int k = 0; //number of codons
        int num = 0; //number of iterations
        k = (dna.length()-start)/3;
        String current;
        while (num <= k-1) {
            current = dna.substring(num*3+start, num*3+start+3);
            if (!map.containsKey(current)) map.put(current, 1);
            else map.put(current, map.get(current)+1);
            num = num + 1;
        }
    }

    private String getMostCommonCodon() {
        int largest = 0;
        int current = 0;
        String largestone = null;
        for (String index : map.keySet()) {
            current = map.get(index);
            if (largest < current) {
                largest = current;
                largestone = index;
            }
        }
        return largestone;
    }

    private void printCodonCounts(int start, int end) {
        int current = 0;
        for (String index : map.keySet()) {
            current = map.get(index);
            if (current >= start && current <= end)
                System.out.println(index+": "+current+"\t");
        }
    }

    public void test() throws IOException {
        FileReader fr = new FileReader("java2/week2/exam2/smalldna.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        StringBuilder contentBuilder = new StringBuilder();
        while ( line != null){
            contentBuilder.append(line);
            line = reader.readLine();
        }
        String dna = contentBuilder.toString();


        dna = dna.toUpperCase();
        int start = 1;
        int end = 5;

        buildCodonMap(0, dna);
        System.out.println("Reading frame starting with 0 results in "+map.size()+" unique codons"+"\t");
        String largest = getMostCommonCodon();
        System.out.println("and most common codon is "+largest+" with count "+map.get(largest)+"\t");
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);

        buildCodonMap(1, dna);
        System.out.println("Reading frame starting with 1 results in "+map.size()+" unique codons"+"\t");
        largest = getMostCommonCodon();
        System.out.println("and most common codon is "+largest+" with count "+map.get(largest)+"\t");
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);

        buildCodonMap(2, dna);
        System.out.println("Reading frame starting with 2 results in "+map.size()+" unique codons"+"\t");
        largest = getMostCommonCodon();
        System.out.println("and most common codon is "+largest+" with count "+map.get(largest)+"\t");
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);
    }
}
