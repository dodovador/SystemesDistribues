import java.io.*;
import java.net.*;


public class Client implements Runnable{
    private static Socket socket = null;
    private static PrintWriter out = null;
    private static BufferedReader in = null;
    private static String reponse = ""; 

    public static void main (String[] args)
    {
        try
        {
            System.out.println("Demande de connexion");
            socket = new Socket("127.0.0.1",2009);
            System.out.println("Connexion établie avec le serveur");

            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            do
            {
                reponse = in.readLine();
                if(!reponse.equals("stop"))
                {
                    int n = Integer.parseInt(reponse);
                    System.out.println(isPair(n));
                }
            }
            while(!reponse.equals("stop"));

            out.println("j ai finis !");
            out.flush();


        }
        catch(IOException e)
        {
            System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
        }
    }

    public static int isPair(int n)
    {
        if( n % 2 == 0) return n;
        else return 0;
    }
}