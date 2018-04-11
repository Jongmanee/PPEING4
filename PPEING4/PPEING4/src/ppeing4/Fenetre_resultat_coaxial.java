/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppeing4;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.text.DecimalFormat;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gautier
 */
public class Fenetre_resultat_coaxial extends JFrame {

    public JPanel panneau;
    public JTable tableau;
    public JTable tableau2;
    public JTable tableau3;
    
    /**
     * Constrcteur de la classe Fenetre_resultat_coaxial
     * @param longueur
     * @param largeur
     * @param hauteur
     * @param debit_m
     * @param capacite_th
     * @param tempc
     * @param tempf
     * @param masse_volumique
     * @param viscosite
     * @param epaisseur 
     */
    public Fenetre_resultat_coaxial(float longueur, float largeur, float hauteur, float debit_m, float capacite_th, float tempc, float tempf, float masse_volumique, float viscosite, float epaisseur) {

        Coaxial coax1;
        Finance F1;

        coax1 = new Coaxial(longueur, largeur, hauteur, debit_m, capacite_th, tempc, tempf, masse_volumique);
        F1 = new Finance();

        double smod_main = coax1.calcul_smod(coax1.getter_surface_module());

        coax1.calcul_densite_couple();

        coax1.calcul_rcharge();

        coax1.calcul_rth(debit_m, masse_volumique, epaisseur, viscosite, capacite_th);

        double pe_main = coax1.calcul_Pe();
        float rayon_main = coax1.calcul_rayon();

        double prix_module_main = F1.calcul_prix_modules(coax1.getter_nbre_modules());
        if (prix_module_main < 0) {
            prix_module_main = 0;
        }
        
        F1.calcul_volume_coaxial(rayon_main, longueur, epaisseur);
        
        double prix_materiaux_main = F1.calcul_prix_matiere();
        if (prix_materiaux_main < 0) {
            prix_materiaux_main = 0;
        }
        
        double prix_total = prix_module_main + prix_materiaux_main;

        double energie_produite_main = F1.conversion_kwh(pe_main);
        double revenu_horaire_main = F1.calcul_revenu_horaire();
        double nbre_heures_main = F1.calcul_nbre_heures();
        
        DecimalFormat df2 = new DecimalFormat("#.##");
        DecimalFormat df4 = new DecimalFormat("#.####");
        DecimalFormat df5 = new DecimalFormat("#.#####");
        DecimalFormat df7 = new DecimalFormat("#.#######");
        

        String entetes[] = {"Résultat", "Valeur"};
        Object donnees[][] = {
            {"Nombre de modules", coax1.getter_nbre_modules()},
            {"Surface proposée (en m²)", df5.format(coax1.getter_surface_contact())},
            {"Surface utilisée par les modules (en m²)", df5.format(smod_main)},
            {"Débit massique (en m3/h)", debit_m},
            {"Température chaude (en °C)", tempc},
            {"Température froide (en °C)", tempf},
            {"Différence de température", coax1.getter_diff_temperature()},
            {"Puissance électrique générée (en W)", df2.format(pe_main)}};

        DefaultTableModel modele = new DefaultTableModel(donnees, entetes) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        tableau = new JTable(modele);
        

        
        String entetes2[] = {"Caractéristiques", "Valeurs"};
        Object donnees2[][] = {
            {"Surface d'un module (en m²)", coax1.getter_surface_module()},
            {"Longueur d'une jambe (en m)", df4.format(coax1.getter_longueur_jambe())},
            {"Surface d'une jambe (en m²)", df7.format(coax1.getter_surface_jambe())},
            {"Densité de couple", df5.format(coax1.getter_densite_couple())},
            {"Conductivité thermique du module (en W/m/K)", df2.format(coax1.getter_conduct_th_module())}
        };

        DefaultTableModel modele2 = new DefaultTableModel(donnees2, entetes2) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        Object donnees3[][] = {
            {"Prix des modules (en €)", df2.format(prix_module_main)},
            {"Prix de la matière première (en €)", df2.format(prix_materiaux_main)},
            {"Prix total échangeur (en €)", df2.format(prix_total)},
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
        chart.getData().setAll(new PieChart.Data("Prix des modules " + prix_module_main + " €", prix_module_main), new PieChart.Data("Prix du matériau " + df2.format(prix_materiaux_main) + " €", prix_materiaux_main)
        ); // on implémente les différents case du camebert
        final Scene scene = new Scene(chart); // on crée une scene (FX) où l'on met le graph camembert
        fxPanel.setScene(scene);

        tableau2 = new JTable(modele2);

        JScrollPane tableau_entete = new JScrollPane(tableau);
        JScrollPane tableau_entete2 = new JScrollPane(tableau2);
        JScrollPane tableau_entete3 = new JScrollPane(tableau3);

        tableau_entete.setViewportView(tableau);
        tableau_entete2.setViewportView(tableau2);
        tableau_entete3.setViewportView(tableau3);

        tableau_entete.setPreferredSize(new Dimension(550, 155));
        tableau_entete2.setPreferredSize(new Dimension(550, 110));
        tableau_entete3.setPreferredSize(new Dimension(550, 120));

        JLabel label_resultat = new JLabel("Resultat de la simulation");
        JLabel label_module = new JLabel("Caractéristiques du module utilisé");
        JLabel label_prix = new JLabel("Prix de l'échangeur");
        
        setBounds(0, 0, 600, 950);
        setTitle("Résultats Technologie Coaxial");
        
        panneau = new JPanel();
        panneau.add(label_resultat);
        panneau.add(tableau_entete);
        panneau.add(label_module);
        panneau.add(tableau_entete2);
        panneau.add(label_prix);
        panneau.add(tableau_entete3);
        panneau.add(fxPanel);
        getContentPane().add(panneau);
        
        this.setLocation(600, 0);
        this.setResizable(false);
    }

}
