/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Reclamation;
import entity.Response;
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
public class ResponseService implements IResponseService {
       Connection connexion;   
  public ResponseService() {
        connexion = MyDB.getInstance().getConnection();
    }
  
    
@Override
  public void ajouterResponse(Response e) throws SQLException {
        String req = "INSERT INTO `response` (`reclamation_id`,`description`) "
                + "VALUES (?,?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1, e.getReclamation_id());
        ps.setString(2, e.getDesciption());
    
        ps.executeUpdate();
    }
@Override
     public List<Response> AfficherResponse() throws SQLException {
        List<Response> Responses = new ArrayList<>();
        String req = "select * from response ";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            Response e = new Response(rst.getInt("id")
                    , rst.getInt("reclamation_id")
                    , rst.getString("description")
            
            );
            Responses.add(e);
        }
        return Responses;
    }

@Override
     public void SupprimerResponse(Response e)  throws SQLException {
        String req = "DELETE FROM response WHERE id =?";
        try {
            PreparedStatement ps = connexion.prepareStatement(req);
            ps.setInt(1, e.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }
     @Override
      public void modifierResponse(Response e) throws SQLException, NoSuchAlgorithmException {
        String req = "UPDATE response SET "
                + " reclamation_id='"+  e.getReclamation_id()+"'"
             
                + ", description='"+  e.getDesciption()+"' where id  = "+e.getId()+"";
        Statement stm = connexion.createStatement();
        stm.executeUpdate(req);
    } 
      
}
