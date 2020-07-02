/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpracticalserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Ramez
 */
public class Send {
    Socket socket ;  String messages  , name  , oldname;
    public Send (Socket socket , String messages , String name){this.socket=socket ; this.messages = messages ; this.name = name; this.oldname = name; }
    public void sendd (){
    
    try{
    DataInputStream dis = new DataInputStream (socket.getInputStream());
    DataOutputStream dos = new DataOutputStream (socket.getOutputStream());
    
     if (messages.startsWith("rename"))
            {   oldname = name ;
                messages = messages .replaceFirst("rename", "      ");
             
               messages = messages.trim();
                name = messages ;
                dos.writeUTF(oldname +  " changed his name to " + name );
            }
    else if (messages.startsWith("red"))
    {
        messages = messages .replaceFirst("red", "   ");
             
               messages = messages.trim();
       dos.writeUTF("red"+ name +  " : " + messages);
       
    }
      else if (messages.startsWith("exit"))
    {
       
       dos.writeUTF("exit" + name );
       
    }
    else
         dos.writeUTF(name +  " : " + messages);
    }
    catch (IOException ex){}
    }
    
}
