import java.io.*;
import java.net.*;
import java.util.*;

public class IP{
    public static void main(String[] args){
        
        System.out.println("1.Host Name \n2.Ip Address");
        System.out.println("Enter your Choice:");

        Scanner ch = new Scanner(System.in);
        int c = ch.nextInt();
        Scanner name = new Scanner(System.in);
        String n = new String();
        if (c==1){
            System.out.println("Enter the hostname: ");
            n = name.nextLine();
        }
        else if (c==2){
            System.out.println("Enter the IP address: ");
            n = name.nextLine();
        }
        else{
            System.out.println("Wrong Input/");

        }
        try{
            InetAddress address = InetAddress.getByName(n);
            System.out.println(address.getHostAddress());
            System.out.println(address.getHostName());
            System.out.println(address.toString());
        }
        catch(UnknownHostException ex){
            System.out.println("Not able to find");
        }

    }
}