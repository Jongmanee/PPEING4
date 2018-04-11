/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppeing4;

/**
 *
 * @author gautier
 */
public class Finance {

    private float prix_module = 30;
    private double prix_materiaux = 4.54;
    private double epaisseur_tube = 0.058;
    private double volume_exter;
    private double volume_exter_sans_ep;
    private double volume_inter;
    private double volume_inter_sans_ep;
    private double volume_exter_total;
    private double volume_inter_total;
    private double volume_total;
    private double prix_matiere_premiere;
    private double prix_total_modules;
    private double masse_volumique_materiaux = 4500;// kg/m3
    private double prix_elec = 0.15; // en €;
    private double energie_produite;
    private double revenu_horaire;
    private double nbre_heures;

    /**
     * Constructeur vide de la classe Finance
     */
    public Finance() {
    }
    
    /**
     * calul du volume de materiaux utilisés pour l'échangeur Coaxial
     * @param rayon
     * @param longueur
     * @param epaisseur
     * @return volume_total
     */
    public double calcul_volume_coaxial(float rayon, float longueur, float epaisseur) {
        volume_exter = Math.PI * (rayon * 2) * (rayon * 2) * longueur;
        volume_exter_sans_ep = Math.PI * (rayon * 2 - epaisseur) * (rayon * 2 - epaisseur) * longueur;
        volume_inter = Math.PI * (rayon * rayon) * longueur;
        volume_inter_sans_ep = Math.PI * (rayon - epaisseur) * (rayon - epaisseur) * longueur;
        volume_exter_total = volume_exter - volume_exter_sans_ep;
        volume_inter_total = volume_inter - volume_inter_sans_ep;
        volume_total = volume_exter_total + volume_inter_total;
        return volume_total;
    }
    
    /**
     * calul du prix des matières premières utilisées
     * @return prix_matiere_premiere
     */
    public double calcul_prix_matiere() {
        double poids_total;
        poids_total = volume_total * masse_volumique_materiaux;
        prix_matiere_premiere = poids_total * prix_materiaux;
        return prix_matiere_premiere;
    }  
    
    /**
     * calcul du volume de materiaux utilises pour l'echangeur à Spirale
     * @param epaisseur_spire
     * @param surface_contact
     * @return 
     */
    public double calcul_volume_spirale(double epaisseur_spire, double surface_contact) {
        volume_total = surface_contact * epaisseur_spire;
        return volume_total;
    }
    
    /**
     * calcul du volume du prix total des modules
     * @param nbre_modules
     * @return prix_total_modules
     */
    public double calcul_prix_modules(float nbre_modules) {
        prix_total_modules = nbre_modules * prix_module;
        return prix_total_modules;
    }
    
    /**
     * calcul du volume des matériaux utilisés dans l'échangeur à Plaques
     * @param surface_plaque
     * @param diam_tube
     * @param epaisseur_plaque
     * @param nbre_plaques
     * @param epaisseur_inter_plaques
     * @return 
     */
    public double calcul_volume_plaques(double surface_plaque, double diam_tube, double epaisseur_plaque, int nbre_plaques, double epaisseur_inter_plaques) {
        volume_total = (surface_plaque - diam_tube * diam_tube * Math.PI) * epaisseur_plaque * nbre_plaques + (nbre_plaques - 1) * Math.PI * (diam_tube * diam_tube - ((diam_tube - epaisseur_tube) * (diam_tube - epaisseur_tube))) * epaisseur_inter_plaques;
        return volume_total;
    }
    
    /**
     * Convertie la puissance en kWh
     * @param Pe
     * @return energie produite
     */
    public double conversion_kwh(double Pe) {
        energie_produite = Pe / 1000;
        return energie_produite;
    }

    /**
     * calcul le revenu de l'installation (euros par heure)
     * @return revenu_horaire
     */
    public double calcul_revenu_horaire() {
        revenu_horaire = energie_produite * prix_elec;
        return revenu_horaire;
    }
    
    /**
     * calcul le nombre d'heure pour rembourser l'installation (modules+materiau)
     * @return nbre_heures
     */
    public double calcul_nbre_heures() {
        nbre_heures = (prix_matiere_premiere + prix_total_modules) / revenu_horaire;
        return nbre_heures;
    }
    
    

}
