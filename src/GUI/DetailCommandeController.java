/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import ConnexionSource.ConnexionSource;
import static GUI.CommandeUserController.id;
import controller.Commande_Service;
import entity.Commande_entity;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class DetailCommandeController implements Initializable {
        Connection cnx = ConnexionSource.getInstance().getCnx();

    @FXML
    private AnchorPane root;
    @FXML
    private Text titreev;
    @FXML
    private Text lieuev;
    @FXML
    private Text dtdbev;
    @FXML
    private Text datefev;
    @FXML
    private Text nbrplev;
    @FXML
    private ImageView imgev;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 public void loadData() throws SQLException {

        String requete = "SELECT * FROM commande c,panier p WHERE c.idPanier=p.id ORDER BY c.id DESC LIMIT 1";

            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //(int id, String titleEvent, LocalDate dateEvent, String locationEvent, LocalDate dateReservation, int nbrPlace, String nomUser, String prenomUser)
                Commande_entity r;
            r = new Commande_entity(rs.getInt("id"),rs.getString("nom"),rs.getString("description"),rs.getInt("quantity"),rs.getString("date_creation"),
                    rs.getDate("date_c"),
                    rs.getInt("idPanier"));
                    
             
                titreev.setText(r.getNom());
                lieuev.setText(r.getDescription());
                dtdbev.setText(r.getDate_c().toString());
                datefev.setText(r.getDate_creation().toString());
                nbrplev.setText(String.valueOf(r.getQuantite()));
            
        }
 }
    
    @FXML
    private void Reserver(ActionEvent event) {
    }
    
}
