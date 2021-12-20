# network-daily-report-from-logs
##Create a file containing the traffic data per IP address

###Implement a method in order to produce the following daily report: /reports/ipaddr.csv
It must be a text/csv file containing the traffic data per IP Address.
Each rows must have the following fields :
1. IP Address
2. Number of requests
3. Percentage of the total amount of requests
4. Total Bytes sent
5. Percentage of the total amount of bytes
The data set must be sorted by the number of requests(DESC).
###The source data for your report is stored in the file /logfiles/requests.log
where each row (record) contains the following semicolon-separated values:
1. TIMESTAMP: the moment when the event occurred.
2. BYTES: the number of bytes sent to a client.
3. STATUS: HTTP response status.
4. REMOTE_ADDR: IP address of the client.
####Exclude from your report all the lines in the source file where the STATUS is different from “OK” ( RFC 2616).
