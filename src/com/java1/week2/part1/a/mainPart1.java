package com.java1.week2.part1.a;

public class mainPart1 {
    public static void main(String[] args) {

        String dna = "ATGATCGCTTAAGATTAA";

        FindGeneStopCodon findGeneStopCodon = new FindGeneStopCodon();
        String gene = findGeneStopCodon.findDna(dna);
        System.out.println("Gene is : " + gene);

        String dna1 = "ATGATCGCTGATTAGGCTTAAATGACG";
        String gene1 = findGeneStopCodon.findStopCodon(dna1);
        System.out.println("3 stop codon is : " +gene1);
    }
}
