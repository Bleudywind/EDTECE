package EDTECE;


import java.util.ArrayList;


public class utilisateur {
    
    private int ID;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private int droit;
    
    public utilisateur(String Email, String Password)
    {
        ArrayList<String> user = new ArrayList<>();
        user = edtece.MySQL.getStringAndExceptionHandling("SELECT * FROM  utilisateur WHERE EMAIL='" + Email + "' AND PASSWORD = '" + Password + "';");
        
        ID = Integer.parseInt(user.get(0));
        email = Email;
        password = Password;
        nom = user.get(3);
        prenom = user.get(4);
        droit = Integer.parseInt(user.get(5));
        
    }
     public utilisateur(String nom)
    {
        ArrayList<String> user = new ArrayList<>();
        user = edtece.MySQL.getStringAndExceptionHandling("SELECT * FROM  utilisateur WHERE NOM='" + nom + "';");
        
        ID = Integer.parseInt(user.get(0));
        email=user.get(2);
        password=user.get(3);
        prenom = user.get(4);
        droit = Integer.parseInt(user.get(5));
        
    }
    
    public utilisateur(int id)
    {
        ArrayList <String> result = new ArrayList<>();
        result = edtece.MySQL.getStringAndExceptionHandling("SELECT * FROM utilisateur WHERE ID = '"+ id +"'");
        ID = id;
        email = result.get(1);
        nom = result.get(3);
        prenom = result.get(4);
        droit = Integer.parseInt(result.get(5));
        
    }
    
    public static boolean checklogin (String email_check, String password_check)
    {
        ArrayList<String> user = new ArrayList<>();
        user = edtece.MySQL.getStringAndExceptionHandling("SELECT * FROM  utilisateur WHERE EMAIL='" + email_check + "' AND PASSWORD = '" + password_check + "';");
        
        if (!user.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public int getID()
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
    public int getDroit()
    {
        return droit;
    }
}
