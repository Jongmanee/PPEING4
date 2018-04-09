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
    private double coeff_convection_h;
    
    
    private float flux_thermique;
    private float puissance_electrique;
    
    private int nbre_plaques;
    private float viscosite_1;
    private float viscosite_2;
    private float conductivite_th_1;
    private float conductivite_th_2;
    private double th_froide_rechauffe;
    private float temp_ech;
    private double dtlm;
    private int nbre_plaques_total;

/*

public Plaques  ( float debit_m_1, float debit_m_2, float capacite_th_1, float capacite_th_2, float tempc, float tempf, float masse_volumique_1, float masse_volumique_2, float viscosite_1, float viscosite_2, float conductivite_th_1, float conductivite_th_2, float temp_ech )
    {
        super(debit_m_1, debit_m_2,capacite_th_1, capacite_th_2,masse_volumique_1,masse_volumique_2, tempc, tempf);
        this.viscosite_1 = viscosite_1;
        this.viscosite_2 = viscosite_2;
        this.temp_ech = temp_ech+273;
        this.conductivite_th_1 = conductivite_th_1;
        this.conductivite_th_2 = conductivite_th_2;
        
       
    }

public double calcul_temperature_DTLM()

{
    th_froide_rechauffe = tempf + (debit_m_1*capacite_th_1*(tempc-temp_ech))/(debit_m_2*capacite_th_2);
     System.out.println("temp froide"+tempf);
              System.out.println(debit_m_1); 
                       System.out.println(capacite_th_1);
                               System.out.println(tempc);
                                       System.out.println(temp_ech); 
                                               System.out.println(debit_m_2);
                                                       System.out.println(capacite_th_2);
                               
                               
                               
                               
                      
      System.out.println("temp DTLM"+th_froide_rechauffe);
    return th_froide_rechauffe;
}

public double calcul_DTLM()
{
    
     dtlm = ((tempc-th_froide_rechauffe)-(temp_ech-tempf))/(Math.log((tempc-th_froide_rechauffe)/(temp_ech-tempf)));
     System.out.println("DTLM"+dtlm);
     return dtlm;
}

public int calcul_nbre_plaques ()
{
    double inter_nbre_plaques;
    inter_nbre_plaques = (debit_m_1*capacite_th_1*(th_froide_rechauffe-tempf))/(coeff_convection_h*surface_plaques*dtlm);
     System.out.println("DEBIT M 1"+debit_m_1);
              System.out.println(capacite_th_1);
                       System.out.println(th_froide_rechauffe);
                                System.out.println(tempf);
                                         System.out.println(coeff_convection_h);
                                                  System.out.println(surface_plaques);
                                                           System.out.println(dtlm);
                                                                   
    nbre_plaques = (int) inter_nbre_plaques;
    System.out.println("$$$$"+nbre_plaques);
    return nbre_plaques;
}



public int calcul_nbre_plaques_total()
        {
           nbre_plaques_total = nbre_plaques + 2;
           return nbre_plaques_total;
        }




public double calcul_Sc (double surface_module)
{
    double inter_nbre_modules;
    
    
    
    System.out.println("nbre plaque =" + nbre_plaques);
    surface_contact = (nbre_plaques-1)*(surface_plaques-(Math.PI*diam_tube*diam_tube));
    if (surface_contact<0)
    {
        surface_contact=0;
    }
     inter_nbre_modules =  surface_contact/surface_module;
        nbre_modules = (int) inter_nbre_modules;
        if(nbre_modules<0)
        {
            nbre_modules=0;
        }
        
       
        
        smod = nbre_modules*surface_module;
        
        System.out.println(nbre_modules);
       System.out.println(surface_module);
        
     taux_occupation = smod/surface_contact;
     System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
     System.out.println(smod);
     System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
     this.smod=smod;
    
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
     
     
     
     
    


public double calcul_rth ()
    {
        
        
        resistance_th_globale= 1/(coeff_convection_h*smod);
        System.out.println("SMOD"+smod);
        return resistance_th_globale;
    }

public double calcul_coeff_convection_h()
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
         
         Rey1 = (4*debit_m_1)/(Math.PI*diam_tube*viscosite_1);
         Rey2 = (4*debit_m_2)/(Math.PI*diam_tube*viscosite_2);
         
         System.out.println(Rey1+"Rey1");
         System.out.println(Rey2+"Rey2");
         
         Prandt = (viscosite_1*capacite_th_1)/(conductivite_th_1);  
         Prandt2 = (viscosite_2*capacite_th_2)/(conductivite_th_2);
          System.out.println(viscosite_1);
           System.out.println(capacite_th_1);
            System.out.println(conductivite_th_1);
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
        
        h1=(Nuss1*conductivite_th_1)/(diam_tube);
        h2=(Nuss2*conductivite_th_2)/(diam_tube);
        
        System.out.println(h1+" h1");
        System.out.println(h2+" h2");
        
        
        
        coeff_convection_h = 1/((1/h1) + (1/h2));
        System.out.println(coeff_convection_h);
        return coeff_convection_h;
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
*/
    
    
    public Plaques  (float longueur, float largeur, float hauteur, float debit_m_1,float debit_m_2, float capacite_th_1, float capacite_th_2, float tempc, float tempf, float masse_volumique_1, float masse_volumique_2, float viscosite_1, float viscosite_2, float conductivite_th_1, float conductivite_th_2)
    {
         super(debit_m_1, debit_m_2,capacite_th_1, capacite_th_2,masse_volumique_1,masse_volumique_2, tempc, tempf);
        this.viscosite_1 = viscosite_1;
        this.viscosite_2 = viscosite_2;
        this.conductivite_th_1 = conductivite_th_1;
        this.conductivite_th_2 = conductivite_th_2;
        this.longueur=longueur;
         this.largeur=largeur;
         this.hauteur = hauteur;
    }
    
    public int calcul_nbre_plaques_total ()
    {
        double inter_nbre_plaques_total;
        
        inter_nbre_plaques_total = longueur/(epaisseur_plaques+epaisseur_inter);
        nbre_plaques_total = (int) inter_nbre_plaques_total;
        
        nbre_plaques = nbre_plaques_total-2;
        
        return nbre_plaques;
    }
    
    public double calcul_surface_plaques ()
    {
        surface_plaques = largeur*hauteur;
        System.out.println("largeur"+largeur+" "+hauteur);
        return surface_plaques;
    }
    
    public double calcul_surface_contact ()
    {
        surface_contact = nbre_plaques*surface_plaques;
        System.out.println(nbre_plaques);
        System.out.println("surface_contact "+surface_contact);
        return surface_contact;
    }
    
    
    public double calcul_smod ()
    {
        
        double inter_nbre_modules =  surface_contact/surface_module;
        nbre_modules = (int) inter_nbre_modules;
        if(nbre_modules<0)
        {
            nbre_modules=0;
        }
        
        smod = nbre_modules*surface_module;
        taux_occupation = smod/surface_contact;
        
        return smod;
    }
    
    
    
    
    
    
