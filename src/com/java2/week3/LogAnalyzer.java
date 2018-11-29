package com.java2.week3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        records = new ArrayList<LogEntry>();
    }

    public void readFile(String fileName) throws IOException, ParseException {
        FileReader fr = new FileReader("java2/week3/" + fileName);
        BufferedReader reader = new BufferedReader(fr);
        String lineO = reader.readLine();
        List<String> lines = new ArrayList<>();
        while ( lineO != null){
            if (!(lineO.isEmpty())){
                lines.add(lineO);
                // TODO make this method
                records.add(WebLogParser.parseEntry(lineO));

            }
            lineO = reader.readLine();
        }
        
    }

    public void printAll() {
        for (LogEntry le: records){
            System.out.println(le);
        }
    }

    public int countUniqueIPs(){
        ArrayList<String> uniqueIPs = new ArrayList<>();

        for (LogEntry le : records){
            String ipAdd = le.getIpAddress();
            if (!uniqueIPs.contains(ipAdd)){
                uniqueIPs.add(ipAdd);
            }
        }
        return uniqueIPs.size();
    }

    /**
     * This method should examine all the web log entries in records and print
     * those LogEntrys that have a status code greater than num.
     * @param num	minimal status code to be printed
     */
    public void printAllHigherThanNum(int num){
        // examine StatusCode of record is grater than num
        System.out.printf("Status>%d:\n",num);
        for (LogEntry le: records){
            int statuseCode = le.getStatusCode();
            if (statuseCode > num){
                System.out.println(le);
            }
        }
    }

    public ArrayList<String> uniqueIPVisitsOnDay(String someday){
        //examples are “Dec 05” and “Apr 22”---> someDay  "MMM DD"
        System.out.printf("Vist on Date: %s are list Below: \n",someday);
        ArrayList<String> ipsOneDay = new ArrayList<>();

        for (LogEntry le : records){
            String leTime = le.getAccessTime().toString();
            String leIP = le.getIpAddress();
            if (leTime.indexOf(someday)!=-1)
                if (!ipsOneDay.contains(leIP))
                    ipsOneDay.add(leIP);
        }
        return ipsOneDay;
    }

    public int countUniqueIPsInRange(int low, int high){
        ArrayList<String> unique = new ArrayList<String>();
        for (LogEntry le : records) {
            String ip = le.getIpAddress();
            if (!unique.contains(ip)) {
                int stat = le.getStatusCode();
                if (stat >= low && stat <= high)
                    unique.add(ip);
            }
        }
        return unique.size();
    }
}
