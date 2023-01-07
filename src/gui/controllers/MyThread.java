/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.controllers;

import gui.db.MyDB;
import gui.views.MyList;

/**
 *
 * @author Ahmed Katteni
 */
public class MyThread extends Thread{
    MyList ml;
    MyDB mdb;
    public MyThread(MyList ml) {
        this.ml = ml;
        mdb=new MyDB();
    }



    public void run() {
        while(true) {
            
            mdb.stat(ml.g, ml.cv);
            mdb.remplirJtable(ml.model);

            try {sleep(200);}catch(Exception e) {}
        }
    }




}
