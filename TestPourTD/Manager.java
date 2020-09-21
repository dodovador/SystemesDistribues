import java.io.*;
import java.net.*;


public class Manager{ 
    private static ServerSocket managerSocket = null;
    private static Socket socket = null;
    private static ObjectOutputStream managerOuputStream = null;

    private static Objet objet = null;

    public static void main (String[] args)
    {
        try
        {
            managerSocket = new ServerSocket(2009);
            socket = managerSocket.accept();

            managerOuputStream = new ObjectOutputStream(socket.getOutputStream());
            objet = new Objet("titi",120);

            System.out.println("Quelqu'un souhaite se connecter");
            
            managerOuputStream.writeObject(objet);

        }
        catch(IOException e)
        {
            System.err.println("Le port "+managerSocket.getLocalPort()+" Est déjà utilisé !");
        }
    }
}