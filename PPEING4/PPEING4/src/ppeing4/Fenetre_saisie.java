/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppeing4;
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

/**
 *
 * @author gautier
 */
public class Fenetre_saisie extends JFrame{
    
    JButton b1,b2;
    JPanel panneau;
    JTextArea txt_utilisation;
    String bulle;
    
    public Fenetre_saisie ()
    {
        String[] choix = {"Coaxial", "À plaques", "À spirales"};
                    JOptionPane jop = new JOptionPane();

                    bulle = (String)jop.showInputDialog(null, 
                    "Veuillez choisir la technologie de l'échangeur",
                    "PPE ING4 GEOTHERMIE",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    choix,
                    choix[2]);
        System.out.println(bulle);
        if (bulle!=null)
    {
                     
                     
                     
    setBounds(0,0,600,600);
        setTitle("PPE-ING4-GEOTHERMIE");
        
        panneau = new JPanel();
        
        
                    
                    if(bulle=="Coaxial")
                    {
                        System.out.println("ok");
                        
                    }
                    
                    
                    
                 
                     
          b1 = new JButton("Résultats");
          b2 = new JButton("Changer de technologie");
          
          
          Ecouteur2 ec;
        ec = new Ecouteur2();
        b1.addActionListener(ec);
        b2.addActionListener(ec);
          
          panneau.add(b1);
          panneau.add(b2);
          
        // Formulaire (partie coaxial)
        JLabel debitlb=new JLabel("Rentrer le debit");
        panneau.add(debitlb);
        JFormattedTextField debitnb= new JFormattedTextField(NumberFormat.getInstance());
        debitnb.setColumns(20);
        panneau.add(debitnb);
        
        
        JLabel capacitelb=new JLabel("Rentrer la capacite");
        panneau.add(capacitelb);
        JFormattedTextField capacitenb= new JFormattedTextField(NumberFormat.getInstance());
        capacitenb.setColumns(20);
        panneau.add(capacitenb);
        
        
        JLabel difftemperaturelb=new JLabel("Rentrer la différence de temperature");
        panneau.add(difftemperaturelb);
        JFormattedTextField difftemperaturenb= new JFormattedTextField(NumberFormat.getInstance());
        difftemperaturenb.setColumns(20);
        panneau.add(difftemperaturenb);
        
        
        JLabel massevolumiquelb=new JLabel("Rentrer la masse volumique");
        panneau.add(massevolumiquelb);
        JFormattedTextField massevolumiquenb= new JFormattedTextField(NumberFormat.getInstance());
        massevolumiquenb.setColumns(20);
        panneau.add(massevolumiquenb);
        
        
        JLabel longueurlb=new JLabel("Rentrer la longueur");
        panneau.add(longueurlb);
        JFormattedTextField longueurnb= new JFormattedTextField(NumberFormat.getInstance());
        longueurnb.setColumns(20);
        panneau.add(longueurnb);
        
        
        JLabel largeurlb=new JLabel("Rentrer la largueur");
        panneau.add(largeurlb);
        JFormattedTextField largeurnb= new JFormattedTextField(NumberFormat.getInstance());
        largeurnb.setColumns(20);
        panneau.add(largeurnb);
        
        
        JLabel hauteurlb=new JLabel("Rentrer la hauteur");
        panneau.add(hauteurlb);
        JFormattedTextField hauteurnb= new JFormattedTextField(NumberFormat.getInstance());
        hauteurnb.setColumns(20);
        panneau.add(hauteurnb);
        
        JLabel viscositelb=new JLabel("Rentrer la viscosite");
        panneau.add(debitlb);
        JFormattedTextField viscositenb= new JFormattedTextField(NumberFormat.getInstance());
        debitnb.setColumns(20);
        panneau.add(debitnb);
        
        JLabel epaisseurlb=new JLabel("Rentrer l'épaisseur de la paroi");
        panneau.add(debitlb);
        JFormattedTextField epaisseurnb= new JFormattedTextField(NumberFormat.getInstance());
        debitnb.setColumns(20);
        panneau.add(debitnb);
        //faire les setVisibles
        
        getContentPane().add(panneau); 
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
                         Fenetre_resultats fenetre3 ;
                        fenetre3 = new Fenetre_resultats();
                        fenetre3.setVisible(true);
                    }
                     
                     if(arg0.getSource()==b2)
                     {
                       if (bulle=="Coaxial")
                       {
                           //faire les setVisibles
                       }
                       if (bulle=="À plaques")
                       {
                           //faire les setVisibles
                       }
                       if (bulle=="À spirales")
                       {
                           //faire les setVisibles
                       }
                     }
                }
         
         }
         
         
        
    
}
