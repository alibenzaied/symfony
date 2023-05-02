/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controller.CategoryService;
import controller.ProductService;
import entity.Product;
import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage; 
import javafx.scene.control.Alert.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.mail.*;
import javax.mail.internet.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author weixin
 */
public class ProductFXMLController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private TextField subtitleTextField;
    @FXML
    private TextField prixTextField;
    private TextField imageTextField;
    @FXML
    private Button submitButton;

    String name, description, subtitle, image;
    int category;
    double prix;

    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();
    int idProduct = productService.idProduct;
    boolean selected = productService.selected;
    @FXML
    private ComboBox<String> categoryComboBox;
    @FXML
    private Button tfphoto;
    @FXML
    private AnchorPane images;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if (selected) {
            Product product = productService.findById(idProduct);
            nameTextField.setText(product.getName());
            descriptionTextField.setText(product.getDescription());
            subtitleTextField.setText(product.getSubtitle());
            tfphoto.setText(product.getImage());
            //  categoryTextField.setText("" + product.getIdCategory());
            prixTextField.setText("" + product.getPrix());
        } //else {
            categoryComboBox.setItems(categoryService.showAllCategory());
   //     }
        submitButton.setOnAction((ActionEvent event) -> {
            name = nameTextField.getText();
            description = descriptionTextField.getText();
            subtitle = subtitleTextField.getText();
            image = tfphoto.getText();
            category = categoryService.findByName(categoryComboBox.getValue());
            prix = Double.parseDouble(prixTextField.getText());
            Product product = new Product(name, image, subtitle, description, prix, category);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            if (!selected) {
                productService.addProduct(product);
sendMail();
                alert.setTitle("Product added");
                alert.setHeaderText(null);
                alert.setContentText("Ypur product has been successfully added!");

            } else {
                productService.updateProduct(idProduct, product);
                productService.selected = false;
                alert.setTitle("Product updated");
                alert.setHeaderText(null);
                alert.setContentText("Your product has been successfully updated!");
            }
            alert.showAndWait();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        });

    }

    private void sendMail() {
        // Set the SMTP host and port for sending the email
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "arco.sc0156@gmail.com";
        String password = "hghseksuroiqviag";

        // Set the properties for the email session
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true"); // Enable authentication
        properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS encryption

        // Create a new email session using the specified properties
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a new email message
            Message msg = new MimeMessage(session);

            // Set the "From" address for the email
            // msg.setFrom(new InternetAddress("ahmed.benabid2503@gmail.com"));
            // Add the "To" address for the email (including the recipient's name)
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ons.ajmi@esprit.tn"));

            // Set the subject and body text for the email
            msg.setSubject("Nouveau produit ajouté.");
            msg.setText("consulter notre nouveau produit le plûtot possible!");
            // Create an alert to notify the user that the email was sent successfully


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation d'envoie");
            alert.setHeaderText("Voulez-vous envoyez ce mail à ");
            alert.setContentText("Cette action est requise.");

            // Show the confirmation dialog and wait for the user's response
            Optional<ButtonType> result = alert.showAndWait();

            // Send the email
            if (result.get() == ButtonType.OK) {



                Transport.send(msg);
                System.out.println("Email envoyé");


            } else {
                // Close the dialog and do nothing
                alert.close();

            }

            // Print a message to the console to indicate that the email was sent successfully
        } catch (AddressException e) {
            // Create an alert to notify the user that there was an error with the email address
            e.printStackTrace();
            System.out.println("Failed to send email: " + e.getMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }

    @FXML
    private void uploadphoto(ActionEvent event) {
        FileChooser F = new FileChooser();
        F.setTitle("Choisir une image");
        F.getExtensionFilters().addAll();
        File f = F.showOpenDialog(images.getScene().getWindow());
        if(f != null){
            tfphoto.setText(f.toString());
        }
    }

}
