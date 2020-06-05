package EDTECE.GUI;

import EDTECE.SeanceGroupe;
import EDTECE.etudiant;
import EDTECE.utilisateur;
import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import org.joda.time.DateTime;


public class MainPage extends JFrame{
    
    private final int HAUTEUR_SCREEN = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private final int LARGEUR_SCREEN = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final JLabel nom_txt = new JLabel();
    private JLabel weekofyear;
    
    
    public MainPage(utilisateur user)
    {
        setTitle("Emploi du temps");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container frame = getContentPane();
        JPanel jp = new JPanel();
        jp.setLayout(null);
        
        DateTime dt = new DateTime();
        weekofyear = new JLabel("Semaine " +Integer.toString(dt.getWeekOfWeekyear()));
        
        etudiant etu = new etudiant(user);
        SeanceGroupe seanceUser = new SeanceGroupe(etu.getGroupe().GetID());
        
        
        nom_txt.setText("Emploi du temps de " + user.getPrenom() + " " + user.getNom());
        
        JPanel navbar = new JPanel();
        navbar.setLayout(null);
        navbar.setBackground(Color.gray);
        
        JPanel conteneurEDT = new JPanel();
        conteneurEDT.setLayout(null);
        conteneurEDT.setBackground(Color.LIGHT_GRAY);
        
        
        
        
        conteneurEDT.setBounds(LARGEUR_SCREEN*168/10000, HAUTEUR_SCREEN*16/100, LARGEUR_SCREEN*9664/10000, HAUTEUR_SCREEN * 65 / 100);
        navbar.setBounds(0, 0,LARGEUR_SCREEN, HAUTEUR_SCREEN /12);
        nom_txt.setBounds(navbar.getWidth()/100 , navbar.getHeight()/ 2 -10, 300, 20);
        
        ArrayList <JPanel> semaine = new ArrayList<JPanel>();
        JPanel jour;
        ArrayList <JLabel> semaine_txt = new ArrayList<JLabel>();
        JLabel lundi = new JLabel("lundi");
        JLabel mardi = new JLabel("mardi");
        JLabel mercredi = new JLabel("mercredi");
        JLabel jeudi = new JLabel("jeudi");
        JLabel vendredi = new JLabel("vendredi");
        JLabel samedi = new JLabel("samedi");
        
        semaine_txt.add(lundi);
        semaine_txt.add(mardi);
        semaine_txt.add(mercredi);
        semaine_txt.add(jeudi);
        semaine_txt.add(vendredi);
        semaine_txt.add(samedi);
        
        ArrayList<JSeparator> lines = new ArrayList<JSeparator>();
        JSeparator line;
        
        ArrayList <JLabel> heures_txt = new ArrayList<JLabel>();
        JLabel heure_txt;
        
        
        
        
        int lgJour = conteneurEDT.getWidth()*14/100;
        for (int i = 0; i < 6; i++)
        {
            jour = new JPanel();
            semaine.add(jour);
            semaine.get(i).setLayout(null);
            semaine.get(i).setBackground(Color.white);
            semaine.get(i).setBounds(conteneurEDT.getWidth()*3/100 + i*lgJour + i*conteneurEDT.getWidth()*2/100, conteneurEDT.getHeight()*5/100, lgJour , conteneurEDT.getHeight()*9/10);
            
            for (int j = 0; j < 12; j++)
            {
                line = new JSeparator();
                lines.add(line);
                lines.get(j + i*12).setForeground(Color.BLACK);
                lines.get(j + i*12).setBounds(0, semaine.get(i).getHeight() * (j+1) /13, 300, 1);
                semaine.get(i).add(lines.get(j + i*12));
            }
            
            
            
            semaine_txt.get(i).setBounds(conteneurEDT.getWidth()*3/100 + i*lgJour + i*conteneurEDT.getWidth()*2/100 + lgJour/2 - 20, conteneurEDT.getHeight()*2/100, 100, 20);
            conteneurEDT.add(semaine_txt.get(i));
            
        }
        JPanel Case;
        for (int j = 0; j < seanceUser.getSeance().size(); j++)
        {
            
            if (seanceUser.getSeance().get(j).Getsemaine() == dt.getWeekOfWeekyear())
            {
                int premierJDeLaSemaine = dt.getDayOfMonth() - dt.getDayOfWeek();
                switch (seanceUser.getSeance().get(j).Getjour() - premierJDeLaSemaine + 1)
                {
                    case 1:
                        Case = new JPanel();
                        int tempsSeance = seanceUser.getSeance().get(j).GetheureF() + seanceUser.getSeance().get(j).GetminuteF()/60 - seanceUser.getSeance().get(j).GetheureD() - seanceUser.getSeance().get(j).GetminuteD();
                        Case.setBounds(semaine.get(0).getX(), semaine.get(0).getY() + (seanceUser.getSeance().get(j).GetheureD()+ seanceUser.getSeance().get(j).GetminuteD()/60 - 17/2)*semaine.get(0).getHeight() /13 , semaine.get(0).getWidth(), tempsSeance *semaine.get(0).getHeight()/13 );
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    
                }
            }
        }
        for (int i = 0; i < 6; i++)
        {
            conteneurEDT.add(semaine.get(i));
        }
        
        for(int j = 0; j < 14; j++)
            {
            heure_txt = new JLabel((j+8)+ ":30");
            heures_txt.add(heure_txt);
            heures_txt.get(j).setBounds(conteneurEDT.getWidth()*1/100, semaine.get(0).getHeight() * (j) /13 + conteneurEDT.getHeight()*5/100 - 5, 50, 10);
            conteneurEDT.add(heures_txt.get(j));
            }
        
        
        weekofyear.setBounds(LARGEUR_SCREEN /2 - 50, HAUTEUR_SCREEN*16/100 - 50, 100, 10);
        
        
        navbar.add(nom_txt);
        
        jp.add(weekofyear);
        jp.add(navbar);
        jp.add(conteneurEDT);
        
        add(jp);
        setVisible(true);
    }
}
