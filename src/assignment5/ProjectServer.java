/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.List;



public class ProjectServer {
    
      public static void main(String[] args) throws SQLException, IOException {
       
            try {

            System.out.println("Server started and awaiting connections....");
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            int clientNo = 1;
            
            while(true) {
            // Start listening for connections on the server socket
            Socket connectToClient = serverSocket.accept();

            //print the new connect number on the console.
            System.out.println("Start thread for client " + clientNo);
            
            //Find the clients host name and ip address      
            InetAddress clientInetAddress = connectToClient.getInetAddress();
            System.out.println("Clients host name is " + clientInetAddress.getHostName());
            System.out.println("Clients IP address is " + clientInetAddress.getHostAddress());
            
        // Create a new thread for the connection
        HandleAClient thread = new HandleAClient(connectToClient);
        
        thread.start();// Start the new thread
        clientNo++;// Increment clientNo
      }
    }
           catch(IOException ex)  {
      System.err.println(ex);
    }
  }
}

class HandleAClient extends Thread {

    
 private final Socket connectToClient; // A connected socket

  /**Construct a thread*/
  public HandleAClient(Socket socket)  {
    connectToClient = socket;
  }

  /**Implement the run() method for the thread*/

  public void run() {
    try   {
// Create an input stream to get data from the client
      DataInputStream isFromClient = new DataInputStream(connectToClient.getInputStream());

      ObjectOutputStream toClient = new ObjectOutputStream(connectToClient.getOutputStream());
                  



             //Continuously read from the client and process it and send result back to the client
            while (true) {
               IncidenceDB.doConnection();
               
               int id = isFromClient.readInt();
      switch (id){
      
          case 1:
              String countryCode = isFromClient.readUTF();
              System.out.println("country Code recieved from client " + countryCode);
              if("Error".equals(countryCode))
              {
                  break;
              }
              String date = isFromClient.readUTF();
              System.out.println("Date recieved from client: " + date);
                if("Error".equals(date))
              {
                  break;
              }
              
              
              System.out.println("Covid Rate for Country on date");
              System.out.println();
              
              List<Incidence> lists = IncidenceDB.getIncidenceByDate(countryCode, date);

                    toClient.writeObject(lists);
                    toClient.flush();

              break;
              
          case 2:
              
              countryCode = isFromClient.readUTF();
              System.out.println("country Code recieved from client " + countryCode);
               if("Error".equals(countryCode))
              {
                  break;
              }
              int limit = isFromClient.readInt();
              System.out.println("Limit recieved from client: " + limit);
              
              System.out.println("Covid Rate for Country on date");
              System.out.println();
              
              lists = IncidenceDB.getAllIncidence(countryCode, limit);

                        toClient.writeObject(lists);

                        toClient.flush();             
              break;
              
          case 3:
              
              countryCode = isFromClient.readUTF();
              System.out.println("country Code recieved from client " + countryCode);
               if("Error".equals(countryCode))
              {
                  break;
              }
              String startDate = isFromClient.readUTF();
              System.out.println("start Date recieved from client: " + startDate);
                if("Error".equals(startDate))
              {
                  break;
              }
              String endDate = isFromClient.readUTF();
              System.out.println("end Date recieved from client: " + endDate);
                  if("Error".equals(endDate))
              {
                  break;
              }
              System.out.println("Covid Rate for Country between " + startDate + " and " + endDate );
              System.out.println();
              
              lists = IncidenceDB.getIncidenceByStartAndEndDate(countryCode, startDate, endDate);

                        toClient.writeObject(lists);

                        toClient.flush();
              break;
      
      
      }

           }//end while
         } catch (IOException | SQLException ex) {
             System.err.println("No Records Found");
   
         //System.err.println(ex);
         }
        //end catch
        //end catch
           finally {
           IncidenceDB.closeConnection();
       }      
      }     
    }



