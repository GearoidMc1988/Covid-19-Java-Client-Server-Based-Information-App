/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.List;



public class ProjectClient {

    
//    private static ObjectOutputStream objOutSteam;
//    private static ObjectInputStream objInSteam;
    
    public static void main(String[] args) throws ClassNotFoundException {
        try {

            Scanner scanner = new Scanner(System.in);

            // Create a socket to connect to the server
         
            Socket connectToServer = new Socket("localhost", 8000);

            // Create an input stream to receive data from the server
            //DataInputStream isFromServer = new DataInputStream(connectToServer.getInputStream());

            // Create an output stream to send data to the server
            DataOutputStream osToServer = new DataOutputStream(connectToServer.getOutputStream());

            
            ObjectInputStream FromServer = new ObjectInputStream(connectToServer.getInputStream());
            
            
            // Continuously send options and receive results from the server
            
            
       
            
            int app = 0;
           do {
                
                System.out.println("Option 1: Get information based on country code and date \n");
                System.out.println("Option 2: Get information based on country code limited by the limit entered \n");
                System.out.println("Option 3: List of countries between 2 dates entered and country code\n");
                System.out.println("Option 4: Exit Application \n");
                //List<Incidence> lists;
              
                int id= 0;
                boolean isNumber;
                
                
                
                
                do {                
                if(scanner.hasNextInt()){
                id = scanner.nextInt();
                isNumber = true;
                }else{
                    System.out.println("Please enter a number between 1 & 4");
                    isNumber = false;
                    scanner.next();
                }
                } while(!(isNumber));
               

                        osToServer.writeInt(id);
                        osToServer.flush();
                
                
                switch(id){
                
                    case 1:
                        
                   
                        
                        System.out.println("Please enter a country code");
                        String countryCode = scanner.next();
                 
                        if(ErrorHandler.countryCodeValidator(countryCode) == false){
                            countryCode = "Error";
                            osToServer.writeUTF(countryCode);
                            osToServer.flush();
                        break;
                        }
                        
                        osToServer.writeUTF(countryCode);
                        osToServer.flush();
                   
                        System.out.println("Please enter the date in the format YYYY/MM/DD");
                        String Date = scanner.next();
                      
                        if(ErrorHandler.dateValidator(Date) == false){
                            Date = "Error";
                            osToServer.writeUTF(Date);
                            osToServer.flush();
                        break;
                        }
                        
                        osToServer.writeUTF(Date);
                        osToServer.flush();
                        
                      
                        List<Incidence> lists = (List<Incidence>) FromServer.readObject();
                        if(lists.isEmpty()){
                            System.out.println("No records found");    
                        }else
                        {
                        lists.forEach((message) -> System.out.println(message.toString()));
                        }

                        break;
                        
                    case 2:
                        int count = 0;
                        System.out.println("Please enter a country code");
                        countryCode = scanner.next();
                          if(ErrorHandler.countryCodeValidator(countryCode) == false){
                            countryCode = "Error";
                            osToServer.writeUTF(countryCode);
                            osToServer.flush();
                        break;
                        }
                        osToServer.writeUTF(countryCode);
                        osToServer.flush();
                        
                        System.out.println("Please enter a search result limit");
                        
  
                do {
                if(scanner.hasNextInt()){
                int Limit = scanner.nextInt();
                isNumber = true;
                 osToServer.writeInt(Limit);
                 osToServer.flush();
                }else{                
                    count++;
                    if(count == 3){
                    System.out.println("You have entered an incorrect Limit 3 times\n");
                    System.out.println("Returning to Main Menu");
                   break;
                    }
  
                    else{
                    System.out.println("Please enter a number");
                    }
                    isNumber = false;
                    scanner.next();
                }
                } while(!(isNumber));
                        if(count == 3){
                            break;
                        }

                        lists = (List<Incidence>) FromServer.readObject();
                        
                           if(lists.isEmpty()){
                            System.out.println("No records found");
                          
                        }else
                        {
                        lists.forEach((message) -> System.out.println(message.toString()));
                        }
                        break;
                        
                    case 3:
                        
                        System.out.println("Please enter a country code");
                        countryCode = scanner.next();
                        
                          if(ErrorHandler.countryCodeValidator(countryCode) == false){
                            countryCode = "Error";
                            osToServer.writeUTF(countryCode);
                            osToServer.flush();
                        break;
                        }
                        
                        osToServer.writeUTF(countryCode);
                        osToServer.flush();
                        
                        System.out.println("Please enter a start date");
                        String startDate = scanner.next();
                          if(ErrorHandler.dateValidator(startDate) == false){
                            startDate = "Error";
                            osToServer.writeUTF(startDate);
                            osToServer.flush();
                        break;
                        }
                        
                        
                        
                        osToServer.writeUTF(startDate);
                        osToServer.flush();
                        
                        
                        System.out.println("Please enter an end date");
                        String endDate = scanner.next();
                         if(ErrorHandler.dateValidator(endDate) == false){
                            endDate = "Error";
                            osToServer.writeUTF(endDate);
                            osToServer.flush();
                        break;
                        }
                        
                        osToServer.writeUTF(endDate);
                        osToServer.flush();
                      
                        lists = (List<Incidence>) FromServer.readObject();
                       
                        
                             if(lists.isEmpty()){
                            System.out.println("No records found");    
                        }else
                        {
                        lists.forEach((message) -> System.out.println(message.toString()));
                        }
                        
                        
                        break;
                    case 4:
                        System.out.println("You are now exiting the application");
                       app = -1;
                        break;
                  
                    }
                            

            }  while (app != -1);//end while
            
        }//end try
        catch (IOException ex) {
            
            System.err.println(ex);
        }//end catch
    }//end main
}//end class