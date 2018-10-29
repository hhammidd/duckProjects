package com.java1.week2.others.storingCodeon;

import java.util.ArrayList;
import java.util.List;

public class AllCodonsStoring {
    public static void main(String[] args) {
        AllCodonsStoring ac = new AllCodonsStoring();
        ac.test();
    }

    public void test(){

        testOn("AATGCTAACTAGCTGACTAAT");
        testOn("");

        testOn("caaagagaggccaacatatgatcataagaagataatatggtttgaagaactttcttcagaagctccaccctataattctgaacctgcagaagaatctgaacataaaaa");
    }

    private void testOn(String dna) {
        System.out.println("Testing printAllGenes on " + dna);
        ArrayList<String> genes = (ArrayList<String>) getAllGenes(dna);

        for (String g : genes) {
            System.out.println(g);
        }
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

    public String findGene(String dna, int where){
        int startIndex = dna.indexOf("atg" ,where);
        if (startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex,"taa");
        int tagIndex = findStopCodon(dna, startIndex,"tag");
        int tgaIndex = findStopCodon(dna, startIndex,"tga");


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



    public List<String> getAllGenes(String dna) {

        List<String> geneList = new ArrayList<String>();

        int startIndex = 0;

        while (true) {
            String currentGene = findGene(dna, startIndex);

            if (currentGene.isEmpty()) {
                break;
            }

            geneList.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) +
                    currentGene.length();        }

        return geneList;
    }




}
