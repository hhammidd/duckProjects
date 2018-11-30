package com.java2.week3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
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

    /**
     * the number of times this IP address visited the website
     * @return
     */
    public HashMap<String, Integer> countVisitsPerIP(){

        HashMap<String,Integer> counts = new HashMap<>();
        for (LogEntry le: records){
            String ip = le.getIpAddress();
            if (! counts.containsKey(ip)){
                counts.put(ip,1);
            }else {
                counts.put(ip,counts.get(ip)+1);
            }
        }
        return counts;
    }

    public Integer mostNumberVisitsByIP(HashMap<String,Integer> countsMonth){
        Integer most=0;
        for (Integer v : countsMonth.values()){
            if(most <= v){
                most = v;
            }
        }
        return most;
    }

    public ArrayList<String> iPsMostVisits(HashMap<String,Integer> countsHashMap){
        ArrayList<String > mostVisitedIps = new ArrayList<>();
        //countsHashMap =countVisitsPerIP();
        int max = mostNumberVisitsByIP(countsHashMap);
        for (String element : countsHashMap.keySet()){
            if (max == countsHashMap.get(element)){
                mostVisitedIps.add(element);
            }
        }
        return mostVisitedIps;
    }

    public HashMap<String, ArrayList<String>> iPsForDays(){
        HashMap<String, ArrayList<String>> iPsForDay = new HashMap<>();
        for (LogEntry le: records){
            ArrayList<String> iPs = new ArrayList<>();
            String ipAddress = le.getIpAddress();
            String date = le.getAccessTime().toString().substring(4,10);

            if (!iPsForDay.containsKey(date)){
                iPs.add(ipAddress);
                iPsForDay.put(date,iPs);
            } else {
                ArrayList<String> currentIp = iPsForDay.get(date);
                currentIp.add(ipAddress);
                iPsForDay.put(date,currentIp);
            }
        }
        return iPsForDay;
    }

    public String dayWithMostIPVisits(HashMap<String,ArrayList<String>> countshatDay){
        String thatDay = "";
        countshatDay = iPsForDays();
        int max = 0;

        for (String thaDay: countshatDay.keySet()){
            ArrayList<String> iPs = countshatDay.get(thaDay);
            if (iPs.size() > max ){
                max = iPs.size();
                thatDay = thaDay;
            }
        }
        return thatDay;
    }

    // return the IP list with most visits on particular day.
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> eachday, String day) {
        ArrayList<String> ip = new ArrayList<String>();
        HashMap<String, Integer> eachip = new HashMap<String, Integer>();
        ArrayList<String> mostthatday = new ArrayList<String>();
        int mostnumber = 0;
        int currentnumber;
        for (String time: eachday.keySet()) {
            if (time.equals(day)) {
                ip = eachday.get(time);
            }
        }
        for (int k = 0; k < ip.size(); k++) {
            if (!eachip.containsKey(ip.get(k))) {
                eachip.put(ip.get(k), 1);
            }
            else eachip.put(ip.get(k), eachip.get(ip.get(k))+1);
        }
        mostthatday = iPsMostVisits(eachip);
        return mostthatday;
    }
}
