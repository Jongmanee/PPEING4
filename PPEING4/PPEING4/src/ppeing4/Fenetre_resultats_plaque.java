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
public class Fenetre_resultats_plaque extends JFrame{
    
    JPanel panneau;
    JTable tableau;
    JTable tableau2;
    
    
    public Fenetre_resultats_plaque( float debit_m_1,float debit_m_2, float capacite_th_1, float capacite_th_2, float viscosite_1, float viscosite_2, float conductivite_th_1, float conductivite_th_2, float masse_volumique_1, float masse_volumique_2, float tempc, float tempf, float temp_ech)
            {
                
                Plaques plaque1;
        
                plaque1 = new Plaques(debit_m_1, debit_m_2, capacite_th_1, capacite_th_2,tempc, tempf, masse_volumique_1, masse_volumique_2, viscosite_1, viscosite_2, conductivite_th_1, conductivite_th_2, temp_ech);
        
                
              
                 double temp_dtlm_main = plaque1.calcul_temperature_DTLM();
                 System.out.println(temp_dtlm_main);
                 
                 double dtlm_main = plaque1.calcul_DTLM();
                 System.out.println(dtlm_main);
                 
                 double coeff_convection_h=plaque1.calcul_coeff_convection_h();
                 System.out.println(coeff_convection_h);
                 
                 int nbre_plaques_main = plaque1.calcul_nbre_plaques();
                 System.out.println(nbre_plaques_main);
                 
                 int nbre_plaques_total_main = plaque1.calcul_nbre_plaques_total();
                 System.out.println(nbre_plaques_total_main);
                 
                 
                 double sc_main = plaque1.calcul_Sc(plaque1.getter_surface_module());
                 System.out.println(sc_main);
         
                 double rth_main = plaque1.calcul_rth();
                 System.out.println(rth_main);
                 
                 
                 
                 
                
                 
                 double pe_main = plaque1.calcul_Pe();
                 System.out.println(pe_main);
                 
                 String entetes[] = {"Résultat","Valeur"};
                 Object donnees[][] = {
                    {"Nombre de modules",plaque1.getter_nbre_modules()},
                    {"Surface proposée (en m²)",plaque1.getter_surface_contact()},
                    {"Surface utilisée par les modules (en m²)",sc_main},
                    {"Débit massique chaud(en m3/h)",debit_m_1},
                    {"Débit massique froid(en m3/h)",debit_m_2},
                    {"Température chaude (en °C)",tempc},
                    {"Température froide (en °C)",tempf},
                    {"Temperature voulue sortie echangeur (en °C)",temp_ech},
                    {"Différence de température",plaque1.getter_diff_temperature()},
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
                    {"Surface d'un module (en m²)",plaque1.getter_surface_module()},
                    {"Longueur d'une jambe (en m)",plaque1.getter_longueur_jambe()},
                    {"Surface d'une jambe (en m²)",plaque1.getter_surface_jambe()},
                    {"Densité de couple",plaque1.getter_densite_couple()},
                    {"Conductivité thermique du module (en W/m/K)",plaque1.getter_conduct_th_module()}
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
                setTitle("Résultats Technologie Plaques");    
                panneau = new JPanel();
                panneau.add(tableau_entete);
                panneau.add(label_module);
                panneau.add(tableau_entete2);
                getContentPane().add(panneau);
                this.setLocation(600,0);
                         
            }
    
    
    }
    
    
    
    


