package com.java1.week2.part1.a;

public class FindGeneStopCodon {

    public String findDna(String dna) {
        int startIndex = dna.indexOf("ATG");
        int currIndex = dna.indexOf("TAA",startIndex+3 );

        while (currIndex != -1) {
            if ((currIndex-startIndex) %3 == 0){
                return dna.substring(startIndex, currIndex+3);
            }
            else {
                currIndex = dna.indexOf("TAA", currIndex +1);
            }

        }
        return "";

    }

    public String findStopCodon(String dna1) {
        return null;
    }
}
