/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Response;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface IResponseService {
    public void ajouterResponse(Response e) throws SQLException ;
       public List<Response> AfficherResponse() throws SQLException;
        public void SupprimerResponse(Response e)  throws SQLException;
        public void modifierResponse(Response e) throws SQLException, NoSuchAlgorithmException;
}
