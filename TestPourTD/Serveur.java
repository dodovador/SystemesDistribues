import java.io.*;
import java.net.*;


public class Serveur{ 
    private static ServerSocket serveurSocket = null;
    private static Socket socket = null;
    private static PrintWriter out = null;
    private static BufferedReader in = null;
    private static int n = 0;

    public static void main (String[] args)
    {
        try
        {
            serveurSocket = new ServerSocket(2009);
            socket = serveurSocket.accept();

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            System.out.println("Quelqu'un souhaite se connecter");
            
            while(n < 100)
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
            System.err.println("Le port "+serveurSocket.getLocalPort()+" Est déjà utilisé !");
        }
    }
}