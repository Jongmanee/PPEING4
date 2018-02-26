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

/**
*
* @author gautier
*/
public class Ecran extends JFrame
{


    JPanel panneau, panneau2;
    JButton b1, b2, b3, b4;
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







        b1 = new JButton("Sélection Technologie", new ImageIcon("/images/saisie.png"));
        b1.setSize(200,200);
        
        
        b2 = new JButton("Saisie des caract.");
        b3 = new JButton("Affichage");
        b4 = new JButton("Lancer Calcul");

        b1.addActionListener(ec);
        b2.addActionListener(ec);
        b3.addActionListener(ec);
        b4.addActionListener(ec);


        panneau = new JPanel();
        
        

        panneau.add(defil);
        txt_utilisation.setLineWrap(true);
        txt_utilisation.setWrapStyleWord(true);

        panneau.add(b1);
        panneau.add(b2);
        panneau.add(b3);
        panneau.add(b4);
        

        getContentPane().add(panneau);


    }

        public class Ecouteur extends PPEING4 implements ActionListener
        {
            
            
                public void actionPerformed(ActionEvent arg0)
                {

                    if (arg0.getSource()==b1)
                    {
                          String[] choix = {"Coaxial", "À plaques", "À spirales"};
                    JOptionPane jop = new JOptionPane();

                    bulle = (String)jop.showInputDialog(null, 
                    "Veuillez choisir la technologie de l'échangeur",
                    "PPE ING4 GEOTHERMIE",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    choix,
                    choix[2]);

                    }

                     if (arg0.getSource()==b2)
                    {
                         double input_debit = Double.parseDouble(JOptionPane.showInputDialog(null, "Veuillez saisir le débit :")) ;
                         System.out.println(input_debit);
                         String input_capacite_massique = JOptionPane.showInputDialog("Veuillez saisir la capacité massique du fluide :");
                         System.out.println(input_capacite_massique);
                         String input_diff_temperature = JOptionPane.showInputDialog("Veuillez saisir la différence de température entre les deux fluides :");
                         System.out.println(input_diff_temperature);
                         String input_masse_volumique = JOptionPane.showInputDialog("Veuillez saisir la masse volumique du fluide :");
                         System.out.println(input_masse_volumique);
                         String input_largeur = JOptionPane.showInputDialog("Veuillez saisir la largeur de l'espace disponible :");
                         System.out.println(input_largeur);
                         String input_hauteur = JOptionPane.showInputDialog("Veuillez saisir la hauteur de l'espace disponible :");
                         System.out.println(input_hauteur);
                         String input_longeur = JOptionPane.showInputDialog("Veuillez saisir la longueur de l'espace disponible :");
                         System.out.println(input_longeur);
                         
                    }

                      if (arg0.getSource()==b3)
                    {
                         panneau.setBackground(Color.BLUE);
                         System.out.println("BLEU");
                    }
                      
                     if (arg0.getSource()==b4)
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