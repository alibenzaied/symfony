/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import controller.Commande_Service;
import entity.Commande_entity;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class CommandeController implements Initializable {

    private Commande_entity Commande_entity;
    private int id;
    @FXML
    private TextField txtQuantite;
    @FXML
    private TextField txtNom;
    @FXML
    private TableColumn<Integer,Commande_entity> IdPanier;
    @FXML
    private Button btnAjout;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TableColumn<Integer,Commande_entity> IDCommande;
    @FXML
    private TableColumn<String,Commande_entity> NomCommande;
    @FXML
    private TableColumn<String,Commande_entity> DescriptionCommande;
    @FXML
    private TableColumn<Integer , Commande_entity> QuantiteCommande;
    @FXML
    private TableColumn<Date, Commande_entity> DateCommande;
    ObservableList<Commande_entity> obsCommande = FXCollections.observableArrayList();
    ObservableList<Commande_entity> dataList ;

    @FXML
    private TextField txtDescription;
    @FXML
    private DatePicker txtDate;
    @FXML
    private TableColumn<String,Commande_entity> DateCreation;
    @FXML
    private TableView<Commande_entity> TableCommande;
    @FXML
    private TextField txtPanier;
    @FXML
    private TextField txtrecherche;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private Button btn;
    @FXML
    private Button btnr1;
    @FXML
    private Button btn1;
    @FXML
    private Button btn11;
    @FXML
    private AnchorPane recpane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadData();
    }    

    @FXML
    private void onTableItemSelect(MouseEvent event) {
        Commande_entity = TableCommande.getSelectionModel().getSelectedItem();
        txtNom.setText(Commande_entity.getNom());
        txtQuantite.setText(String.valueOf(Commande_entity.getQuantite()).toString());
        txtDescription.setText(Commande_entity.getDescription());
        txtDate.setValue(LocalDate.parse(Commande_entity.getDate_c().toString()));
        this.id=Commande_entity.getId();
        txtPanier.setText(String.valueOf(Commande_entity.getIdPanier()));
    }


    @FXML
