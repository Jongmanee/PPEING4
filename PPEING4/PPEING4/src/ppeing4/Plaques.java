/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppeing4;

import java.lang.Math;

/**
 *
 * @author gautier
 */
public class Plaques extends Technologies {

    private float longueur;
    private float largeur;
    private float hauteur;

    private double coeff_convection_h;
    private double surface_plaques;
    private float flux_thermique;

    private int nbre_plaques;
    private int nbre_plaques_total;

    private float viscosite_1;
    private float viscosite_2;
    private float conductivite_th_1;
    private float conductivite_th_2;

    protected double epaisseur_inter = 0.0040;
    protected double diam_tube = 0.45;
    protected double epaisseur_plaques = 0.0057;
    
    /**
     * Constructeur de la classe Plaques qui utilise le constructeur de la classe mere Technologies
     * @param longueur
     * @param largeur
     * @param hauteur
     * @param debit_m_1
     * @param debit_m_2
     * @param capacite_th_1
     * @param capacite_th_2
     * @param tempc
     * @param tempf
     * @param masse_volumique_1
     * @param masse_volumique_2
     * @param viscosite_1
     * @param viscosite_2
     * @param conductivite_th_1
     * @param conductivite_th_2 
     */
    public Plaques(float longueur, float largeur, float hauteur, float debit_m_1, float debit_m_2, float capacite_th_1, float capacite_th_2, float tempc, float tempf, float masse_volumique_1, float masse_volumique_2, float viscosite_1, float viscosite_2, float conductivite_th_1, float conductivite_th_2) {
        super(debit_m_1, debit_m_2, capacite_th_1, capacite_th_2, masse_volumique_1, masse_volumique_2, tempc, tempf);
        this.viscosite_1 = viscosite_1;
        this.viscosite_2 = viscosite_2;
        this.conductivite_th_1 = conductivite_th_1;
        this.conductivite_th_2 = conductivite_th_2;
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }
    
    /**
     * calcul du nombre de plaques total de l'échangeur
     * @return nbre_plaques
     */
    public int calcul_nbre_plaques_total() {
        double inter_nbre_plaques_total;

        inter_nbre_plaques_total = longueur / (epaisseur_plaques + epaisseur_inter);
        nbre_plaques_total = (int) inter_nbre_plaques_total;

        nbre_plaques = nbre_plaques_total - 2;

        return nbre_plaques;
    }
    
    /**
     * calcul de la surface d'une plaque
     * @return surface_plaques
     */
    public double calcul_surface_plaques() {
        surface_plaques = largeur * hauteur;
        return surface_plaques;
    }
    
    /**
     * calcul de la surface de contact
     * @return surface_contact
     */
    public double calcul_surface_contact() {
        surface_contact = nbre_plaques * surface_plaques;
        return surface_contact;
    }
    
    /**
     * calcul de la surface occupée par les modules
     * @return smod
     */
    public double calcul_smod() {

        double inter_nbre_modules = surface_contact / surface_module;
        nbre_modules = (int) inter_nbre_modules;
        if (nbre_modules < 0) {
            nbre_modules = 0;
        }

        smod = nbre_modules * surface_module;
        taux_occupation = smod / surface_contact;

        return smod;
    }
    
    /**
     * calcul de la resistance thermique globale
     * @return resistance_th_globale
     */
    public double calcul_rth() {

        resistance_th_globale = 1 / (coeff_convection_h * smod);
        return resistance_th_globale;
    }
    
    /**
     * calcul du coefficient de convection 
     * @return coeff_convection_h
     */
    public double calcul_coeff_convection_h() {
        double h_global_inverse;
        double A1 = 0;
        double m1 = 0;
        double A2 = 0;
        double m2 = 0;
        double h1;
        double h2;

        double Rey1;
        double Rey2;
        double Nuss1;
        double Nuss2;
        double Prandt;
        double Prandt2;

        Rey1 = (4 * debit_m_1) / (Math.PI * diam_tube * viscosite_1);
        Rey2 = (4 * debit_m_2) / (Math.PI * diam_tube * viscosite_2);


        Prandt = (viscosite_1 * capacite_th_1) / (conductivite_th_1);
        Prandt2 = (viscosite_2 * capacite_th_2) / (conductivite_th_2);

        if (Rey1 >= 1 && Rey1 <= 4) {
            A1 = 0.891;
            m1 = 0.330;
        } else if (Rey1 >= 4 && Rey1 <= 40) {
            A1 = 0.821;
            m1 = 0.385;
        } else if (Rey1 >= 40 && Rey1 <= 4 * Math.pow(10, 3)) {
            A1 = 0.615;
            m1 = 0.466;
        } else if (Rey1 >= 4 * Math.pow(10, 3) && Rey1 <= 4 * Math.pow(10, 4)) {
            A1 = 0.175;
            m1 = 0.618;
        } else if (Rey1 >= 4 * Math.pow(10, 4) && Rey1 <= 4 * Math.pow(10, 5)) {
            A1 = 0.024;
            m1 = 0.805;
        }

        if (Rey2 >= 1 && Rey2 <= 4) {
            A2 = 0.891;
            m2 = 0.330;
        } else if (Rey2 >= 4 && Rey2 <= 40) {
            A2 = 0.821;
            m2 = 0.385;
        } else if (Rey2 >= 40 && Rey2 <= 4 * Math.pow(10, 3)) {
            A2 = 0.615;
            m2 = 0.466;
        } else if (Rey2 >= 4 * Math.pow(10, 3) && Rey2 <= 4 * Math.pow(10, 4)) {
            A2 = 0.175;
            m2 = 0.618;
        } else if (Rey2 >= 4 * Math.pow(10, 4) && Rey2 <= 4 * Math.pow(10, 5)) {
            A2 = 0.024;
            m2 = 0.805;
        }

        Nuss1 = 1.11 * A1 * Math.pow(Rey1, m1) * Math.pow(Prandt, 0.31);
        Nuss2 = 1.11 * A2 * Math.pow(Rey2, m2) * Math.pow(Prandt, 0.31);


        h1 = (Nuss1 * conductivite_th_1) / (diam_tube);
        h2 = (Nuss2 * conductivite_th_2) / (diam_tube);


        coeff_convection_h = 1 / ((1 / h1) + (1 / h2) + (1 / surface_plaques) * (0.000005 + epaisseur_plaques / 21.9));
        return coeff_convection_h;
    }

    /**
     * getter du diametre du tube
     * @return diam_tube
     */
    public double getter_diam_tube() {
        return diam_tube;
    }
    
    /**
     * getter de l'epaisseur d'un plaque
     * @return epaisseur_plaques
     */
    public double getter_epaisseur_plaque() {
        return epaisseur_plaques;
    }
    
    /**
     * getter de la longueur entre les plaques
     * @return epaisseur_inter
     */
    public double getter_inter_plaque() {
        return epaisseur_inter;
    }

}
