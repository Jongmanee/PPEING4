/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppeing4;

import java.lang.Math;

/**
 *
 * @author Jongmanee Denis
 */

public class Spirale extends Technologies {

   private float longueur;
   private float largeur;
   private float hauteur;
    private float viscosite_1;
    private float viscosite_2;
    private float conductivite_th_1;
    private float conductivite_th_2;
    private double surface_contact;
    private double coeff_convection_h;
    private double resistance_th_globale;
    private double epasseur_paroi = 0.0057;
    private double smod;
    private int nbre_spires;
    private int nbre_modules;
    double epaisseur_spire;
    

    public Spirale(float longueur, float largeur, float hauteur, float debit_m_1, float debit_m_2, float capacite_th_1, float capacite_th_2, float tempc, float tempf, float masse_volumique_1, float masse_volumique_2, float viscosite_1, float viscosite_2, float conductivite_th_1, float conductivite_th_2) {
        super(debit_m_1, debit_m_2, capacite_th_1, capacite_th_2, masse_volumique_1, masse_volumique_2, tempc, tempf);
        this.viscosite_1 = viscosite_1;
        this.viscosite_2 = viscosite_2;
        this.conductivite_th_1 = conductivite_th_1;
        this.conductivite_th_2 = conductivite_th_2;
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }
    
   
    public int calcul_nbre_spire() {
        double inter_nbre_spires;
        double l=longueur;
        if (l>largeur) {
            l=largeur;
        }
        if (l>hauteur) {
            l=hauteur;
        }
        inter_nbre_spires =  l/(4*epaisseur_inter) ; 
        
        nbre_spires = (int) inter_nbre_spires;
        return nbre_spires;
    }
    
    public double calcul_epaiseur_spire() {
        epaisseur_spire = 2*(epaisseur_plaques+epaisseur_inter);
        return epaisseur_spire;
    }
      
    
    public double calcul_surface_contact ()
    {
        double l=longueur;
        if (l>largeur) {
            l=largeur;
        }
        if (l>hauteur) {
            l=hauteur;
        }
        surface_contact = 8*Math.PI*Math.PI*epaisseur_spire*epaisseur_spire*l*(nbre_spires*(nbre_spires+1)/2+(nbre_spires-0.5)*(nbre_spires-0.5)/2); //
        System.out.println(nbre_spires);
        System.out.println("surface_contact "+surface_contact);
        return surface_contact;
    }
    
    public double calcul_smod ()
    {
        double inter_nbre_modules =  surface_contact/surface_module;
        nbre_modules = (int) inter_nbre_modules;
        smod = nbre_modules*surface_module;
        return smod;
    }
    
    
    

    public double calcul_coeff_convection_h() {
        double A1 = 0;
        double m1 = 0;
        double A2 = 0;
        double m2 = 0;
        double h1;
        double h2;

        double Rey1;
        double Rey2;
        double Nuss1;
        double Nuss2;
        double Prandt;
        double Prandt2;

        Rey1 = (4 * debit_m_1) / (Math.PI * diam_tube * viscosite_1);
        Rey2 = (4 * debit_m_2) / (Math.PI * diam_tube * viscosite_2);

        System.out.println(Rey1 + "Rey1");
        System.out.println(Rey2 + "Rey2");

        Prandt = (viscosite_1 * capacite_th_1) / (conductivite_th_1);
        Prandt2 = (viscosite_2 * capacite_th_2) / (conductivite_th_2);
        System.out.println(viscosite_1);
        System.out.println(capacite_th_1);
        System.out.println(conductivite_th_1);
        System.out.println(Prandt + "Prandt");
        System.out.println(Prandt2 + "Prandt2");

        if (Rey1 >= 1 && Rey1 <= 4) {
            A1 = 0.891;
            m1 = 0.330;
        } else if (Rey1 >= 4 && Rey1 <= 40) {
            A1 = 0.821;
            m1 = 0.385;
        } else if (Rey1 >= 40 && Rey1 <= 4 * Math.pow(10, 3)) {
            A1 = 0.615;
            m1 = 0.466;
        } else if (Rey1 >= 4 * Math.pow(10, 3) && Rey1 <= 4 * Math.pow(10, 4)) {
            A1 = 0.175;
            m1 = 0.618;
        } else if (Rey1 >= 4 * Math.pow(10, 4) && Rey1 <= 4 * Math.pow(10, 5)) {
            A1 = 0.024;
            m1 = 0.805;
        }

        if (Rey2 >= 1 && Rey2 <= 4) {
            A2 = 0.891;
            m2 = 0.330;
        } else if (Rey2 >= 4 && Rey2 <= 40) {
            A2 = 0.821;
            m2 = 0.385;
        } else if (Rey2 >= 40 && Rey2 <= 4 * Math.pow(10, 3)) {
            A2 = 0.615;
            m2 = 0.466;
        } else if (Rey2 >= 4 * Math.pow(10, 3) && Rey2 <= 4 * Math.pow(10, 4)) {
            A2 = 0.175;
            m2 = 0.618;
        } else if (Rey2 >= 4 * Math.pow(10, 4) && Rey2 <= 4 * Math.pow(10, 5)) {
            A2 = 0.024;
            m2 = 0.805;
        }

        Nuss1 = 1.11 * A1 * Math.pow(Rey1, m1) * Math.pow(Prandt, 0.31);
        Nuss2 = 1.11 * A2 * Math.pow(Rey2, m2) * Math.pow(Prandt, 0.31);

        System.out.println(Nuss1 + "Nuss1");
        System.out.println(Nuss2 + "Nuss2");

        h1 = (Nuss1 * conductivite_th_1) / (diam_tube);
        h2 = (Nuss2 * conductivite_th_2) / (diam_tube);

        System.out.println(h1 + " h1");
        System.out.println(h2 + " h2");
        coeff_convection_h = 1/((1/h1) + (1/h2) + (1/smod)*(0.000005+epaisseur_plaques/21.9));
        System.out.println(coeff_convection_h);
        return coeff_convection_h;
    }

    public double calcul_rth() {
        resistance_th_globale = 1 / (coeff_convection_h);
        System.out.println("SMOD" + smod);
        return resistance_th_globale;
    }

}
