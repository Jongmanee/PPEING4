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
    
    JButton b1;
    JPanel panneau;
    JTextArea txt_utilisation;
    
    
    public Fenetre_saisie ()
    {
    setBounds(0,0,600,600);
        setTitle("PPE-ING4-GEOTHERMIE");
        
        panneau = new JPanel();
        
        
          b1 = new JButton("Résultats");
          
          
          Ecouteur2 ec;
        ec = new Ecouteur2();
        b1.addActionListener(ec);
          
          panneau.add(b1);
          
          getContentPane().add(panneau);
          
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
                }
         
         }
         
         
        
    
}
