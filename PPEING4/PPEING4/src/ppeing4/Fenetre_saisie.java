/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppeing4;
import java.awt.BorderLayout;
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
import java.text.NumberFormat;
import java.text.Format;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Box;

/**
 *
 * @author gautier
 */
public class Fenetre_saisie extends JFrame
{
    
    JButton b1,b2;
    JPanel panneau;
    JTextArea txt_utilisation;
    String bulle;
    
    public Fenetre_saisie ()
    {
        String[] choix = {"Coaxial", "À plaques", "À spirales"};
        JOptionPane jop = new JOptionPane();
        bulle = (String)jop.showInputDialog(null, "Veuillez choisir la technologie de l'échangeur","PPE ING4 GEOTHERMIE",JOptionPane.QUESTION_MESSAGE,null,choix,choix[2]);
        System.out.println(bulle);

        if (bulle!=null)
        {                                   
            setBounds(0,0,600,600);
            setTitle("PPE-ING4-GEOTHERMIE");    
            panneau = new JPanel();

            Box box1 = Box.createHorizontalBox();
            b1 = new JButton("Résultats");
            b2 = new JButton("Changer de technologie");

            Ecouteur2 ec;
            ec = new Ecouteur2();
            b1.addActionListener(ec);
            b2.addActionListener(ec);

            box1.add(b1);
            box1.add(b2);

            // Formulaire (partie coaxial)
            Box box2 = Box.createHorizontalBox();
            JLabel debitlb=new JLabel("Rentrer le debit :");
            box2.add(debitlb,BorderLayout.WEST);
            JFormattedTextField debitnb= new JFormattedTextField(NumberFormat.getInstance());
            debitnb.setColumns(30);
            box2.add(debitnb,BorderLayout.EAST);

            Box box3 = Box.createHorizontalBox();
            JLabel capacitelb=new JLabel("Rentrer la capacite :");
            box3.add(capacitelb);
            JFormattedTextField capacitenb= new JFormattedTextField(NumberFormat.getInstance());
            capacitenb.setColumns(30);
            box3.add(capacitenb);

            Box box4 = Box.createHorizontalBox();
            JLabel tempclb=new JLabel("Rentrer la temperature chaude :");
            box4.add(tempclb);
            JFormattedTextField tempcnb= new JFormattedTextField(NumberFormat.getInstance());
            tempcnb.setColumns(30);
            box4.add(tempcnb);
            
            Box box5 = Box.createHorizontalBox();
            JLabel tempflb=new JLabel("Rentrer la temperature froide :");
            box5.add(tempflb);
            JFormattedTextField tempfnb= new JFormattedTextField(NumberFormat.getInstance());
            tempfnb.setColumns(30);
            box5.add(tempfnb);  
            
            Box box6 = Box.createHorizontalBox();
            JLabel longueurlb=new JLabel("Rentrer la longueur :");
            box6.add(longueurlb);
            JFormattedTextField longueurnb= new JFormattedTextField(NumberFormat.getInstance());
            longueurnb.setColumns(30);
            box6.add(longueurnb);

            Box box7 = Box.createHorizontalBox();
            JLabel largeurlb=new JLabel("Rentrer la largueur :");
            box7.add(largeurlb);
            JFormattedTextField largeurnb= new JFormattedTextField(NumberFormat.getInstance());
            largeurnb.setColumns(30);
            box7.add(largeurnb);

            Box box8 = Box.createHorizontalBox();
            JLabel hauteurlb=new JLabel("Rentrer la hauteur :");
            box8.add(hauteurlb);
            JFormattedTextField hauteurnb= new JFormattedTextField(NumberFormat.getInstance());
            hauteurnb.setColumns(30);
            box8.add(hauteurnb);

            Box box9 = Box.createHorizontalBox();
            JLabel viscositelb=new JLabel("Rentrer la viscosite :");
            box9.add(viscositelb);
            JFormattedTextField viscositenb= new JFormattedTextField(NumberFormat.getInstance());
            viscositenb.setColumns(30);
            box9.add(viscositenb);

            Box box10 = Box.createHorizontalBox();
            JLabel epaisseurlb=new JLabel("Rentrer l'épaisseur de la paroi :");
            box10.add(epaisseurlb);
            JFormattedTextField epaisseurnb= new JFormattedTextField(NumberFormat.getInstance());
            epaisseurnb.setColumns(30);
            box10.add(epaisseurnb);
            
            Box box11 = Box.createHorizontalBox();
            JLabel massevolumiquelb=new JLabel("Rentrer la masse volumique :");
            box11.add(massevolumiquelb);
            JFormattedTextField massevolumiquenb= new JFormattedTextField(NumberFormat.getInstance());
            massevolumiquenb.setColumns(30);
            box11.add(massevolumiquenb);

            //faire les setVisibles

            Box lastbox = Box.createVerticalBox();
            lastbox.add(box1);
            lastbox.add(box2);
            lastbox.add(box3);
            lastbox.add(box4);
            lastbox.add(box5);
            lastbox.add(box6);
            lastbox.add(box7);
            lastbox.add(box8);
            lastbox.add(box9);
            lastbox.add(box10);
            lastbox.add(box11);
            panneau.add(lastbox);
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
           String[] choix = {"Coaxial", "À plaques", "À spirales"};
           JOptionPane jop = new JOptionPane();
           bulle = (String)jop.showInputDialog(null, "Veuillez choisir la technologie de l'échangeur","PPE ING4 GEOTHERMIE",JOptionPane.QUESTION_MESSAGE,null,choix,choix[2]);
           System.out.println(bulle); 

           if (bulle=="Coaxial")
           {
               //faire les setVisibles
           }
           if (bulle=="À plaques")
           {
               //faire les setVisibles
           }
           if (bulle=="À spirales")
           {
               //faire les setVisibles
           }
        }
      }
     }  
}
