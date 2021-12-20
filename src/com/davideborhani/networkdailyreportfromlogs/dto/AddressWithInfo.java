package com.davideborhani.networkdailyreportfromlogs.dto;

public class AddressWithInfo extends RequestInfo{
    private String ipAddress;
    private double percentageTotalRequest;
    private double percentageTotalBytes;

    public AddressWithInfo(String ipAddress, double percentageTotalRequest, double percentageTotalBytes,
                           long numOfRequests, long bytesSent) {
        super(numOfRequests, bytesSent);
        this.ipAddress = ipAddress;
        this.percentageTotalRequest = percentageTotalRequest;
        this.percentageTotalBytes = percentageTotalBytes;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public double getPercentageTotalRequest() {
        return percentageTotalRequest;
    }

    public void setPercentageTotalRequest(double percentageTotalRequest) {
        this.percentageTotalRequest = percentageTotalRequest;
    }

    public double getPercentageTotalBytes() {
        return percentageTotalBytes;
    }

    public void setPercentageTotalBytes(double percentageTotalBytes) {
        this.percentageTotalBytes = percentageTotalBytes;
    }

    @Override
    public String toString() {
        return this.getIpAddress() + "," +
                this.getNumOfRequests() + "," +
                this.getPercentageTotalRequest() + "," +
                this.getBytesSent() + "," +
                this.getPercentageTotalBytes();
    }
}
