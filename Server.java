import java.io.* ;
import java.net.* ;

public class Server{
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(9999);

            System.out.println("Waiting for client..");

            Socket socket = serverSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream() , true);

            String message ;
            String m;

            while(true){
                System.out.println("Client: ");
                m = in.readLine();
                System.out.println(m);
                System.out.println("Enter the message: ");
                message = in2.readLine();
                out.println(message);
                out.flush();
                if (m == "end"){
                    break;
                }

            }
            in.close();
            in2.close();
            out.close();
            serverSocket.close();
            socket.close();
        }
        catch(IOException e){
            System.out.println("hm.");
        }
    }
}