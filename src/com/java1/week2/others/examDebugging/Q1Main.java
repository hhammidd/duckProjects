/*
package com.java1.week2.others.examDebugging;

public class Q1Main {
    public static void main(String[] args) {
        Q1Main q = new Q1Main();
        q.test();
    }

    /**
     * Write a method that finds each occurrence of “abc_” in a String input
     * (where _ is a single character) and prints “bc_” for each such occurrence.
     * For example, findAbc(“abcdefabcghi”) should print:
     * findAbc(“abcdefabcghi”)
     * @param input
     */
/*
    public void findAbc(String input) {
        int length = input.length();

        System.out.println("length: " + length );
        int index = input.indexOf("abc");
        while (true) {
            if (index == -1) {
                break;
            }

            System.out.println("+1 is: " + index+1 + " ---- +4 is: " +input+4);
            //if (index >= input.length() - 3) {
                String found = input.substring(index + 1, index + 4);
                System.out.println(found);
                index = input.indexOf("abc", index + 4);
                System.out.println("bb " + input);
            //}
        }
    }
    public void test() {
        //no code yet
       // findAbc("abcdabc");
 findAbc("yabcyabc");
       // findAbc("abcd");
    }

}
*/