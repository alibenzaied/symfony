/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class GestionController implements Initializable {

    @FXML
    private Hyperlink f;
    @FXML
    private Hyperlink b;
    @FXML
    private Hyperlink f1;
    @FXML
    private Hyperlink f2;
    @FXML
    private AnchorPane recl;
    @FXML
    private Hyperlink f11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void b(ActionEvent event) throws IOException {
           AnchorPane pane = FXMLLoader.load(getClass().getResource("GestionReclamation.fxml"));
           recl.getChildren().setAll(pane);
        
    }

    @FXML
    private void f(ActionEvent event) throws IOException {
           AnchorPane pane = FXMLLoader.load(getClass().getResource("ProductsFXML.fxml"));
           recl.getChildren().setAll(pane);
    }

    @FXML
    private void c(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("CategoriesFXML.fxml"));
           recl.getChildren().setAll(pane);
    }

    @FXML
    private void u(ActionEvent event) throws IOException {
           AnchorPane pane = FXMLLoader.load(getClass().getResource("AdminHomeInterface.fxml"));
           recl.getChildren().setAll(pane);
    }

    @FXML
    private void co(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("Commande.fxml"));
           recl.getChildren().setAll(pane);
    }
    
}
