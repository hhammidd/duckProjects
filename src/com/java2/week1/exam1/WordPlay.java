package com.java2.week1.exam1;

public class WordPlay {
    public static void main(String[] args) {
        char ch = 'o';
        boolean isVowelOrNot = isVowel(ch);
        System.out.println(isVowelOrNot);

        String phrase = "Hello World";
        String replaceVowelsOk = replaceVowels(phrase ,'*');



    }

    private static String replaceVowels(String phrase, char ch) {
        String newPhrase = "";
        for (int i = 0; i<phrase.length() ;i++ ){
            char c = phrase.charAt(i);
            if (isVowel(c)){
                newPhrase += ch ;
            } else {
                newPhrase += c;
            }
        }
       return phrase;
    }

    private static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' ||ch == 'u' ){
            return true;
        }else
            return false;
    }
}
