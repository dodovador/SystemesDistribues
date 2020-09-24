import java.io.*;
import java.net.*;


public class Worker implements Runnable
{
    private static Socket socket = null;
    private static ObjectInputStream workerInputStream = null;
    private static Objet objet = null;

    public Worker()
    {
        try
        {
            System.out.println("Demande de connexion");
            socket = new Socket("127.0.0.1",2009);
            System.out.println("Connexion établie avec le serveur");
        }
        catch(IOException e)
        {
            System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
            e.printStackTrace();
        }
    }

    public void run()
    {
        try
        {
            System.out.println("debut");
            workerInputStream = new ObjectInputStream(socket.getInputStream());
            objet = (Objet)workerInputStream.readObject();
            System.out.println(objet.getPrix());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static void main (String[] args)
    {
        try
        {
            Thread t = new Thread(new Worker());
            t.start();
            t.sleep(3000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static int isPair(int n)
    {
        if( n % 2 == 0) return n;
        else return 0;
    }
}