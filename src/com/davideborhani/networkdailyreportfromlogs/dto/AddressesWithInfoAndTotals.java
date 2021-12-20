package com.davideborhani.networkdailyreportfromlogs.dto;

import java.util.Map;

public class AddressesWithInfoAndTotals {
    private long totalRequests;
    private long totalBytes;
    private Map<String, RequestInfo> addressesWithInfo;

    public AddressesWithInfoAndTotals(long totalRequests, long totalBytes, Map<String, RequestInfo> addressesWithInfo) {
        this.totalRequests = totalRequests;
        this.totalBytes = totalBytes;
        this.addressesWithInfo = addressesWithInfo;
    }

    public long getTotalRequests() {
        return totalRequests;
    }

    public void setTotalRequests(long totalRequests) {
        this.totalRequests = totalRequests;
    }

    public long getTotalBytes() {
        return totalBytes;
    }

    public void setTotalBytes(long totalBytes) {
        this.totalBytes = totalBytes;
    }

    public Map<String, RequestInfo> getAddressesWithInfo() {
        return addressesWithInfo;
    }

    public void setAddressesWithInfo(Map<String, RequestInfo> addressesWithInfo) {
        this.addressesWithInfo = addressesWithInfo;
    }
}
