/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ConnexionSource.DBConnexion;
import ConnexionSource.DataSource;
import controller.UserServices;
import entity.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
 
/**
 * FXML Controller class
 *
 * @author TECHNOPC
 */
public class LoginInterfaceController implements Initializable {

    @FXML
    private AnchorPane recpane;
    @FXML
    private TextField emailtf;
    @FXML
    private PasswordField pwdtf;
    private Connection cnx = null; 
    
    private PreparedStatement pst = null ;
    private ResultSet rs = null ;
     private ResultSet rsd = null ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    Connection c = DBConnexion.getInstance().getCnx();
    Stage dialogStage = new Stage();
    Scene scene;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @FXML
    private void go(ActionEvent event) throws IOException {
          AnchorPane pane = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
           recpane.getChildren().setAll(pane);
    }
    @FXML
    public void mdpoublie() throws SQLException, MessagingException{
    senemail();
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("message envoyé");
    }
    public void senemail() throws SQLException, AddressException, MessagingException{
      //String req="Select User_Email from 'membres' where User_nom='user.getText()'"; 
     // Statement st = cnx.createStatement();
         //   ResultSet rs = st.executeQuery(req);
 //String r = emailToField.getText();
 
    
            Connection cnx = DataSource.getInstance().getCnx();
 
 String req = "SELECT password FROM users where email='"+emailtf.getText()+"'";
 Statement st = cnx.createStatement();
  ResultSet rsd = st.executeQuery(req);
            rsd.next();
            String r=rsd.getString("password");
  String to = emailtf.getText();
 String from = "majd.idani@esprit.tn"; 
 final String password="majdmajd0202";
 final String username="majd.idani@esprit.tn";
 
   
 String host = "smtp.google.com";
 
       Properties props = new Properties();
         props.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        props.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        props.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        props.put("mail.smtp.port", "587");
  Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
  try {
     
            
      MimeMessage m = new MimeMessage(session);
      m.setFrom(new InternetAddress(from));
      m.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
      m.setSubject("mot de passe");
      m.setText(r);      
      
      
      Transport.send(m);
      System.out.println("message envoyé");
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("message envoyé");
      
  } catch (MessagingException e){
  e.printStackTrace();
  }
  }

     @FXML
    private void signin(ActionEvent event) throws IOException, SQLException, Exception {
                        
        
        UserServices user = new UserServices();
        String email = emailtf.getText();
        String password = pwdtf.getText();
        User u1 = user.findByMail1(emailtf.getText());
        
              
         PreparedStatement st = (PreparedStatement) c.prepareStatement("Select id,email, password from users where email=? and password=?");
   try {
                    st.setString(1, email);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                          Preferences prefs = Preferences.userNodeForPackage(getClass());

 int userId = rs.getInt("id");prefs.putInt("userId", userId);
                       // dispose();
                        //Scene ah = new Scene();
                        //ah.setTitle("Welcome");
                        JOptionPane.showMessageDialog(null, "You have successfully logged in");
                         Stage primaryStage = new Stage();
                         if(email.equals("admin@gmail.com" )&& password.equals("0000")){
                             
                             Parent root = FXMLLoader.load(getClass().getResource("/GUI/Gestion.fxml"));
               Scene scene = new Scene(root);
            
            primaryStage.setTitle("Acceuil");
            primaryStage.setScene(scene);
            primaryStage.show();
                         }
                         else{
                             
                             
        
   
      
            
            
            AnchorPane pane = FXMLLoader.load(getClass().getResource("design.fxml"));
           recpane.getChildren().setAll(pane);
                         }
               
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
    }
    
    @FXML
        private void signup(ActionEvent event) throws SQLException, IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
           recpane.getChildren().setAll(pane);
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
                  user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"), rs.getString("email"),rs.getString("password"),rs.getString("gender"),rs.getString("role"),rs.getInt("phone"),rs.getDate("birthday"));
               
                          

            }    
        }catch(Exception ex){
            ex.printStackTrace();
        }
            System.out.println(user);
    return user;
    }
}
