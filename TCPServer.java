import java.io.*;
import java.net.*;

public class TCPServer{
    public static void main(String[] args){
        try{
            
            ServerSocket serverSocket = new ServerSocket(9999);
            
            System.out.println("Waiting for client to connect.");
            
            Socket socket = serverSocket.accept();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream() , true);
            
            String message;
            while ((message = in.readLine()) != null){
                System.out.println("Client: " + message);
                out.println("Message received: " + message);
            }
            
            in.close();
            out.close();
            serverSocket.close();
            socket.close();
            
        }
        catch (IOException e){
            System.out.println("Wrong Happened");
        }
    }
}

