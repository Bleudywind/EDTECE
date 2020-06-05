package EDTECE;

import java.util.ArrayList;

public class Seance_enseignant {
    private Seance seance;
    private Enseignant enseignant;
    
    public Seance_enseignant (int ID_S)
    {
        ArrayList <String> result = new ArrayList<>();
        result = edtece.MySQL.getStringAndExceptionHandling("SELECT * FROM seance_enseignant WHERE ID_SEANCE = '"+ ID_S +"'");
        enseignant = new Enseignant(Integer.parseInt(result.get(1)));
        seance = new Seance(ID_S);
    }
}
