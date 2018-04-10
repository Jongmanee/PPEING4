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
public class Coaxial extends Technologies {

    private float longueur;
    private float largeur;
    private float hauteur;
    private double coeff_convection_h_inverse;

    /**
     * Constructeur de la classe Coaxial qui utilise le constructeur de classe
     * mere Technologies
     *
     * @param longueur
     * @param largeur
     * @param hauteur
     * @param debit_m
     * @param capacite_th
     * @param tempc
     * @param tempf
     * @param masse_volumique
     */
    public Coaxial(float longueur, float largeur, float hauteur, float debit_m, float capacite_th, float tempc, float tempf, float masse_volumique) {
        super(debit_m, 0, capacite_th, 0, masse_volumique, 0, tempc, tempf);
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    /**
     * Calcul du rayon de l'échangeur
     *
     * @return rayon
     */
    public float calcul_rayon() {
        float rayon;
        if (hauteur < largeur) {
            rayon = hauteur / 4;
        } else {
            rayon = largeur / 4;
        }

        return rayon;
    }

    /**
     * calcul de la surface occupée par les modules
     *
     * @param surface_module
     * @return smod
     */
    public double calcul_smod(double surface_module) {
        float rayon;
        double inter_nbre_modules;

        rayon = calcul_rayon();

        surface_contact = 2 * Math.PI * rayon * longueur;

        inter_nbre_modules = surface_contact / surface_module;
        nbre_modules = (int) inter_nbre_modules;

        smod = nbre_modules * surface_module;

        taux_occupation = smod / surface_contact;

        return smod;

    }

    /**
     * calcul de la resistance thermique 
     * @param débit_m
     * @param masse_volumique
     * @param epaisseur_paroi
     * @param viscosite
     * @param capacite_th
     * @return resistance_th_globle
     */
    public double calcul_rth(float débit_m, float masse_volumique, float epaisseur_paroi, float viscosite, float capacite_th) {

        double l;
        double h_global_inverse;
        double A1 = 0;
        double m1 = 0;
        double A2 = 0;
        double m2 = 0;
        double h1;
        double h2;
        float rayon1;
        float rayon2;
        double debit_volumique;
        if (hauteur < largeur) {
            rayon1 = (hauteur / 2) - 2 * epaisseur_paroi;
            rayon2 = (hauteur / 2) - 2 * epaisseur_paroi;
            l = hauteur;
        } else {
            rayon1 = (largeur / 2) - 2 * epaisseur_paroi;
            rayon2 = (largeur / 2) - 2 * epaisseur_paroi;
            l = largeur;
        }

        double Rey1;
        double Rey2;
        double Nuss1;
        double Nuss2;
        double Prandt;

        Rey1 = (4 * debit_m_1) / (Math.PI * rayon1 * viscosite);
        Rey2 = (4 * debit_m_1) / (Math.PI * rayon2 * viscosite);

        Prandt = (viscosite * capacite_th) / (conduct_th_fluide);

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

        h1 = (Nuss1 * conduct_th_fluide) / rayon1;
        h2 = (Nuss2 * conduct_th_fluide) / rayon2;

        coeff_convection_h_inverse = (((l / 4)) / ((l / 4 - epaisseur_paroi) * h1)) + (((l / 4) * Math.log((l / 4) / ((l / 4) - epaisseur_paroi))) / conduct_th_tube) + (1 / h2);

        resistance_th_globale = coeff_convection_h_inverse / smod;
        return resistance_th_globale;
    }

}
