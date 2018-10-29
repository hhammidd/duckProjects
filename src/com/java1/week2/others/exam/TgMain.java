package com.java1.week2.others.exam;

public class TgMain {
    public static void main(String[] args) {
        String dna = "CTGCCTGCATGATCGTA";
        int pos = dna.indexOf("TG");
        int count = 0;
        while (pos >= 0) {
            count = count + 1;
            pos = dna.indexOf("TG",pos);
        }
        System.out.println(count);
    }
}
