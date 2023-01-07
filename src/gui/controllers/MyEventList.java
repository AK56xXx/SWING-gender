/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.controllers;

import gui.views.MyList;

/**
 *
 * @author Ahmed Katteni
 */
public class MyEventList {
    

    MyList ml;
    
    public MyEventList(MyList ml) {
        this.ml=ml;
        MyThread th=new MyThread(ml);
        th.start();


        
    }
    
    

    
    
}
