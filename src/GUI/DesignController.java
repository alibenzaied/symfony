/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controller.UserServices;
import entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author TECHNOPC
 */
public class DesignController implements Initializable {

    @FXML
    private AnchorPane rec;
    @FXML
    private Button btn;
    @FXML
    private Button btnr1;
    @FXML
    private AnchorPane recpane;
    @FXML
    private Button btn1;
    @FXML
    private Button btn11;
    @FXML
    private Button btn111;
    @FXML
    private Button btn1111;
    @FXML
    private TextField tfname;
    @FXML
    private TextField tflastname;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfphone;
    @FXML
    private ComboBox<?> tfgender;
    @FXML
    private DatePicker dater;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          loaddata() ;
            }    
    public void loaddata(){
       
    }

   @FXML
    private void t1(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("PanierController.fxml"));
           recpane.getChildren().setAll(pane);
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("LoginInterface.fxml"));
           rec.getChildren().setAll(pane);
    }

    @FXML
    private void rec(ActionEvent event) throws IOException {
           AnchorPane pane = FXMLLoader.load(getClass().getResource("EnvoyerReclamation.fxml"));
           rec.getChildren().setAll(pane);
    }

    @FXML
    private void prod(ActionEvent event) {
    }

    @FXML
    private void cat(ActionEvent event) {
    }

    

    @FXML
    private void prof(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("Profile.fxml"));
           rec.getChildren().setAll(pane);
    }

    @FXML
    private void signup(ActionEvent event) {
    }
    
}
