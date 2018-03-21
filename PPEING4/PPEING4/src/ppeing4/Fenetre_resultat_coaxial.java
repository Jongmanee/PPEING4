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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static javax.xml.bind.JAXBIntrospector.getValue;

/**
 *
 * @author gautier
 */
public class Fenetre_resultat_coaxial extends JFrame{
    
    JPanel panneau;
    JTable tableau;
    JTable tableau2;
    
    
    public Fenetre_resultat_coaxial(float longueur, float largeur, float hauteur, float debit_m, float capacite_th, float tempc, float tempf, float masse_volumique, float viscosite, float epaisseur)
            {
                
                Coaxial coax1;
        
                coax1 = new Coaxial(longueur, largeur, hauteur, debit_m,capacite_th,tempc, tempf, masse_volumique);
        
                
              
                 double smod_main = coax1.calcul_smod(coax1.getter_surface_module());
                 System.out.println(smod_main);
                 
                 double densite_couple_main = coax1.calcul_densite_couple();
                 System.out.println(densite_couple_main);
         
                 
                 double rth_main = coax1.calcul_rth(debit_m, masse_volumique, epaisseur, viscosite, capacite_th);
                 System.out.println(rth_main);
                 
                 double pe_main = coax1.calcul_Pe();
                 System.out.println(pe_main);
                 
                 String entetes[] = {"Résultat","Valeur"};
                 Object donnees[][] = {
                    {"Nombre de modules",coax1.getter_nbre_modules()},
                    {"Surface proposée (en m²)",coax1.getter_surface_contact()},
                    {"Surface utilisée par les modules (en m²)",smod_main},
                    {"Débit massique (en m3/h)",debit_m},
                    {"Température chaude (en °C)",tempc},
                    {"Température froide (en °C)",tempf},
                    {"Différence de température",coax1.getter_diff_temperature()},
                    {"Puissance électrique générée (en W)",pe_main},
                 };
                
                 
                 DefaultTableModel modele = new DefaultTableModel(donnees,entetes)
                 {
                    @Override
                    public boolean isCellEditable(int row, int col)
                    {
			return false;
                    }
                };
                 
                tableau = new JTable(modele);
                
                String entetes2[] = {"Caractéristiques","Valeurs"};
                Object donnees2[][] = {
                    {"Surface d'un module (en m²)",coax1.getter_surface_module()},
                    {"Longueur d'une jambe (en m)",coax1.getter_longueur_jambe()},
                    {"Surface d'une jambe (en m²)",coax1.getter_surface_jambe()},
                    {"Densité de couple",coax1.getter_densite_couple()},
                    {"Conductivité thermique du module (en W/m/K)",coax1.getter_conduct_th_module()}
                };
                
                DefaultTableModel modele2 = new DefaultTableModel(donnees2,entetes2)
                 {
                    @Override
                    public boolean isCellEditable(int row, int col)
                    {
			return false;
                    }
                };
                
                tableau2 = new JTable(modele2);
                
                JScrollPane tableau_entete = new JScrollPane(tableau);
                JScrollPane tableau_entete2 = new JScrollPane(tableau2);
                
                tableau_entete.setViewportView(tableau);
                tableau_entete2.setViewportView(tableau2);
                
                tableau_entete.setPreferredSize(new Dimension(500, 155));
                tableau_entete2.setPreferredSize(new Dimension(550, 110));
                
                JLabel label_module=new JLabel("Caractéristique du module utilisé");
                setBounds(0,0,600,600);
                setTitle("Résultats Technologie Coaxial");    
                panneau = new JPanel();
                panneau.add(tableau_entete);
                panneau.add(label_module);
                panneau.add(tableau_entete2);
                getContentPane().add(panneau);
                this.setLocation(600,0);
                         
            }
    
    
    }
    
    
    
    


