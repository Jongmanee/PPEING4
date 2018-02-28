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
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;

/**
*
* @author gautier
*/
public class Ecran extends JFrame
{


    JPanel panneau, panneau2;
    JButton b1;
    JTextArea txt_utilisation;
    JScrollPane defil;
    JFrame frame;
    ImageIcon fond;
    JLabel jlbackgroundImage;
    String bulle;
   
    




    public Ecran ()
    {

        setBounds(0,0,600,600);
        setTitle("PPE-ING4-GEOTHERMIE");
        
       
        JTextArea txt_utilisation = new JTextArea(

        "                                    Présentation du Logiciel\n"+

        "Partis de ce constat nous avons décidé d’étendre notre travail à d’autres centrales géothermique afin de pouvoir palie a une perte de chaleur éventuel sur toutes les centrales. "+"\r"+
        "Nous avons décidé de créer un logiciel qui pourra permettre à l’utilisateur, après saisie des caractéristiques de sa centrale géothermique et de son réseau, avoir une comparaison entre différentes façons ou technologies afin d’exploiter la chaleur perdue au retour de l’eau chaude dans le réseau géothermique.\n\r" +
        "L’intérêt de notre logiciel sera donc d’obtenir une solution adaptée et efficace pour chaque chacune des centrales géothermique face a une éventuelle perte de chaleur.\n"+
        "Après avoir rentré les données caractéristiques de la centrale, l’utilisateur aura à sa disposition un tableau de solutions diverses ou lui sera indiqué la solution la plus efficace pour valoriser la chaleur de sa centrale.\n"

        );

        


        txt_utilisation.setLineWrap(true);
        txt_utilisation.setWrapStyleWord(true);
        txt_utilisation.setEditable(false); 

        defil = new JScrollPane(txt_utilisation);
        txt_utilisation.setRows(20);
        txt_utilisation.setColumns(40);

        Ecouteur ec;
        ec = new Ecouteur();

        b1 = new JButton("Lancer Calcul");

        b1.addActionListener(ec);


        panneau = new JPanel();
            
        txt_utilisation.setLineWrap(true);
        txt_utilisation.setWrapStyleWord(true);

        Box boxa = Box.createHorizontalBox();
        Box boxb = Box.createHorizontalBox();
        Box dernierebox = Box.createVerticalBox();
        boxa.add(defil);
        boxb.add(b1);
        dernierebox.add(boxa);
        dernierebox.add(boxb);
        panneau.add(dernierebox);
        

        getContentPane().add(panneau);


    }

        public class Ecouteur extends PPEING4 implements ActionListener
        {
            
            
                public void actionPerformed(ActionEvent arg0)
                {

                     if (arg0.getSource()==b1)
                    {
                         
                         Fenetre_saisie fenetre2 ;
                        fenetre2 = new Fenetre_saisie();
                        if (fenetre2.bulle!=null)
                        {
                            fenetre2.setVisible(true);
                        }
                        else
                        {
                            fenetre2.setVisible(false);
                        }
                        
                    } 

                }


        }

}