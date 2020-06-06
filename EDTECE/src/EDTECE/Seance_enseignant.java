package EDTECE;

import java.util.ArrayList;

public class Seance_enseignant {
    private Seance sceance;
    private ArrayList<Seance> seance = new ArrayList<>();
    private Enseignant enseignant;
    
    public Seance_enseignant (int ID_S)
    {
        ArrayList <String> result = new ArrayList<>();
        result = edtece.MySQL.getStringAndExceptionHandling("SELECT * FROM seance_enseignant WHERE ID_SCEANCE = '"+ ID_S +"'");
        enseignant = new Enseignant(Integer.parseInt(result.get(1)));
        sceance = new Seance(ID_S);
    }
    public Seance_enseignant(int ID_E, boolean oui)
    {
        ArrayList <String> result = new ArrayList<>();
        result = edtece.MySQL.getStringAndExceptionHandling("SELECT * FROM seance_enseignant WHERE ID_ENSEIGNANT = '"+ ID_E +"'");
        Seance sc;
        for (int i = 0; i < result.size()/2; i++)
        {
            sc = new Seance(Integer.parseInt(result.get(i*2)));
            seance.add(sc);
        }
    }
    public Enseignant GetEnseignant()
    {
        return enseignant;
    }
    public ArrayList<Seance> getSeance()
    {
        return seance;
    }
}
