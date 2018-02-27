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
public class Fenetre_resultat_coaxial extends JFrame{
    
    
    
    public Fenetre_resultat_coaxial(float longueur, float largeur, float hauteur, float debit_m, float capacite_th, float tempc, float tempf, float masse_volumique, float viscosite, float epaisseur)
            {
                
                 Coaxial coax1;
        
                coax1 = new Coaxial(longueur, largeur, hauteur, debit_m,capacite_th,tempc, tempf, masse_volumique);
        
                
              
                 double smod_main = coax1.calcul_smod(coax1.getter_surface_module());
                 System.out.println(smod_main);
                 
                 double densite_couple_main = coax1.calcul_densite_couple();
                 System.out.println(densite_couple_main);
         
                 double r_charge_main = coax1.calcul_r_charge(coax1.getter_densite_couple(), longueur, largeur);
                 System.out.println(r_charge_main);
                 
                 double rth_main = coax1.calcul_rth(debit_m, masse_volumique, epaisseur, viscosite, coax1.getter_conduct_th(), capacite_th);
                 System.out.println(rth_main);
                 
                 double pe_main = coax1.calcul_Pe();
                 System.out.println(pe_main);
                
                
                
                
            }
    
    
    
    
}
