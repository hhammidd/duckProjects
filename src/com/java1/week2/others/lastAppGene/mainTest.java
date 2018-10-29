package com.java1.week2.others.lastAppGene;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class mainTest {
    public static void main(String[] args) throws FileNotFoundException {

        String someString = "eleeephant";
        long count = someString.chars().filter(ch -> ch == 'e').count();
        System.out.println(count);

        long count2 = someString.codePoints().filter(ch -> ch == 'e').count();
        //assertEquals(2, count2);


        List<String> geneList = new ArrayList();

        geneList.add("1234567890"); // more than 9
        geneList.add("123456789011");


       // File file = new File("brca1line.fa");
        //FileReader fr = new FileReader(file);

        List sr = new ArrayList();

        sr.add("hello");
        sr.add("bb");

        for (Object s: sr) {
            System.out.println((String) s);
        }
    }
}
