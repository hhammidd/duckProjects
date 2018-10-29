package com.java1.week2.others.examDebugging2;



public class Exam2Main {
    public static void main(String[] args) {
        Exam2Main q = new Exam2Main();
        q.test();
    }


    public void findAbc(String input){
        int index = input.indexOf("abc");
        while (true){
            if (index == -1 || index >= input.length() - 3){
                break;
            }
            System.out.println("index: " + index);
            String found = input.substring(index+1, index+4);
            System.out.println(found);
            //index = input.indexOf("abc",index+4);
            index = input.indexOf("abc",index+3);
            System.out.println("index after updating " + index);
        }
    }

    public void test() {
        //no code yet
        // findAbc("abcdabc");
        //            >                             >  >
        //            01234567890123456789012345678901234567890123
        //String str = "abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj";
        String str = "abcabcabcabca”" ;
        findAbc(str);
        // findAbc("abcd");
    }
}
