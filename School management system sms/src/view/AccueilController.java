package view;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class AccueilController {

    @FXML
    private Button GotoCnx;

    @FXML
    private Button accueilBtn;

    @FXML
    private AnchorPane accueilForm;

    @FXML
    void goToInscription(ActionEvent event) throws IOException{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Page De Connexion");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
            GotoCnx.getScene().getWindow().hide();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }     
    }
    


    @FXML
    void switchForm(ActionEvent event) {
        if(event.getSource()==accueilBtn){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("DataGeneral.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Accueil Form");
                stage.setResizable(false);
                accueilBtn.getScene().getWindow().hide();
            stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
    
    
    
    

}
