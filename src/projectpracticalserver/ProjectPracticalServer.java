/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectpracticalserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


/**
 *
 * @author Ramez
 */
public class ProjectPracticalServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 ArrayList <Socket>clients = new ArrayList ();
        try {
       
       ServerSocket server = new ServerSocket (9393);
       while (! server.isClosed())
       try { 
           Socket socket = server.accept();
           clients.add(socket);
       HandledClient t1 = new HandledClient (socket , server , clients);
       t1.start();
   
       }
            catch (IOException ex){}
   }
   catch (IOException ex){}
    }
    
}
