import java.io.*;
import java.net.*;


public class Manager implements Runnable
{ 
    private static Socket socket = null;
    private static Objet objet;

    public Manager(Socket socket)
    {
        this.socket = socket;
    }

    public static void main (String[] args)
    {
        try
        {
            ServerSocket managerSocket = new ServerSocket(2009);
            System.out.println("Listening");

            while(true)
            {
                Socket socket = managerSocket.accept();
                System.out.println("Connected");
                new Thread(new Manager(socket)).start();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }

    public void run()
    {
        try
        {
            ObjectOutputStream managerOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
            objet = new Objet("titi",120);

            System.out.println("Quelqu'un souhaite se connecter");
            managerOutputStream.writeObject(objet);

            socket.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}