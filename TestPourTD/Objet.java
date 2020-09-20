import java.io.*;

class Objet implements Serializable
{
    private String nom = "";
    private int prix = 0;
    
    public Objet(String nom, int prix)
    {
        this.nom = nom;
        this.prix = prix;
    }
}