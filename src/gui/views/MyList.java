/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.views;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import gui.controllers.MyEventList;

/**
 *
 * @author Ahmed Katteni
 */
public class MyList extends JFrame {
    
     public Canvas cv = new Canvas();
     public Graphics g;
    
    String entete[]={"id","Nom","Genre"};
                public DefaultTableModel model= new DefaultTableModel((entete),0);
                public JTable tab = new JTable(model);
                public JScrollPane sp = new JScrollPane(tab);
                
                
                public MyList()
                {
                             
                   this.setTitle("INFORMATION LIST");
                   this.setSize(700,600);
                   this.setLocationRelativeTo(getParent());
                   this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                   
                   cv.setPreferredSize(new Dimension(500,300));
                   cv.setBackground(Color.black);
                   
                Container c = getContentPane();
                    c.setLayout(new BorderLayout());
                    c.add("Center",sp);
                    c.add("South",cv);
                   
        
                    
                  setVisible(true);  
                  
                  g=cv.getGraphics();
                  MyEventList m = new MyEventList(this); 
                  
                  
                  
                  
                }
                
    public static void main(String[] args) {
        new MyList();
    }
    
    
    
}
