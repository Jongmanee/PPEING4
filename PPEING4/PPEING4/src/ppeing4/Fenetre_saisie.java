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
public class Fenetre_saisie extends JFrame{
    
    JButton b1,b2;
    JPanel panneau;
    JTextArea txt_utilisation;
    String bulle;
    
    public Fenetre_saisie ()
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
        System.out.println(bulle);
        if (bulle!=null)
    {
                     
                     
                     
    setBounds(0,0,600,600);
        setTitle("PPE-ING4-GEOTHERMIE");
        
        panneau = new JPanel();
        
        
                    
                    if(bulle=="Coaxial")
                    {
                        System.out.println("ok");
                        
                    }
                    
                    
                    
                 
                     
          b1 = new JButton("Résultats");
          b2 = new JButton("Changer de technologie");
          
          
          Ecouteur2 ec;
        ec = new Ecouteur2();
        b1.addActionListener(ec);
        b2.addActionListener(ec);
          
          panneau.add(b1);
          panneau.add(b2);
          
          getContentPane().add(panneau);
          
    }
        
        if(bulle==null)
        {
        System.out.println("annuler");
        	
        }
        
    }
    
     public class Ecouteur2 extends PPEING4 implements ActionListener
        {
         public void actionPerformed(ActionEvent arg0)
                {
                    
                     if (arg0.getSource()==b1)
                    {
                         Fenetre_resultats fenetre3 ;
                        fenetre3 = new Fenetre_resultats();
                        fenetre3.setVisible(true);
                    }
                     
                     if(arg0.getSource()==b2)
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
