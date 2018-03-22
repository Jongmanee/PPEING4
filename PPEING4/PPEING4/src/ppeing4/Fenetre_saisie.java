/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppeing4;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.text.Format;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Box;
import static javax.xml.bind.JAXBIntrospector.getValue;

/**
 *
 * @author gautier
 */
public class Fenetre_saisie extends JFrame
{
    
    JButton b1,b2;
    JPanel panneau;
    JTextArea txt_utilisation;
    String bulle;
    JTextField debitnb;
    JTextField capacitenb;
    JTextField tempcnb;
    JTextField tempfnb;
    JTextField longueurnb;
    JTextField largeurnb;
    JTextField hauteurnb;
    JTextField epaisseurnb;
    JTextField viscositenb;
    JTextField massevolumiquenb;
    JTextField debit1nb;
    JTextField debit2nb;
    JTextField viscosite1nb;
    JTextField viscosite2nb;
    JTextField capacite1nb;
    JTextField capacite2nb;
    JTextField lambda1nb;
    JTextField lambda2nb;
    JTextField tempfroidnb;
    JTextField tempchaudnb;
    JTextField massevolumique1nb;
    JTextField massevolumique2nb;
    JLabel techno;
    Box boxtechno = Box.createHorizontalBox();
    Box box1 = Box.createHorizontalBox();
    Box box2 = Box.createHorizontalBox();
    Box box3 = Box.createHorizontalBox();
    Box box4 = Box.createHorizontalBox();
    Box box5 = Box.createHorizontalBox();
    Box box6 = Box.createHorizontalBox();
    Box box7 = Box.createHorizontalBox();
    Box box8 = Box.createHorizontalBox();
    Box box9 = Box.createHorizontalBox();
    Box box10 = Box.createHorizontalBox();
    Box box11 = Box.createHorizontalBox();
    Box box12 = Box.createHorizontalBox();
    Box box13 = Box.createHorizontalBox();
    Box box14 = Box.createHorizontalBox();
    Box box15 = Box.createHorizontalBox();
    Box box16 = Box.createHorizontalBox();
    Box box17 = Box.createHorizontalBox();
    Box box18 = Box.createHorizontalBox();
    Box box19 = Box.createHorizontalBox();
    Box box21 = Box.createHorizontalBox();
    Box box22 = Box.createHorizontalBox();
    Box box23 = Box.createHorizontalBox();
    Box box24 = Box.createHorizontalBox();
    Box boxerreurchamp = Box.createHorizontalBox();
    Box boxlabel1=Box.createHorizontalBox();
    Box boxlabel2=Box.createHorizontalBox();
    Box boxlabel3=Box.createHorizontalBox();
    Box boxlabel4=Box.createHorizontalBox();
    Box boxlabel5=Box.createHorizontalBox();
    