public double calcul_rth ()
    {
        
        
        resistance_th_globale= 1/(coeff_convection_h*smod);
        System.out.println("SMOD"+smod);
        return resistance_th_globale;
    }

public double calcul_coeff_convection_h()
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
         
         Rey1 = (4*debit_m_1)/(Math.PI*diam_tube*viscosite_1);
         Rey2 = (4*debit_m_2)/(Math.PI*diam_tube*viscosite_2);
         
         System.out.println(Rey1+"Rey1");
         System.out.println(Rey2+"Rey2");
         
         Prandt = (viscosite_1*capacite_th_1)/(conductivite_th_1);  
         Prandt2 = (viscosite_2*capacite_th_2)/(conductivite_th_2);
          System.out.println(viscosite_1);
           System.out.println(capacite_th_1);
            System.out.println(conductivite_th_1);
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
        
        h1=(Nuss1*conductivite_th_1)/(diam_tube);
        h2=(Nuss2*conductivite_th_2)/(diam_tube);
        
        System.out.println(h1+" h1");
        System.out.println(h2+" h2");
        
        
        
        coeff_convection_h = 1/((1/h1) + (1/h2) + (1/surface_plaques)*(0.000005+epaisseur_plaques/21.9));
        System.out.println(coeff_convection_h);
        return coeff_convection_h;
    }
     public double calcul_densite_couple()
    {
        densite_couple = (254*2*surface_jambe*Math.pow(taux_occupation*surface_contact, -1));
        return densite_couple;
    }
     
    public double calcul_rcharge() {
        r_charge = masse_volumique_1*densite_couple*smod*longueur_jambe/(2*surface_jambe);
        return r_charge;
    }
public double calcul_Pe ()
    {
        //double Pe = (   ((seebeck+thomson)*(seebeck+thomson))  *   densite_couple*densite_couple*taux_occupation*taux_occupation*surface_contact*surface_contact*   ( (2*((debit_m*masse_volumique)/3600)*capacite_th*(-diff_temperature))*(2*((debit_m*masse_volumique)/3600)*capacite_th*(-diff_temperature))) *longueur_jambe*longueur_jambe*r_charge*surface_jambe*surface_jambe  )/(  4*  (2*((debit_m*masse_volumique)/3600)*capacite_th*(longueur_jambe+resistance_th_globale*conduct_th_module*densite_couple*taux_occupation*surface_contact) + conduct_th_module*densite_couple*taux_occupation*surface_contact) *  (2*((debit_m*masse_volumique)/3600)*capacite_th*(longueur_jambe+resistance_th_globale*conduct_th_module*densite_couple*taux_occupation*surface_contact) + conduct_th_module*densite_couple*taux_occupation*surface_contact)  * (r_charge*surface_jambe*surface_jambe+ masse_volumique*densite_couple*taux_occupation*surface_contact*longueur_jambe)*(r_charge*surface_jambe*surface_jambe+ masse_volumique*densite_couple*taux_occupation*surface_contact*longueur_jambe) );
        double Pe = ((    16*diff_temperature*diff_temperature*debit_m_1*debit_m_1*capacite_th_1*capacite_th_1*r_charge*surface_jambe*surface_jambe*surface_contact*surface_contact*seebeck*seebeck*densite_couple*densite_couple*taux_occupation*taux_occupation*longueur_jambe*longueur_jambe)/((  2*r_charge*surface_jambe*surface_jambe + masse_volumique_1*densite_couple*taux_occupation*surface_contact*longueur_jambe      )*(  2*r_charge*surface_jambe*surface_jambe + masse_volumique_1*densite_couple*taux_occupation*surface_contact*longueur_jambe      ) * (2*debit_m_1*capacite_th_1*(2*longueur_jambe+resistance_th_globale*conduct_th_module*densite_couple*taux_occupation*surface_contact) + (conduct_th_module*densite_couple*taux_occupation*surface_contact)) * (2*debit_m_1*capacite_th_1*(2*longueur_jambe+resistance_th_globale*conduct_th_module*densite_couple*taux_occupation*surface_contact) + (conduct_th_module*densite_couple*taux_occupation*surface_contact))           ));

        //double Pe = (diff_temperature*diff_temperature*debit_m_1*capacite_th_1*2.9)/(8*(1+2*debit_m_1*capacite_th_1*resistance_th_globale));
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
    
    
    public double getter_diam_tube()
    {
        return diam_tube;
    }
    
    
    
}





    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
