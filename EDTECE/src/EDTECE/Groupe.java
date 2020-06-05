package EDTECE;

import java.util.ArrayList;

public class Groupe {
    
    private String Nom;
    private String Promo;
    
    public Groupe (int ID)
    {
        ArrayList <String> result = new ArrayList<>();
        result = edtece.MySQL.getStringAndExceptionHandling("SELECT * FROM groupe WHERE ID = '"+ ID +"'");
        Nom = result.get(1);
        result = edtece.MySQL.getStringAndExceptionHandling("SELECT * FROM promotion WHERE ID = '"+ result.get(2) +"'");
        Promo = result.get(1);
    }
    
    public String getNom()
    {
        return Nom;
    }
    public String getPromo()
    {
        return Promo;
    }
}
