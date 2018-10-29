package com.java1.week2.others.lastAppGene;

import java.util.ArrayList;
import java.util.List;

public class AllCodonsAnd {

    public static void main(String[] args) {
        AllCodonsAnd ac = new AllCodonsAnd();
        //ac.testFindStop();
        System.out.println("++++++++++");
        //ac.testFindGene();
        ac.test();
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

    //Translate to code
    public void printAllGenes(String dna){
        int startIndex = 0;

        while (true){
            String currentGene = findGene(dna, startIndex);

            if (currentGene.isEmpty()){
                break;
            }

            System.out.println(currentGene);

            //update currentIndex
            startIndex = dna.indexOf(currentGene, startIndex) +
                    currentGene.length();
        }
    }

    public void test(){

        testOn("AATGCTAACTAGCTGACTAAT");
        testOn("");

        testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAAATGGGGGGjL");
    }

    private void testOn(String dna) {
        System.out.println("Testing printAllGenes on " + dna);
        printAllGenes(dna);
    }


    private List getAllGene(String dna){
        List storageRes = new ArrayList();

        int startIndex = 0;

        while (true) {
            String currentGene = findGene(dna, startIndex);

            if (currentGene.isEmpty()) {
                break;
            }


            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }

        return storageRes;
    }


}
