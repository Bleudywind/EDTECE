
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
    private JButton Modifier = new JButton("Modifier");
    private JButton Supprimer = new JButton("Supprimer");
    
    public Research(utilisateur user,int droit,int cp_semaine,String nom)
    {
        setTitle("Emploi du temps");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container frame = getContentPane();
        JPanel jp = new JPanel();
        jp.setLayout(null);
  
        JPanel navbar = new JPanel();
        navbar.setLayout(null);
        navbar.setBackground(Color.gray);
        
        JPanel conteneurEDT = new JPanel();
        conteneurEDT.setLayout(null);
        conteneurEDT.setBackground(Color.LIGHT_GRAY);
       
    
       
        
        
        conteneurEDT.setBounds(LARGEUR_SCREEN*168/10000, HAUTEUR_SCREEN*16/100, LARGEUR_SCREEN*9664/10000, HAUTEUR_SCREEN * 65 / 100);
        navbar.setBounds(0, 0,LARGEUR_SCREEN, HAUTEUR_SCREEN /12);
        nom_txt.setBounds(navbar.getWidth()/100 , navbar.getHeight()/ 2 -10, 300, 20);  
        logout.setBounds(navbar.getWidth()*9/10, navbar.getHeight()/2 - 15, 150, 30);
        
        JPanel Case;
        int tempsSeance;
        Seance_enseignant scE;
        SeanceSalle SS;
        JLabel infoEdt1;
        JLabel infoEdt2;
        JLabel infoEdt3;
        JLabel infoEdt4;
        JLabel infoEdt5;
        int cpt=0;
        if(droit==4)
        {       
                etudiant etu = new etudiant(user);
                SeanceGroupe seanceUser = new SeanceGroupe(etu.getGroupe().GetID());
                for (int j = 0; j < seanceUser.getSeance().size(); j++)
                {System.out.println(seanceUser.getSeance().size());
                   if(seanceUser.getSeance().get(j).Getcours().GetNom().equals(nom))
                    {
                                cpt++;
                               
                                Case = new JPanel();
                                Case.setBounds(0,(conteneurEDT.getHeight()/16)*cpt,conteneurEDT.getWidth(),(conteneurEDT.getHeight()/16));
                                scE = new Seance_enseignant(seanceUser.getSeance().get(j).getID());
                                SS = new SeanceSalle(seanceUser.getSeance().get(j).getID());
                                infoEdt1 = new JLabel( "               "+seanceUser.getSeance().get(j).Getcours().GetNom()+ "               ");
                                infoEdt2 = new JLabel("               "+scE.GetEnseignant().Getuser().getPrenom()+" "+scE.GetEnseignant().Getuser().getNom()+ "               ");
                                infoEdt3 = new JLabel("               "+etu.getGroupe().getNom()+ " " + etu.getGroupe().getPromo()+ "               ");
                                infoEdt4 = new JLabel("               "+SS.GetSalle().GetNom()+ " " + SS.GetSalle().GetSite() + " " + SS.GetSalle().getCapacite()+ "               ");
                                infoEdt5 = new JLabel("               "+ "heure:" +seanceUser.getSeance().get(j).GetheureD()+":"+seanceUser.getSeance().get(j).GetminuteD()+ "-" +seanceUser.getSeance().get(j).GetheureF()+":"+ seanceUser.getSeance().get(j).GetminuteF());

                                infoEdt1.setBounds(Case.getWidth()/2 -25 , Case.getHeight()/6, 50, 10);
                                infoEdt2.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*2/6, 50, 10);
                                infoEdt3.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*3/6, 50, 10);
                                infoEdt4.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*4/6, 50, 10);
                                infoEdt5.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*4/6, 50, 10);
                               

                                Case.add(infoEdt1);
                                Case.add(infoEdt2);
                                Case.add(infoEdt3);
                                Case.add(infoEdt4);
                                Case.add(infoEdt5);
                                conteneurEDT.add(Case);
                               
                    }
                }        
                jp.add(navbar);
                jp.add(conteneurEDT);
                add(jp);
                setVisible(true);
        }
        else if(droit==2)
        {
                utilisateur nouveau= new utilisateur(nom);
                etudiant etu = new etudiant(nouveau);
                SeanceGroupe seanceUser = new SeanceGroupe(etu.getGroupe().GetID());
                for (int j = 0; j < seanceUser.getSeance().size(); j++)
                {
                    {
                                cpt++;
                                Case = new JPanel();
                                Case.setBounds(0,(conteneurEDT.getHeight()/16)*cpt,conteneurEDT.getWidth(),(conteneurEDT.getHeight()/16));
                                scE = new Seance_enseignant(seanceUser.getSeance().get(j).getID());
                                SS = new SeanceSalle(seanceUser.getSeance().get(j).getID());
                                infoEdt1 = new JLabel("               "+seanceUser.getSeance().get(j).Getcours().GetNom()+ "               ");
                                infoEdt2 = new JLabel("               "+scE.GetEnseignant().Getuser().getPrenom()+" "+scE.GetEnseignant().Getuser().getNom()+ "               ");
                                infoEdt3 = new JLabel("               "+etu.getGroupe().getNom()+ " " + etu.getGroupe().getPromo()+ "               ");
                                infoEdt4 = new JLabel("               "+SS.GetSalle().GetNom()+ " " + SS.GetSalle().GetSite() + " " + SS.GetSalle().getCapacite()+ "               ");
                                infoEdt5 = new JLabel("               "+ "heure:" +seanceUser.getSeance().get(j).GetheureD()+":"+seanceUser.getSeance().get(j).GetminuteD()+ "-" +seanceUser.getSeance().get(j).GetheureF()+":"+ seanceUser.getSeance().get(j).GetminuteF());
                                infoEdt1.setBounds(Case.getWidth()/2 -25 , Case.getHeight()/6, 50, 10);
                                infoEdt2.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*2/6, 50, 10);
                                infoEdt3.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*3/6, 50, 10);
                                infoEdt4.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*4/6, 50, 10);
                                infoEdt5.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*5/6, 50, 10);
                                
                                Case.add(infoEdt1);
                                Case.add(infoEdt2);
                                Case.add(infoEdt3);
                                Case.add(infoEdt4);
                                Case.add(infoEdt5);
                                
                                conteneurEDT.add(Case);
                                
                               
                    }
                }        
                jp.add(navbar);
                jp.add(conteneurEDT);
                add(jp);
                setVisible(true);
            
        }
       else
        {
                utilisateur nouveau= new utilisateur(nom);
                if(nouveau.getDroit()==4)
               {
                etudiant etu = new etudiant(nouveau);
                SeanceGroupe seanceUser = new SeanceGroupe(etu.getGroupe().GetID());
                for (int j = 0; j < seanceUser.getSeance().size(); j++)
                {
                    {
                                cpt++;
                                Case = new JPanel();
                                Case.setBounds(0,(conteneurEDT.getHeight()/16)*cpt,conteneurEDT.getWidth(),(conteneurEDT.getHeight()/16));
                                scE = new Seance_enseignant(seanceUser.getSeance().get(j).getID());
                                SS = new SeanceSalle(seanceUser.getSeance().get(j).getID());
                                infoEdt1 = new JLabel("               "+seanceUser.getSeance().get(j).Getcours().GetNom()+ "               ");
                                infoEdt2 = new JLabel("               "+scE.GetEnseignant().Getuser().getPrenom()+" "+scE.GetEnseignant().Getuser().getNom()+ "               ");
                                infoEdt3 = new JLabel("               "+etu.getGroupe().getNom()+ " " + etu.getGroupe().getPromo()+ "               ");
                                infoEdt4 = new JLabel("               "+SS.GetSalle().GetNom()+ " " + SS.GetSalle().GetSite() + " " + SS.GetSalle().getCapacite()+ "               ");
                                infoEdt5 = new JLabel("               "+ "heure:" +seanceUser.getSeance().get(j).GetheureD()+":"+seanceUser.getSeance().get(j).GetminuteD()+ "-" +seanceUser.getSeance().get(j).GetheureF()+":"+ seanceUser.getSeance().get(j).GetminuteF());
                                infoEdt1.setBounds(Case.getWidth()/2 -25 , Case.getHeight()/6, 50, 10);
                                infoEdt2.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*2/6, 50, 10);
                                infoEdt3.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*3/6, 50, 10);
                                infoEdt4.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*4/6, 50, 10);
                                infoEdt5.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*5/6, 50, 10);
                                
                                
                                Case.add(infoEdt1);
                                Case.add(infoEdt2);
                                Case.add(infoEdt3);
                                Case.add(infoEdt4);
                                Case.add(infoEdt5);
                                conteneurEDT.add(Case);
                                Modifier.addActionListener(new Research.bt1Listener());
                                Supprimer.addActionListener(new Research.bt2Listener());
                               
                    }
                }        
                jp.add(navbar);
                jp.add(conteneurEDT);
                add(jp);
                setVisible(true);
               }
               else
              {
               Enseignant profs= new Enseignant(nouveau.getID());
               System.out.println(profs.Getuser().getNom());
               Seance_enseignant seanceEns = new Seance_enseignant(profs.Getuser().getID(), true);
               for (int j = 0; j < seanceEns.getSeance().size(); j++)
                {
                    {
                                cpt++;
                                Case = new JPanel();
                                Case.setBounds(0,(conteneurEDT.getHeight()/16)*cpt,conteneurEDT.getWidth(),(conteneurEDT.getHeight()/16));
                                scE = new Seance_enseignant(seanceEns.getSeance().get(j).getID());
                                SS = new SeanceSalle(seanceEns.getSeance().get(j).getID());
                                infoEdt1 = new JLabel( "               "+seanceEns.getSeance().get(j).Getcours().GetNom()+ "               ");
                                infoEdt2 = new JLabel("               "+scE.GetEnseignant().Getuser().getPrenom()+" "+scE.GetEnseignant().Getuser().getNom()+ "               ");
                                
                                infoEdt4 = new JLabel("               "+SS.GetSalle().GetNom()+ " " + SS.GetSalle().GetSite() + " " + SS.GetSalle().getCapacite()+ "               ");
                                infoEdt5 = new JLabel("               "+ "heure:" +seanceEns.getSeance().get(j).GetheureD()+":"+seanceEns.getSeance().get(j).GetminuteD()+ "-" +seanceEns.getSeance().get(j).GetheureF()+":"+ seanceEns.getSeance().get(j).GetminuteF());
                                infoEdt1.setBounds(Case.getWidth()/2 -25 , Case.getHeight(), 50, 10);
                                infoEdt2.setBounds(Case.getWidth()/2 -25 , Case.getHeight(), 50, 10);
                                infoEdt4.setBounds(Case.getWidth()/2 -25 , Case.getHeight(), 50, 10);
                                infoEdt5.setBounds(Case.getWidth()/2 -25 , Case.getHeight(), 50, 10);
                               
                                Modifier.setBounds(Case.getWidth()/2 -25 , Case.getHeight(), 50, 10);
                                Supprimer.setBounds(Case.getWidth()/2 -25 , Case.getHeight(), 50, 10);
                 
                                Case.add(infoEdt1);
                                Case.add(infoEdt2);
                                Case.add(infoEdt4);
                                Case.add(infoEdt5);
                                conteneurEDT.add(Case);
                                Modifier.addActionListener(new Research.bt1Listener());
                                Supprimer.addActionListener(new Research.bt2Listener());
                                
                               
                    }
                }        
                jp.add(navbar);
                jp.add(conteneurEDT);
                add(jp);
                setVisible(true);
               }
               
              }

    }

    private static class bt1Listener implements ActionListener {

        public bt1Listener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class bt2Listener implements ActionListener {

        public bt2Listener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
                

   
        
}

