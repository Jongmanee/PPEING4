/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppeing4;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
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
    JTextArea txt_utilisation;
    JScrollPane defil;
    
    
    
    
    public Ecran ()
    {
        
        setBounds(0,0,600,600);
        setTitle("PPE-ING4-GEOTHERMIE");
        
       
        txt_utilisation = new JTextArea (10,40);
        defil = new JScrollPane(txt_utilisation);
       
        Ecouteur ec;
        ec = new Ecouteur();
        
        String[] choix = {"Coaxial", "A plaques"};
        JOptionPane jop = new JOptionPane();
        
        String bulle = (String)jop.showInputDialog(null, 
      "Veuillez choisir la technologie de l'échangeur",
      "PPE ING4 GEOTHERMIE",
      JOptionPane.QUESTION_MESSAGE,
      null,
      choix,
      choix[1]);
        
       
       
       
        b1 = new JButton("Sélection Technologie");
        b2 = new JButton("Saisie des caract.");
        b3 = new JButton("Affichage");
        
        b1.addActionListener(ec);
        b2.addActionListener(ec);
        b3.addActionListener(ec);
        
       
        panneau = new JPanel();
        
        panneau.add(defil);
        txt_utilisation.setLineWrap(true);
         txt_utilisation.setWrapStyleWord(true);
        
        panneau.add(b1);
        panneau.add(b2);
        panneau.add(b3);
        
        getContentPane().add(panneau);
        
       
    }
        
    public class Ecouteur implements ActionListener
    {
        public void actionPerformed(ActionEvent arg0)
        {
            
            if (arg0.getSource()==b1)
            {
                 panneau.setBackground(Color.RED);
                 System.out.println("ROUGE");
            }
              
             if (arg0.getSource()==b2)
            {
                 panneau.setBackground(Color.GREEN);
                 System.out.println("VERT");
            }
             
              if (arg0.getSource()==b3)
            {
                 panneau.setBackground(Color.BLUE);
                 System.out.println("BLEU");
            }
            
        }
                
        
    }
    
}
