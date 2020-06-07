/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDTECE.GUI;

import EDTECE.Enseignant;
import EDTECE.Seance;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Marie
 */




public class Recap extends JFrame{
    private final int HAUTEUR_SCREEN = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private final int LARGEUR_SCREEN = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final JLabel nom_txt = new JLabel();
    private JLabel weekofyear;
    private JButton logout = new JButton("Se Déconnecter");
    private int cp;
    private utilisateur userLng;
    private JButton Modifier = new JButton("Modifier");
    private JButton Supprimer = new JButton("Supprimer");
    
    public Recap(utilisateur user)
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
        JLabel infoEdt6;
        int cpt=0;
        if(user.getDroit()==4)
        {       
                etudiant etu = new etudiant(user);
                SeanceGroupe seanceUser = new SeanceGroupe(etu.getGroupe().GetID());
                for (int j = 0; j < seanceUser.getSeance().size(); j++)
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
                                infoEdt6 = new JLabel("               "+seanceUser.getSeance().get(j).Getjour()+"/"+seanceUser.getSeance().get(j).Getmois()+"/"+seanceUser.getSeance().get(j).Getannee());
                                infoEdt1.setBounds(Case.getWidth()/2 -25 , Case.getHeight()/6, 50, 10);
                                infoEdt2.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*2/6, 50, 10);
                                infoEdt3.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*3/6, 50, 10);
                                infoEdt4.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*4/6, 50, 10);
                                infoEdt5.setBounds(Case.getWidth()/2 -25 , Case.getHeight()*4/6, 50, 10);
                                infoEdt6.setBounds(Case.getWidth()/2 -25 , Case.getHeight(), 50, 10);

                                Case.add(infoEdt1);
                                Case.add(infoEdt2);
                                Case.add(infoEdt3);
                                Case.add(infoEdt4);
                                Case.add(infoEdt5);
                                Case.add(infoEdt6);
                                conteneurEDT.add(Case);
                               
                    
                }        
                jp.add(navbar);
                jp.add(conteneurEDT);
                add(jp);
                setVisible(true);
        }
       
           else
              {
               Enseignant profs= new Enseignant(user.getID());
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
                                infoEdt1 = new JLabel("               "+seanceEns.getSeance().get(j).Getcours().GetNom()+ "               ");
                                infoEdt2 = new JLabel("               "+scE.GetEnseignant().Getuser().getPrenom()+" "+scE.GetEnseignant().Getuser().getNom()+ "               ");
                                infoEdt4 = new JLabel("               "+SS.GetSalle().GetNom()+ " " + SS.GetSalle().GetSite() + " " + SS.GetSalle().getCapacite()+ "               ");
                                infoEdt5 = new JLabel("               "+ "heure:" +seanceEns.getSeance().get(j).GetheureD()+":"+seanceEns.getSeance().get(j).GetminuteD()+ "-" +seanceEns.getSeance().get(j).GetheureF()+":"+ seanceEns.getSeance().get(j).GetminuteF());
                                infoEdt6 = new JLabel("               "+seanceEns.getSeance().get(j).Getjour()+"/"+seanceEns.getSeance().get(j).Getmois()+"/"+seanceEns.getSeance().get(j).Getannee());
                                infoEdt1.setBounds(Case.getWidth()/2 -25 , Case.getHeight(), 50, 10);
                                infoEdt2.setBounds(Case.getWidth()/2 -25 , Case.getHeight(), 50, 10);
                                infoEdt4.setBounds(Case.getWidth()/2 -25 , Case.getHeight(), 50, 10);
                                infoEdt5.setBounds(Case.getWidth()/2 -25 , Case.getHeight(), 50, 10);
                                infoEdt6.setBounds(Case.getWidth()/2 -25 , Case.getHeight(), 50, 10);
                                
                                Modifier.setBounds(Case.getWidth()/2 -25 , Case.getHeight(), 50, 10);
                                Supprimer.setBounds(Case.getWidth()/2 -25 , Case.getHeight(), 50, 10);
                 
                                Case.add(infoEdt1);
                                Case.add(infoEdt2);
                                Case.add(infoEdt4);
                                Case.add(infoEdt5);
                                Case.add(infoEdt6);
                                conteneurEDT.add(Case);
                               
                                infoEdt6.setBounds(Case.getWidth()/2 -25 , Case.getHeight(), 50, 10);
                               
                    }
                }        
                jp.add(navbar);
                jp.add(conteneurEDT);
                add(jp);
                setVisible(true);
               }
               
              }

    }

    
    
                

   
        


    

