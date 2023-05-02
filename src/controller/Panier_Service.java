/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import ConnexionSource.ConnexionSource;
import entity.Panier_entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author PC
 */
public class Panier_Service implements IservicePanier<Panier_entity> {
    
    private Connection cnx;
    public Panier_Service(){
        cnx = ConnexionSource.getInstance().getCnx();
        
    }

    @Override
    public void insert(Panier_entity t) {
    String req= "INSERT INTO panier(nom,quantite,iduser) VALUES (?,?,?)";
        try {
        PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getNom());
            pst.setInt(2, t.getQuantite());
            pst.setInt(3, t.getIduser());
            pst.executeUpdate();
            System.out.println("Panier ajouter avec succees");
        }    
         catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }    }

    @Override
    public void delete(Panier_entity t) {
     String query ="DELETE FROM Panier where id="+ t.getId() +"";
        try {
            
            Statement ste = cnx.createStatement();
            ste.executeUpdate(query);
            System.out.println("Panier deleted");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }                   
    }

    @Override
    public Void update(Panier_entity t) {
        String req ="UPDATE panier SET "
                +"`nom`='" + t.getNom() +"'"
                +",`quantite`='" + t.getQuantite() +"'"
                +"WHERE `id`='"+ t.getId()+"'";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("panier modifier");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }    
        return null;
}

    @Override
    public List<Panier_entity> readAll() {
     List<Panier_entity> list = new ArrayList<>();
        String req = "SELECT * FROM panier";
        try {
            Statement pst = cnx.createStatement();
            ResultSet rs = pst.executeQuery(req);
            while(rs.next()){
                Panier_entity ce= new Panier_entity(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getInt("quantite")

                        
                );
            list.add(ce);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<Panier_entity> readAll2(int id) {
     List<Panier_entity> list = new ArrayList<>();
        String req = "SELECT * FROM panier Where iduser="+id+" ORDER BY id DESC ";
        try {
            Statement pst = cnx.createStatement();
            ResultSet rs = pst.executeQuery(req);
            while(rs.next()){
                Panier_entity ce= new Panier_entity(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getInt("quantite")

                        
                );
            list.add(ce);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    @Override
    public Panier_entity readyById(int id) {
        Panier_entity pe = new Panier_entity();
        String condition =(" id ='" + id + "'");
        String requete = "SELECT * FROM panier WHERE"+ condition +"LIMIT 1";
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            if(rs.next()){
                pe = new Panier_entity(
                rs.getInt("id"),
                rs.getString("nom"),     
                rs.getInt("quantite")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Error ReadyBy=\n" +ex);
        }
        return pe;   
        }
    
    public List<Panier_entity> Search(String t) {

        List<Panier_entity> list1 = new ArrayList<>();
        List<Panier_entity> list2 = readAll();
        list1 = (list2.stream().filter(c -> c.getNom().startsWith(t)).collect(Collectors.toList()));
        
    return list1;
    }

    public List<Panier_entity> triNom(int id) {
 
     List<Panier_entity> list = new ArrayList<>();
        String req = "SELECT * FROM panier Where iduser="+id+" ORDER BY nom DESC LIMIT 1";
        try {
            Statement pst = cnx.createStatement();
            ResultSet rs = pst.executeQuery(req);
            while(rs.next()){
                Panier_entity ce= new Panier_entity(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getInt("quantite")

                        
                );
            list.add(ce);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    
    }
    public List<Panier_entity> triQuantity() {

        List<Panier_entity> list1 = new ArrayList<>();
        List<Panier_entity> list2 = readAll();

        list1 = list2.stream().sorted((q1, q2) -> Integer.compare(q1.getQuantite(), q2.getQuantite()))
             .collect(Collectors.toList());
        return list1;

    }
    
}