private void ajouter(ActionEvent event) {
    Commande_Service ims = new Commande_Service();
     if (txtNom.getText().isEmpty() || txtDescription.getText().isEmpty() || txtQuantite.getText().isEmpty() || txtDate.getValue().toString().isEmpty() || txtPanier.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
    } else {
    // Create a new Commande_entity object using the converted Date string and other input fields
    ims.insert(new Commande_entity(txtNom.getText(), txtDescription.getText(),
        Integer.parseInt(txtQuantite.getText()), "hjh",
        Date.valueOf(txtDate.getValue()),
        Integer.parseInt(txtPanier.getText())));
    JOptionPane.showMessageDialog(null, "Commande ajoutée !");
    txtNom.clear(); txtQuantite.clear(); txtDescription.clear(); txtPanier.clear();
    LoadData2();
     }
    }

    @FXML
    private void update(ActionEvent event) {
        Commande_Service ims = new Commande_Service();
        if (txtNom.getText().isEmpty() || txtDescription.getText().isEmpty() || txtQuantite.getText().isEmpty() || txtDate.getValue().toString().isEmpty() || txtPanier.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
    } else {
        Commande_entity.setNom(txtNom.getText());
        Commande_entity.setQuantite(Integer.parseInt(txtQuantite.getText()));
        Commande_entity.setDescription(txtDescription.getText());
        Commande_entity.setDate_c(Date.valueOf(txtDate.getValue()));
        Commande_entity.setIdPanier(Integer.parseInt(txtPanier.getText()));

        
        
        
ims.update(new Commande_entity(Commande_entity.getId(),txtNom.getText(), txtDescription.getText(),
        Integer.parseInt(txtQuantite.getText()), "hjh",
        Date.valueOf(txtDate.getValue()),
        Integer.parseInt(txtPanier.getText())));                
        new Alert(Alert.AlertType.INFORMATION, Commande_entity.getNom()+ " Modifier !!", ButtonType.APPLY.APPLY.CLOSE).show();
        //clearFields();
        obsCommande.set(TableCommande.getSelectionModel().getFocusedIndex(), Commande_entity);
        }
    }

    @FXML
    private void delete(ActionEvent event) {
        Commande_Service ims = new Commande_Service();
        Commande_entity sp = new Commande_entity();
        ObservableList obsCommande, Pointage;
        obsCommande = TableCommande.getItems();
        Pointage = TableCommande.getSelectionModel().getSelectedItems();
        sp = TableCommande.getSelectionModel().getSelectedItems().get(0);
        
        ims.delete(new Commande_entity(sp.getId()));
        
        Pointage.forEach(obsCommande::remove);
    }
    
     private void LoadData2() {
        Commande_Service ims = new Commande_Service();
        
        ims.readAll().stream().forEach((p) -> {
            obsCommande.add(p);
        });
        IDCommande.setCellValueFactory(new PropertyValueFactory<>("id"));
        NomCommande.setCellValueFactory(new PropertyValueFactory<>("nom"));
        DescriptionCommande.setCellValueFactory(new PropertyValueFactory<>("description"));
        QuantiteCommande.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        DateCommande.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
        DateCreation.setCellValueFactory(new PropertyValueFactory<>("date_c"));

        IdPanier.setCellValueFactory(new PropertyValueFactory<>("idPanier"));

        TableCommande.setItems(obsCommande);
        
        
    } 


    private void LoadData() {
        Commande_Service ims = new Commande_Service();
        
        ims.readAll().stream().forEach((p) -> {
            obsCommande.add(p);
        });
        IDCommande.setCellValueFactory(new PropertyValueFactory<>("id"));
        NomCommande.setCellValueFactory(new PropertyValueFactory<>("nom"));
        DescriptionCommande.setCellValueFactory(new PropertyValueFactory<>("description"));
        QuantiteCommande.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        DateCommande.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
        DateCreation.setCellValueFactory(new PropertyValueFactory<>("date_c"));

        IdPanier.setCellValueFactory(new PropertyValueFactory<>("idPanier"));
        
        combo.getItems().addAll("aucun", "Trier Selon Nom", "Trier Selon Quantity");

        
        TableCommande.setItems(obsCommande);

        txtrecherche.textProperty().addListener((obs, oldText, newText) -> {
            List<Commande_entity> ae = ims.Search(newText);
            TableCommande.getItems().setAll(ae);
            
        });
    }
    
    private void TrieNom() throws IOException {
        Commande_Service ums = new Commande_Service();
        Commande_entity Commande = new Commande_entity();
        List<Commande_entity> a = ums.triNom();
        IDCommande.setCellValueFactory(new PropertyValueFactory<>("id"));
        NomCommande.setCellValueFactory(new PropertyValueFactory<>("nom"));
        DescriptionCommande.setCellValueFactory(new PropertyValueFactory<>("description"));
        QuantiteCommande.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        DateCommande.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
        DateCreation.setCellValueFactory(new PropertyValueFactory<>("date_c"));

        IdPanier.setCellValueFactory(new PropertyValueFactory<>("idPanier"));

        TableCommande.getItems().setAll(a);

    }

    private void TrieQuantity() throws IOException {
        Commande_Service ums = new Commande_Service();
        Commande_entity Commande = new Commande_entity();
        List<Commande_entity> a = ums.triQuantity();
        IDCommande.setCellValueFactory(new PropertyValueFactory<>("id"));
        NomCommande.setCellValueFactory(new PropertyValueFactory<>("nom"));
        DescriptionCommande.setCellValueFactory(new PropertyValueFactory<>("description"));
        QuantiteCommande.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        DateCommande.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
        DateCreation.setCellValueFactory(new PropertyValueFactory<>("date_c"));

        IdPanier.setCellValueFactory(new PropertyValueFactory<>("idPanier"));

        TableCommande.getItems().setAll(a);

    }
    
    @FXML
    void triCoice(ActionEvent event) throws IOException {
        if (combo.getValue().equals("Trier Selon Nom")) {
            TrieNom();
        } else if (combo.getValue().equals("Trier Selon Quantity")) {
            TrieQuantity();
        }   
    }

    @FXML
    private void t1(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }

    @FXML
    private void rec(ActionEvent event) {
    }

    
    
    
}