    public Fenetre_saisie ()
    {
        String[] choix = {"Coaxial", "À plaques", "À spirales"};
        JOptionPane jop = new JOptionPane();
        bulle = (String)jop.showInputDialog(null, "Veuillez choisir la technologie de l'échangeur","PPE ING4 GEOTHERMIE",JOptionPane.QUESTION_MESSAGE,null,choix,choix[2]);
        System.out.println(bulle);

        if (bulle!=null)
        {                                   
            setBounds(0,0,800,600);
            setTitle("Saisie des Données");    
            panneau = new JPanel();

            b1 = new JButton("Résultats");
            b2 = new JButton("Changer de technologie");

            Ecouteur2 ec;
            ec = new Ecouteur2();
            b1.addActionListener(ec);
            b2.addActionListener(ec);

            box1.add(b1);
            box1.add(b2);

            // Formulaire (partie coaxial)
            if (bulle=="Coaxial")
            {
                techno=new JLabel("Technologie Echangeur Coaxial");
                boxtechno.add(techno);
                boxtechno.setVisible(true);
            }
            
            if (bulle=="À plaques")
            {
                techno=new JLabel("Technologie Echangeur à Plaques");
                boxtechno.add(techno);
                boxtechno.setVisible(true);
            }
            
            if (bulle=="À spirales")
            {
                techno=new JLabel("Technologie Echangeur à Spirales");
                boxtechno.add(techno);
                boxtechno.setVisible(true);
            }
            
            JLabel debitlb=new JLabel("Rentrer le debit :");
            box2.add(debitlb);
            debitnb= new JTextField();
            debitnb.setColumns(30);
            box2.add(Box.createRigidArea(new Dimension(5,0)));//créé un espace entre le layout et la zone de donné
            box2.add(debitnb);

            JLabel capacitelb=new JLabel("Rentrer la capacite (en J/°K) :");
            box3.add(capacitelb);
            capacitenb= new JTextField();
            capacitenb.setColumns(30);
            box3.add(Box.createRigidArea(new Dimension(5,0)));
            box3.add(capacitenb);

            JLabel tempclb=new JLabel("Rentrer la temperature chaude (en °C) :");
            box4.add(tempclb);
            tempcnb= new JTextField();
            tempcnb.setColumns(30);
            box4.add(Box.createRigidArea(new Dimension(5,0)));
            box4.add(tempcnb);
            
            JLabel tempflb=new JLabel("Rentrer la temperature froide (en °C) :");
            box5.add(tempflb);
            tempfnb= new JTextField();
            tempfnb.setColumns(30);
            box5.add(Box.createRigidArea(new Dimension(5,0)));
            box5.add(tempfnb);  
            
            JLabel longueurlb=new JLabel("Rentrer la longueur (en m) :");
            box6.add(longueurlb);
            longueurnb= new JTextField();
            longueurnb.setColumns(30);
            box6.add(Box.createRigidArea(new Dimension(5,0)));
            box6.add(longueurnb);

            JLabel largeurlb=new JLabel("Rentrer la largueur (en m) :");
            box7.add(largeurlb);
            largeurnb= new JTextField();
            largeurnb.setColumns(30);
            box7.add(Box.createRigidArea(new Dimension(5,0)));
            box7.add(largeurnb);

            JLabel hauteurlb=new JLabel("Rentrer la hauteur (en m) :");
            box8.add(hauteurlb);
            hauteurnb= new JTextField();
            hauteurnb.setColumns(30);
            box8.add(Box.createRigidArea(new Dimension(5,0)));
            box8.add(hauteurnb);

            JLabel viscositelb=new JLabel("Rentrer la viscosite (en Pascal.s) :");
            box9.add(viscositelb);
            viscositenb= new JTextField();
            viscositenb.setColumns(30);
            box9.add(Box.createRigidArea(new Dimension(5,0)));
            box9.add(viscositenb);

            JLabel epaisseurlb=new JLabel("Rentrer l'épaisseur de la paroi (en m) :");
            box10.add(epaisseurlb);
            epaisseurnb= new JTextField();
            epaisseurnb.setColumns(30);
            box10.add(Box.createRigidArea(new Dimension(5,0)));
            box10.add(epaisseurnb);
            
            JLabel massevolumiquelb=new JLabel("Rentrer la masse volumique (Kg/m3):");
            box11.add(massevolumiquelb);
            massevolumiquenb= new JTextField();
            massevolumiquenb.setColumns(30);
            box11.add(Box.createRigidArea(new Dimension(5,0)));
            box11.add(massevolumiquenb);
            
            //techno a plaque
            
            JLabel debit1lb=new JLabel("Rentrer le debit du fluide 1 (m3/h):");
            box12.add(debit1lb);
            debit1nb= new JTextField();
            debit1nb.setColumns(30);
            box12.add(Box.createRigidArea(new Dimension(5,0)));
            box12.add(debit1nb);
            
            JLabel debit2lb=new JLabel("Rentrer le debit du fluide 2 (m3/h):");
            box13.add(debit2lb);
            debit2nb= new JTextField();
            debit2nb.setColumns(30);
            box13.add(Box.createRigidArea(new Dimension(5,0)));
            box13.add(debit2nb);
            
            JLabel viscosite1lb=new JLabel("Rentrer la viscosite du fluide 1 (Pa/s):");
            box14.add(viscosite1lb);
            viscosite1nb= new JTextField();
            viscosite1nb.setColumns(30);
            box14.add(Box.createRigidArea(new Dimension(5,0)));
            box14.add(viscosite1nb);
            
            JLabel viscosite2lb=new JLabel("Rentrer la viscosite du fluide 2 (Pa/s):");
            box15.add(viscosite2lb);
            viscosite2nb= new JTextField();
            viscosite2nb.setColumns(30);
            box15.add(Box.createRigidArea(new Dimension(5,0)));
            box15.add(viscosite2nb);
            
            JLabel capacite1lb=new JLabel("Rentrer la capacite du fluide 1 (J/K):");
            box16.add(capacite1lb);
            capacite1nb= new JTextField();
            capacite1nb.setColumns(30);
            box16.add(Box.createRigidArea(new Dimension(5,0)));
            box16.add(capacite1nb);
            
            JLabel capacite2lb=new JLabel("Rentrer la capacite du fluide 2 (J/K):");
            box17.add(capacite2lb);
            capacite2nb= new JTextField();
            capacite2nb.setColumns(30);
            box17.add(Box.createRigidArea(new Dimension(5,0)));
            box17.add(capacite2nb);
            
            JLabel lambda1lb=new JLabel("Rentrer la conductivite thermique du fluide 1 (W/m/K):");
            box18.add(lambda1lb);
            lambda1nb= new JTextField();
            lambda1nb.setColumns(30);
            box18.add(Box.createRigidArea(new Dimension(5,0)));
            box18.add(lambda1nb);
            
            JLabel lambda2lb=new JLabel("Rentrer la conductivite thermique du fluide 2 (W/m/K):");
            box19.add(lambda2lb);
            lambda2nb= new JTextField();
            lambda2nb.setColumns(30);
            box19.add(Box.createRigidArea(new Dimension(5,0)));
            box19.add(lambda2nb);
            
            
            JLabel tempchaudlb=new JLabel("Rentrer la temperature du fluide Chaud (C) :");
            box21.add(tempchaudlb);
            tempchaudnb= new JTextField();
            tempchaudnb.setColumns(30);
            box21.add(Box.createRigidArea(new Dimension(5,0)));
            box21.add(tempchaudnb);
            
            JLabel tempfroidelb=new JLabel("Rentrer la temperature du fluide Froid (C):");
            box22.add(tempfroidelb);
            tempfroidnb= new JTextField();
            tempfroidnb.setColumns(30);
            box22.add(Box.createRigidArea(new Dimension(5,0)));
            box22.add(tempfroidnb);
            
            JLabel massevolumique1lb=new JLabel("Rentrer la masse volumique du fluide 1 (Kg/m3) :");
            box23.add(massevolumique1lb);
            massevolumique1nb= new JTextField();
            massevolumique1nb.setColumns(30);
            box23.add(Box.createRigidArea(new Dimension(5,0)));
            box23.add(massevolumique1nb);
            
            JLabel massevolumique2lb=new JLabel("Rentrer la masse volumique du fluide 2 (Kg/m3) :");
            box24.add(massevolumique2lb);
            massevolumique2nb= new JTextField();
            massevolumique2nb.setColumns(30);
            box24.add(Box.createRigidArea(new Dimension(5,0)));
            box24.add(massevolumique2nb);
            
            JLabel erreurchamp=new JLabel("Champ Manquant (Merci de renseigner tous les champs)");
            boxerreurchamp.add(erreurchamp);
            boxerreurchamp.setVisible(false);
            
            JLabel cat1=new JLabel("Caracteristique du fluide :");
            boxlabel1.add(cat1);
            boxlabel1.setVisible(true);
            
            JLabel cat2=new JLabel("Espace Disponible pour l'implementation de l'echangeur :");
            boxlabel2.add(cat2);
            boxlabel2.setVisible(true);
            
            JLabel cat3=new JLabel("Caracteristique de l'echangeur :");
            boxlabel3.add(cat3);
            boxlabel3.setVisible(true);
            
            JLabel cat4=new JLabel("Caracteristique du fluide 1 (fluide chaud):");
            boxlabel4.add(cat4);
            boxlabel4.setVisible(true);
            
            JLabel cat5=new JLabel("Caracteristique du fluide 2 (fluide froid):");
            boxlabel5.add(cat5);
            boxlabel5.setVisible(true);

            //faire les setVisibles
            if (bulle=="Coaxial")
            {
                boxlabel1.setVisible(true);
                boxlabel2.setVisible(true);
                boxlabel3.setVisible(true);
                boxlabel4.setVisible(false);
                boxlabel5.setVisible(false);
                box1.setVisible(true); //bouton
                box2.setVisible(true); //debit
                box3.setVisible(true); //capacite thermique
                box4.setVisible(true); //temp chaud
                box5.setVisible(true); //temp froid
                box6.setVisible(true); //longueur
                box7.setVisible(true); //largeur
                box8.setVisible(true); //hauteur
                box9.setVisible(true); //viscosité
                box10.setVisible(true); //epaisseur
                box11.setVisible(true); //masse volumique
                box12.setVisible(false); //debit1
                box13.setVisible(false); //debit2
                box14.setVisible(false); //viscosite 1
                box15.setVisible(false); //viscosite 2
                box16.setVisible(false); //capacite 1
                box17.setVisible(false); //capacite 2
                box18.setVisible(false); //lambda 1
                box19.setVisible(false); //lambda 2
                box21.setVisible(false); // temp fluide chaud 
                box22.setVisible(false); // temp fluide froid
                box23.setVisible(false); // masse volumique 1
                box24.setVisible(false); // masse volumique 2
            } 
            
            if (bulle=="À spirales")
            {
                boxlabel1.setVisible(true);
                boxlabel2.setVisible(true);
                boxlabel3.setVisible(true);
                boxlabel4.setVisible(false);
                boxlabel5.setVisible(false);
                box1.setVisible(true);//bouton
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                box9.setVisible(false);
                box10.setVisible(false);
                box11.setVisible(false);
                box12.setVisible(false); //debit1
                box13.setVisible(false); //debit2
                box14.setVisible(false); //viscosite 1
                box15.setVisible(false); //viscosite 2
                box16.setVisible(false); //capacite 1
                box17.setVisible(false); //capacite 2
                box18.setVisible(false); //lambda 1
                box19.setVisible(false); //lambda 2
                box21.setVisible(false); // temp fluide chaud 
                box22.setVisible(false); // temp fluide froid
                box23.setVisible(false); // masse volumique 1
                box24.setVisible(false); // masse volumique 2
            }   
            
            if (bulle=="À plaques")
            {
                boxlabel1.setVisible(false);
                boxlabel2.setVisible(false);
                boxlabel3.setVisible(true);
                boxlabel4.setVisible(true);
                boxlabel5.setVisible(true);
                box1.setVisible(true);//bouton
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(true);
                box7.setVisible(true);
                box8.setVisible(true);
                box9.setVisible(false);
                box10.setVisible(false);
                box11.setVisible(false);
                box12.setVisible(true); //debit1
                box13.setVisible(true); //debit2
                box14.setVisible(true); //viscosite 1
                box15.setVisible(true); //viscosite 2
                box16.setVisible(true); //capacite 1
                box17.setVisible(true); //capacite 2
                box18.setVisible(true); //lambda 1
                box19.setVisible(true); //lambda 2
                box21.setVisible(true); // temp fluide chaud 
                box22.setVisible(true); // temp fluide froid
                box23.setVisible(true); // masse volumique 1
                box24.setVisible(true); // masse volumique 2
            }
                 
            Box lastbox = Box.createVerticalBox();
            lastbox.add(boxtechno);
            lastbox.add(Box.createVerticalStrut(20));//crée un espace
                 
            lastbox.add(boxlabel1);
            lastbox.add(boxlabel4);
            lastbox.add(Box.createVerticalStrut(20));
            lastbox.add(box2);
            lastbox.add(box3);
            lastbox.add(box4);
            lastbox.add(box5);
            lastbox.add(box9);
            lastbox.add(box11);
            lastbox.add(box12);
            lastbox.add(box14);
            lastbox.add(box16);
            lastbox.add(box18);
            lastbox.add(box23);
            lastbox.add(box21);
            lastbox.add(Box.createVerticalStrut(20));
            
            lastbox.add(boxlabel2);
            lastbox.add(boxlabel5);
            lastbox.add(Box.createVerticalStrut(20));
            lastbox.add(box6);
            lastbox.add(box7);
            lastbox.add(box8);
            lastbox.add(box13);
            lastbox.add(box15);
            lastbox.add(box17);
            lastbox.add(box19);
            lastbox.add(box24);
            lastbox.add(box22);
            lastbox.add(Box.createVerticalStrut(20));
            
            lastbox.add(boxlabel3);
            lastbox.add(Box.createVerticalStrut(20));
            lastbox.add(box10);
            lastbox.add(Box.createVerticalStrut(20));
            
            lastbox.add(box1);
            lastbox.add(Box.createVerticalStrut(20));
            lastbox.add(boxerreurchamp);
            panneau.add(lastbox);
            getContentPane().add(panneau); 
            this.setLocation(0,0);
        }

        if(bulle==null)
        {
            System.out.println("annuler");
        }
    }

