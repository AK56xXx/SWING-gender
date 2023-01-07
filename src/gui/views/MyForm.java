/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gui.views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import gui.controllers.MyEvent;

/**
 *
 * @author Ahmed Katteni
 */
public class MyForm extends JFrame {
    
    public JLabel noml = new JLabel("Nom");
    public JLabel genrel = new JLabel("Genre");
    public JTextField nomt = new JTextField();
    public JRadioButton homme = new JRadioButton("Homme");
    public JRadioButton femme = new JRadioButton("Femme");
    public ButtonGroup bg = new ButtonGroup();
    public JButton add = new JButton("Ajouter");
    public JButton show = new JButton("Afficher");
   
    
    public MyForm()
    {

        this.setTitle("PROJECT JAVA");
        this.setSize(500,200);
        this.setLocationRelativeTo(getParent());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel Pgenre = new JPanel(new GridLayout(1,3));
        homme.setSelected(rootPaneCheckingEnabled);
        Pgenre.add(homme);
	    Pgenre.add(femme);
        bg.add(homme);
        bg.add(femme);
        
        JPanel Pcenter = new JPanel(new GridLayout(2,2));
            Pcenter.add(noml);
            Pcenter.add(nomt);
            Pcenter.add(genrel);
            Pcenter.add(Pgenre);
                
              
        JPanel Psouth = new JPanel(new GridLayout(1,2));
            Psouth.add(add);
            Psouth.add(show);
                
                
                Container c = getContentPane();
		            c.setLayout(new BorderLayout());
                    c.add("Center",Pcenter);
                    c.add("South",Psouth);
	
        
           MyEvent evt = new MyEvent(this);
                show.addActionListener(evt); 
		        add.addActionListener(evt);
         
         setVisible(true);
    }
    
    
   
    
    
    public static void main(String[] args) {
        new MyForm();
    }
    
    

 
}
