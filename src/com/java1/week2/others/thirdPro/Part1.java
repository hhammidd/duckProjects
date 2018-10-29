package com.java1.week2.others.thirdPro;

import com.sun.corba.se.spi.orb.Operation;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        Part1 ac = new Part1();
        //ac.testFindStop();
        System.out.println("++++++++++");
        //ac.testFindGene();
        ac.test();

        System.out.println("====cgRation======");
        ac.cgRatio("CDSSSSGGGCC");

        System.out.println("====ProcessGene======");
        ac.processGenes(null);
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

        testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAAATGGGGGGjL");
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

        allGenes.add("1234567890");
        allGenes.add("CGTCGTTACGTCGT");
        allGenes.add("CGT");

        int countMoreThaneight = 0;
        int countMoreCg = 0;
        for (String s : allGenes){
            if (s.length() > 8 ) {
                System.out.println("dna more than 8 " + s);
                countMoreThaneight++ ;
            }
            if (cgRatio(s) > 0.35 ){
                System.out.println("dna cg ratio > 0.35: " +s);
                countMoreCg++ ;
            }


        }



        return allGenes;
    }

    private float cgRatio(String dna) {

        float ratioCg = 0;
        int len = dna.length();

        int cPos = 0;
        int gPos = 0;

       // cPos = findLetter (dna, startIndex,"TAA");

        float countC = dna.chars().filter(ch -> ch == 'C').count();

        float countG = dna.chars().filter(ch -> ch == 'G').count();

        ratioCg = (countC+countG)/len ;

        return ratioCg;
    }





}