     public class Ecouteur2 extends PPEING4 implements ActionListener
    {
     public void actionPerformed(ActionEvent arg0)
     {
        if (arg0.getSource()==b1)
        {
            if (bulle=="Coaxial")
            {
                try
                {
                    float debitnbV=Float.parseFloat(debitnb.getText());
                    float capacitenbV=Float.parseFloat(capacitenb.getText());
                    float tempcnbV=Float.parseFloat(tempcnb.getText());
                    float tempfnbV=Float.parseFloat(tempfnb.getText());
                    float longueurnbV=Float.parseFloat(longueurnb.getText());
                    float largeurnbV=Float.parseFloat(largeurnb.getText());
                    float hauteurnbV=Float.parseFloat(hauteurnb.getText());
                    float viscositenbV=Float.parseFloat(viscositenb.getText());
                    float epaisseurnbV=Float.parseFloat(epaisseurnb.getText());
                    float massevolumiquenbV=Float.parseFloat(massevolumiquenb.getText());

                    System.out.println(debitnbV);
                    boxerreurchamp.setVisible(false);
                    Fenetre_resultat_coaxial fenetre3 ;
                    fenetre3 = new Fenetre_resultat_coaxial(longueurnbV, largeurnbV, hauteurnbV, debitnbV,capacitenbV,tempcnbV, tempfnbV, massevolumiquenbV, viscositenbV, epaisseurnbV);
                    fenetre3.setVisible(true);
                }
                catch(NumberFormatException e)
                {
                     System.out.println("Champ manquant");
                     boxerreurchamp.setVisible(true);
                }
            }
            
            if (bulle=="À spirales")
            {
                try
                {
                    
                    
                    boxerreurchamp.setVisible(false);
                    // Fenetre_resultat_spirales fenetre4 ;
                    // fenetre4=new Fenetre_resultat_spirales();
                    //fenetre4.setVisible(true);
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Champ manquant");
                    boxerreurchamp.setVisible(true);
                }
            }
            
            if (bulle=="À plaques")
            {
                try
                {
                    float longueurnbV=Float.parseFloat(longueurnb.getText());
                    float largeurnbV=Float.parseFloat(largeurnb.getText());
                    float hauteurnbV=Float.parseFloat(hauteurnb.getText());
                    float debit1nbV=Float.parseFloat(debit1nb.getText());
                    float debit2nbV=Float.parseFloat(debit2nb.getText());
                    float viscosite1nbV=Float.parseFloat(viscosite1nb.getText());
                    float viscosite2nbV=Float.parseFloat(viscosite2nb.getText());
                    float capacite1nbV=Float.parseFloat(capacite1nb.getText());
                    float capacite2nbV=Float.parseFloat(capacite2nb.getText());
                    float lambda1nbV=Float.parseFloat(lambda1nb.getText());
                    float lambda2nbV=Float.parseFloat(lambda2nb.getText());
                    float tempfroidnbV=Float.parseFloat(tempfroidnb.getText());
                    float tempchaudnbV=Float.parseFloat(tempchaudnb.getText());
                    float massevolumique1nbV=Float.parseFloat(massevolumique1nb.getText());
                    float massevolumique2nbV=Float.parseFloat(massevolumique2nb.getText());
                    boxerreurchamp.setVisible((false));
                    Fenetre_resultats_plaque fenetre5 ;
                    fenetre5=new Fenetre_resultats_plaque(debit1nbV,debit2nbV,capacite1nbV,capacite2nbV,viscosite1nbV,viscosite2nbV,lambda1nbV,lambda2nbV,massevolumique1nbV,massevolumique2nbV,tempchaudnbV,tempfroidnbV,longueurnbV,largeurnbV,hauteurnbV);
                    fenetre5.setVisible(true);
                }
                catch(NumberFormatException e)
                {
                     System.out.println("Champ manquant");
                     boxerreurchamp.setVisible(true);
                }
            }
        }

        if(arg0.getSource()==b2)
        {
           String[] choix = {"Coaxial", "À plaques", "À spirales"};
           JOptionPane jop = new JOptionPane();
           bulle = (String)jop.showInputDialog(null, "Veuillez choisir la technologie de l'échangeur","PPE ING4 GEOTHERMIE",JOptionPane.QUESTION_MESSAGE,null,choix,choix[2]);
           System.out.println(bulle); 

           if (bulle=="Coaxial")
           {
               //faire les setVisibles
                techno.setText("Technologie Echangeur Coaxial");
                boxlabel1.setVisible(true);
                boxlabel2.setVisible(true);
                boxlabel3.setVisible(true);
                boxlabel4.setVisible(false);
                boxlabel5.setVisible(false);
                box1.setVisible(true); //bouton
                box2.setVisible(true); //debit
                box3.setVisible(true); //capacite thermique
                box4.setVisible(true); //temp chaud
                box5.setVisible(true); //temp froid
                box6.setVisible(true); //longueur
                box7.setVisible(true); //largeur
                box8.setVisible(true); //hauteur
                box9.setVisible(true); //viscosité
                box10.setVisible(true); //epaisseur
                box11.setVisible(true); //masse volumique
                box12.setVisible(false); //debit1
                box13.setVisible(false); //debit2
                box14.setVisible(false); //viscosite 1
                box15.setVisible(false); //viscosite 2
                box16.setVisible(false); //capacite 1
                box17.setVisible(false); //capacite 2
                box18.setVisible(false); //lambda 1
                box19.setVisible(false); //lambda 2
                box21.setVisible(false); // temp fluide chaud 
                box22.setVisible(false); // temp fluide froid
                box23.setVisible(false); // masse volumique 1
                box24.setVisible(false); // masse volumique 2
                boxerreurchamp.setVisible(false);
           }
           if (bulle=="À plaques")
           {
               //faire les setVisibles
                techno.setText("Technologie Echangeur à Plaques");
                boxlabel1.setVisible(false);
                boxlabel2.setVisible(false);
                boxlabel3.setVisible(true);
                boxlabel4.setVisible(true);
                boxlabel5.setVisible(true);
                box1.setVisible(true);//bouton
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(true); // longueur
                box7.setVisible(true); // largeur
                box8.setVisible(true); // hauteur
                box9.setVisible(false);
                box10.setVisible(false);
                box11.setVisible(false);
                box12.setVisible(true); //debit1
                box13.setVisible(true); //debit2
                box14.setVisible(true); //viscosite 1
                box15.setVisible(true); //viscosite 2
                box16.setVisible(true); //capacite 1
                box17.setVisible(true); //capacite 2
                box18.setVisible(true); //lambda 1
                box19.setVisible(true); //lambda 2
                box21.setVisible(true); // temp fluide chaud 
                box22.setVisible(true); // temp fluide froid
                box23.setVisible(true); // masse volumique 1
                box24.setVisible(true); // masse volumique 2
                boxerreurchamp.setVisible(false);
           }
           if (bulle=="À spirales")
           {
               //faire les setVisibles
                techno.setText("Technologie Echangeur à Spirales");
                boxlabel1.setVisible(true);
                boxlabel2.setVisible(true);
                boxlabel3.setVisible(true);
                boxlabel4.setVisible(false);
                boxlabel5.setVisible(false);
                box1.setVisible(true);//bouton
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                box9.setVisible(false);
                box10.setVisible(false);
                box11.setVisible(false);
                box12.setVisible(false); //debit1
                box13.setVisible(false); //debit2
                box14.setVisible(false); //viscosite 1
                box15.setVisible(false); //viscosite 2
                box16.setVisible(false); //capacite 1
                box17.setVisible(false); //capacite 2
                box18.setVisible(false); //lambda 1
                box19.setVisible(false); //lambda 2
                box21.setVisible(false); // temp fluide chaud 
                box22.setVisible(false); // temp fluide froid
                box23.setVisible(false); // masse volumique 1
                box24.setVisible(false); // masse volumique 2
                boxerreurchamp.setVisible(false);
           }
        }
      }
     }  
}
