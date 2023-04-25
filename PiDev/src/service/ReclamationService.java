/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import entity.Reclamation;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tools.MyDB;

/**
 *
 * @author Administrateur
 */
public class ReclamationService implements IReclamationService {
       Connection connexion;   
  public ReclamationService() {
        connexion = MyDB.getInstance().getConnection();
    }
  
    
@Override
  public void ajouterReclamation(Reclamation e) throws SQLException {
        String req = "INSERT INTO `reclamation` (`date`,`type`,`etat`,`description`) "
                + "VALUES (?,?,?,?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setDate(1,(java.sql.Date) (Date) e.getDate());
        ps.setString(2, e.getType());
        ps.setString(3, e.getEtat());
        ps.setString(4, e.getDescription()); 
        ps.executeUpdate();
    }
@Override
     public List<Reclamation> AfficherReclamation() throws SQLException {
        List<Reclamation> Reclamations = new ArrayList<>();
        String req = "select * from reclamation ";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            Reclamation e = new Reclamation(rst.getInt("id")
                    , rst.getDate("date")
                    , rst.getString("type")
                    , rst.getString("etat")
                  , rst.getString("description")
            );
            Reclamations.add(e);
        }
        return Reclamations;
    }
     public List<Reclamation> AfficherReclamationParDate() throws SQLException {
        List<Reclamation> Reclamations = new ArrayList<>();
        String req = "select * from reclamation order by date ";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            Reclamation e = new Reclamation(rst.getInt("id")
                    , rst.getDate("date")
                    , rst.getString("type")
                    , rst.getString("etat")
                  , rst.getString("description")
            );
            Reclamations.add(e);
        }
        return Reclamations;
    }
          public List<Reclamation> AfficherReclamationParType() throws SQLException {
        List<Reclamation> Reclamations = new ArrayList<>();
        String req = "select * from reclamation order by type ";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            Reclamation e = new Reclamation(rst.getInt("id")
                    , rst.getDate("date")
                    , rst.getString("type")
                    , rst.getString("etat")
                  , rst.getString("description")
            );
            Reclamations.add(e);
        }
        return Reclamations;
    }
@Override
     public void SupprimerReclamation(Reclamation e) throws SQLException {
        String req = "DELETE FROM reclamation WHERE id =?";
        try {
            PreparedStatement ps = connexion.prepareStatement(req);
            ps.setInt(1, e.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }
     @Override
      public void modifierReclamation(Reclamation e) throws SQLException, NoSuchAlgorithmException {
        String req = "UPDATE reclamation SET "
                + " date='"+ (java.sql.Date) (Date) e.getDate()+"'"
                + ", type='"+e.getType()+"'"
                + ", etat='"+e.getEtat()+"'"    
                + ", description='"+  e.getDescription()+"' where id  = "+e.getId()+"";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);
    } 
      
   
}
