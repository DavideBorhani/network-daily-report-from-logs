package com.davideborhani.networkdailyreportfromlogs.dto;

public class RequestInfo {
    private long numOfRequests;
    private long bytesSent;

    public RequestInfo(long numOfRequests, long bytesSent) {
        this.numOfRequests = numOfRequests;
        this.bytesSent = bytesSent;
    }

    public long getNumOfRequests() {
        return numOfRequests;
    }

    public void setNumOfRequests(long numOfRequests) {
        this.numOfRequests = numOfRequests;
    }

    public long getBytesSent() {
        return bytesSent;
    }

    public void setBytesSent(long bytesSent) {
        this.bytesSent = bytesSent;
    }

    public final void incrementAndAddBytes(long bytesSent) {
        this.numOfRequests++;
        this.bytesSent += bytesSent;
    }
}
