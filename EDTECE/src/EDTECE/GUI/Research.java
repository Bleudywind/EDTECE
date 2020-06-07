
package EDTECE.GUI;

import EDTECE.Enseignant;
import EDTECE.SeanceGroupe;
import EDTECE.SeanceSalle;
import EDTECE.Seance_enseignant;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import org.joda.time.DateTime;

/**
 *
 * @author Marie
 */
public class Research extends JFrame{
    private final int HAUTEUR_SCREEN = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private final int LARGEUR_SCREEN = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final JLabel nom_txt = new JLabel();
    private JLabel weekofyear;
    private JButton logout = new JButton("Se Déconnecter");
    private int cp;
    private utilisateur userLng;
    
    public Research(utilisateur user,int type,int cp_semaine,String nom)
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
       
        logout.addActionListener(new Research.btListener());
        
        
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
        
        
        ArrayList <JLabel> heures_txt = new ArrayList<JLabel>();
        JLabel heure_txt;
        
        
        
        
        int lgJour = conteneurEDT.getHeight()*14/100;
        ArrayList<JPanel> Cases = new ArrayList<>();
        JPanel Case;
        int tempsSeance;
        Seance_enseignant scE;
        SeanceSalle SS;
        JLabel infoEdt1;
        JLabel infoEdt2;
        JLabel infoEdt3;
        JLabel infoEdt4;
        
        etudiant etu = new etudiant(user);
                SeanceGroupe seanceUser = new SeanceGroupe(etu.getGroupe().GetID());
                for (int j = 0; j < seanceUser.getSeance().size(); j++)
                {
                    if (seanceUser.getSeance().get(j).Getcours().GetNom()== nom)
                    {
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
                                conteneurEDT.add(Case);

                                }

/*
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
*/
                        }
                    }
                

    private class btListener implements ActionListener
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

