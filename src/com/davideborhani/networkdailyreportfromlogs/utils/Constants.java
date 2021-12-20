package com.davideborhani.networkdailyreportfromlogs.utils;

public class Constants {
    public static final String path = "src\\com\\davideborhani\\networkdailyreportfromlogs\\resource\\";
    public static final String requests = "logfiles\\requests.log";
    public static final String report = "reports\\ipaddr.csv";
    public static final String getInputFile(){
        return path+ requests;
    }
    public static final String getOutputFile(){
        return path+ report;
    }
}
