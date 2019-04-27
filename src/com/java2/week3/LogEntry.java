package com.java2.week3;

import java.util.Date;

public class LogEntry {
    private String ipAddress;
    private Date accessTime;
    private String request;
    private int statusCode;
    private int bytesReturned;



    public String getIpAddress() {
        return ipAddress;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getRequest() {
        return request;
    }

    public LogEntry(String ipAddress, Date accessTime, String request, int statusCode, int bytesReturned) {
        this.ipAddress = ipAddress;
        this.accessTime = accessTime;
        this.request = request;
        this.statusCode = statusCode;
        this.bytesReturned = bytesReturned;
    }

    public int getBytesReturned() {
        return bytesReturned;
    }

    @Override
    public String toString() {
        return ipAddress + " " + accessTime + " "
                +request + " " + statusCode +
                 " " + bytesReturned;
    }
}
