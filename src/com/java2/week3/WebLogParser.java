package com.java2.week3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WebLogParser {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z", Locale.getDefault());
    private static String munchTo(StringBuilder sb, String delim) {
        int x = sb.indexOf(delim);
        if (x == -1) {
            x = sb.length();
        }
        String ans = sb.substring(0,x);
        sb.delete(0, x + delim.length());
        return ans;
    }

    public static LogEntry parseEntry(String log) throws ParseException {
        StringBuilder sb = new StringBuilder(log);

        //String ipAddress= log.substring(0, log.indexOf(" "));
        String ipAddress = munchTo(sb, " ");
        munchTo(sb, " ");
        munchTo(sb, " [");
        String dateStr = munchTo(sb, "] \"");
        Date accessTime = parseDate(dateStr);
        String request = munchTo(sb, "\" ");
        String statusCodeStr = munchTo(sb, " ");
        int statusCode = Integer.parseInt(statusCodeStr);
        String byteRetStr = munchTo(sb, " ");
        int byteReturned = Integer.parseInt(byteRetStr);

        LogEntry le = new LogEntry(ipAddress, accessTime, request, statusCode, byteReturned);
        return le;
    }

    private static Date parseDate(String dateStr) throws ParseException {
        return  dateFormat.parse(dateStr);
    }
}
