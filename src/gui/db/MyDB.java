/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.db;

import gui.models.Personne;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Ahmed Katteni
 */
public class MyDB {
    
    
    

   public Connection con=null;
   public Statement stm;
   public int res;
   Canvas cv;
   
    
    public MyDB()
    {

        getCnx();
    }
    
    public void getCnx()
    {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MyDB.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("driver error !");
            }
            
            con =  DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
        } catch (SQLException ex) {
            Logger.getLogger(MyDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("not connected !");
            
        }
    }
    
    public void remplirJtable (DefaultTableModel model){
        model.setRowCount(0);
        try{
            stm = con.createStatement();
            
        }catch(SQLException e) {
            System.out.println("error stm " + e.getMessage());
        }
        
        try{
            ResultSet rs =stm.executeQuery("select * from user");
            while (rs.next())
            {
                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)
                
                });
            }
            
        }catch(SQLException e){
            System.out.println("error ! "+ e.getMessage());
        }
    }
    
    

  
    public void ajouter(Personne p)
    {

        try {
        String sql = "insert into user (nom, genre) values ('"+p.getNom()+"','"+p.getGenre()+"');";
        stm = con.createStatement();
        stm.executeUpdate(sql);
        }
        catch(SQLException e) {
            
            System.out.println(" CRUD error");
            System.out.println(e);
        }
    }
    
    

    public void histogramme(Graphics g, Canvas cv,int nbrTot,int nbrH,int nbrF)
    {
        cv.update(g);
        double ph=(nbrH*100)/nbrTot;
        double pf=(nbrF*100)/nbrTot;

        String H = "Homme : "+ String.valueOf(nbrH);
        String F = "Femme : "+ String.valueOf(nbrF);
        String T = "Total : "+ String.valueOf(nbrTot);
        String nb = "Nbr \n"+ String.valueOf(nbrTot);

        g.setColor(Color.blue);
        g.drawString(H,16,16);
        g.fillRect(10,cv.getHeight() - (int)ph,70,(int)ph);

        g.setColor(Color.red);
        g.drawString(F,100,16);
        g.fillRect(90,cv.getHeight() - (int)pf,70,(int)pf);

        g.setColor(Color.green);
        g.drawString(nb,5,90);
        g.drawString(T,200,16);

        g.setColor(Color.green);
        g.drawLine(1, cv.getHeight(), 1, 120);

        g.setColor(Color.yellow);
        g.drawLine(cv.getWidth(), 299, 0, 299);

        g.setColor(Color.yellow);
        g.drawString("Genre H/F",630,cv.getHeight());


    }



    public void stat (Graphics g , Canvas cv)
    {
        int nbrH = 0;
        int nbrF = 0;
        int nbrTot = 0;
        try {
           stm = con.createStatement();
        }
            catch (SQLException e)
            {
                System.out.println(e.getMessage());
            }

        try {
                ResultSet res = stm.executeQuery("select * from user");
                while(res.next()) {
                    nbrTot ++;
                    if (res.getString(3).equals("Homme")) {
                        nbrH++;

                    }
                    else if(res.getString(3).equals("Femme")) {
                        nbrF++;
                    }
                }
            }
         catch (SQLException e)
                 {
                    System.out.println(e.getMessage());
                 }

        histogramme( g,cv, nbrTot, nbrH, nbrF);

    }

    
    
    

    
    
    
    
    
    


    
}
