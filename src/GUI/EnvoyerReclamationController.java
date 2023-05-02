/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entity.Reclamation;
import entity.Response;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import controller.ReclamationService;
import controller.ResponseService;
import java.util.prefs.Preferences;
import javafx.scene.layout.AnchorPane;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class EnvoyerReclamationController implements Initializable {

    @FXML
    private ComboBox<String> type;
    @FXML
    private TextField description;
    @FXML
    private Button Ajouter;
  private Label label;
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
  type.getItems().addAll("Publication", "User","Application");   
    
    
    
    }    

    @FXML
    private void Ajouter(ActionEvent event) throws IOException, SQLException {
        
           ReclamationService service = new ReclamationService();
        if (description.getText().equals("")   ) {
             
               
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Veuillez saisir tous les champs ");
            a.setHeaderText(null);
            a.showAndWait();
        } 
     

        else {
 Preferences prefs = Preferences.userNodeForPackage(getClass());
int userId = prefs.getInt("userId", -1);
  Date date = new Date(System.currentTimeMillis());
            java.sql.Date d = new java.sql.Date(date.getTime());          
            Reclamation r = new Reclamation(d,type.getValue(),"non traité",description.getText(),userId);

   Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Confirmer ");
      alert.setHeaderText("Confirmer");
      alert.setContentText(" ");
      
         Optional<ButtonType> option = alert.showAndWait();

      if (option.get() == null) {
       
      } else if (option.get() == ButtonType.OK) {
                 service.ajouterReclamation(r);
                  TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.SLIDE;
            tray.setAnimationType(type);
            tray.setTitle("Envoyé avec succés");
            tray.setMessage("Envoyé avec succés");
            tray.setNotificationType(NotificationType.NOTICE);
            tray.showAndDismiss(Duration.millis(3000));

    Parent page1 = FXMLLoader.load(getClass().getResource("AfficherMesReclamation.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
          
      
      } else if (option.get() == ButtonType.CANCEL) {
      
      } else {
         this.label.setText("-");
      }
      

          

        }; 
        
    
        
        
        
    }
         public static void sendMail(String recipient,String Subject,String Text) throws MessagingException {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        String myAccountEmail = "pidevvpidevvpidevvpidevv@gmail.com";
        String password = "sjxjqsoyhoemxmkq";
        Session session = Session.getInstance(properties, new Authenticator() {
             @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(myAccountEmail, password);
            }
        });
            
        Message message = prepareMessage(session, myAccountEmail, recipient,Subject,Text);

        javax.mail.Transport.send(message);
        System.out.println("Message sent successfully");
    }  
   
    
    private static Message prepareMessage(Session session, String myAccountEmail, String recipient,String Subject,String Text) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(Subject);
            message.setText(Text);
            return message;
        } catch (MessagingException ex) {
          
        }
        return null;} 

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
