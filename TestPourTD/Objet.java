import java.io.*;

class Objet implements Serializable
{
    private String nom = "";
    private int prix = 0;

    public String getNom(){
        return nom;
    }

    public int getPrix(){
        return prix;
    }
    
    public Objet(String nom, int prix)
    {
        this.nom = nom;
        this.prix = prix;
    }
}