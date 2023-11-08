import java.io.*;
import java.net.*;

public class TCPClient{
    public static void main(String[] args){
        try{
        Socket socket = new Socket("localhost" , 9999);
        
        System.out.println("Connected");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream() , true);
        
        out.println("Hello message from client.");
        
        String message = in.readLine();
        System.out.println("Server: " + message);
        
        in.close();
        out.close();
        socket.close();
        }
        catch (IOException e){
            System.out.println("something wrong happened");
        }
        
    }
}