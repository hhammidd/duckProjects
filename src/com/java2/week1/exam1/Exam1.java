package com.java2.week1.exam1;

public class Exam1 {
    public static void main(String[] args) {
        boolean a = isAorE('d');
        System.out.println(a);
    }
    public static boolean isAorE (char ch) {
        if (ch == 'a' || ch == 'e') {
            return true;
        }
        return false;
    }
}
