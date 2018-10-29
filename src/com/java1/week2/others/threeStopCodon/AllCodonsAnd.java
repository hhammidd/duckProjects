package com.java1.week2.others.threeStopCodon;

import java.util.ArrayList;
import java.util.List;

public class AllCodonsAnd {
    public static void main(String[] args) {
        AllCodonsAnd ac = new AllCodonsAnd();
        //ac.testFindStop();
        System.out.println("++++++++++");
        ac.testFindGene();
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
    public void testFindStop() {
        // 0...15
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(dna, 0 , "TAA");
        if (dex != 9) System.out.println("error on 9");
        dex = findStopCodon(dna, 9 , "TAA");
        if (dex != 21) System.out.println("error on 21");
        dex = findStopCodon(dna, 1 , "TAG");
        if (dex != -1) System.out.println("error on 26");
        dex = findStopCodon(dna, 0 , "TAG");
        if (dex != -1) System.out.println("error on 26 TAG");
        System.out.println("test finished");

    }

    public String findGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex,"TAA");
        int tagIndex = findStopCodon(dna, startIndex,"TAG");
        int tgaIndex = findStopCodon(dna, startIndex,"TGA");

        //store the minIndex smallest value
        //int temp = Math.min(taaIndex,tagIndex);
        //int minIndex = Math.min(temp, tgaIndex);

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
        return "";
    }


    public void testFindGene() {
        String dna = "ATGCCCGGGAAATAACCC";
        String gene = findGene(dna);
        if (! gene.equals("ATGCCCGGGAAATAA")){
            System.out.println("error");
        }
        System.out.println("test finished");

    }


    public List<String> getAllGenes(String dna) {
        List<String> geneList = new ArrayList<String>();
        int starttIndex = 0;

        return geneList;
    }

}
