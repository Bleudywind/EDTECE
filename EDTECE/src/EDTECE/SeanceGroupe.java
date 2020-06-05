package EDTECE;

import java.util.ArrayList;

public class SeanceGroupe {
    private ArrayList<Seance> seance = new ArrayList<>();
    private Groupe groupe;
    
    public SeanceGroupe(int ID_G)
    {
        ArrayList <String> result = new ArrayList<>();
        result = edtece.MySQL.getStringAndExceptionHandling("SELECT * FROM seance_groupe WHERE ID_GROUPE = '"+ ID_G +"'");
        Seance sc;
        for (int i = 0; i < result.size()/2; i++)
        {
            sc = new Seance(Integer.parseInt(result.get(i*2)));
            seance.add(sc);
        }
        groupe = new Groupe(ID_G);
    }
    
    public ArrayList<Seance> getSeance()
    {
        return seance;
    }
}
