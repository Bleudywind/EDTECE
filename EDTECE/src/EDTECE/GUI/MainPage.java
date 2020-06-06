package EDTECE.GUI;

import EDTECE.Enseignant;
import EDTECE.SeanceGroupe;
import EDTECE.SeanceSalle;
import EDTECE.Seance_enseignant;
import EDTECE.etudiant;
import EDTECE.utilisateur;
import java.awt.Color;
import java.awt.Container;
import java.awt.Rectangle;
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
    private JButton suivant = new JButton("Semaine suivante");
    private JButton prec = new JButton("Semaine précédente");
    private JButton logout = new JButton("Se Déconnecter");
    private int cp;
    private utilisateur userLng;
    
    
    public MainPage(utilisateur user, int cp_semaine)
    {
        setTitle("Emploi du temps");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container frame = getContentPane();
        JPanel jp = new JPanel();
        jp.setLayout(null);
        
        userLng =user;
        
        DateTime dt = new DateTime();
        cp = cp_semaine;
        weekofyear = new JLabel("Semaine " + Integer.toString(cp + dt.getWeekOfWeekyear()));
        
        
        
        
        
        
        nom_txt.setText("Emploi du temps de " + user.getPrenom() + " " + user.getNom());
        
        JPanel navbar = new JPanel();
        navbar.setLayout(null);
        navbar.setBackground(Color.gray);
        
        JPanel conteneurEDT = new JPanel();
        conteneurEDT.setLayout(null);
        conteneurEDT.setBackground(Color.LIGHT_GRAY);
        
        suivant.addActionListener(new MainPage.bt1Listener());
        prec.addActionListener(new MainPage.bt2Listener());
        logout.addActionListener(new MainPage.bt3Listener());
        
        suivant.setBounds(LARGEUR_SCREEN*2/3 - 175/2, HAUTEUR_SCREEN * 85 / 100, 175, 60);
        prec.setBounds(LARGEUR_SCREEN/3 -175/2, HAUTEUR_SCREEN * 85 / 100, 175, 60);
        
        
        conteneurEDT.setBounds(LARGEUR_SCREEN*168/10000, HAUTEUR_SCREEN*16/100, LARGEUR_SCREEN*9664/10000, HAUTEUR_SCREEN * 65 / 100);
        navbar.setBounds(0, 0,LARGEUR_SCREEN, HAUTEUR_SCREEN /12);
        nom_txt.setBounds(navbar.getWidth()/100 , navbar.getHeight()/ 2 -10, 300, 20);
        
        logout.setBounds(navbar.getWidth()*9/10, navbar.getHeight()/2 - 15, 150, 30);
        
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
            
            
            
            
            
            semaine_txt.get(i).setBounds(conteneurEDT.getWidth()*3/100 + i*lgJour + i*conteneurEDT.getWidth()*2/100 + lgJour/2 - 20, conteneurEDT.getHeight()*2/100, 100, 20);
            conteneurEDT.add(semaine_txt.get(i));
            
        }
        ArrayList<JPanel> Cases = new ArrayList<>();
        JPanel Case;
        int tempsSeance;
        Seance_enseignant scE;
        SeanceSalle SS;
        JLabel infoEdt1;
        JLabel infoEdt2;
        JLabel infoEdt3;
        JLabel infoEdt4;
        switch (user.getDroit())
        {
            case 1:
                break;
            case 2:
                
            case 3:
                Enseignant ens = new Enseignant(user.getID());
                Seance_enseignant seanceEns = new Seance_enseignant(user.getID(), true);
                for (int j = 0; j < seanceEns.getSeance().size(); j++)
                {
                    if (seanceEns.getSeance().get(j).Getsemaine() == (dt.getWeekOfWeekyear() + cp))
                    {

                        int premierJDeLaSemaine = dt.getDayOfMonth() - dt.getDayOfWeek()+1;
                        switch (seanceEns.getSeance().get(j).Getjour() - premierJDeLaSemaine + 1)
                        {
                            case 1:

                                Case = new JPanel();
                                tempsSeance = seanceEns.getSeance().get(j).GetheureF() + seanceEns.getSeance().get(j).GetminuteF()/60 - seanceEns.getSeance().get(j).GetheureD() - seanceEns.getSeance().get(j).GetminuteD()/60;
                                Case.setBounds(0, 1 + (seanceEns.getSeance().get(j).GetheureD()+ seanceEns.getSeance().get(j).GetminuteD()/60 - 17/2)*semaine.get(0).getHeight() /13 , semaine.get(0).getWidth(), tempsSeance *semaine.get(0).getHeight()/13 -1);

                                scE = new Seance_enseignant(seanceEns.getSeance().get(j).getID());
                                SS = new SeanceSalle(seanceEns.getSeance().get(j).getID());
                                infoEdt1 = new JLabel( "               "+seanceEns.getSeance().get(j).Getcours().GetNom()+ "               ");
                                infoEdt2 = new JLabel("               "+scE.GetEnseignant().Getuser().getPrenom()+" "+scE.GetEnseignant().Getuser().getNom()+ "               ");
                                
                                infoEdt4 = new JLabel("               "+SS.GetSalle().GetNom()+ " " + SS.GetSalle().GetSite() + " " + SS.GetSalle().getCapacite()+ "               ");

                                infoEdt1.setBounds(Case.getWidth()/2 -25 , Case.getHeight()/5, 50, 10);
                                infoEdt2.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*2/5, 50, 10);
                                
                                infoEdt4.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*4/5, 50, 10);

                                Case.add(infoEdt1);
                                Case.add(infoEdt2);
                                
                                Case.add(infoEdt4);

                                if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Mathematiques"))
                                {
                                    Case.setBackground(Color.green);
                                }
                                else if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Electromagnetisme"))
                                {
                                    Case.setBackground(Color.MAGENTA);
                                }
                                else if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Informatique"))
                                {
                                    Case.setBackground(Color.YELLOW);
                                }
                                else if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Electronique"))
                                {
                                    Case.setBackground(Color.ORANGE);
                                }
                                else
                                {
                                    Case.setBackground(Color.CYAN);
                                }
                                semaine.get(0).add(Case);

                                break;
                            case 2:
                                Case = new JPanel();
                                tempsSeance = seanceEns.getSeance().get(j).GetheureF() + seanceEns.getSeance().get(j).GetminuteF()/60 - seanceEns.getSeance().get(j).GetheureD() - seanceEns.getSeance().get(j).GetminuteD()/60;
                                Case.setBounds(0, 1 + (seanceEns.getSeance().get(j).GetheureD()+ seanceEns.getSeance().get(j).GetminuteD()/60 - 17/2)*semaine.get(0).getHeight() /13 , semaine.get(0).getWidth(), tempsSeance *semaine.get(0).getHeight()/13 -1);
                                 scE = new Seance_enseignant(seanceEns.getSeance().get(j).getID());
                                SS = new SeanceSalle(seanceEns.getSeance().get(j).getID());
                                infoEdt1 = new JLabel( "               "+seanceEns.getSeance().get(j).Getcours().GetNom()+ "               ");
                                infoEdt2 = new JLabel("               "+scE.GetEnseignant().Getuser().getPrenom()+" "+scE.GetEnseignant().Getuser().getNom()+ "               ");
                                
                                infoEdt4 = new JLabel("               "+SS.GetSalle().GetNom()+ " " + SS.GetSalle().GetSite() + " " + SS.GetSalle().getCapacite()+ "               ");

                                infoEdt1.setBounds(Case.getWidth()/2 -25 , Case.getHeight()/5, 50, 10);
                                infoEdt2.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*2/5, 50, 10);
                                
                                infoEdt4.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*4/5, 50, 10);

                                Case.add(infoEdt1);
                                Case.add(infoEdt2);
                                
                                Case.add(infoEdt4);

                                if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Mathematiques"))
                                {
                                    Case.setBackground(Color.green);
                                }
                                else if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Electromagnetisme"))
                                {
                                    Case.setBackground(Color.MAGENTA);
                                }
                                else if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Informatique"))
                                {
                                    Case.setBackground(Color.YELLOW);
                                }
                                else if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Electronique"))
                                {
                                    Case.setBackground(Color.ORANGE);
                                }
                                else
                                {
                                    Case.setBackground(Color.CYAN);
                                }
                                semaine.get(1).add(Case);
                                break;
                            case 3:
                                Case = new JPanel();
                                tempsSeance = seanceEns.getSeance().get(j).GetheureF() + seanceEns.getSeance().get(j).GetminuteF()/60 - seanceEns.getSeance().get(j).GetheureD() - seanceEns.getSeance().get(j).GetminuteD()/60;
                                Case.setBounds(0, 1 + (seanceEns.getSeance().get(j).GetheureD()+ seanceEns.getSeance().get(j).GetminuteD()/60 - 17/2)*semaine.get(0).getHeight() /13 , semaine.get(0).getWidth(), tempsSeance *semaine.get(0).getHeight()/13 -1);
                                 scE = new Seance_enseignant(seanceEns.getSeance().get(j).getID());
                                SS = new SeanceSalle(seanceEns.getSeance().get(j).getID());
                                infoEdt1 = new JLabel( "               "+seanceEns.getSeance().get(j).Getcours().GetNom()+ "               ");
                                infoEdt2 = new JLabel("               "+scE.GetEnseignant().Getuser().getPrenom()+" "+scE.GetEnseignant().Getuser().getNom()+ "               ");
                                
                                infoEdt4 = new JLabel("               "+SS.GetSalle().GetNom()+ " " + SS.GetSalle().GetSite() + " " + SS.GetSalle().getCapacite()+ "               ");

                                infoEdt1.setBounds(Case.getWidth()/2 -25 , Case.getHeight()/5, 50, 10);
                                infoEdt2.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*2/5, 50, 10);
                                
                                infoEdt4.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*4/5, 50, 10);

                                Case.add(infoEdt1);
                                Case.add(infoEdt2);
                                
                                Case.add(infoEdt4);

                                if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Mathematiques"))
                                {
                                    Case.setBackground(Color.green);
                                }
                                else if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Electromagnetisme"))
                                {
                                    Case.setBackground(Color.MAGENTA);
                                }
                                else if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Informatique"))
                                {
                                    Case.setBackground(Color.YELLOW);
                                }
                                else if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Electronique"))
                                {
                                    Case.setBackground(Color.ORANGE);
                                }
                                else
                                {
                                    Case.setBackground(Color.CYAN);
                                }
                                semaine.get(2).add(Case);
                                break;
                            case 4:
                                Case = new JPanel();
                                tempsSeance = seanceEns.getSeance().get(j).GetheureF() + seanceEns.getSeance().get(j).GetminuteF()/60 - seanceEns.getSeance().get(j).GetheureD() - seanceEns.getSeance().get(j).GetminuteD()/60;
                                Case.setBounds(0, 1 + (seanceEns.getSeance().get(j).GetheureD()+ seanceEns.getSeance().get(j).GetminuteD()/60 - 17/2)*semaine.get(0).getHeight() /13 , semaine.get(0).getWidth(), tempsSeance *semaine.get(0).getHeight()/13 -1);
                                 scE = new Seance_enseignant(seanceEns.getSeance().get(j).getID());
                                SS = new SeanceSalle(seanceEns.getSeance().get(j).getID());
                                infoEdt1 = new JLabel( "               "+seanceEns.getSeance().get(j).Getcours().GetNom()+ "               ");
                                infoEdt2 = new JLabel("               "+scE.GetEnseignant().Getuser().getPrenom()+" "+scE.GetEnseignant().Getuser().getNom()+ "               ");
                                
                                infoEdt4 = new JLabel("               "+SS.GetSalle().GetNom()+ " " + SS.GetSalle().GetSite() + " " + SS.GetSalle().getCapacite()+ "               ");

                                infoEdt1.setBounds(Case.getWidth()/2 -25 , Case.getHeight()/5, 50, 10);
                                infoEdt2.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*2/5, 50, 10);
                                
                                infoEdt4.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*4/5, 50, 10);

                                Case.add(infoEdt1);
                                Case.add(infoEdt2);
                                
                                Case.add(infoEdt4);

                                if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Mathematiques"))
                                {
                                    Case.setBackground(Color.green);
                                }
                                else if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Electromagnetisme"))
                                {
                                    Case.setBackground(Color.MAGENTA);
                                }
                                else if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Informatique"))
                                {
                                    Case.setBackground(Color.YELLOW);
                                }
                                else if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Electronique"))
                                {
                                    Case.setBackground(Color.ORANGE);
                                }
                                else
                                {
                                    Case.setBackground(Color.CYAN);
                                }
                                semaine.get(3).add(Case);
                                break;
                            case 5:
                                Case = new JPanel();
                                tempsSeance = seanceEns.getSeance().get(j).GetheureF() + seanceEns.getSeance().get(j).GetminuteF()/60 - seanceEns.getSeance().get(j).GetheureD() - seanceEns.getSeance().get(j).GetminuteD()/60;
                                Case.setBounds(0, 1 + (seanceEns.getSeance().get(j).GetheureD()+ seanceEns.getSeance().get(j).GetminuteD()/60 - 17/2)*semaine.get(0).getHeight() /13 , semaine.get(0).getWidth(), tempsSeance *semaine.get(0).getHeight()/13 -1);
                                 scE = new Seance_enseignant(seanceEns.getSeance().get(j).getID());
                                SS = new SeanceSalle(seanceEns.getSeance().get(j).getID());
                                infoEdt1 = new JLabel( "               "+seanceEns.getSeance().get(j).Getcours().GetNom()+ "               ");
                                infoEdt2 = new JLabel("               "+scE.GetEnseignant().Getuser().getPrenom()+" "+scE.GetEnseignant().Getuser().getNom()+ "               ");
                                
                                infoEdt4 = new JLabel("               "+SS.GetSalle().GetNom()+ " " + SS.GetSalle().GetSite() + " " + SS.GetSalle().getCapacite()+ "               ");

                                infoEdt1.setBounds(Case.getWidth()/2 -25 , Case.getHeight()/5, 50, 10);
                                infoEdt2.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*2/5, 50, 10);
                               
                                infoEdt4.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*4/5, 50, 10);

                                Case.add(infoEdt1);
                                Case.add(infoEdt2);
                                
                                Case.add(infoEdt4);

                                if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Mathematiques"))
                                {
                                    Case.setBackground(Color.green);
                                }
                                else if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Electromagnetisme"))
                                {
                                    Case.setBackground(Color.MAGENTA);
                                }
                                else if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Informatique"))
                                {
                                    Case.setBackground(Color.YELLOW);
                                }
                                else if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Electronique"))
                                {
                                    Case.setBackground(Color.ORANGE);
                                }
                                else
                                {
                                    Case.setBackground(Color.CYAN);
                                }
                                semaine.get(4).add(Case);
                                break;
                            case 6:
                                Case = new JPanel();
                                tempsSeance = seanceEns.getSeance().get(j).GetheureF() + seanceEns.getSeance().get(j).GetminuteF()/60 - seanceEns.getSeance().get(j).GetheureD() - seanceEns.getSeance().get(j).GetminuteD()/60;
                                Case.setBounds(0, 1 + (seanceEns.getSeance().get(j).GetheureD()+ seanceEns.getSeance().get(j).GetminuteD()/60 - 17/2)*semaine.get(0).getHeight() /13 , semaine.get(0).getWidth(), tempsSeance *semaine.get(0).getHeight()/13 -1);
                                 scE = new Seance_enseignant(seanceEns.getSeance().get(j).getID());
                                SS = new SeanceSalle(seanceEns.getSeance().get(j).getID());
                                infoEdt1 = new JLabel( "               "+seanceEns.getSeance().get(j).Getcours().GetNom()+ "               ");
                                infoEdt2 = new JLabel("               "+scE.GetEnseignant().Getuser().getPrenom()+" "+scE.GetEnseignant().Getuser().getNom()+ "               ");
                               
                                infoEdt4 = new JLabel("               "+SS.GetSalle().GetNom()+ " " + SS.GetSalle().GetSite() + " " + SS.GetSalle().getCapacite()+ "               ");

                                infoEdt1.setBounds(Case.getWidth()/2 -25 , Case.getHeight()/5, 50, 10);
                                infoEdt2.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*2/5, 50, 10);
                                
                                infoEdt4.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*4/5, 50, 10);

                                Case.add(infoEdt1);
                                Case.add(infoEdt2);
                            
                                Case.add(infoEdt4);

                                if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Mathematiques"))
                                {
                                    Case.setBackground(Color.green);
                                }
                                else if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Electromagnetisme"))
                                {
                                    Case.setBackground(Color.MAGENTA);
                                }
                                else if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Informatique"))
                                {
                                    Case.setBackground(Color.YELLOW);
                                }
                                else if (seanceEns.getSeance().get(j).Getcours().GetNom().equals("Electronique"))
                                {
                                    Case.setBackground(Color.ORANGE);
                                }
                                else
                                {
                                    Case.setBackground(Color.CYAN);
                                }
                                semaine.get(5).add(Case);
                                break;

                        }
                    }
                }
                break;
            case 4:
                etudiant etu = new etudiant(user);
                SeanceGroupe seanceUser = new SeanceGroupe(etu.getGroupe().GetID());
                for (int j = 0; j < seanceUser.getSeance().size(); j++)
                {
                    if (seanceUser.getSeance().get(j).Getsemaine() == (dt.getWeekOfWeekyear() + cp))
                    {

                        int premierJDeLaSemaine = dt.getDayOfMonth() - dt.getDayOfWeek()+1;
                        switch (seanceUser.getSeance().get(j).Getjour() - premierJDeLaSemaine + 1)
                        {
                            case 1:

                                Case = new JPanel();
                                tempsSeance = seanceUser.getSeance().get(j).GetheureF() + seanceUser.getSeance().get(j).GetminuteF()/60 - seanceUser.getSeance().get(j).GetheureD() - seanceUser.getSeance().get(j).GetminuteD()/60;
                                Case.setBounds(0, 1 + (seanceUser.getSeance().get(j).GetheureD()+ seanceUser.getSeance().get(j).GetminuteD()/60 - 17/2)*semaine.get(0).getHeight() /13 , semaine.get(0).getWidth(), tempsSeance *semaine.get(0).getHeight()/13 -1);

                                scE = new Seance_enseignant(seanceUser.getSeance().get(j).getID());
                                SS = new SeanceSalle(seanceUser.getSeance().get(j).getID());
                                infoEdt1 = new JLabel( "               "+seanceUser.getSeance().get(j).Getcours().GetNom()+ "               ");
                                infoEdt2 = new JLabel("               "+scE.GetEnseignant().Getuser().getPrenom()+" "+scE.GetEnseignant().Getuser().getNom()+ "               ");
                                infoEdt3 = new JLabel("               "+etu.getGroupe().getNom()+ " " + etu.getGroupe().getPromo()+ "               ");
                                infoEdt4 = new JLabel("               "+SS.GetSalle().GetNom()+ " " + SS.GetSalle().GetSite() + " " + SS.GetSalle().getCapacite()+ "               ");

                                infoEdt1.setBounds(Case.getWidth()/2 -25 , Case.getHeight()/5, 50, 10);
                                infoEdt2.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*2/5, 50, 10);
                                infoEdt3.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*3/5, 50, 10);
                                infoEdt4.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*4/5, 50, 10);

                                Case.add(infoEdt1);
                                Case.add(infoEdt2);
                                Case.add(infoEdt3);
                                Case.add(infoEdt4);

                                if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Mathematiques"))
                                {
                                    Case.setBackground(Color.green);
                                }
                                else if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Electromagnetisme"))
                                {
                                    Case.setBackground(Color.MAGENTA);
                                }
                                else if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Informatique"))
                                {
                                    Case.setBackground(Color.YELLOW);
                                }
                                else if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Electronique"))
                                {
                                    Case.setBackground(Color.ORANGE);
                                }
                                else
                                {
                                    Case.setBackground(Color.CYAN);
                                }
                                semaine.get(0).add(Case);

                                break;
                            case 2:
                                Case = new JPanel();
                                tempsSeance = seanceUser.getSeance().get(j).GetheureF() + seanceUser.getSeance().get(j).GetminuteF()/60 - seanceUser.getSeance().get(j).GetheureD() - seanceUser.getSeance().get(j).GetminuteD()/60;
                                Case.setBounds(0, 1 + (seanceUser.getSeance().get(j).GetheureD()+ seanceUser.getSeance().get(j).GetminuteD()/60 - 17/2)*semaine.get(0).getHeight() /13 , semaine.get(0).getWidth(), tempsSeance *semaine.get(0).getHeight()/13 -1);
                                 scE = new Seance_enseignant(seanceUser.getSeance().get(j).getID());
                                SS = new SeanceSalle(seanceUser.getSeance().get(j).getID());
                                infoEdt1 = new JLabel( "               "+seanceUser.getSeance().get(j).Getcours().GetNom()+ "               ");
                                infoEdt2 = new JLabel("               "+scE.GetEnseignant().Getuser().getPrenom()+" "+scE.GetEnseignant().Getuser().getNom()+ "               ");
                                infoEdt3 = new JLabel("               "+etu.getGroupe().getNom()+ " " + etu.getGroupe().getPromo()+ "               ");
                                infoEdt4 = new JLabel("               "+SS.GetSalle().GetNom()+ " " + SS.GetSalle().GetSite() + " " + SS.GetSalle().getCapacite()+ "               ");

                                infoEdt1.setBounds(Case.getWidth()/2 -25 , Case.getHeight()/5, 50, 10);
                                infoEdt2.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*2/5, 50, 10);
                                infoEdt3.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*3/5, 50, 10);
                                infoEdt4.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*4/5, 50, 10);

                                Case.add(infoEdt1);
                                Case.add(infoEdt2);
                                Case.add(infoEdt3);
                                Case.add(infoEdt4);

                                if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Mathematiques"))
                                {
                                    Case.setBackground(Color.green);
                                }
                                else if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Electromagnetisme"))
                                {
                                    Case.setBackground(Color.MAGENTA);
                                }
                                else if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Informatique"))
                                {
                                    Case.setBackground(Color.YELLOW);
                                }
                                else if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Electronique"))
                                {
                                    Case.setBackground(Color.ORANGE);
                                }
                                else
                                {
                                    Case.setBackground(Color.CYAN);
                                }
                                semaine.get(1).add(Case);
                                break;
                            case 3:
                                Case = new JPanel();
                                tempsSeance = seanceUser.getSeance().get(j).GetheureF() + seanceUser.getSeance().get(j).GetminuteF()/60 - seanceUser.getSeance().get(j).GetheureD() - seanceUser.getSeance().get(j).GetminuteD()/60;
                                Case.setBounds(0, 1 + (seanceUser.getSeance().get(j).GetheureD()+ seanceUser.getSeance().get(j).GetminuteD()/60 - 17/2)*semaine.get(0).getHeight() /13 , semaine.get(0).getWidth(), tempsSeance *semaine.get(0).getHeight()/13 -1);
                                 scE = new Seance_enseignant(seanceUser.getSeance().get(j).getID());
                                SS = new SeanceSalle(seanceUser.getSeance().get(j).getID());
                                infoEdt1 = new JLabel( "               "+seanceUser.getSeance().get(j).Getcours().GetNom()+ "               ");
                                infoEdt2 = new JLabel("               "+scE.GetEnseignant().Getuser().getPrenom()+" "+scE.GetEnseignant().Getuser().getNom()+ "               ");
                                infoEdt3 = new JLabel("               "+etu.getGroupe().getNom()+ " " + etu.getGroupe().getPromo()+ "               ");
                                infoEdt4 = new JLabel("               "+SS.GetSalle().GetNom()+ " " + SS.GetSalle().GetSite() + " " + SS.GetSalle().getCapacite()+ "               ");

                                infoEdt1.setBounds(Case.getWidth()/2 -25 , Case.getHeight()/5, 50, 10);
                                infoEdt2.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*2/5, 50, 10);
                                infoEdt3.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*3/5, 50, 10);
                                infoEdt4.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*4/5, 50, 10);

                                Case.add(infoEdt1);
                                Case.add(infoEdt2);
                                Case.add(infoEdt3);
                                Case.add(infoEdt4);

                                if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Mathematiques"))
                                {
                                    Case.setBackground(Color.green);
                                }
                                else if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Electromagnetisme"))
                                {
                                    Case.setBackground(Color.MAGENTA);
                                }
                                else if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Informatique"))
                                {
                                    Case.setBackground(Color.YELLOW);
                                }
                                else if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Electronique"))
                                {
                                    Case.setBackground(Color.ORANGE);
                                }
                                else
                                {
                                    Case.setBackground(Color.CYAN);
                                }
                                semaine.get(2).add(Case);
                                break;
                            case 4:
                                Case = new JPanel();
                                tempsSeance = seanceUser.getSeance().get(j).GetheureF() + seanceUser.getSeance().get(j).GetminuteF()/60 - seanceUser.getSeance().get(j).GetheureD() - seanceUser.getSeance().get(j).GetminuteD()/60;
                                Case.setBounds(0, 1 + (seanceUser.getSeance().get(j).GetheureD()+ seanceUser.getSeance().get(j).GetminuteD()/60 - 17/2)*semaine.get(0).getHeight() /13 , semaine.get(0).getWidth(), tempsSeance *semaine.get(0).getHeight()/13 -1);
                                 scE = new Seance_enseignant(seanceUser.getSeance().get(j).getID());
                                SS = new SeanceSalle(seanceUser.getSeance().get(j).getID());
                                infoEdt1 = new JLabel( "               "+seanceUser.getSeance().get(j).Getcours().GetNom()+ "               ");
                                infoEdt2 = new JLabel("               "+scE.GetEnseignant().Getuser().getPrenom()+" "+scE.GetEnseignant().Getuser().getNom()+ "               ");
                                infoEdt3 = new JLabel("               "+etu.getGroupe().getNom()+ " " + etu.getGroupe().getPromo()+ "               ");
                                infoEdt4 = new JLabel("               "+SS.GetSalle().GetNom()+ " " + SS.GetSalle().GetSite() + " " + SS.GetSalle().getCapacite()+ "               ");

                                infoEdt1.setBounds(Case.getWidth()/2 -25 , Case.getHeight()/5, 50, 10);
                                infoEdt2.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*2/5, 50, 10);
                                infoEdt3.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*3/5, 50, 10);
                                infoEdt4.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*4/5, 50, 10);

                                Case.add(infoEdt1);
                                Case.add(infoEdt2);
                                Case.add(infoEdt3);
                                Case.add(infoEdt4);

                                if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Mathematiques"))
                                {
                                    Case.setBackground(Color.green);
                                }
                                else if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Electromagnetisme"))
                                {
                                    Case.setBackground(Color.MAGENTA);
                                }
                                else if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Informatique"))
                                {
                                    Case.setBackground(Color.YELLOW);
                                }
                                else if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Electronique"))
                                {
                                    Case.setBackground(Color.ORANGE);
                                }
                                else
                                {
                                    Case.setBackground(Color.CYAN);
                                }
                                semaine.get(3).add(Case);
                                break;
                            case 5:
                                Case = new JPanel();
                                tempsSeance = seanceUser.getSeance().get(j).GetheureF() + seanceUser.getSeance().get(j).GetminuteF()/60 - seanceUser.getSeance().get(j).GetheureD() - seanceUser.getSeance().get(j).GetminuteD()/60;
                                Case.setBounds(0, 1 + (seanceUser.getSeance().get(j).GetheureD()+ seanceUser.getSeance().get(j).GetminuteD()/60 - 17/2)*semaine.get(0).getHeight() /13 , semaine.get(0).getWidth(), tempsSeance *semaine.get(0).getHeight()/13 -1);
                                 scE = new Seance_enseignant(seanceUser.getSeance().get(j).getID());
                                SS = new SeanceSalle(seanceUser.getSeance().get(j).getID());
                                infoEdt1 = new JLabel( "               "+seanceUser.getSeance().get(j).Getcours().GetNom()+ "               ");
                                infoEdt2 = new JLabel("               "+scE.GetEnseignant().Getuser().getPrenom()+" "+scE.GetEnseignant().Getuser().getNom()+ "               ");
                                infoEdt3 = new JLabel("               "+etu.getGroupe().getNom()+ " " + etu.getGroupe().getPromo()+ "               ");
                                infoEdt4 = new JLabel("               "+SS.GetSalle().GetNom()+ " " + SS.GetSalle().GetSite() + " " + SS.GetSalle().getCapacite()+ "               ");

                                infoEdt1.setBounds(Case.getWidth()/2 -25 , Case.getHeight()/5, 50, 10);
                                infoEdt2.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*2/5, 50, 10);
                                infoEdt3.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*3/5, 50, 10);
                                infoEdt4.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*4/5, 50, 10);

                                Case.add(infoEdt1);
                                Case.add(infoEdt2);
                                Case.add(infoEdt3);
                                Case.add(infoEdt4);

                                if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Mathematiques"))
                                {
                                    Case.setBackground(Color.green);
                                }
                                else if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Electromagnetisme"))
                                {
                                    Case.setBackground(Color.MAGENTA);
                                }
                                else if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Informatique"))
                                {
                                    Case.setBackground(Color.YELLOW);
                                }
                                else if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Electronique"))
                                {
                                    Case.setBackground(Color.ORANGE);
                                }
                                else
                                {
                                    Case.setBackground(Color.CYAN);
                                }
                                semaine.get(4).add(Case);
                                break;
                            case 6:
                                Case = new JPanel();
                                tempsSeance = seanceUser.getSeance().get(j).GetheureF() + seanceUser.getSeance().get(j).GetminuteF()/60 - seanceUser.getSeance().get(j).GetheureD() - seanceUser.getSeance().get(j).GetminuteD()/60;
                                Case.setBounds(0, 1 + (seanceUser.getSeance().get(j).GetheureD()+ seanceUser.getSeance().get(j).GetminuteD()/60 - 17/2)*semaine.get(0).getHeight() /13 , semaine.get(0).getWidth(), tempsSeance *semaine.get(0).getHeight()/13 -1);
                                 scE = new Seance_enseignant(seanceUser.getSeance().get(j).getID());
                                SS = new SeanceSalle(seanceUser.getSeance().get(j).getID());
                                infoEdt1 = new JLabel( "               "+seanceUser.getSeance().get(j).Getcours().GetNom()+ "               ");
                                infoEdt2 = new JLabel("               "+scE.GetEnseignant().Getuser().getPrenom()+" "+scE.GetEnseignant().Getuser().getNom()+ "               ");
                                infoEdt3 = new JLabel("               "+etu.getGroupe().getNom()+ " " + etu.getGroupe().getPromo()+ "               ");
                                infoEdt4 = new JLabel("               "+SS.GetSalle().GetNom()+ " " + SS.GetSalle().GetSite() + " " + SS.GetSalle().getCapacite()+ "               ");

                                infoEdt1.setBounds(Case.getWidth()/2 -25 , Case.getHeight()/5, 50, 10);
                                infoEdt2.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*2/5, 50, 10);
                                infoEdt3.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*3/5, 50, 10);
                                infoEdt4.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*4/5, 50, 10);

                                Case.add(infoEdt1);
                                Case.add(infoEdt2);
                                Case.add(infoEdt3);
                                Case.add(infoEdt4);

                                if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Mathematiques"))
                                {
                                    Case.setBackground(Color.green);
                                }
                                else if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Electromagnetisme"))
                                {
                                    Case.setBackground(Color.MAGENTA);
                                }
                                else if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Informatique"))
                                {
                                    Case.setBackground(Color.YELLOW);
                                }
                                else if (seanceUser.getSeance().get(j).Getcours().GetNom().equals("Electronique"))
                                {
                                    Case.setBackground(Color.ORANGE);
                                }
                                else
                                {
                                    Case.setBackground(Color.CYAN);
                                }
                                semaine.get(5).add(Case);
                                break;

                        }
                    }
                }
                break;
        }
        
        
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 12; j++)
            {
                line = new JSeparator();
                lines.add(line);
                lines.get(j + i*12).setForeground(Color.BLACK);
                lines.get(j + i*12).setBounds(0, semaine.get(i).getHeight() * (j+1) /13, 300, 1);
                semaine.get(i).add(lines.get(j + i*12));
            }
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
        
        navbar.add(logout);
        navbar.add(nom_txt);
        
        jp.add(suivant);
        jp.add(prec);
        jp.add(weekofyear);
        jp.add(navbar);
        jp.add(conteneurEDT);
        
        add(jp);
        setVisible(true);
    }
    
    private class bt1Listener implements ActionListener
    {
        
        @Override
        public void actionPerformed(ActionEvent e)
        {

            MainPage mp = new MainPage(userLng, cp + 1);
            setVisible(false);
            dispose();
            
        }
        
    }
    private class bt2Listener implements ActionListener
    {
        
        @Override
        public void actionPerformed(ActionEvent e)
        {

            MainPage mp = new MainPage(userLng, cp - 1);
            setVisible(false);
            dispose();
            
        }
        
    }
    private class bt3Listener implements ActionListener
    {
        
        @Override
        public void actionPerformed(ActionEvent e)
        {

            Login lng = new Login();
            setVisible(false);
            dispose();
            
        }
        
    }
}
