/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import ConnexionSource.DBConnexion;
import controller.UserServices;
import entity.User;
import java.io.IOException;
 
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;

import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author TECHNOPC
 */
public class AdminHomeInterfaceController implements Initializable {

    @FXML
    private AnchorPane recpane;
    @FXML
    private TableView<User> tableviewusers;
    @FXML
    private TableColumn<User, Integer> colid;
    @FXML
    private TableColumn<User, String> colname;
    @FXML
    private TableColumn<User, String> collastname;
    @FXML
    private TableColumn<User, String> colemail;
    @FXML
    private TableColumn<User, String> colpwd;
    @FXML
    private TableColumn<User, String> colgender;
    @FXML
    private TableColumn<User, String> colrole;
    @FXML
    private TableColumn<User, Integer> colphone;
    @FXML
    private TableColumn<User, Date> colbirthday;
    @FXML
    private TextField tfname;
    @FXML
    private TextField tflastname;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfpwd;
    @FXML
    private TextField tfgender;
    @FXML
    private TextField tfrole;
    @FXML
    private TextField tfphone;
    @FXML
    private TextField tfbirthday;
    @FXML
    private TextField tfid;
    
    private Stage primaryStage;
    @FXML
    private TextField ftNom1;
    
    ObservableList<User> list = FXCollections.observableArrayList();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Preferences prefs = Preferences.userNodeForPackage(getClass());
int userId = prefs.getInt("userId", -1);
System.out.print(userId);  
    }    
public ObservableList<User> getUsersList(){
    ObservableList<User> userlist = FXCollections.observableArrayList();
    Connection conn = DBConnexion.getInstance().getCnx();
    String query = "SELECT * FROM users";
    Statement st;
    ResultSet rs;
            try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            User users;
            while(rs.next()){
            users = new User(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"), rs.getString("email"),rs.getString("password"),rs.getString("gender"),rs.getString("role"),rs.getInt("phone"),rs.getDate("birthday"));
            userlist.add(users);
            }    
        }catch(Exception ex){
            ex.printStackTrace();
        }
    return userlist;
    }

 public void showUsers(){
        ObservableList<User> list = getUsersList();
        
        colid.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        collastname.setCellValueFactory(new PropertyValueFactory<User, String>("lastname"));
        colemail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        colpwd.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        colgender.setCellValueFactory(new PropertyValueFactory<User, String>("gender"));
        colrole.setCellValueFactory(new PropertyValueFactory<User, String>("Role"));
        colphone.setCellValueFactory(new PropertyValueFactory<User, Integer>("phone"));
        colbirthday.setCellValueFactory(new PropertyValueFactory<User, Date>("birthday"));
        if(tfid.getText()!=null){
        }

         
         tableviewusers.setItems(list);
        
        
    }
    private void executeQuery(String query) {
        Connection conn = DBConnexion.getInstance().getCnx();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void deleteuser(ActionEvent event) {
        String query = "DELETE FROM users WHERE id ='" + tfid.getText() + "'";
        executeQuery(query);
        showUsers();
      
    }
  @FXML
    private User viewUser(ActionEvent event) {
   User user = null;
    Connection conn = DBConnexion.getInstance().getCnx();
    String query = "SELECT * FROM users WHERE id =" + tfid.getText() + "";
    Statement st;
    ResultSet rs;
            try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            System.out.print(rs);
            
            while(rs.next()){
                  user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("lastname"), rs.getString("email"),rs.getString("password"),rs.getString("gender"),rs.getString("role"),rs.getInt("phone"),rs.getDate("birthday"));
                  tfname.setText(user.getName());
                  tflastname.setText(user.getLastname());
                  tfemail.setText(user.getEmail());
                  tfpwd.setText(user.getPassword());
                  tfgender.setText(user.getGender());
                  tfphone.setText(String.valueOf(user.getPhone()));
                  tfrole.setText(user.getrole());
                  tfbirthday.setText(user.getBirthday().toString());
                          

            }    
        }catch(Exception ex){
            ex.printStackTrace();
        }
    return user;
    }
    
    @FXML
    private void updateuser(ActionEvent event) {
      UserServices ms = new UserServices();
      User u = new User(tfname.getText(),tflastname.getText(),tfemail.getText(),tfpwd.getText(),tfgender.getText(),tfrole.getText(),Integer.parseInt(tfphone.getText()),Date.valueOf(tfbirthday.getText()));
      ms.UpdateUser(Integer.parseInt(tfid.getText()),u);
      JOptionPane.showMessageDialog(null, "User has been updated");
    }

    private void printusers(ActionEvent event) {
        
        System.out.println("To Printer!");
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
    Window primaryStage = null;
           job.showPrintDialog(this.primaryStage); 
            
    Node root = this.tableviewusers;
           job.printPage(root);
           job.endJob();
    }
    
}

    @FXML
    private void reserver(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("AjoutRestaurant.fxml"));
           recpane.getChildren().setAll(pane);
    }
 @FXML
    private void printuser(ActionEvent event) {
        
        System.out.println("To Printer!");
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
    Window primaryStage = null;
           job.showPrintDialog(this.primaryStage); 
            
    Node root = this.tableviewusers;
           job.printPage(root);
           job.endJob();
    }
    
}

   @FXML
     public void recherche() throws SQLException{
    UserServices re= new UserServices() ;
    List<User>results = new ArrayList<>();
    results = re.getAll();
     FilteredList<User> filteredData = new FilteredList<>(list , b -> true);
		User r = new User();
		// 2. Set the filter Predicate whenever the filter changes.
		ftNom1.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(user -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (user.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (user.getGender().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (user.getLastname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (user.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (String.valueOf(r.getEmail()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<User> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableviewusers.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableviewusers.setItems(sortedData);
               
        
    }
    
}
