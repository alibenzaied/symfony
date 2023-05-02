/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import controller.UserServices;
import entity.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;import java.time.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ProfileController implements Initializable {

    @FXML
    private TextField tfname;
    @FXML
    private TextField tflastname;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfphone;
    @FXML
    private ComboBox<String> tfgender;
    @FXML
    private DatePicker dater;
    @FXML
    private Button btn;
    @FXML
    private Button btnr1;
    @FXML
    private Button btn1;
    @FXML
    private Button btn11;
    @FXML
    private Button btn111;
    @FXML
    private Button btn1111;
    @FXML
    private AnchorPane rec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfgender.setPromptText("Chosir l'heure");
        tfgender.getItems().addAll("male","female");
        Preferences prefs = Preferences.userNodeForPackage(getClass());
int userId = prefs.getInt("userId", -1);
        UserServices d = new UserServices();
User u = d.findByMail(userId); 
tfname.setText(u.getName());
tfphone.setText(String.valueOf(u.getPhone()));
tfemail.setText(u.getEmail());
tfname.setText(u.getName());
tflastname.setText(u.getLastname());
tfgender.setPromptText(u.getGender());
         }    

    @FXML
    private void signup(ActionEvent event) {
          String c =(String) tfgender.getValue(); 
        User u = new User(tfname.getText(),tflastname.getText(),tfemail.getText(),c,Integer.parseInt(tfphone.getText()));
        Preferences prefs = Preferences.userNodeForPackage(getClass());
int userId = prefs.getInt("userId", -1);
        UserServices d = new UserServices();
        d.UpdateUser(userId, u);
         JOptionPane.showMessageDialog(null, "updated profile");
    }

      @FXML
    private void t1(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("PanierController.fxml"));
           rec.getChildren().setAll(pane);
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
}
