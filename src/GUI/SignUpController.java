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
import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javax.swing.JOptionPane;
 
import org.controlsfx.control.Notifications;
 

/**
 * FXML Controller class
 *
 * @author TECHNOPC
 */
public class SignUpController implements Initializable {

    @FXML
    private AnchorPane recpane;
    @FXML
    private TextField tfname;
    @FXML
    private TextField tflastname;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfphone;
    @FXML
    private PasswordField tfpwd;
    @FXML
    private PasswordField tfpwd1;
    @FXML
    private ComboBox<String> tfgender;
    @FXML
    private DatePicker dater;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tfgender.setPromptText("Chosir l'heure");
        tfgender.getItems().addAll("male","female");
    }
    
    
   @FXML
    private void signup(ActionEvent event) throws SQLException, IOException {
          System.out.println("press");
          
       UserServices ms = new UserServices();
        int x = tfpwd.getText().compareTo(tfpwd1.getText());
   if ( tfpwd.getText().equals(tfpwd1.getText()))       {
       String date = dater.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      String c =(String) tfgender.getValue();
        ms.AddUser(new User(tfname.getText(),tflastname.getText(),tfemail.getText(),tfpwd.getText(),c,"user",Integer.parseInt(tfphone.getText()),Date.valueOf(date)));
       JOptionPane.showMessageDialog(null, "User has been Created");
            
               
     }     
   
      else {
      
    JOptionPane.showMessageDialog(null, "Verify password");
       System.out.println(tfpwd.getText());
       System.out.println(tfpwd1.getText());
   }
          
    }
    
    
}
