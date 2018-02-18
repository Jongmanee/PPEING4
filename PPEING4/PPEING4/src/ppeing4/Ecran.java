/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppeing4;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
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
    
   
    JPanel panneau;
    JButton b1, b2, b3;
    
    
    public Ecran ()
    {
        
        setBounds(0,0,300,400);
        setTitle("PPE-ING4-GEOTHERMIE");
        
        Ecouteur ec;
        ec = new Ecouteur();
        
       
        
        
       
        b1 = new JButton("Sélection Technologie");
        b2 = new JButton("Saisie des caract.");
        b3 = new JButton("Affichage");
        
        b1.addActionListener(ec);
        
        
       
        panneau = new JPanel();
        
        panneau.add(b1);
        panneau.add(b2);
        panneau.add(b3);
        
        getContentPane().add(panneau);
        
       
    }
        
    public class Ecouteur implements ActionListener
    {
        public void actionPerformed(ActionEvent arg0)
        {
            
            if (arg0.getSource()==b2)
            {
                 System.out.println("HELLO");
            }
               
            
        }
                
        
    }
    
}
