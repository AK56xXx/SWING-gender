/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.db.MyDB;
import gui.models.Personne;
import gui.views.MyForm;
import gui.views.MyList;

/**
 *
 * @author Ahmed Katteni
 */
public class MyEvent implements ActionListener {
    
    public MyForm mf;

    public MyDB mydb;
    
    
    public MyEvent(MyForm mf)
    {
        this.mf=mf;
        mydb=new MyDB();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==mf.show)
        {       
   
          new MyList();
        }
        else if(e.getSource()==mf.add && !mf.nomt.getText().isBlank())
        {
            String genre="Homme";
            if(mf.femme.isSelected()){
                genre="Femme";
            }
            Personne p = new Personne(mf.nomt.getText(),genre);
            mydb.ajouter(p);
  
         
        }
        else
        {
            System.out.println(" error event !");
        }
             
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
