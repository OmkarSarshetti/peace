import java.io.* ;
import java.net.* ;

public class Client{
    public static void main(String[] args){
        try{
            Socket socket = new Socket("localhost" , 9999);

            System.out.println("Connected...");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream() , true);

            String clientmessage;
            String m;

            while(true){
                System.out.println("Enter the message: ");
                clientmessage = in2.readLine();
                out.println(clientmessage);
                System.out.println("Server: ");
                m = in.readLine();
                System.out.println(m);
                if (m == "end"){
                    break;
                }
            }
            socket.close();
            in.close();
            in2.close();
            out.close();
  
        }
        catch(IOException e){
            System.out.println("hm.");
        }
    }
}