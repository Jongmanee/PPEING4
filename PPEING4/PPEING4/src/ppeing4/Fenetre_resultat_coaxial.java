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
public class Fenetre_resultat_coaxial {
    
     Coaxial coax1;
        
        coax1 = new Coaxial(longueur, largeur, hauteur, debit_m,capacite_th,tempc, tempf, masse_volumique);
        
         
        
        
         double densite_couple_main = coax1.calcul_densite_couple();
         System.out.println(densite_couple_main);
         
         
         System.out.println(coax1.calcul_smod(coax1.getter_surface_module()));
         
         
         double r_charge_main = coax1.calcul_r_charge(debit_m, longueur, largeur);
         
        
         System.out.println(r_charge_main);
    
}
