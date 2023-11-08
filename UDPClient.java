import java.io.*;
import java.net.*;

public class UDPClient{
    public static void main(String[] args){
        try{
            
            DatagramSocket socket = new DatagramSocket();
            byte[] send = "Hello from client".getBytes();
            InetAddress saddress = InetAddress.getByName("localhost");
            int port = 9999;
            DatagramPacket sendd = new DatagramPacket(send , send.length , saddress , port);
            socket.send(sendd);
            
            byte[] rdata = new byte[1024];
            DatagramPacket redata = new DatagramPacket(rdata , rdata.length);
            socket.receive(redata);
            
            String servermessage = new String(redata.getData());
            System.out.println("Server: " + servermessage);
            
            socket.close();
            
        }
        catch(IOException e){
                System.out.println("Hm");
        }
    }
}