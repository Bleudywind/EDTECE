package EDTECE;

import java.util.ArrayList;

public class SeanceSalle {
    private Seance seance;
    private Salle salle;
    
    public SeanceSalle(int ID_S)
    {
        ArrayList <String> result = new ArrayList<>();
        result = edtece.MySQL.getStringAndExceptionHandling("SELECT * FROM seance_salle WHERE ID_SEANCE = '"+ ID_S +"'");
        salle = new Salle(Integer.parseInt(result.get(1)));
        seance = new Seance(ID_S);
    }
}
