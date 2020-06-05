package EDTECE;

import edtece.MySQL;
import java.util.ArrayList;

public class Seance {
    private final int ID;
    private String etat;
    private int semaine;
    private int annee;
    private int mois;
    private int jour;
    private int heureD;
    private int heureF;
    private int minuteD;
    private int minuteF;
    private Cours cours;
    
    
    public Seance (int id)
    {
        ArrayList <String> result = new ArrayList<>();
        ID = id;
        result = MySQL.getStringAndExceptionHandling("SELECT * FROM seance WHERE ID = '"+ ID +"'");
        
        if(!result.isEmpty())
        {
            semaine = Integer.parseInt(result.get(1));
            annee = Integer.parseInt(result.get(2).substring(0,4));
            mois = Integer.parseInt(result.get(2).substring(5,7));
            jour = Integer.parseInt(result.get(2).substring(8));
            if (result.get(3).length() == 3)
            {
                heureD = Integer.parseInt(result.get(3).substring(0,1));
                minuteD = Integer.parseInt(result.get(3).substring(1));
            }
            else
            {
                heureD = Integer.parseInt(result.get(3).substring(0,2));
                minuteD = Integer.parseInt(result.get(3).substring(2));
            }
            if (result.get(4).length() == 3)
            {
                heureF = Integer.parseInt(result.get(4).substring(0,1));
                minuteF = Integer.parseInt(result.get(4).substring(1));
            }
            else
            {
                heureF = Integer.parseInt(result.get(4).substring(0,2));
                minuteF = Integer.parseInt(result.get(4).substring(2));
            }
            
            etat = result.get(5);
            
            cours = new Cours(Integer.parseInt(result.get(6)),Integer.parseInt(result.get(7)));
        } 
    }
}
