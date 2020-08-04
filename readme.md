
To make the application working you will need to have the following environmental variables:
1. PORT (equals to 8080 if not specified)
DB credentials (I used postgres):
2. USERNAME
3. PASSWORD
4. URL (of the database)

------------------------------------------------------------------------------------------------------------------------

In order to get the list of customers you need to send the post request to "/customers" endpoint with parameter "data"
in the following JSON format:

{ "loan_value": 1000, "period": 6 } 

Values may be different*
Period is represented in months

The response is represented in JSON and contains the following:
1. "Status" variable: shows whether any customer was found according to the request or not. Equals to "OK" if any 
found or to "NOT OK" if none found.
2. "Customers" variable: contains the list of found customers by the specified criteria, sorted by payment overdue days 
amount in ascending order
------------------------------------------------------------------------------------------------------------------------

NOTE: I didn't manage to finish with authorization within given time, so I disabled security in the last commit
in order not to interrupt the app. And also I removed unused dependency in it.

