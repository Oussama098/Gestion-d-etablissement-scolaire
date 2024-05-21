package view;

import db.cnxDB;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.authentification;

public class InscriptionController implements Initializable{

    @FXML
    private Button cnxBTN;

    @FXML
    private TextField login;

    @FXML
    private TextField pwd;

    AlertMessage alert = new AlertMessage();
    cnxDB cn = new cnxDB();
    static authentification autoDATA = null;
    
    
    @FXML
    void login(ActionEvent event) {
        try {
            if (login.getText().isEmpty() || pwd.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        }else{
            authentification auto=cn.UserCnx(login.getText(), pwd.getText()) ;
            autoDATA =auto;
            if(auto.getUser().getRole().equals("student")){
                
            Parent root = FXMLLoader.load(getClass().getResource("StudentMainForm.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Etudiant Form");
                stage.setResizable(false);
                stage.setScene(new Scene(root));
                stage.show();
                cnxBTN.getScene().getWindow().hide();
            }else{
                if(auto.getUser().getRole().equals("teacher")){
                    Parent root = FXMLLoader.load(getClass().getResource("TeacherMainForm.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Enseignant Form");
                    stage.setResizable(false);
                    stage.setScene(new Scene(root));
                    stage.show();
                    cnxBTN.getScene().getWindow().hide(); 
                }else{
                    if(auto.getUser().getRole().equals("admin")){
                        Parent root = FXMLLoader.load(getClass().getResource("AdminMainForm.fxml"));
                        Stage stage = new Stage();
                        stage.setTitle("administration form");
                        stage.setResizable(false);
                        stage.setScene(new Scene(root));
                        stage.show();
                        cnxBTN.getScene().getWindow().hide(); 
                    }
                }
            }
            }
    
        } catch (Exception e) {
          alert.errorMessage(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
        
    
}
