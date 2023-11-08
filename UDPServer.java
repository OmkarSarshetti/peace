import java.io.*;
import java.net.*;

public class UDPServer{
    public static void main(String[] args){
        try{
            
            DatagramSocket socket = new DatagramSocket(9999);
            byte[] rdata = new byte[1024];
            DatagramPacket recpacket = new DatagramPacket(rdata , rdata.length);
            
            socket.receive(recpacket);
            
            String clientmessage = new String(recpacket.getData());
            
            System.out.println("Client: " + clientmessage);
            
            InetAddress caddress = recpacket.getAddress();
            int port = recpacket.getPort();
            
            String sendmessage = "Received Client" + clientmessage ;
            byte[] sendb = sendmessage.getBytes();
            
            DatagramPacket sendc = new DatagramPacket(sendb , sendb.length , caddress , port);
            
            socket.send(sendc);
            
            socket.close();
            
        }
        catch(IOException e){
            System.out.println("hm");
        }
    }
}