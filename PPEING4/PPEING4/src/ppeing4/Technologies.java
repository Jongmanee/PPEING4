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
public class Technologies {
    
    protected float debit_m_1;
    protected float debit_m_2;
    protected float capacite_th_1;
    protected float capacite_th_2;
    protected float diff_temperature;
    protected float tempc;
    protected float tempf;
    protected float tempm;
    protected float masse_volumique_1;
    protected float masse_volumique_2;
    protected double seebeck;
    protected double thomson;
    protected double densite_couple ;
    protected double longueur_jambe = 3.45*Math.pow(10,-3);
    protected double surface_jambe = 6.25*Math.pow(10,-6);
    protected double conduct_th_module;
    protected double conduct_th_fluide;
    protected double conduct_th_tube;
    protected double surface_module = ((55*Math.pow(10,-3))*(55*Math.pow(10,-3)));
    protected double diam_eq = 0.45;
    protected double surface_plaques = 10.7;
    protected double epaisseur_inter = 0.0040;
    protected double diam_tube = 0.45;
    protected double epaisseur_tube = 0.058;
    protected double epaisseur_plaques = 0.0057;
    
    
    public Technologies (float debit_m_1, float debit_m_2, float capacite_th_1, float capacite_th_2, float masse_volumique_1,float masse_volumique_2, float tempc, float tempf)
    {
        this.tempf = tempf+273;
        this.tempc = tempc+273;
        this.tempm = (this.tempc+this.tempf)/2;
        this.diff_temperature = tempc-tempf;
        this.capacite_th_1 = capacite_th_1;
        this.masse_volumique_1 = masse_volumique_1;
        this.debit_m_1 = (debit_m_1*masse_volumique_1)/3600;
        
         this.capacite_th_2 = capacite_th_2;
        this.masse_volumique_2 = masse_volumique_2;
        this.debit_m_2 = (debit_m_2*masse_volumique_2)/3600;
        
        this.seebeck = ((22224+930.6*tempm) - (0.9905*tempm*tempm))*Math.pow(10,-9);
        this.thomson =((930.6-0.9905*tempm*tempm)*Math.pow(10,-9)*tempm);
        this.conduct_th_fluide = 0.6;
        this.conduct_th_module = ((62605-277.7*tempm + 0.4131*tempm*tempm)*Math.pow(10,-4));
        this.conduct_th_tube = 50.2;
        
        
        
    }
    
    public double getter_surface_module()
    {
        return surface_module;
    }

    public double getter_conduct_th_module()
    {
        return conduct_th_module;
    }
    
    public double getter_conduct_th_fluide()
    {
        return conduct_th_fluide;
    }
    
    public float getter_diff_temperature()
    {
        return diff_temperature;
    }
    
    public double getter_surface_jambe()
    {
        return surface_jambe;
    }
    
    public double getter_longueur_jambe()
    {
        return longueur_jambe;
    }
    
    public double getter_densite_couple()
    {
        return densite_couple;
    }
    
    
   
    
   
    
    
    
    
    
}
