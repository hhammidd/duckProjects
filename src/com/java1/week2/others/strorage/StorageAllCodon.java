package com.java1.week2.others.strorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StorageAllCodon {

    public static void main(String[] args) throws FileNotFoundException {
        StorageAllCodon ac = new StorageAllCodon();
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


    public void test() throws FileNotFoundException {

        testOn("AATGCTAACTAGCTGACTAAT");
        testOn("");

        testOn("Aacaagtttgtacaaaaaagcagaagggccgtcaaggcccaccatgcctattggatc");
    }

    private void testOn(String dna) throws FileNotFoundException {
        System.out.println("Testing printAllGenes on " + dna);

        List gene = getAllGene(dna);
        for (Object g : gene) {
            System.out.println(g);
        }

    }


    private List getAllGene(String dna) throws FileNotFoundException {


        List<String> geneList = new ArrayList<>();
        int startIndex = 0;

        while (true) {
            String currentGene = findGene(dna, startIndex);

            if (currentGene.isEmpty()) {
                break;
            }

            geneList.add(currentGene);

            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }

        return geneList;
    }

    private List processGenes(List<String> sr){

        List<String> allGenes = new ArrayList<>();




        return allGenes;
    }


}
