/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Reclamation;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface IReclamationService {
  public void ajouterReclamation(Reclamation e) throws SQLException;
  
   public List<Reclamation> AfficherReclamation() throws SQLException;
    public void SupprimerReclamation(Reclamation e) throws SQLException;
    public void modifierReclamation(Reclamation e) throws SQLException, NoSuchAlgorithmException;
}
