package EDTECE;

import java.util.ArrayList;


public class Salle {
    
    private String nom;
    private int capacite;
    private String site;
    
    public Salle (int ID){
        ArrayList <String> result = new ArrayList<>();
        result = edtece.MySQL.getStringAndExceptionHandling("SELECT * FROM salle WHERE ID = '"+ ID +"'");
        nom = result.get(1);
        capacite = Integer.parseInt(result.get(2));
        result = edtece.MySQL.getStringAndExceptionHandling("SELECT * FROM site WHERE ID = '"+ Integer.parseInt(result.get(3)) +"'");
        site = result.get(1);
    }
    public String GetNom()
    {
        return nom;
    }
    public String GetSite()
    {
        return site;
    }
    public int getCapacite()
    {
        return capacite;
    }
}
