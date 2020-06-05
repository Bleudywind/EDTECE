package EDTECE;

import edtece.MySQL;
import java.util.ArrayList;


public class etudiant {
    
    private final utilisateur user;
    private final Groupe groupe;
    
    public etudiant (utilisateur users)
    {
        user = users;
        ArrayList <String> result = new ArrayList<>();
        result = MySQL.getStringAndExceptionHandling("SELECT * FROM etudiant WHERE ID_UTILISATEUR = '"+ user.getID() +"'");
        groupe = new Groupe(Integer.parseInt(result.get(2)));
    }
    
    public utilisateur getUser()
    {
        return user;
    }
    public Groupe getGroupe()
    {
        return groupe;
    }
    
}
