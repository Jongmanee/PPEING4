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
    Box boxerreurchamp = Box.createHorizontalBox();
    
    public Fenetre_saisie ()
    {
        String[] choix = {"Coaxial", "À plaques", "À spirales"};
        JOptionPane jop = new JOptionPane();
        bulle = (String)jop.showInputDialog(null, "Veuillez choisir la technologie de l'échangeur","PPE ING4 GEOTHERMIE",JOptionPane.QUESTION_MESSAGE,null,choix,choix[2]);
        System.out.println(bulle);

        if (bulle!=null)
        {                                   
            setBounds(0,0,600,600);
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
            box2.add(debitnb);

            JLabel capacitelb=new JLabel("Rentrer la capacite (en J/°K) :");
            box3.add(capacitelb);
            capacitenb= new JTextField();
            capacitenb.setColumns(30);
            box3.add(capacitenb);

            JLabel tempclb=new JLabel("Rentrer la temperature chaude (en °C) :");
            box4.add(tempclb);
            tempcnb= new JTextField();
            tempcnb.setColumns(30);
            box4.add(tempcnb);
            
            JLabel tempflb=new JLabel("Rentrer la temperature froide (en °C) :");
            box5.add(tempflb);
            tempfnb= new JTextField();
            tempfnb.setColumns(30);
            box5.add(tempfnb);  
            
            JLabel longueurlb=new JLabel("Rentrer la longueur (en m) :");
            box6.add(longueurlb);
            longueurnb= new JTextField();
            longueurnb.setColumns(30);
            box6.add(longueurnb);

            JLabel largeurlb=new JLabel("Rentrer la largueur (en m) :");
            box7.add(largeurlb);
            largeurnb= new JTextField();
            largeurnb.setColumns(30);
            box7.add(largeurnb);

            JLabel hauteurlb=new JLabel("Rentrer la hauteur (en m) :");
            box8.add(hauteurlb);
            hauteurnb= new JTextField();
            hauteurnb.setColumns(30);
            box8.add(hauteurnb);

            JLabel viscositelb=new JLabel("Rentrer la viscosite (en Pascal.s) :");
            box9.add(viscositelb);
            viscositenb= new JTextField();
            viscositenb.setColumns(30);
            box9.add(viscositenb);

            JLabel epaisseurlb=new JLabel("Rentrer l'épaisseur de la paroi (en m) :");
            box10.add(epaisseurlb);
            epaisseurnb= new JTextField();
            epaisseurnb.setColumns(30);
            box10.add(epaisseurnb);
            
            JLabel massevolumiquelb=new JLabel("Rentrer la masse volumique (Kg/m3):");
            box11.add(massevolumiquelb);
            massevolumiquenb= new JTextField();
            massevolumiquenb.setColumns(30);
            box11.add(massevolumiquenb);
            
            JLabel erreurchamp=new JLabel("Champ Manquant (Merci de renseigner tous les champs)");
            boxerreurchamp.add(erreurchamp);
            boxerreurchamp.setVisible(false);

            //faire les setVisibles
            if (bulle=="Coaxial")
            {
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
            } 
            
            if (bulle=="À spirales")
            {
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
            }   
            
            if (bulle=="À plaques")
            {
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
            }
                 
            Box lastbox = Box.createVerticalBox();
            lastbox.add(boxtechno);
            lastbox.add(box1);
            lastbox.add(box2);
            lastbox.add(box3);
            lastbox.add(box4);
            lastbox.add(box5);
            lastbox.add(box6);
            lastbox.add(box7);
            lastbox.add(box8);
            lastbox.add(box9);
            lastbox.add(box10);
            lastbox.add(box11);
            lastbox.add(boxerreurchamp);
            panneau.add(lastbox);
            getContentPane().add(panneau); 
            setLocationRelativeTo(null);
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
               // Fenetre_resultat_spirales fenetre4 ;
               // fenetre4=new Fenetre_resultat_spirales();
                //fenetre4.setVisible(true);
            }
            
            if (bulle=="À plaques")
            {
               // Fenetre_resultat_spirales fenetre5 ;
               // fenetre5=new Fenetre_resultat_plaque();
                //fenetre5.setVisible(true);
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
           }
           if (bulle=="À plaques")
           {
               //faire les setVisibles
                techno.setText("Technologie Echangeur à Plaques");
                box1.setVisible(true);
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
           }
           if (bulle=="À spirales")
           {
               //faire les setVisibles
                techno.setText("Technologie Echangeur à Spirales");
                box1.setVisible(true);
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
           }
        }
      }
     }  
}
