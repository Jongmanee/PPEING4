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
    
    private double resistance_th_globale;
    private double coeff_convection_h_inverse;
    
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
    
    
    
    public double calcul_rth (float débit_m, float masse_volumique, float epaisseur_paroi, float viscosite, float conductivite, float capacite_th)
    {
        
        double l=0;
        double h_global_inverse;
        double A1=0;
        double m1=0;
        double A2=0;
        double m2=0;
        double h1;
        double h2;
        float rayon1;
        float rayon2;
        double debit_volumique;
         if(hauteur<largeur)
         {
              rayon1=(hauteur/2)-2*epaisseur_paroi;
              rayon2=(hauteur)-2*epaisseur_paroi;
              l=hauteur;
         } 
        else
         {
             rayon1=(largeur/2)-2*epaisseur_paroi;
             rayon2=(largeur)-2*epaisseur_paroi;
             l=largeur;
         }
            
        
         
         double Rey1;
         double Rey2;
         double Nuss1;
         double Nuss2;
         double Prandt;
         
         Rey1 = (4*debit_m*masse_volumique)/(Math.PI*rayon1*viscosite);
         Rey2 = (4*debit_m*masse_volumique)/(Math.PI*rayon2*viscosite);
       
         Prandt = (viscosite*capacite_th)/(conductivite);  
        
         if(Rey1>=1 && Rey1<=4)
         {
             A1=0.891;
             m1 = 0.330;
         }
        
         else if(Rey1>=4 && Rey1<=40)
         {
             A1=0.821;
             m1 = 0.385;
         }
         
         else if(Rey1>=40 && Rey1<=4*Math.pow(10,3))
         {
             A1=0.615;
             m1 = 0.466;
         }
         
         else if(Rey1>=4*Math.pow(10,3) && Rey1<=4*Math.pow(10,4))
         {
             A1=0.175;
             m1 = 0.618;
         }
         
         else if(Rey1>=4*Math.pow(10,4) && Rey1<=4*Math.pow(10,5))
         {
             A1=0.024;
             m1 = 0.805;
         }
         
         
         
         
         
         if(Rey2>=1 && Rey2<=4)
         {
             A2=0.891;
             m2 = 0.330;
         }
        
         else if(Rey2>=4 && Rey2<=40)
         {
             A2=0.821;
             m2 = 0.385;
         }
         
         else if(Rey2>=40 && Rey2<=4*Math.pow(10,3))
         {
             A2=0.615;
             m2 = 0.466;
         }
         
         else if(Rey2>=4*Math.pow(10,3) && Rey2<=4*Math.pow(10,4))
         {
             A2=0.175;
             m2 = 0.618;
         }
         
         else if(Rey2>=4*Math.pow(10,4) && Rey2<=4*Math.pow(10,5))
         {
             A2=0.024;
             m2 = 0.805;
         }
         
         
         
        Nuss1= 1.11*A1*Math.pow(Rey1, m1)*Math.pow(Prandt, 0.31);
        Nuss2= 1.11*A2*Math.pow(Rey2, m2)*Math.pow(Prandt, 0.31);
        
        
        h1=(Nuss1*conductivite)/rayon1;
        h2=(Nuss2*conductivite)/rayon2;
        
        coeff_convection_h_inverse = (((l/4)+epaisseur_paroi)/((l/4)*h1)) + ((((l/4)+epaisseur_paroi)*Math.log(((l/4)+epaisseur_paroi)/(l/4)))/conductivite) + (1/h2);
        
        resistance_th_globale= coeff_convection_h_inverse*(1/surface_contact);
        return resistance_th_globale;
    }
    
    
    
    
    
}
