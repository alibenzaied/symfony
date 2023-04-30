/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import models.User;
import service.UserServices;
import util.DBConnexion;

/**
 * FXML Controller class
 *
 * @author TECHNOPC
 */
public class AddOwnerController implements Initializable {

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
    private ComboBox<?> tfgender;
    @FXML
    private DatePicker dater;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

       @FXML
    private void signup(ActionEvent event) throws SQLException {
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
     private User getIdOfUser(String email) {
        System.out.println(email);
   User user = null;
    Connection conn = DBConnexion.getInstance().getCnx();
    String query ="select * from users where email ='"+email+"'";
    Statement st;
    ResultSet rs;
            try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            System.out.print(rs);
            
            while(rs.next()){
                  user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"), rs.getString("email"),rs.getString("password"),rs.getString("gender"),rs.getString("photo"),rs.getInt("phone"),rs.getDate("birthday"));
               
                          

            }    
        }catch(Exception ex){
            ex.printStackTrace();
        }
            System.out.println(user);
    return user;
    }
    
    
}
