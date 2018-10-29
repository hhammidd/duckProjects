package com.java1.week2.others.threeStopCodon;

public class AllCodon {
    public static void main(String[] args) {
        AllCodon ac = new AllCodon();
        ac.testFindStop();
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
        int temp = Math.min(taaIndex,tagIndex);
        int minIndex = Math.min(temp, tgaIndex);

        if (minIndex == dna.length()){
            return "";
        }
        return "";
    }

    public int findStopCodon(String dnaStr, int startIndex, String stopCodon) {
        //find stopCodon strating from (startIndex+3), curreIndex
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
        return dnaStr.length();
    }

    public void testFindStop() {
        // 0...15
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(dna, 0 , "TAA");
        if (dex != 9) System.out.println("error on 9");
        dex = findStopCodon(dna, 9 , "TAA");
        if (dex != 21) System.out.println("error on 21");
        System.out.println("test finished");

    }
}
