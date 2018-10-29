package com.java1.week2.others.FindSimpleGene;

public class FindGeneWhile {

    public String findGene(String dna){

        //find the first occure "ATG"
        int startIndex = dna.indexOf("ATG");
        //
        int currIndex = dna.indexOf("TAA",startIndex+3 );

        while (currIndex != -1) {
            if ((currIndex-startIndex) %3 == 0){
                return dna.substring(startIndex, currIndex+3);
            }
            else {
                System.out.println("it is not multiply 3");
                currIndex = dna.indexOf("TAA", currIndex +1);
            }

        }
        return "No TAA found";
    }

    public void testFindGeneSimple(){
        String dna = "AATGCAGTAATTGAA";
        String gene = findGene(dna);
        System.out.println("The gene is : " + gene);
    }
    public static void main(String[] args) {
        FindGeneWhile f = new FindGeneWhile();
        f.testFindGeneSimple();
    }
}
