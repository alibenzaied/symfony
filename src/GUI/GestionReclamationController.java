/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entity.Reclamation;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import controller.ReclamationService;
import java.util.prefs.Preferences;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class GestionReclamationController implements Initializable {
 private Label label;
    @FXML
    private Button supp;
    @FXML
    private Button Ajouter;
    @FXML
    private Label imgpathttt;
    @FXML
    private Label labelid;
    @FXML
    private TextField inputRech;
    @FXML
    private TableView<Reclamation> tableview;
    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private TableColumn<?, ?> type;
    @FXML
    private TableColumn<?, ?> etat;
    @FXML
    private TableColumn<?, ?> description;
public ObservableList<Reclamation> list;

public static int idRec;
public static Reclamation connectedReclamation;
    @FXML
    private Hyperlink response;
    @FXML
    private Button pdf2;
    @FXML
    private Button afficherpardate;
    @FXML
    private Button afficherpartype; 
    @FXML
    private Button supp1;
    @FXML
    private Button AccepterReclamation;
    @FXML
    private TableColumn<?, ?> user;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ReclamationService pss = new ReclamationService();
      
        
        ArrayList<Reclamation> c = new ArrayList<>();
  
        try {    
            c = (ArrayList<Reclamation>) pss.AfficherReclamation( );
        } catch (SQLException ex) {
        }
   
        
        ObservableList<Reclamation> obs2 = FXCollections.observableArrayList(c);
        tableview.setItems(obs2);
        
        
           
        
        
 date.setCellValueFactory(new PropertyValueFactory<>("date"));
 type.setCellValueFactory(new PropertyValueFactory<>("type"));
  etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
   description.setCellValueFactory(new PropertyValueFactory<>("iduser"));
   user.setCellValueFactory(new PropertyValueFactory<>("iduser"));

   
            try {  Preferences prefs = Preferences.userNodeForPackage(getClass());
int userId = prefs.getInt("userId", -1);
            list = FXCollections.observableArrayList(
                    pss.AfficherReclamation( )
            );        
        
        
   FilteredList<Reclamation> filteredData = new FilteredList<>(list, e -> true);
            inputRech.setOnKeyReleased(e -> {
                inputRech.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
                    filteredData.setPredicate((Predicate<? super Reclamation>) Reclamations -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lower = newValue.toLowerCase();
                        String tostring = Reclamations.getDescription();
                        if (tostring.toLowerCase().contains(lower)) {
                            return true;
                        }
                        return false;
                    });
                });
                SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(tableview.comparatorProperty());
                tableview.setItems(sortedData);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    
      public Reclamation gettempReclamation(TableColumn.CellEditEvent edittedCell) {
        Reclamation test = tableview.getSelectionModel().getSelectedItem();
        return test;
    }
  @FXML
    private void refuserReclamation(ActionEvent event) throws SQLException 
    {
        int i;
        TableColumn.CellEditEvent edittedcell = null;
        Reclamation x = gettempReclamation(edittedcell);
        if (x != null) {

            int c = x.getId();
            String etats = "Rejected";

            ReclamationService sc = new ReclamationService();

            Reclamation rec = new Reclamation(c, etats);

            i = sc.updateEtat(rec);
 resetTableData();
            if (i == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("reclamation updated");
                alert.showAndWait();
               list.clear();
              
 
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Selection un champ SVP");
            alert.showAndWait();
        }
    }
@FXML
    private void AccepterReclamation(ActionEvent event) throws SQLException 
    {
        int i;
        TableColumn.CellEditEvent edittedcell = null;
        Reclamation x = gettempReclamation(edittedcell);
        if (x != null) {

            int c = x.getId();
            String etats = "Accepted";

            ReclamationService sc = new ReclamationService();

            Reclamation rec = new Reclamation(c, etats);

            i = sc.updateEtat(rec);
 resetTableData();
            if (i == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("reclamation updated");
                alert.showAndWait();
               list.clear();
              
 
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Selection un champ SVP");
            alert.showAndWait();
        }
    }
    @FXML
    private void supp(ActionEvent event) throws SQLException {
         if (event.getSource() == supp) {
              Reclamation rec = new Reclamation();

            rec.setId(tableview.getSelectionModel().getSelectedItem().getId());
            ReclamationService cs = new ReclamationService();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Delete");
      alert.setHeaderText("Are you sure want to delete this Reclamation");
      alert.setContentText(" ");

      // option != null.
      Optional<ButtonType> option = alert.showAndWait();

      if (option.get() == null) {
       
      } else if (option.get() == ButtonType.OK) {
         
          
          cs.SupprimerReclamation(rec);
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.SLIDE;
            tray.setAnimationType(type);
            tray.setTitle("Supprimé avec succés");
            tray.setMessage("Suppriméavec succés");
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000)); 
      } else if (option.get() == ButtonType.CANCEL) {
      
      } else {
         this.label.setText("-");
      }
          
           
         
            
            
            resetTableData();

        }    
        
        
    }
  public void resetTableData() throws SQLDataException, SQLException {
        ReclamationService cs = new ReclamationService();
        List<Reclamation> listrec = new ArrayList<>();
        listrec = cs.AfficherReclamation();
        ObservableList<Reclamation> data = FXCollections.observableArrayList(listrec);
        tableview.setItems(data);
    }
    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
           Parent page1 = FXMLLoader.load(getClass().getResource("AjouterResponse.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
        GestionReclamationController.idRec = tableview.getSelectionModel().getSelectedItem().getId();
        
        Reclamation rec = new Reclamation( tableview.getSelectionModel().getSelectedItem().getId(),
                tableview.getSelectionModel().getSelectedItem().getDate(),
        tableview.getSelectionModel().getSelectedItem().getType(),
        tableview.getSelectionModel().getSelectedItem().getEtat(),
        tableview.getSelectionModel().getSelectedItem().getDescription());
        
        GestionReclamationController.connectedReclamation= rec;
        
    }

    @FXML
    private void response(ActionEvent event) throws IOException {
            Parent page1 = FXMLLoader.load(getClass().getResource("GestionResponse.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
        
    }


  private void printPDF() throws FileNotFoundException, DocumentException, IOException {
        
        Document d = new Document();
        PdfWriter.getInstance(d, new FileOutputStream("..\\ListReclamation.pdf"));
        d.open();
        
        PdfPTable pTable = new PdfPTable(4);
       

     
        
        tableview.getItems().forEach((t) -> {
       pTable.addCell(String.valueOf(t.getDate()));
         pTable.addCell(String.valueOf(t.getDescription()));
     pTable.addCell(String.valueOf(t.getType()));
         pTable.addCell(String.valueOf(t.getEtat()));


       
        });
        
                        d.add(pTable);

        d.close();
        Desktop.getDesktop().open(new File("..\\ListReclamation.pdf"));

    } 
    
    
    
    
    
    @FXML
    private void pdf2(ActionEvent event) throws FileNotFoundException, DocumentException, IOException {
         if (event.getSource() == pdf2) {
            
             printPDF();
            
   
        }
 }
  public void ResetParDate() throws SQLDataException, SQLException {
     ReclamationService cs = new ReclamationService();
        List<Reclamation> listrec = new ArrayList<>();
        listrec = cs.AfficherReclamationParDate();
        ObservableList<Reclamation> data = FXCollections.observableArrayList(listrec);
        tableview.setItems(data);
    }
    public void ResetParType() throws SQLDataException, SQLException {
     ReclamationService cs = new ReclamationService();
        List<Reclamation> listrec = new ArrayList<>();
        listrec = cs.AfficherReclamationParType();
        ObservableList<Reclamation> data = FXCollections.observableArrayList(listrec);
        tableview.setItems(data);
    }
    @FXML
    private void afficherpardate(ActionEvent event) throws SQLException {
       
        ResetParDate();
        
    }

    @FXML
    private void afficherpartype(ActionEvent event) throws SQLException {
        ResetParType();
    }

}
