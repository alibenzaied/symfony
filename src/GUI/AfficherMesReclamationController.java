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
import java.security.NoSuchAlgorithmException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
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
public class AfficherMesReclamationController implements Initializable {
 private Label label;
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
  
    @FXML
    private Hyperlink recl;
public ObservableList<Reclamation> list;
    
    @FXML
    private ComboBox<String> type1;
    @FXML
    private Button Modifier;
    @FXML
    private Button Confirmer;
    @FXML
    private Label ll;
    @FXML
    private TextField description1;
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
          ReclamationService pss = new ReclamationService();
      type1.getItems().addAll("Publication", "User","Application");  
        
        ArrayList<Reclamation> c = new ArrayList<>();
  
        try {
            Preferences prefs = Preferences.userNodeForPackage(getClass());
int userId = prefs.getInt("userId", -1);
            c = (ArrayList<Reclamation>) pss.AfficherReclamation(userId);
        } catch (SQLException ex) {
        }
   
        
        ObservableList<Reclamation> obs2 = FXCollections.observableArrayList(c);
        tableview.setItems(obs2);
        
        
           
        
        
 date.setCellValueFactory(new PropertyValueFactory<>("date"));
 type.setCellValueFactory(new PropertyValueFactory<>("type"));
  etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
   description.setCellValueFactory(new PropertyValueFactory<>("description"));

   
            try {
                 Preferences prefs = Preferences.userNodeForPackage(getClass());
int userId = prefs.getInt("userId", -1);
            list = FXCollections.observableArrayList(
                    pss.AfficherReclamation(userId)
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

    @FXML
    private void recl(ActionEvent event) throws IOException {
            Parent page1 = FXMLLoader.load(getClass().getResource("EnvoyerReclamation.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void Modifier(ActionEvent event) {
       Confirmer.setVisible(true);
       type1.setValue(tableview.getSelectionModel().getSelectedItem().getType());
       description1.setText(tableview.getSelectionModel().getSelectedItem().getDescription());
        ll.setText(Integer.toString(tableview.getSelectionModel().getSelectedItem().getId()));
        
    }
  public void resetTableData() throws SQLDataException, SQLException {
        ReclamationService cs = new ReclamationService();
        List<Reclamation> listrec = new ArrayList<>();
         Preferences prefs = Preferences.userNodeForPackage(getClass());
int userId = prefs.getInt("userId", -1);
        listrec = cs.AfficherReclamation(userId);
        ObservableList<Reclamation> data = FXCollections.observableArrayList(listrec);
        tableview.setItems(data);
    }
    @FXML
    private void Confirmer(ActionEvent event) throws SQLException, NoSuchAlgorithmException {
             ReclamationService service = new ReclamationService();
        if (description.getText().equals("")   ) {
             
               
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Veuillez saisir tous les champs ");
            a.setHeaderText(null);
            a.showAndWait();
        } 
     

        else {

  Date date = new Date(System.currentTimeMillis());
            java.sql.Date d = new java.sql.Date(date.getTime());          
            Reclamation r = new Reclamation(Integer.parseInt(ll.getText()),d,type1.getValue(),"non traité",description1.getText());

   Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Confirmer ");
      alert.setHeaderText("Confirmer");
      alert.setContentText(" ");
      
         Optional<ButtonType> option = alert.showAndWait();

      if (option.get() == null) {
       
      } else if (option.get() == ButtonType.OK) {
                 service.modifierReclamation(r);
         TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.SLIDE;
            tray.setAnimationType(type);
            tray.setTitle("Modifié avec succés");
            tray.setMessage("Modifié avec succés");
            tray.setNotificationType(NotificationType.NOTICE);
            tray.showAndDismiss(Duration.millis(3000));
 resetTableData();
          
      
      } else if (option.get() == ButtonType.CANCEL) {
      
      } else {
         this.label.setText("-");
      }
      

          

        }; 
        
               
   
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
