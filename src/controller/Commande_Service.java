/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import ConnexionSource.ConnexionSource;
import entity.Commande_entity;
import java.sql.Connection;
import java.sql.Date;
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
public class Commande_Service implements Iservice<Commande_entity> {

    private  Connection cnx;
    public Commande_Service(){
        cnx = ConnexionSource.getInstance().getCnx();
    }


    @Override
    public void insert(Commande_entity t) {
        String req= "INSERT INTO commande(nom,description,quantite,date_creation,date_c,idPanier) VALUES (?,?,?,?,?,?)";
        try {
        PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getDescription());
            pst.setInt(3, t.getQuantite());
            pst.setString(4, (t.getDate_creation()));
            pst.setDate(5, new java.sql.Date(t.getDate_c().getTime()));
            pst.setInt(6, t.getIdPanier());
            pst.executeUpdate();
            System.out.println("Commande ajouter avec succees");

        }    
         catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
    }


    @Override
    public void delete(Commande_entity t) {
        String query ="DELETE FROM commande where id="+ t.getId() +"";
        try {
            
            Statement ste = cnx.createStatement();
            ste.executeUpdate(query);
            System.out.println("Commande deleted");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }                   
    }

    @Override
    public void update(Commande_entity t) {
        String req ="UPDATE commande SET "
                +"`nom`='" + t.getNom() +"'"
                +",`description`='" + t.getDescription()+"'"
                +",`quantite`='" + t.getQuantite() +"'"
                +",`date_creation`='" + (t.getDate_creation()) +"'"
                +",`date_c`='" + (t.getDate_c()) +"'"
                +",`idPanier`='" + t.getIdPanier()+"'"
                +"WHERE `id`='"+ t.getId()+"'";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Commande modifier");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }



    }
    
    
      
    public List<Commande_entity> readAll2() {
        List<Commande_entity> list = new ArrayList<>();
        String req = "SELECT * FROM commande ORDER BY id DESC LIMIT 1";
        try {
            Statement pst = cnx.createStatement();
            ResultSet rs = pst.executeQuery(req);
            while(rs.next()){
                Commande_entity ce= new Commande_entity(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("description"),
                rs.getInt("quantite"),
                rs.getString("date_creation"),
                rs.getDate("date_c"),
                rs.getInt("idPanier")

                );
            list.add(ce);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    
    
   @Override
    public List<Commande_entity> readAll() {
        List<Commande_entity> list = new ArrayList<>();
        String req = "SELECT * FROM commande";
        try {
            Statement pst = cnx.createStatement();
            ResultSet rs = pst.executeQuery(req);
            while(rs.next()){
                Commande_entity ce= new Commande_entity(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("description"),
                rs.getInt("quantite"),
                rs.getString("date_creation"),
                rs.getDate("date_c"),
                rs.getInt("idPanier")

                );
            list.add(ce);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Commande_entity readById(int id) {
        Commande_entity ce = new Commande_entity();
        String condition =(" id ='" + id + "'");
        String requete = "SELECT * FROM commande WHERE"+ condition +"LIMIT 1";
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            ResultSet rs = st.executeQuery(requete);
            if(rs.next()){
                ce = new Commande_entity(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("description"),
                rs.getInt("quantite"),
                rs.getString("date_creation"),
                rs.getDate("date_c"),
                rs.getInt("idPanier")

                );
            }
        } catch (SQLException ex) {
            System.out.println("Error ReadyBy=\n" +ex);
        }
        return ce;   
    }

    
    public List<Commande_entity> Search(String t) {

        List<Commande_entity> list1 = new ArrayList<>();
        List<Commande_entity> list2 = readAll();
        list1 = (list2.stream().filter(c -> c.getNom().startsWith(t)).collect(Collectors.toList()));
        
    return list1;
    }

    public List<Commande_entity> triNom() {

        List<Commande_entity> list1 = new ArrayList<>();
        List<Commande_entity> list2 = readAll();

        list1 = list2.stream().sorted((o1, o2) -> o1.getNom().compareTo(o2.getNom())).collect(Collectors.toList());
        return list1;

    }
    public List<Commande_entity> triQuantity() {

        List<Commande_entity> list1 = new ArrayList<>();
        List<Commande_entity> list2 = readAll();

        list1 = list2.stream().sorted((q1, q2) -> Integer.compare(q1.getQuantite(), q2.getQuantite()))
             .collect(Collectors.toList());
        return list1;

    }
}
