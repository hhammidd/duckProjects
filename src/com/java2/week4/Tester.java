package com.java2.week4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tester {

    public static void testCasearCipher() throws IOException {

        FileReader fr = new FileReader("java2/week4/titus-small.txt");
        BufferedReader reader = new BufferedReader(fr);
        List<String> lines = new ArrayList<>();
        String lineO = reader.readLine();
        while (lineO != null) {
            lines.add(lineO);
            lineO = reader.readLine();
        }

        System.out.println("======CaesarCipher======");
        CaesarCipher cc = new CaesarCipher(15);
        String encrypted = cc.encrypt(String.valueOf(lines));
        System.out.println("Encrypted message text:\n"+encrypted);

        String decrypted = cc.decrypt(encrypted);
        System.out.println("Decrypted message text:\n"+decrypted);

    }

    public static void testCaesarCrackerWithNoArgs() throws IOException {
        FileReader fr = new FileReader("java2/week4/titus-small_key5.txt");
        BufferedReader reader = new BufferedReader(fr);
        List<String> lines = new ArrayList<>();
        String lineO = reader.readLine();
        while (lineO != null) {
            lines.add(lineO);
            lineO = reader.readLine();
        }

        CaesarCracker cc = new CaesarCracker();
        String message = cc.decrypt(String.valueOf(lines));
        System.out.println("Decrypted message using no args for constructor:\n"+message);
    }

    public static void testCaesarCrackerWithArgs() throws IOException {
        FileReader fr = new FileReader("java2/week4/oslusiadas_key17.txt");
        BufferedReader reader = new BufferedReader(fr);
        List<String> lines = new ArrayList<>();
        String lineO = reader.readLine();
        while (lineO != null) {
            lines.add(lineO);
            lineO = reader.readLine();
        }

        CaesarCracker cc = new CaesarCracker('a');
        String message = cc.decrypt(String.valueOf(lines));
        System.out.println("Decrypted message using 'a' arg for constructor:\n"+message);
    }

    public static void testVigenereCipher() throws IOException {
        FileReader fr = new FileReader("java2/week4/titus-small.txt");
        BufferedReader reader = new BufferedReader(fr);
        List<String> lines = new ArrayList<>();
        String lineO = reader.readLine();
        while (lineO != null) {
            lines.add(lineO);
            lineO = reader.readLine();
        }
        int[] key = {17, 14, 12, 4};
        VigenereCipher vc = new VigenereCipher(key);
        String encrypted = vc.encrypt(String.valueOf(lines));
        String decrypted = vc.decrypt(encrypted);
        System.out.println("Vigenere cipher encrypted message:\n"+encrypted);
        System.out.println("Vigenere cipher decrypted message:\n"+decrypted);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("======1=CaesarCracker===========");
        testCasearCipher();
        System.out.println("======2=testCaesarCrackerWithNoArgs===========");
        testCaesarCrackerWithNoArgs();
        System.out.println("======3=testCaesarCrackerWithArgs===========");
        testCaesarCrackerWithArgs();
        System.out.println("======4=testVigenereCipher===========");
        testVigenereCipher();

    }
}
