package com.java2.week4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VigenereTester {
    public static void testSliceString() {
        String tester = "abcdef*ghijklm";
        VigenereBreaker vb = new VigenereBreaker();
        String slicedString = vb.sliceString(tester,0,3);
        System.out.println("0,3 produced: "+slicedString);
        slicedString = vb.sliceString(tester,1,3);
        System.out.println("1,3 produced: "+slicedString);
        slicedString = vb.sliceString(tester,2,3);
        System.out.println("1,3 produced: "+slicedString);
        slicedString = vb.sliceString(tester,0,4);
        System.out.println("0,4 produced: "+slicedString);
        slicedString = vb.sliceString(tester,1,4);
        System.out.println("1,4 produced: "+slicedString);
        slicedString = vb.sliceString(tester,2,4);
        System.out.println("2,4 produced: "+slicedString);
        slicedString = vb.sliceString(tester,3,4);
        System.out.println("3,4 produced: "+slicedString);
        slicedString = vb.sliceString(tester,0,5);
        System.out.println("0,5 produced: "+slicedString);
        slicedString = vb.sliceString(tester,1,5);
        System.out.println("1,5 produced: "+slicedString);
        slicedString = vb.sliceString(tester,2,5);
        System.out.println("2,5 produced: "+slicedString);
        slicedString = vb.sliceString(tester,3,5);
        System.out.println("3,5 produced: "+slicedString);
        slicedString = vb.sliceString(tester,4,5);
        System.out.println("4,5 produced: "+slicedString);
    }

    public static void testTryKeyLength() throws IOException {
        VigenereBreaker vb = new VigenereBreaker();

        FileReader fr = new FileReader("java2/week4/athens_keyflute.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        StringBuilder contentBuilder = new StringBuilder();
        List<String> lines = new ArrayList<>();
        while ( line != null){

            lines.add(line);
            lines.add("\n");
            contentBuilder.append(line);
            contentBuilder.append(" ");
            //contentBuilder.append(System.getProperty("line.separator"));
            line = reader.readLine();
        }
        String encrypted = String.valueOf(lines);
        String encrypted1 = contentBuilder.toString();
        int[] decryptKeys = vb.tryKeyLength(encrypted1, 5, 'e');
        System.out.println("Keys:");
        for (int index=0;index < decryptKeys.length;index++) {
            System.out.println(decryptKeys[index]);
        }
    }

    public static void  breakVigenereTester() throws IOException {
        VigenereBreaker vb = new VigenereBreaker();
        vb.breakVigenere();
    }
    public static void main(String[] args) throws IOException{
        System.out.println("======tetsSliceString=======");
        testSliceString();
        System.out.println("=======tryKeyLength=========");
        testTryKeyLength();
        System.out.println("=========breakVigenere==============");
        breakVigenereTester();
    }
}
