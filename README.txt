Gearoid McNamara/ K00243098 / Software Development/ Year 3/ Group A

This is a Java Menu Driven Application that will take information from the client or client's and transfer
it to the server which will process this information and send it back to the client. 

This application is multithreaded and can handle multible clients at the same time. 
***********************************************************************************************
Requirements:
NetBeans IDE 8.2
Jar Files:
commons.dbutils-1.7.jar
commons.dbutils-1.7-javadoc.jar
commons.dbutils-1.7-sources.jar
commons.dbutils-1.7-tests.jar
commons.dbutils-1.7-tests-sources.jar
Xampp with covid19_by_country database (no changes have been made to the database)
***********************************************************************************************
Application Core Functionality:

The end user (client) can enter a Country Code and a Date. This data will be transmitted to the
server, where it will search the database and return the matching record to the client. For
situations where there are multiple records with the same date and country just return the
first record found.

The end user (client) can enter a Country Code along with a starting and ending data. This data
will be transmitted to the server, where it will search the database and return all records
that match the country code and occur within the specified date range.

The end user (client) can enter a Country Code and an integer value (limit). This data will be
transmitted to the server, where it will search the database and return the most recent
records for the specified country limited to the number entered based on the date.

If no records are found in the database the application will output a message to the end user stating so and return the client back to the Main Menu.
All records returned as displayed from a list in neat fashion using \n. this allows for data to read easily. 
Client side has a menu that invites user to select an option to send to the server.
***********************************************************************************************
Application Additional Functionality:
Created a class that is responsible for error handling.
dateValidator function:
Function will ensure that all dates entered by client will be formatted correctly before been transmitted to the server.
If a date does not meet the correct format then the client will be notified and taken back to the main menu.

countryCodeValidator function:
Function will ensure that the correct country code format is been entered by checking if the charactres in the string are 3 chars in length.
If they are not then the client will be notified and taken back to the main menu. 

I have additional error handling set up.
When the program is run it will ask the Client to enter a number relating to the options that are displayed. 
If the Client enters any information that does not correspond with the option menu the Client will be notified and asked to enter a value between 1 & 4.


Option 2 allows the user to enter a limit to the number of searches they want back. If anything but an int is entered into the app at this stage
the client will be notified and can try again to enter the Limit. If the Limit is entered incorrectly 3 times. Client will be notified and taken back to the Main Menu.

***********************************************************************************************
How to User:
Make sure Xampp is open and Apache and MySQL are active. This applicatoinjs is running off port number: 3306 as per Xampp.

To run the application you must first start the server. Right click on ProjectServer.java file and click run.
You will then get ba display confirming server is set up and is awaiting connections. 
Then right click on the ProjectClient.java file and click on run and you will be presented with a manu with 4 options. 
Options 1 to 3 are the the questions included int he spec. Option 4 will exit the application. 
***********************************************************************************************

