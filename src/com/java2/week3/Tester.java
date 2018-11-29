package com.java2.week3;

import java.util.Date;

public class Tester {

    public static void main(String[] args) {
        testLogEntry();
    }

    public static void testLogEntry(){
        LogEntry le = new LogEntry("1.2.3.4", new Date(),
                "example req1", 200, 500);
        System.out.println(le);

        LogEntry le2 = new LogEntry("1.2.100.40", new Date(),
                "example req2", 300, 400);
        System.out.println(le2);
    }


}
