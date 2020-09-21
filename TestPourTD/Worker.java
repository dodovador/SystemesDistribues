import java.io.*;
import java.net.*;


public class Worker extends Thread{
    private static Socket socket = null;
    private static ObjectInputStream workerInputStream = null;
    private static Objet objet = null;

    public static void main (String[] args)
    {
        try
        {
            System.out.println("Demande de connexion");
            socket = new Socket("127.0.0.1",2009);
            System.out.println("Connexion établie avec le serveur");

            workerInputStream = new ObjectInputStream(socket.getInputStream());
            objet = (Objet)workerInputStream.readObject();

            System.out.println(objet.getPrix());

        }
        catch(IOException e)
        {
            System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
        }
        catch(ClassNotFoundException c)
        {
            System.err.println("classe non trouve");
        }
    }

    public static int isPair(int n)
    {
        if( n % 2 == 0) return n;
        else return 0;
    }
}