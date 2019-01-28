package com.java2.week3;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class Tester {

    public static void main(String[] args) throws IOException, ParseException {
        testLogEntry();
        testLogAnalyzer();
    }

    public static void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(),
                "example req1", 200, 500);
        System.out.println(le);

        LogEntry le2 = new LogEntry("1.2.100.40", new Date(),
                "example req2", 300, 400);
        System.out.println(le2);
    }

    public static void testLogAnalyzer() throws IOException, ParseException {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        int uniqueIPs = la.countUniqueIPs();
        la.printAll();
        System.out.println("There are " + uniqueIPs + " IPs");

        //la.printAllHigherThanNum(400);
        //System.out.println("above Q2");
        List<String> ipOneDay = la.uniqueIPVisitsOnDay("Sep 27");
        if (!ipOneDay.isEmpty()) {
            System.out.println("Size of the return on Exact date: "+ipOneDay.size());
            for (String ip : ipOneDay) {
                System.out.println(ip);
            }
        } else {
            System.out.println("there is No Ip in This Day");
        }

        int uniqueIpInRange = la.countUniqueIPsInRange(200,299);
        System.out.println("unique IP In Range-->: " + uniqueIpInRange);
    }

}
