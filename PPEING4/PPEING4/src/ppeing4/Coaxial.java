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
    private int nbre_modules;
    private double surface_contact;
    
    private double r_charge;
    private double taux_occupation;
    
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
    
    public float calcul_smod(float surface_module)
    {
        
        float rayon;
        double inter_nbre_modules;
       
        if(hauteur<largeur)
            rayon=hauteur/4;
        else
            rayon=largeur/4;
        
        surface_contact = 2*Math.PI*rayon*longueur;
        inter_nbre_modules =  surface_contact/surface_module;
        nbre_modules = (int) inter_nbre_modules;
        
        
        smod = nbre_modules*surface_module;
        
        taux_occupation = smod/surface_contact;
        
        return smod;
        
        
        
    }
    
    
    
    
    
    public double calcul_r_charge (float densite_couple, float longueur_jambe, float surface_jambe)
    {
       
        r_charge = (masse_volumique*densite_couple*taux_occupation*longueur_jambe)/(2*surface_jambe*surface_jambe);
        return r_charge;
    }
    
    
    
    
}
