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
    
    private double smod;
    private int nbre_modules;
    private double surface_contact;
    
    private double r_charge;
    private double taux_occupation;
    
    private double resistance_th_globale;
    private double coeff_convection_h_inverse;
    
    private float flux_thermique;
    private float puissance_electrique;
    
    private int nbre_plaques;
    private float viscosite_1;
    private float viscosite_2;
    private float surface_plaques;
    private float epaisseur_inter;
    private float diametre_tube;
    private float conductivite_th_1;
    private float conductivite_th_2;
    
    



public Plaques  ( float debit_m_1, float debit_m_2, float capacite_th_1, float capacite_th_2, float tempc, float tempf, float masse_volumique_1, float masse_volumique_2, int nbre_plaques, float viscosite_1, float viscosite_2, float surface_plaques, float conductivite_th_1, float conductivite_th_2, float epaisseur_inter, float diametre_tube )
    {
        super(debit_m_1, debit_m_2,capacite_th_1, capacite_th_2,masse_volumique_1,masse_volumique_2, tempc, tempf);
        this.nbre_plaques= nbre_plaques;
        this.viscosite_1 = viscosite_1;
        this.viscosite_2 = viscosite_2;
        this.surface_plaques = surface_plaques;
        this.epaisseur_inter = epaisseur_inter;
        this.diametre_tube = diametre_tube;
    }

public double Calcul_Sc (double surface_module)
{
    double inter_nbre_modules;
    
    
    
    
    surface_contact = (nbre_plaques-1)*(surface_plaques-(Math.PI*(2*epaisseur_inter)*(2*epaisseur_inter)));
    
     inter_nbre_modules =  surface_contact/surface_module;
        nbre_modules = (int) inter_nbre_modules;
        
       
        
        smod = nbre_modules*surface_module;
       
        
     taux_occupation = smod/surface_contact;
    
    return smod;
}


 public double calcul_densite_couple()
    {
        densite_couple = ((254*2*surface_jambe)*(Math.pow(taux_occupation*surface_module, -1)));
        return densite_couple;
    }
    
     
     public double getter_densite_couple()
    {
        return densite_couple;
    }
     
     
     
public double calcul_r_charge (double densite_couple, float longueur_jambe, float surface_jambe)
    {
       
        r_charge = (masse_volumique_1*densite_couple*taux_occupation*longueur_jambe)/(2*surface_jambe*surface_jambe);
        return r_charge;
    } 



public double calcul_rth ()
    {
        
        double h_global_inverse;
        double A1=0;
        double m1=0;
        double A2=0;
        double m2=0;
        double h1;
        double h2;
        
        
       
            
        
         
         double Rey1;
         double Rey2;
         double Nuss1;
         double Nuss2;
         double Prandt;
         double Prandt2;
         
         Rey1 = (4*debit_m_1)/(Math.PI*2*epaisseur_inter*viscosite_1);
         Rey2 = (4*debit_m_2)/(Math.PI*2*epaisseur_inter*viscosite_2);
         
         System.out.println(Rey1+"Rey1");
         System.out.println(Rey2+"Rey2");
         
         Prandt = (viscosite_1*capacite_th_1)/(conductivite_th_1);  
         Prandt2 = (viscosite_2*capacite_th_2)/(conductivite_th_2);
         System.out.println(Prandt+"Prandt");
        System.out.println(Prandt2+"Prandt2");
         
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
        
        
        System.out.println(Nuss1+"Nuss1");
        System.out.println(Nuss2+"Nuss2");
        
        h1=(Nuss1*conductivite_th_1)/(2*epaisseur_inter);
        h2=(Nuss2*conductivite_th_2)/(2*epaisseur_inter);
        
        System.out.println(h1+" h1");
        System.out.println(h2+" h2");
        
        
        
        coeff_convection_h_inverse = (1/h1) + (1/h2);
        System.out.println(coeff_convection_h_inverse);
        
        resistance_th_globale= coeff_convection_h_inverse*(smod);
        return resistance_th_globale;
    }




public double calcul_Pe ()
    {
        //double Pe = (   ((seebeck+thomson)*(seebeck+thomson))  *   densite_couple*densite_couple*taux_occupation*taux_occupation*surface_contact*surface_contact*   ( (2*((debit_m*masse_volumique)/3600)*capacite_th*(-diff_temperature))*(2*((debit_m*masse_volumique)/3600)*capacite_th*(-diff_temperature))) *longueur_jambe*longueur_jambe*r_charge*surface_jambe*surface_jambe  )/(  4*  (2*((debit_m*masse_volumique)/3600)*capacite_th*(longueur_jambe+resistance_th_globale*conduct_th_module*densite_couple*taux_occupation*surface_contact) + conduct_th_module*densite_couple*taux_occupation*surface_contact) *  (2*((debit_m*masse_volumique)/3600)*capacite_th*(longueur_jambe+resistance_th_globale*conduct_th_module*densite_couple*taux_occupation*surface_contact) + conduct_th_module*densite_couple*taux_occupation*surface_contact)  * (r_charge*surface_jambe*surface_jambe+ masse_volumique*densite_couple*taux_occupation*surface_contact*longueur_jambe)*(r_charge*surface_jambe*surface_jambe+ masse_volumique*densite_couple*taux_occupation*surface_contact*longueur_jambe) );
        //double Pe = ((    16*diff_temperature*diff_temperature*debit_m*debit_m*capacite_th*capacite_th*r_charge*surface_jambe*surface_jambe*surface_contact*surface_contact*seebeck*seebeck*densite_couple*densite_couple*taux_occupation*taux_occupation*longueur_jambe*longueur_jambe)/((  2*r_charge*surface_jambe*surface_jambe + masse_volumique*densite_couple*taux_occupation*surface_contact*longueur_jambe      )*(  2*r_charge*surface_jambe*surface_jambe + masse_volumique*densite_couple*taux_occupation*surface_contact*longueur_jambe      ) * (2*debit_m*capacite_th*(2*longueur_jambe+resistance_th_globale*conduct_th_module*densite_couple*taux_occupation*surface_contact) + (conduct_th_module*densite_couple*taux_occupation*surface_contact)) * (2*debit_m*capacite_th*(2*longueur_jambe+resistance_th_globale*conduct_th_module*densite_couple*taux_occupation*surface_contact) + (conduct_th_module*densite_couple*taux_occupation*surface_contact))           ));
        double Pe = (diff_temperature*diff_temperature*debit_m_1*capacite_th_1*2.9)/(8*(1+2*debit_m_1*capacite_th_1*resistance_th_globale));
        System.out.println("rth="+resistance_th_globale);
        return Pe;   
        
    }



 public int getter_nbre_modules()
    {
        return nbre_modules;
    }
    
    public double getter_surface_contact()
    {
        return surface_contact;
    }


}