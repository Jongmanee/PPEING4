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
    
    protected float debit_m;
    protected float capacite_th;
    protected float diff_temperature;
    protected float tempm;
    protected float masse_volumique;
    protected double seebeck;
    protected double thomson;
    protected double densite_couple ;
    protected double longueur_jambe = 3.45*Math.pow(10,-3);
    protected double surface_jambe = 6.25*Math.pow(10,-6);
    protected double conduct_th;
    protected double surface_module = ((55*Math.pow(10,-3))*55*Math.pow(10,-3));
    
    public Technologies (float debit_m, float capacite_th, float masse_volumique, float tempc, float tempf)
    {
        this.tempm = (tempc+tempf)/2;
        this.diff_temperature = tempc-tempf;
        this.debit_m = debit_m;
        this.capacite_th = capacite_th;
        this.masse_volumique = masse_volumique;
        
        this.densite_couple = 
        this.seebeck = ((22224+930.6*tempm) - (0.9905*tempm*tempm))*Math.pow(10,-9);
        this.thomson = ((930.6-0.9905*tempm*tempm)*Math.pow(10,-9)*tempm);
        this.conduct_th = ((62605-277.7*tempm + 0.4131*tempm*tempm)*Math.pow(10,-4));
        
        
        
    }

   
    
   
    
    
    
    
    
}
