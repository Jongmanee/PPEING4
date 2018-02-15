/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppeing4;

import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author Jongmanee Denis
 */
public class PPEING4 {

    /**fefeffffefefefe
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // HELLO WORLD BELETTE
        
        
        
        Scanner sc = new Scanner(System.in);
        float debit_m;
        float capacite_th;
        float diff_temperature;
        float masse_volumique;
        float longueur;
        float largeur;
        float hauteur;
        
        
        
        
        
        System.out.println("Veuillez saisir le débit massique :");
         do  
        {
           debit_m = sc.nextFloat();
        }while (debit_m<0);
         
                 System.out.println(debit_m);

        
        
                 
        System.out.println("Veuillez saisir la capacité massique du fluide :");
        do  
        {
           capacite_th = sc.nextFloat();
        }while (capacite_th<0);
         
                 System.out.println(capacite_th);
        
                 
                 
                 
        System.out.println("Veuillez saisir la différence de température entre les deux fluides :");
        do  
        {
           diff_temperature = sc.nextFloat();
        }while (diff_temperature<0);
         
                 System.out.println(diff_temperature);
        
                 
                 
                 
                 
        System.out.println("Veuillez saisir la masse volumique du fluide :");
        do  
        {
           masse_volumique = sc.nextFloat();
        }while (masse_volumique<0);
         
                 System.out.println(masse_volumique);
        
                 
                 
                 
      
                 
                 
                 
                 
                 
        System.out.println("Veuillez saisir la largeur de l'espace disponible :");
        do  
        {
           largeur = sc.nextFloat();
        }while (largeur<0);
         
                 System.out.println(largeur);
                 
                 
                 
                 
        System.out.println("Veuillez saisir la hauteur de l'espace disponible :");
        do  
        {
           hauteur = sc.nextFloat();
        }while (hauteur<0);
         
                 System.out.println(hauteur);
                 
                 
        System.out.println("Veuillez saisir la longueur de l'espace disponible :");
          do  
        {
           longueur = sc.nextFloat();
        }while (longueur<0 && longueur>=hauteur && longueur>=largeur);
         
                 System.out.println(longueur);
        
        
        Coaxial coax1;
        
        coax1 = new Coaxial(longueur,largeur,hauteur,debit_m,capacite_th,diff_temperature,masse_volumique);
        
        System.out.println(coax1.get_debit());
        
         System.out.println(coax1.calcul_smod(3));
         System.out.println(coax1.calcul_r_charge(2,1,1));
        
    }
    
}
