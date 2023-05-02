/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import controller.Panier_Service;
import entity.Panier_entity;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class PanierControllerController implements Initializable {
    
    private Panier_entity Panier_entity;
    public static int idPanier;
    @FXML
    private TextField txtQuantite;
    @FXML
    private TextField txtNom;
    @FXML
    private TableView<Panier_entity> TablePanier;
    @FXML
    private TableColumn<Integer, Panier_entity> IdPanier;
    @FXML
    private TableColumn<String, Panier_entity> NomPanier;
    @FXML
    private TableColumn<Integer, Panier_entity> QuantitePanier;
    ObservableList<Panier_entity> obsPanier = FXCollections.observableArrayList();
    
    @FXML
    private Button btnAjout;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField txtrecherche;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private Button btnCommande;
    TextField nameLabel;
    @FXML
    private TextField txtid;
    @FXML
    private Button btnImprimer;
    @FXML
    private AnchorPane Capture; 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Preferences prefs = Preferences.userNodeForPackage(getClass());
int userId = prefs.getInt("userId", -1);
         LoadData(userId);  
         System.out.print(userId);
         
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        Panier_Service ims = new Panier_Service();
        //controlle saisie
        if (txtNom.getText().isEmpty() || txtQuantite.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
        } else {
              Preferences prefs = Preferences.userNodeForPackage(getClass());
int userId = prefs.getInt("userId", -1);
        ims.insert(new Panier_entity(txtNom.getText(),Integer.parseInt(txtQuantite.getText()), userId));
                JOptionPane.showMessageDialog(null, "Sponsors ajoutée !");
txtNom.clear();txtQuantite.clear();
LoadData2(); 
        }
    }


    
    @FXML
    private void update(ActionEvent event) {
        Panier_Service ims = new Panier_Service();
           if (txtNom.getText().isEmpty() || txtQuantite.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
        } else {
        Panier_entity.setNom(txtNom.getText());
        Panier_entity.setQuantite(Integer.parseInt(txtQuantite.getText()));
        
        ims.update(new Panier_entity(Panier_entity.getId(),txtNom.getText(),Integer.parseInt(txtQuantite.getText())));
        
                
        new Alert(Alert.AlertType.INFORMATION, Panier_entity.getNom()+ " Modifier !!", ButtonType.APPLY.APPLY.CLOSE).show();
        //clearFields();
        obsPanier.set(TablePanier.getSelectionModel().getFocusedIndex(), Panier_entity);
           }
    }
    
     private void LoadData2() {
        Panier_Service ims = new Panier_Service();
        
        ims.readAll2(4).stream().forEach((p) -> {
            obsPanier.add(p);
        });
        IdPanier.setCellValueFactory(new PropertyValueFactory<>("id"));
        NomPanier.setCellValueFactory(new PropertyValueFactory<>("nom"));
        QuantitePanier.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        TablePanier.setItems(obsPanier);
        
        
    } 

    @FXML
    private void delete(ActionEvent event) {
        Panier_Service ims = new Panier_Service();
        Panier_entity sp = new Panier_entity();
        ObservableList obsPanier, Pointage;
        obsPanier = TablePanier.getItems();
        Pointage = TablePanier.getSelectionModel().getSelectedItems();
        sp = TablePanier.getSelectionModel().getSelectedItems().get(0);
        
        ims.delete(new Panier_entity(sp.getId()));
        
        Pointage.forEach(obsPanier::remove);
    }
    
    
    private void LoadData(int id) {
        Panier_Service ims = new Panier_Service();
        
        
        ims.readAll2(id).stream().forEach((p) -> {
            obsPanier.add(p);
        });
        IdPanier.setCellValueFactory(new PropertyValueFactory<>("id"));
        NomPanier.setCellValueFactory(new PropertyValueFactory<>("nom"));
        QuantitePanier.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        
        combo.getItems().addAll("aucun", "Trier Selon Nom", "Trier Selon Quantity");

        TablePanier.setItems(obsPanier);

        txtrecherche.textProperty().addListener((obs, oldText, newText) -> {
            List<Panier_entity> ae = ims.Search(newText);
            TablePanier.getItems().setAll(ae);    
        
    
                
});
}
    
    

    @FXML
    private void onTableItemSelect(MouseEvent event) {
        
        Panier_entity = TablePanier.getSelectionModel().getSelectedItem();
        txtid.setText(String.valueOf(Panier_entity.getId()).toString());        
        txtNom.setText(Panier_entity.getNom());
        txtQuantite.setText(String.valueOf(Panier_entity.getQuantite()).toString());
        this.idPanier=Panier_entity.getId();
    }
 private void TrieNom() throws IOException {
        Panier_Service ums = new Panier_Service();
        Panier_entity Panier = new Panier_entity();
          Preferences prefs = Preferences.userNodeForPackage(getClass());
int userId = prefs.getInt("userId", -1);
        List<Panier_entity> a = ums.triNom(userId);
        IdPanier.setCellValueFactory(new PropertyValueFactory<>("id"));
        NomPanier.setCellValueFactory(new PropertyValueFactory<>("nom"));
        QuantitePanier.setCellValueFactory(new PropertyValueFactory<>("quantite"));

        TablePanier.getItems().setAll(a);

    }

    private void TrieQuantity() throws IOException {
        Panier_Service ums = new Panier_Service();
        Panier_entity Panier = new Panier_entity();
        List<Panier_entity> a = ums.triQuantity();
        IdPanier.setCellValueFactory(new PropertyValueFactory<>("id"));
        NomPanier.setCellValueFactory(new PropertyValueFactory<>("nom"));
        QuantitePanier.setCellValueFactory(new PropertyValueFactory<>("quantite"));

        TablePanier.getItems().setAll(a);

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
    private void commander(ActionEvent event) {
        
               FXMLLoader loader = new FXMLLoader(getClass().getResource("CommandeUSer.fxml"));
        try {
           Parent root = loader.load();
            CommandeUserController ac = loader.getController();
            //ac.setL_nom(nom);
            //ac.setL_prenom(prenom);

            
            //ac.setProduitID(ps.afficher().toString());
            txtid.getScene().setRoot(root); 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
      
    }

    @FXML
    private void Imprimer(ActionEvent event) {
      PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
             Window primaryStage = null;
             job.showPrintDialog(primaryStage); 
            
             Node root=this.Capture
;   
              job.printPage(root);
              
              job.endJob(); 

    
        
    }
    }
}
