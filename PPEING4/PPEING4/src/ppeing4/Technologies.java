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
public class Technologies {
    
    private float debit_m;
    private float capacite_th;
    private float diff_temperature;
    private float masse_volumique;
    
    public Technologies (float debit_m, float capacite_th, float diff_temperature, float masse_volumique)
    {
        this.debit_m = debit_m;
        this.capacite_th = capacite_th;
        this.diff_temperature = diff_temperature;
        this.masse_volumique = masse_volumique;
        
    }
    
}
