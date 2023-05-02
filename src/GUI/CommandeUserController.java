/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import static GUI.PanierControllerController.idPanier;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import controller.Commande_Service;
import entity.Commande_entity;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class CommandeUserController implements Initializable {
    public static int id;
    @FXML
    private TextField txtQuantite;
    @FXML
    private TextField txtNom;
    @FXML
    private Button btnAjout;
    @FXML
    private TextField txtDescription;
    @FXML
    private DatePicker txtDate;
    @FXML
    private TextField txtPanier;
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
        txtPanier.setText(Integer.toString(idPanier));
        // TODO
    }    
    @FXML
    private void ajouter(ActionEvent event) {
        
                String filePath ="";
               try {
           //insert event info  and user name from  to qrcode 
            String qrCodeData = "Event name :"+txtNom.getText()+"\n"+"User name :"+txtQuantite+"\n"+"Number of places :"+txtDescription.getText();

                    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        
        // create a random number generator
            Random random = new Random();
        
        // generate a random name
        String name = "";
        for (int i = 0; i < 4; i++) {
            char c = alphabet[random.nextInt(alphabet.length)];
            name += c;
        }



             filePath = "C:\\Users\\PC\\Documents\\NetBeansProjects\\Panier\\src\\GUI\\Images\\"+name+".jpg";
            String charset = "UTF-8"; // or "ISO-8859-1"
            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, 200, 200, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                .lastIndexOf('.') + 1), new File(filePath));
            System.out.println("QR Code image created successfully!");
        } catch (Exception e) {
            System.err.println(e);
        }
        
        
         Commande_Service ims = new Commande_Service();
     if (txtNom.getText().isEmpty() || txtDescription.getText().isEmpty() || txtQuantite.getText().isEmpty() || txtDate.getValue().toString().isEmpty() || txtPanier.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
    } else {
    // Create a new Commande_entity object using the converted Date string and other input fields
    ims.insert(new Commande_entity(txtNom.getText(), txtDescription.getText(),
        Integer.parseInt(txtQuantite.getText()), "hjh",
        Date.valueOf(txtDate.getValue()),
            PanierControllerController.idPanier));
    JOptionPane.showMessageDialog(null, "Commande ajoutée !");
     }
          
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
