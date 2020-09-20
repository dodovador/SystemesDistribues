import java.io.*;
import java.net.*;


public class Manager{ 
    private static ServerSocket managerSocket = null;
    private static Socket socket = null;
    private static PrintWriter out = null;
    private static BufferedReader in = null;
    private static int n = 0;

    public static void main (String[] args)
    {
        try
        {
            managerSocket = new ServerSocket(2009);
            socket = managerSocket.accept();

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            System.out.println("Quelqu'un souhaite se connecter");
            
            while(n < 5)
            {
                out.println(n);
                out.flush();
                n += 1;
            }

            out.println("stop");
            out.flush();

            System.out.println(in.readLine());
        }
        catch(IOException e)
        {
            System.err.println("Le port "+managerSocket.getLocalPort()+" Est déjà utilisé !");
        }
    }
}