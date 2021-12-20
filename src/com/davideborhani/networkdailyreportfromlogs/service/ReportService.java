package com.davideborhani.networkdailyreportfromlogs.service;

import com.davideborhani.networkdailyreportfromlogs.dto.AddressWithInfo;
import com.davideborhani.networkdailyreportfromlogs.dto.AddressesWithInfoAndTotals;
import com.davideborhani.networkdailyreportfromlogs.dto.RequestInfo;
import com.davideborhani.networkdailyreportfromlogs.utils.Constants;

import java.io.*;
import java.util.*;

public class ReportService {
    public void getReportFromRequests() {
        AddressesWithInfoAndTotals addressesWithInfoAndTotals = getRequestsData(Constants.getInputFile());
        List<AddressWithInfo> list = getReportData(addressesWithInfoAndTotals.getTotalRequests(),
                addressesWithInfoAndTotals.getTotalBytes(), addressesWithInfoAndTotals.getAddressesWithInfo());
        System.out.println("[INFO]Requests per IP Address not sorted");
        list.forEach(addressWithInfo -> System.out.println(addressWithInfo));
        System.out.println("[INFO]Requests per IP Address sorted by num of requests");
        list.sort(Comparator.comparing(AddressWithInfo::getNumOfRequests).reversed());
        list.forEach(addressWithInfo -> System.out.println(addressWithInfo));
        getReport(list);
    }

    private AddressesWithInfoAndTotals getRequestsData(String input) {
        long totalRequests = 0;
        long totalBytes = 0;
        Map<String, RequestInfo> addressesWithInfo = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            String line = "";
            while (((line = bufferedReader.readLine()) != null)) {
                String[] values = line.split(";");
                if (values[2] != null && values[2].equals("200") &&
                        values[1] != null && values[1].matches("^\\d+$") &&//regex byte
                        values[3] != null && !values[3].isEmpty()) {
                    Long bytes = Long.parseLong(values[1]);
                    if (addressesWithInfo.get(values[3]) == null) {
                        addressesWithInfo.put(values[3], new RequestInfo(1, bytes));
                    } else {
                        addressesWithInfo.get(values[3]).incrementAndAddBytes(bytes);
                    }
                    totalRequests++;
                    totalBytes += bytes;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("[ERROR]File with path " + input + " not found");
        } catch (IOException e) {
            System.out.println("[ERROR]IOException while reading file " + input);
        }
        return new AddressesWithInfoAndTotals(totalRequests, totalBytes, addressesWithInfo);
    }

    private List<AddressWithInfo> getReportData(long totalRequests, long totalBytes,
                                                Map<String, RequestInfo> addressesWithInfo) {
        List<AddressWithInfo> list = new ArrayList<>();
        if (!addressesWithInfo.isEmpty()) {
            for (Map.Entry<String, RequestInfo> entry : addressesWithInfo.entrySet()) {
                double percentageTotalBytes = (double) (entry.getValue().getBytesSent() * 100) / totalBytes;
                double percentageTotalRequest = (double) (entry.getValue().getNumOfRequests() * 100) / totalRequests;
                list.add(new AddressWithInfo(
                        entry.getKey(), percentageTotalRequest, percentageTotalBytes,
                        entry.getValue().getNumOfRequests(), entry.getValue().getBytesSent()
                ));
            }
        }
        return list;
    }

    private void getReport(List<AddressWithInfo> list) {
        String output = Constants.getOutputFile();
        try (PrintWriter writer = new PrintWriter(output, "UTF-8")) {
            for (AddressWithInfo addressWithInfo : list) {
                writer.println(addressWithInfo.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("[ERROR]An error occurred while writing file " + output);
        } catch (UnsupportedEncodingException e) {
            System.out.println("[ERROR]The Character Encoding is not supported");
        }
    }
}
