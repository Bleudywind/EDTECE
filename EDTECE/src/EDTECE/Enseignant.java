package EDTECE;

import java.util.ArrayList;

public class Enseignant {
    
    private utilisateur Utilisateur;
    private Cours cours;
    
    public Enseignant(int ID_utilisateur)
    {
        ArrayList <String> result = new ArrayList<>();
        result = edtece.MySQL.getStringAndExceptionHandling("SELECT * FROM enseignant WHERE ID_UTILISATEUR = '"+ ID_utilisateur +"'");
        Utilisateur = new utilisateur(ID_utilisateur);
        cours = new Cours(Integer.parseInt(result.get(1)));
    }
    public utilisateur Getuser()
    {
        return Utilisateur;
    }
}
