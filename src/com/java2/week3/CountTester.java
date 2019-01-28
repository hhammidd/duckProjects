package com.java2.week3;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class CountTester {
    public static void testCounts() throws IOException, ParseException {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");

        System.out.println("======countVisitsPerIP========");
        HashMap<String,Integer> counts = la.countVisitsPerIP();
        System.out.println(counts);

        System.out.println("========mostNumberVisitsByIP=========");
        int mostNOVi = la.mostNumberVisitsByIP(counts);
        System.out.println("Most NO visited By IP: " + mostNOVi);

        System.out.println("========iPsMostVisits===========");
        ArrayList<String> iPsMostVisited = la.iPsMostVisits(counts);
        System.out.println("ip MOst Visited: " + iPsMostVisited);

        System.out.println("========iPsForDays=========");
        HashMap<String, ArrayList<String>> iPsForDay = la.iPsForDays();
        System.out.println(iPsForDay);

        System.out.println("===========dayWithMostIPVisits==============");
        String dayMostIp = la.dayWithMostIPVisits(iPsForDay);
        System.out.println(dayMostIp);

        System.out.println("========iPsWithMostVisitsOnDay==========");
        ArrayList<String> iPs = la.iPsWithMostVisitsOnDay(iPsForDay, "Sep 29");
        System.out.println("On that day ips were" + iPs) ;


    }

    public static void main(String[] args) throws IOException, ParseException {
        testCounts();
    }
}
