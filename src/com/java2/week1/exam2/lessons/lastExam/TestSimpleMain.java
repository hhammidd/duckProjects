package com.java2.week1.exam2.lessons.lastExam;

public class TestSimpleMain {
    public static void main(String[] args) {
        TestSimple testSimple = new TestSimple();
        testSimple.print();
    }

    public static class TestSimple{
        public void print() {
            Simple item = new Simple(3, "blue");
            System.out.println(item);
            System.out.println(item.mystery(5, "ho"));
        }
    }
}
