/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package myclientsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gerdoc
 */
public class MyClientSocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Socket socket = null;
        PrintWriter printWriter= null;
        BufferedReader bufferedReader = null;
        String ip = "127.0.0.1";
        int port = 9999;
        String msgWrite = "hola gerdoc1";
        String msgRead = null;
        try 
        {    
            socket = new Socket(ip, port );
            printWriter = new PrintWriter(socket.getOutputStream( ), true );
            bufferedReader = new BufferedReader(new InputStreamReader( socket.getInputStream( ) ) );
            printWriter.println(msgWrite );
            msgRead = bufferedReader.readLine( );
            Logger.getLogger(MyClientSocket.class.getName( ) ).log(Level.INFO, "--------------------" );
            Logger.getLogger(MyClientSocket.class.getName( ) ).log(Level.INFO, msgRead );
            Logger.getLogger(MyClientSocket.class.getName( ) ).log(Level.INFO, "--------------------" );
            bufferedReader.close( );
            printWriter.close( );
            socket.close( );
            Logger.getLogger(MyClientSocket.class.getName( ) ).log(Level.INFO, "End" );
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(MyClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
