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
public class Finance {

    private float rayon;
    private float longueur;
    private float epaisseur;
    private float nbre_modules;
    private float prix_module;
    private double prix_materiaux = 4.54;
    private float poids;
    private double volume_exter;
    private double volume_exter_sans_ep;
    private double volume_inter;
    private double volume_inter_sans_ep;

    private double volume_exter_total;
    private double volume_inter_total;
    private double volume_total;
    private double poids_total;
    private double prix_matiere_premiere;
    private double prix_total_modules;
    private double masse_volumique_materiaux = 4500;// kg/m3
    private double prix_elec = 0.15; // en €;
    private double energie_produite;
    private double revenu_horaire;
    private double nbre_heures;
    private double temps_remboursement;

    public Finance() {

    }

    public double calcul_volume_coaxial(float rayon, float longueur, float epaisseur, double prix_materiaux, float masse_volumique_materiaux) {
        volume_exter = Math.PI * (rayon * 2) * (rayon * 2) * longueur;
        volume_exter_sans_ep = Math.PI * (rayon * 2 - epaisseur) * (rayon * 2 - epaisseur) * longueur;
        volume_inter = Math.PI * (rayon * rayon) * longueur;
        volume_inter_sans_ep = Math.PI * (rayon - epaisseur) * (rayon - epaisseur) * longueur;

        volume_exter_total = volume_exter - volume_exter_sans_ep;
        volume_inter_total = volume_inter - volume_inter_sans_ep;

        volume_total = volume_exter_total + volume_inter_total;

        return volume_total;
    }

    public double calcul_prix_matiere() {
        poids_total = volume_total * masse_volumique_materiaux;
        prix_matiere_premiere = poids_total * prix_materiaux;
        System.out.println ("poids = "+poids_total+"prix_materiau = "+prix_materiaux);
        return prix_matiere_premiere;
    }

    public double calcul_volume_spirale(double epaisseur_spire, double surface_contact) {
        volume_total = surface_contact * epaisseur_spire;
        return volume_total;
    }

    public double calcul_prix_modules(float nbre_modules, float prix_module) {
        prix_total_modules = nbre_modules * prix_module;
        return prix_total_modules;
    }

    public double calcul_volume_plaques(double surface_plaque, double diam_tube, double epaisseur_plaque, double epaisseur_tube, int nbre_plaques, double epaisseur_inter_plaques) {

        volume_total = (surface_plaque - diam_tube * diam_tube * Math.PI) * epaisseur_plaque * nbre_plaques + (nbre_plaques - 1) * Math.PI * (diam_tube * diam_tube - ((diam_tube - epaisseur_tube) * (diam_tube - epaisseur_tube))) * epaisseur_inter_plaques;

        return volume_total;

    }

    public double conversion_kwh(double Pe) {
        energie_produite = Pe / 1000;
        return energie_produite;
    }

    public double calcul_revenu_horaire() {
        revenu_horaire = energie_produite * prix_elec;
        return revenu_horaire;
    }

    public double calcul_nbre_heures() {
        nbre_heures = (prix_matiere_premiere + prix_total_modules) / revenu_horaire;
        return nbre_heures;
    }

}
