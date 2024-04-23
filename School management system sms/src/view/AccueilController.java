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
    private AnchorPane accueilForm;

    @FXML
    private AnchorPane inscrirForm;

    @FXML
    void goToInscription(ActionEvent event) throws IOException{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
        Stage stage = new Stage();
        //stage.setTitle("University Management System | Student Portal");
        stage.setScene(new Scene(root));
        stage.show();
        GotoCnx.getScene().getWindow().hide();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }     
    }
    
    

}
