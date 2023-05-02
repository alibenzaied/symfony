/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnexionSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ConnexionSource_1{
    
    private String url="jdbc:mysql://localhost:3306/test";
    private String login="root";
    private String pwd="";
    private Connection cnx;
    private static ConnexionSource_1 instance;
    
      public ConnexionSource_1() {
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionSource_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ConnexionSource_1 getInstance(){
        if(instance==null)
            instance=new ConnexionSource_1();
        return instance;
    }
    
    public Connection getCnx(){
        return cnx;
    }
    
}
