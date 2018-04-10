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

    /**
     *
     */
    protected double smod;

    /**
     *
     */
    protected int nbre_modules;

    /**
     *
     */
    protected double surface_contact;

    /**
     *
     */
    protected double r_charge;

    /**
     *
     */
    protected float debit_m_1;

    /**
     *
     */
    protected float debit_m_2;

    /**
     *
     */
    protected float capacite_th_1;

    /**
     *
     */
    protected float capacite_th_2;

    /**
     *
     */
    protected float diff_temperature;

    /**
     *
     */
    protected float tempc;

    /**
     *
     */
    protected float tempf;

    /**
     *
     */
    protected float tempm;

    /**
     *
     */
    protected float masse_volumique_1;

    /**
     *
     */
    protected float masse_volumique_2;

    /**
     *
     */
    protected double taux_occupation;

    /**
     *
     */
    protected double resistance_th_globale;

    /**
     *
     */
    protected double longueur_jambe = 3.45 * Math.pow(10, -3);

    /**
     *
     */
    protected double surface_jambe = 6.25 * Math.pow(10, -6);

    /**
     *
     */
    protected double conduct_th_fluide;

    /**
     *
     */
    protected double conduct_th_tube;

    /**
     *
     */
    protected double surface_module = ((55 * Math.pow(10, -3)) * (55 * Math.pow(10, -3)));

    /**
     *
     */
    protected double conduct_th_module;

    /**
     *
     */
    protected double seebeck;

    /**
     *
     */
    protected double thomson;

    /**
     *
     */
    protected double densite_couple;

    /**
     * Constructeur de la classe Technologie 
     * @param debit_m_1
     * @param debit_m_2
     * @param capacite_th_1
     * @param capacite_th_2
     * @param masse_volumique_1
     * @param masse_volumique_2
     * @param tempc
     * @param tempf 
     */
    public Technologies(float debit_m_1, float debit_m_2, float capacite_th_1, float capacite_th_2, float masse_volumique_1, float masse_volumique_2, float tempc, float tempf) {
        this.tempf = tempf + 273;
        this.tempc = tempc + 273;
        this.tempm = (this.tempc + this.tempf) / 2;
        this.diff_temperature = tempc - tempf;
        this.capacite_th_1 = capacite_th_1;
        this.masse_volumique_1 = masse_volumique_1;
        this.debit_m_1 = (debit_m_1 * masse_volumique_1) / 3600;

        this.capacite_th_2 = capacite_th_2;
        this.masse_volumique_2 = masse_volumique_2;
        this.debit_m_2 = (debit_m_2 * masse_volumique_2) / 3600;

        this.seebeck = ((22224 + 930.6 * tempm) - (0.9905 * tempm * tempm)) * Math.pow(10, -9);
        this.thomson = ((930.6 - 0.9905 * tempm * tempm) * Math.pow(10, -9) * tempm);
        this.conduct_th_fluide = 0.6;
        this.conduct_th_module = ((62605 - 277.7 * tempm + 0.4131 * tempm * tempm) * Math.pow(10, -4));
        this.conduct_th_tube = 50.2;

    }
    
    /**
     * cacul du taux d'occupation
     * @return taux_occupation
     */
    public double calcul_taux_occupation() {
        taux_occupation = smod / surface_contact;
        return taux_occupation;
    }
    
    /**
     * calcul de la densité de couple du module
     * @return densite_couple
     */
    public double calcul_densite_couple() {
        densite_couple = ((254 * 2 * surface_jambe) * (Math.pow(taux_occupation * surface_contact, -1)));
        return densite_couple;
    }
    
    /**
     * calcul la puissance électrique générée par les modules thermoélectriques
     * @return Pe
     */
    public double calcul_Pe() {
        //double Pe = (   ((seebeck+thomson)*(seebeck+thomson))  *   densite_couple*densite_couple*taux_occupation*taux_occupation*surface_contact*surface_contact*   ( (2*((debit_m*masse_volumique)/3600)*capacite_th*(-diff_temperature))*(2*((debit_m*masse_volumique)/3600)*capacite_th*(-diff_temperature))) *longueur_jambe*longueur_jambe*r_charge*surface_jambe*surface_jambe  )/(  4*  (2*((debit_m*masse_volumique)/3600)*capacite_th*(longueur_jambe+resistance_th_globale*conduct_th_module*densite_couple*taux_occupation*surface_contact) + conduct_th_module*densite_couple*taux_occupation*surface_contact) *  (2*((debit_m*masse_volumique)/3600)*capacite_th*(longueur_jambe+resistance_th_globale*conduct_th_module*densite_couple*taux_occupation*surface_contact) + conduct_th_module*densite_couple*taux_occupation*surface_contact)  * (r_charge*surface_jambe*surface_jambe+ masse_volumique*densite_couple*taux_occupation*surface_contact*longueur_jambe)*(r_charge*surface_jambe*surface_jambe+ masse_volumique*densite_couple*taux_occupation*surface_contact*longueur_jambe) );
        //double Pe = ((    16*diff_temperature*diff_temperature*debit_m_1*debit_m_1*capacite_th_1*capacite_th_1*r_charge*surface_jambe*surface_jambe*surface_contact*surface_contact*seebeck*seebeck*densite_couple*densite_couple*taux_occupation*taux_occupation*longueur_jambe*longueur_jambe)/((  2*r_charge*surface_jambe*surface_jambe + masse_volumique_1*densite_couple*taux_occupation*surface_contact*longueur_jambe      )*(  2*r_charge*surface_jambe*surface_jambe + masse_volumique_1*densite_couple*taux_occupation*surface_contact*longueur_jambe      ) * (2*debit_m_1*capacite_th_1*(2*longueur_jambe+resistance_th_globale*conduct_th_module*densite_couple*taux_occupation*surface_contact) + (conduct_th_module*densite_couple*taux_occupation*surface_contact)) * (2*debit_m_1*capacite_th_1*(2*longueur_jambe+resistance_th_globale*conduct_th_module*densite_couple*taux_occupation*surface_contact) + (conduct_th_module*densite_couple*taux_occupation*surface_contact))           ));
        double Pe = 0.05 * (diff_temperature * diff_temperature * debit_m_1 * capacite_th_1 * 2.9) / (8 * (1 + 2 * debit_m_1 * capacite_th_1 * resistance_th_globale));

        return Pe;
    }
    
    /**
     * calcul de la résistance de charge (non utilisé)
     * @return r_charge
     */
    public double calcul_rcharge() {
        r_charge = masse_volumique_1 * densite_couple * smod * longueur_jambe / (2 * surface_jambe);
        return r_charge;
    }

    
    
    // les differents getter
    
    /**
     * getter de la surface d'un module
     * @return surface_module
     */
    public double getter_surface_module() {
        return surface_module;
    }

    /**
     * getter de la conductivité thermique du module
     * @return conduct_th_module
     */
    public double getter_conduct_th_module() {
        return conduct_th_module;
    }

    /**
     * getter de la conductivité thermique du fluide
     * @return conduct_th_fluide
     */
    public double getter_conduct_th_fluide() {
        return conduct_th_fluide;
    }
    
    /**
     * getter de la différence de température
     * @return diff_temperature
     */
    public float getter_diff_temperature() {
        return diff_temperature;
    }

    /**
     * getter de la surface de la jambe d'un module
     * @return surface_jambe
     */
    public double getter_surface_jambe() {
        return surface_jambe;
    }
    
    /**
     * getter de la longueur de d'une jambe d'un module
     * @return longueur_jambe
     */
    public double getter_longueur_jambe() {
        return longueur_jambe;
    }
    
    /**
     * getter de la densite de couple du module
     * @return densite_couple
     */
    public double getter_densite_couple() {
        return densite_couple;
    }
    
    /**
     * getter du nombre de modules utilisés dans l'échangeur
     * @return nbre_modules
     */
    public int getter_nbre_modules() {
        return nbre_modules;
    }
    
    /**
     * getter de la surface de contact
     * @return surface_contact
     */
    public double getter_surface_contact() {
        return surface_contact;
    }

}
