import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client{
    public void run() throws UnknownHostException,IOException{
        int port = 8010;
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address,port);
        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toSocket.println("Hello from socket"+socket.getLocalSocketAddress());
        String line = fromSocket.readLine();
        System.out.println("Response from socket is : "+line);
        toSocket.close();
        fromSocket.close();
        socket.close();
    }
    public static void main(String[] args) {
        Client singleThreaded = new Client();
        try{
            singleThreaded.run();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
