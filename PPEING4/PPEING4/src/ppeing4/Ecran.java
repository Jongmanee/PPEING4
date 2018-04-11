/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package ppeing4;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.WindowConstants;

/**
 *
 * @author gautier
 */
public class Ecran extends JFrame {

    JPanel panneau, panneau2;
    JButton b1;
    JTextArea txt_utilisation;
    JScrollPane defil;
    JFrame frame;
    ImageIcon fond;
    JLabel jlbackgroundImage;
    String bulle;

    /**
     * Constructeur de la classe Ecran (main)
     */
    public Ecran() {

        setBounds(0, 0, 600, 600);
        setTitle("C°2WATT");
        JTextArea txt_utilisation = new JTextArea(
                "                                    Présentation du Logiciel\n\n"
                + "Le but de ce logiciel est de vous permettre de choisir la technologie d'échangeur, afin de constituer un générateur thermoélectrique, pour valoriser la chaleur perdue au sein de votre centrale géothermique.\n\n"
                + "1ere étape : SELECTION de votre technologie d'échangeur\n\n"
                + "2eme étape : SAISIE des caractéristiques de votre centrale necessaires aux calculs\n\n"
                + "3eme étape : AFFICHAGE des résultats (physique et économique)"
        );

        txt_utilisation.setLineWrap(true);
        txt_utilisation.setWrapStyleWord(true);
        txt_utilisation.setEditable(false);

        defil = new JScrollPane(txt_utilisation);
        txt_utilisation.setRows(15);
        txt_utilisation.setColumns(40);

        Ecouteur ec;
        ec = new Ecouteur();
        b1 = new JButton("Lancer Calcul");
        b1.addActionListener(ec);

        JLabel img = new JLabel(new ImageIcon("logo.png"));

        panneau = new JPanel();

        txt_utilisation.setLineWrap(true);
        txt_utilisation.setWrapStyleWord(true);

        Box boxa = Box.createHorizontalBox();
        Box boxb = Box.createHorizontalBox();
        Box dernierebox = Box.createVerticalBox();
        Box boximg = Box.createHorizontalBox();
        boximg.add(img);
        boxa.add(defil);
        boxb.add(b1);
        dernierebox.add(boximg);
        dernierebox.add(boxa);
        dernierebox.add(boxb);
        panneau.add(dernierebox);

        getContentPane().add(panneau);
        this.setLocation(400, 200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

    }

    /**
     * classe intégrée Listener pour le bouton
     */
    public class Ecouteur extends PPEING4 implements ActionListener {

        /**
         *
         * @param arg0
         */
        public void actionPerformed(ActionEvent arg0) {

            if (arg0.getSource() == b1) {
                Fenetre_saisie fenetre2;
                fenetre2 = new Fenetre_saisie();
                if (fenetre2.bulle != null) {
                    fenetre2.setVisible(true);
                } else {
                    fenetre2.setVisible(false);
                }
            }
        }
    }
}