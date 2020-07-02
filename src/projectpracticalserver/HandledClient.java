/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpracticalserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


/**
 *
 * @author Ramez
 */
public class HandledClient extends Thread{
    Socket socket  ; ArrayList <Socket> clients = new ArrayList() ; String neo ; ServerSocket server;
    public HandledClient (Socket socket , ServerSocket server , ArrayList<Socket> clients ){this.socket = socket;  this.clients = clients; this.server = server;}
    @Override
    public void run (){
    try {
      
    DataInputStream dis = new DataInputStream (socket.getInputStream());
    DataOutputStream dos = new DataOutputStream (socket.getOutputStream());
    
    dos.writeUTF("enter your name");
    String name = dis.readUTF();
    if (name.contains("admin03555close"))
    {
    dos.writeUTF("Server Disconnected");
    dos.writeUTF("exit");
    dos.writeUTF("admin045555close");
    server.close();
    socket.close();
    
    }
    String x = name + " joined the chat room" ;
    
    String messages ;

  for (int i =0 ;i < clients.size() ; i ++)
  { Socket j = clients.get(i);
      Send s = new Send (j , x , "" );
  s.sendd();
  }
  neo = name;
  while (true){
      
        messages = dis.readUTF();
        for (int i = 0 ; i< clients.size() ; i++)
        {    
        Socket l = clients.get(i);
        Send s = new Send ( l , messages , name );
        s.sendd();
        neo = s.name;
        }
       name = neo ;
  }
    }
    
    catch (IOException ex){
    
    
    
    }
    }
}
