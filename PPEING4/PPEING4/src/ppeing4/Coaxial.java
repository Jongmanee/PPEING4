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
public class Coaxial extends Technologies{
    
   
    private float longueur;
    private float largeur;
    private float hauteur;
    
    private float smod;
    private float nbre_modules;
    private float surface_contact;
    
    private float r_charge;
    private float taux_occupation;
    
    private float resistance_th_globale;
    private float coeff_convection_h;
    
    private float flux_thermique;
    private float puissance_electrique;
    
    
    public Coaxial  (float longueur, float largeur, float hauteur, float debit_m, float capacite_th, float diff_temperature, float masse_volumique)
    {
        super(debit_m,capacite_th,diff_temperature,masse_volumique);
        this.longueur=longueur;
        this.largeur=largeur;
        this.hauteur=hauteur;

    }
    
    
    
}