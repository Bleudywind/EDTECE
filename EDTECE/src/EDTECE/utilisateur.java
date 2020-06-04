package EDTECE;

import edtece.MySQL;
import java.util.ArrayList;


public class utilisateur {
    
    private String ID;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private String droit;
    
    public utilisateur(String Email, String Password)
    {
        ArrayList<String> user = new ArrayList<>();
        user = MySQL.getStringAndExceptionHandling("SELECT * FROM  utilisateur WHERE EMAIL='" + Email + "' AND PASSWORD = '" + Password + "';");
        
        ID = user.get(0);
        email = Email;
        password = Password;
        nom = user.get(3);
        prenom = user.get(4);
        droit = user.get(5);
        
    }
    
    public static boolean checklogin (String email_check, String password_check)
    {
        ArrayList<String> user = new ArrayList<>();
        user = MySQL.getStringAndExceptionHandling("SELECT * FROM  utilisateur WHERE EMAIL='" + email_check + "' AND PASSWORD = '" + password_check + "';");
        
        if (!user.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String getID()
    {
        return ID;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPassword()
    {
        return password;
    }
    public String getNom()
    {
        return nom;
    }
    public String getPrenom()
    {
        return prenom;
    }
    public String getDroit()
    {
        return droit;
    }
}
