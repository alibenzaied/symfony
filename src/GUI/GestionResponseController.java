
package GUI;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entity.Response;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
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
import controller.ResponseService;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class GestionResponseController implements Initializable {

    @FXML
    private Button supp;
    @FXML
    private Button Modifier;
    @FXML
    private Label labelid;
    @FXML
    private TextField inputRech;
    @FXML
    private TableView<Response> tableview;
    @FXML
    private TableColumn<?, ?> reclamation_id;
    @FXML
    private Hyperlink Reclamation;
    @FXML
    private TextField resss;
    @FXML
    private Button Confirmer;
    @FXML
    private TableColumn<?, ?> description;
    
        
public ObservableList<Response> list;
 private Label label;
    @FXML
    private Button pdf2;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            ResponseService pss = new ResponseService();
      
        
        ArrayList<Response> c = new ArrayList<>();
  
        try {
            c = (ArrayList<Response>) pss.AfficherResponse();
        } catch (SQLException ex) {
        }
   
        
        ObservableList<Response> obs2 = FXCollections.observableArrayList(c);
        tableview.setItems(obs2);
        
        
           
        
        
 reclamation_id.setCellValueFactory(new PropertyValueFactory<>("reclamation_id"));
  description.setCellValueFactory(new PropertyValueFactory<>("description"));

      try {
            list = FXCollections.observableArrayList(
                    pss.AfficherResponse()
                    
            );
            for ( Response s : list){
                System.out.println(s.getDesciption());
            }
        
   FilteredList<Response> filteredData = new FilteredList<>(list, e -> true);
            inputRech.setOnKeyReleased(e -> {
                inputRech.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
                    filteredData.setPredicate((Predicate<? super Response>) Responses -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lower = newValue.toLowerCase();
                        String tostring = Responses.getDesciption();
                        if (tostring.toLowerCase().contains(lower)) {
                            return true;
                        }
                        return false;
                    });
                });
                SortedList<Response> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(tableview.comparatorProperty());
                tableview.setItems(sortedData);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

   
      
    }    
  public void resetTableData() throws SQLDataException, SQLException {
        ResponseService cs = new ResponseService();
        List<Response> listrec = new ArrayList<>();
        listrec = cs.AfficherResponse();
        ObservableList<Response> data = FXCollections.observableArrayList(listrec);
        tableview.setItems(data);
    }
    @FXML
    private void supp(ActionEvent event) throws SQLException {
         if (event.getSource() == supp) {
              Response rec = new Response();

            rec.setId(tableview.getSelectionModel().getSelectedItem().getId());
            ResponseService cs = new ResponseService();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Delete");
      alert.setHeaderText("Are you sure want to delete this Response");
      alert.setContentText(" ");

     
      Optional<ButtonType> option = alert.showAndWait();

      if (option.get() == null) {
       
      } else if (option.get() == ButtonType.OK) {
         
          
          cs.SupprimerResponse(rec);
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

    @FXML
    private void Modifier(ActionEvent event) {
        
        resss.setText( tableview.getSelectionModel().getSelectedItem().getDesciption());
        labelid.setText( Integer.toString(tableview.getSelectionModel().getSelectedItem().getId()));
        Confirmer.setVisible(true);
    }

    @FXML
    private void Reclamation(ActionEvent event) throws IOException {
           Parent page1 = FXMLLoader.load(getClass().getResource("GestionReclamation.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Confirmer(ActionEvent event) throws SQLException, IOException, NoSuchAlgorithmException {
        
        
        
     ResponseService service = new ResponseService();
        if (resss.getText().equals("")   ) {
             
               
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Veuillez saisir tous les champs ");
            a.setHeaderText(null);
            a.showAndWait();
        } 
     

        else {


        Response r = new Response(Integer.parseInt(labelid.getText()),GestionReclamationController.idRec,resss.getText());

   Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Confirmer");
      alert.setHeaderText("Confirmer");
      alert.setContentText(" ");
      
         Optional<ButtonType> option = alert.showAndWait();

      if (option.get() == null) {
       
      } else if (option.get() == ButtonType.OK) {
                 service.modifierResponse(r);
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

  private void printPDF() throws FileNotFoundException, DocumentException, IOException {
        
        Document d = new Document();
        PdfWriter.getInstance(d, new FileOutputStream("..\\ListResponse.pdf"));
        d.open();
        
        PdfPTable pTable = new PdfPTable(2);
       

     
        
        tableview.getItems().forEach((t) -> {
       pTable.addCell(String.valueOf(t.getDesciption()));
         pTable.addCell(String.valueOf(t.getReclamation_id()));



       
        });
        
                        d.add(pTable);

        d.close();
        Desktop.getDesktop().open(new File("..\\ListResponse.pdf"));

    } 
    
    
    
    
    
    @FXML
    private void pdf2(ActionEvent event) throws FileNotFoundException, DocumentException, IOException {
         if (event.getSource() == pdf2) {
            
             printPDF();
            
   
        }
 }
}
