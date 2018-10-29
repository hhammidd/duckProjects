package com.java1.week2.part3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exam {

    public static void main(String[] args) throws Exception {
        Exam ac = new Exam();

        System.out.println("====ProcessGene======");
        ac.testProcessGenes();
    }


    public int findStopCodon(String dnaStr, int startIndex, String stopCodon) {
        int currIndex = dnaStr.indexOf(stopCodon,startIndex+3);
        while (currIndex != -1){
            int diff = currIndex - startIndex;
            if (diff % 3  == 0) {
                return currIndex;
            }
            else {
                currIndex =dnaStr.indexOf(stopCodon, currIndex+1);
            }
        }
        return -1;
    }


    public String findGene(String dna, int where){
        int startIndex = dna.indexOf("ATG" ,where);
        if (startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex,"TAA");
        int tagIndex = findStopCodon(dna, startIndex,"TAG");
        int tgaIndex = findStopCodon(dna, startIndex,"TGA");


        int minIndex = 0;
        if (taaIndex == -1 || (tgaIndex !=-1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        } else {
            minIndex = taaIndex;
        }

        if (minIndex == -1 || (tgaIndex != -1 && tgaIndex < minIndex)) {
            minIndex = tagIndex;
        }

        if (minIndex == -1){
            return "";
        }
        return dna.substring(startIndex,minIndex +3);
    }

    private void testProcessGenes() throws Exception {

        FileReader fr = new FileReader("GRch38dnapart.fa");
        BufferedReader reader = new BufferedReader(fr);

        //File file = new File();
        String geneText = "";
        String line = reader.readLine();
        while (line != null){
            geneText += line;
            line = reader.readLine();
        }

        System.out.println(geneText);

        List<String> allGenes = new ArrayList<>();

        allGenes = getAllGene(geneText);
        processGenes(allGenes);


    }


    private List getAllGene(String dna) throws FileNotFoundException {

        List<String> geneList = new ArrayList<>();


        int counterGene =0;
        int startIndex = 0;

        while (true) {
            String currentGene = findGene(dna, startIndex);

            if (currentGene.isEmpty()) {
                break;
            }

            geneList.add(currentGene);

            counterGene ++;
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }

        int genCont = counterGene;
        return geneList;
    }

    private List processGenes(List<String> sr){

        int countMoreThaneight = 0;
        int countMoreCg = 0;
        float cgRatioConst = (float) 0.35;
        for (String s : sr){
            if (s.length() > 60 ) {
                //System.out.println("dna more than 8 " + s);
                countMoreThaneight++ ;
            }
            if (cgRatio(s) > cgRatioConst ){
               // System.out.println("dna cg ratio > 0.35: " +s);
                countMoreCg++ ;
            }



        }
        String max = Collections.max(sr, Comparator.comparing(s -> s.length()));
        int maxLen = max.length();

        return null;
    }

    public float cgRatio( String dna ) {
        String dnaLow = dna.toLowerCase();
        int cgCount = 0;
        int start = 0;

        while (true) {
            int pos = dnaLow.indexOf("C", start);
            if (pos == -1) {
                start = 0;
                break;
            }
            cgCount += 1;
            start = pos + 1;
        }

        while (true) {
            int pos = dnaLow.indexOf("G", start);
            if (pos == -1) {
                start = 0;
                break;
            }
            cgCount += 1;
            start = pos + 1;
        }

        return ( (float) cgCount ) / dna.length();

    }

    private double cgRatio1(String dna) {

        double ratioCg = 0;
        int len = dna.length();

        int cPos = 0;
        int gPos = 0;

       // cPos = findLetter (dna, startIndex,"TAA");

        double countC = dna.chars().filter(ch -> ch == 'C').count();

        double countG = dna.chars().filter(ch -> ch == 'G').count();

        ratioCg = (countC+countG)/len ;
        double countcg = countC+countG;

        return ratioCg;
    }

}
