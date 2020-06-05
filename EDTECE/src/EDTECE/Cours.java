package EDTECE;

import edtece.MySQL;
import java.util.ArrayList;


public class Cours {
    
    private String nom;
    private String typeCour;
    
    public Cours (int ID_c, int ID_t)
    {
        ArrayList <String> result = new ArrayList<>();
        result = MySQL.getStringAndExceptionHandling("SELECT * FROM cours WHERE ID = '"+ ID_c +"'");
        nom = result.get(1);
        result = MySQL.getStringAndExceptionHandling("SELECT * FROM type_cours WHERE ID = '"+ ID_t +"'");
        typeCour = result.get(1);
    }
    public Cours(int ID)
    {
        ArrayList <String> result = new ArrayList<>();
        result = MySQL.getStringAndExceptionHandling("SELECT * FROM cours WHERE ID = '"+ ID +"'");
        nom = result.get(1);
    }
    public String GetNom()
    {
        return nom;
    }
    public String typeCour()
    {
        return typeCour;
    }
}
