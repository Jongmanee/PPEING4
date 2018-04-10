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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.Format;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
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
public class Fenetre_resultats_spirales extends JFrame {

    /**
     *
     */
    public JPanel panneau;

    /**
     *
     */
    public JTable tableau;

    /**
     *
     */
    public JTable tableau2;

    /**
     *
     */
    public JTable tableau3;

    /**
     * Constructeur de la classe Fenetre_resultats_spirales
     * @param debit_m_1
     * @param debit_m_2
     * @param capacite_th_1
     * @param capacite_th_2
     * @param viscosite_1
     * @param viscosite_2
     * @param conductivite_th_1
     * @param conductivite_th_2
     * @param masse_volumique_1
     * @param masse_volumique_2
     * @param tempc
     * @param tempf
     * @param longueur 
     */
    public Fenetre_resultats_spirales(float debit_m_1, float debit_m_2, float capacite_th_1, float capacite_th_2, float viscosite_1, float viscosite_2, float conductivite_th_1, float conductivite_th_2, float masse_volumique_1, float masse_volumique_2, float tempc, float tempf, float longueur) {

        Spirale spir1;
        Finance F1;

        spir1 = new Spirale(longueur, debit_m_1, debit_m_2, capacite_th_1, capacite_th_2, tempc, tempf, masse_volumique_1, masse_volumique_2, viscosite_1, viscosite_2, conductivite_th_1, conductivite_th_2);
        F1 = new Finance();

        double nbre_spire_main = spir1.calcul_nbre_spire();

        double epaisseur_spire_main = spir1.calcul_epaisseur_spire();

        double surface_contact_main = spir1.calcul_surface_contact();

        double smod_main = spir1.calcul_smod();

        double coeff_convection_h = spir1.calcul_coeff_convection_h();

        double rth_main = spir1.calcul_rth();


        double pe_main = spir1.calcul_Pe();

        double densite_couple_main = spir1.calcul_densite_couple();

        double prix_modules_main = F1.calcul_prix_modules(spir1.getter_nbre_modules());
        if (prix_modules_main < 0) {
            prix_modules_main = 0;
        }
        double volume_materiaux_main = F1.calcul_volume_spirale(epaisseur_spire_main, surface_contact_main);
        double prix_materiaux_main = F1.calcul_prix_matiere();
        if (prix_materiaux_main < 0) {
            prix_materiaux_main = 0;
        }
        double prix_total_main = prix_modules_main + prix_materiaux_main;

        double energie_produite_main = F1.conversion_kwh(pe_main);
        double revenu_horaire_main = F1.calcul_revenu_horaire();
        double nbre_heures_main = F1.calcul_nbre_heures();
    
        DecimalFormat df2 = new DecimalFormat("#.##");
        DecimalFormat df4 = new DecimalFormat("#.####");
        DecimalFormat df5 = new DecimalFormat("#.#####");
        DecimalFormat df7 = new DecimalFormat("#.#######");
        
        String entetes[] = {"Résultat", "Valeur"};
        Object donnees[][] = {
            {"Nombre de modules", spir1.getter_nbre_modules()},
            {"Surface proposée (en m²)", df5.format(spir1.getter_surface_contact())},
            {"Surface utilisée par les modules (en m²)", df5.format(smod_main)},
            {"Débit massique chaud(en m3/h)", debit_m_1},
            {"Débit massique froid(en m3/h)", debit_m_2},
            {"Température chaude (en °C)", tempc},
            {"Température froide (en °C)", tempf},
            //{"Temperature voulue sortie echangeur (en °C)",temp_ech},
            {"Différence de température", spir1.getter_diff_temperature()},
            {"Puissance électrique générée (en W)", df2.format(pe_main)}
        };

        DefaultTableModel modele = new DefaultTableModel(donnees, entetes) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        tableau = new JTable(modele);

        String entetes2[] = {"Caractéristiques", "Valeurs"};
        Object donnees2[][] = {
            {"Surface d'un module (en m²)", spir1.getter_surface_module()},
            {"Longueur d'une jambe (en m)", df4.format(spir1.getter_longueur_jambe())},
            {"Surface d'une jambe (en m²)", df7.format(spir1.getter_surface_jambe())},
            {"Densité de couple", df5.format(spir1.getter_densite_couple())},
            {"Conductivité thermique du module (en W/m/K)", df2.format(spir1.getter_conduct_th_module())}
        };

        DefaultTableModel modele2 = new DefaultTableModel(donnees2, entetes2) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        Object donnees3[][] = {
            {"Prix des modules (en €)", df2.format(prix_modules_main)},
            {"Prix de la matière première (en €)", df2.format(prix_materiaux_main)},
            {"Prix total échangeur (en €)", df2.format(prix_total_main)},
            {"Nombre de KiloWatt-heures", df2.format(energie_produite_main)},
            {"Revenu horaire", df2.format(revenu_horaire_main)},
            {"Nbre d'heures pour remboursement", df2.format(nbre_heures_main)}

        };
        String entetes3[] = {"Caractéristiques", "Valeurs"};

        DefaultTableModel modele3 = new DefaultTableModel(donnees3, entetes3) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        tableau3 = new JTable(modele3);

        // Pour le graphique en camembert
        final JFXPanel fxPanel = new JFXPanel(); // On crée un panneau FX car on peut pas mettre des objet FX dans un JFRame
        final PieChart chart = new PieChart();  // on crée un objet de type camembert
        chart.setTitle("Répartition du prix de l'échangeur");  // on change le titre de ce graph
        chart.getData().setAll(new PieChart.Data("Prix des modules " + prix_modules_main + " €", prix_modules_main), new PieChart.Data("Prix du matériau " + df2.format(prix_materiaux_main) + " €", prix_materiaux_main)
        ); // on implémente les différents case du camebert
        final Scene scene = new Scene(chart); // on crée une scene (FX) où l'on met le graph camembert
        fxPanel.setScene(scene);

        // a partir de là c'est plus le camembert
        tableau2 = new JTable(modele2);

        JScrollPane tableau_entete = new JScrollPane(tableau);
        JScrollPane tableau_entete2 = new JScrollPane(tableau2);
        JScrollPane tableau_entete3 = new JScrollPane(tableau3);

        tableau_entete.setViewportView(tableau);
        tableau_entete2.setViewportView(tableau2);
        tableau_entete3.setViewportView(tableau3);

        tableau_entete.setPreferredSize(new Dimension(550, 170));
        tableau_entete2.setPreferredSize(new Dimension(550, 110));
        tableau_entete3.setPreferredSize(new Dimension(550, 120));

        JLabel label_resultat = new JLabel("Resultats de la simulation");
        JLabel label_module = new JLabel("Caractéristiques du module utilisé");
        JLabel label_prix = new JLabel("Prix de l'échangeur");
        setBounds(0, 0, 600, 950);
        setTitle("Résultats Technologie Spirale");
        panneau = new JPanel();

        panneau.add(label_resultat);
        panneau.add(tableau_entete);
        panneau.add(label_module);
        panneau.add(tableau_entete2);
        panneau.add(label_prix);
        panneau.add(tableau_entete3);
        panneau.add(fxPanel); // on ajoute au Jframe notre panneau FX (qui contient donc UNE "scene" qui elle contient les object FX, ici notre camembert)
        getContentPane().add(panneau);
        this.setLocation(600, 0);
        this.setResizable(false);
    }

}
