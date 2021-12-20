package com.davideborhani.networkdailyreportfromlogs;

import com.davideborhani.networkdailyreportfromlogs.service.ReportService;

public class Main {

    public static void main(String[] args) {
        ReportService reportService = new ReportService();
        reportService.getReportFromRequests();
    }
}
