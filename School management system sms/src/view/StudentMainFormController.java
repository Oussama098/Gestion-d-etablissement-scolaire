package view;

import db.EtudiantController;
import db.SeanceController;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import model.seance;

public class StudentMainFormController implements Initializable{

    @FXML
    private Label Classe;

    @FXML
    private Label Email;

    @FXML
    private Label FullName;

    @FXML
    private AnchorPane StudentDATA;

    @FXML
    private Label Student_ID;

    @FXML
    private Label birthday;

    @FXML
    private Label birthplace;

    @FXML
    private Circle circle_image;

    @FXML
    private Button logout_btn;

    @FXML
    private Label phone;

    @FXML
    private Label sexe;

    @FXML
    private Button studentInformation_btn;

    @FXML
    private Button studentInformation_btn1;

    @FXML
    private Label student_id;

    @FXML
    private Label subjectDATA;
    
    SeanceController SC = new SeanceController();
    ArrayList<seance> seance =SC.getSessionDataByStudent(InscriptionController.autoDATA.getUser().getId_user());
    
    public void switchForm(ActionEvent event){
        
            StudentDATA.setVisible(true);
            Student_ID.setText(InscriptionController.autoDATA.getUser().getId_user()+"");
            FullName.setText(InscriptionController.autoDATA.getUser().getPrenom()+" "+ InscriptionController.autoDATA.getUser().getNom());
            birthplace.setText(InscriptionController.autoDATA.getUser().getLieuNais());
            birthday.setText(InscriptionController.autoDATA.getUser().getDateNais());
            Email.setText(InscriptionController.autoDATA.getUser().getEmail());
            phone.setText(InscriptionController.autoDATA.getUser().getTele());
            if(InscriptionController.autoDATA.getUser().getSexe().equals("M")){
                sexe.setText("Male");
            }else{
                sexe.setText("Female");
            }
            
            for (seance sc : seance) {
            Classe.setText(sc.getSeancegenerique().getClasse().getClassegenerique().getNiveau().getCode()+" "+ sc.getSeancegenerique().getClasse().getClassegenerique().getFiliere().getCode());
            subjectDATA.setText( sc.getSeancegenerique().getModule().getNom()+" : "+sc.getSeancegenerique().getMatiere().getNom()+ "( "+ sc.getSeancegenerique().getJour()+ " ["+sc.getSeancegenerique().getDatedeb()+" , "+sc.getSeancegenerique().getDatefin()+"] )");
            
            }
            
        }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        StudentDATA.setVisible(true);
            Student_ID.setText(InscriptionController.autoDATA.getUser().getId_user()+"");
            FullName.setText(InscriptionController.autoDATA.getUser().getPrenom()+" "+ InscriptionController.autoDATA.getUser().getNom());
            birthplace.setText(InscriptionController.autoDATA.getUser().getLieuNais());
            birthday.setText(InscriptionController.autoDATA.getUser().getDateNais());
            Email.setText(InscriptionController.autoDATA.getUser().getEmail());
            phone.setText(InscriptionController.autoDATA.getUser().getTele());
            if(InscriptionController.autoDATA.getUser().getSexe().equals("M")){
                sexe.setText("Male");
            }else{
                sexe.setText("Female");
            }
            
            for (seance sc : seance) {
                Classe.setText(sc.getSeancegenerique().getClasse().getId_classe()+"");
            subjectDATA.setText( sc.getSeancegenerique().getModule().getNom()+" : "+sc.getSeancegenerique().getMatiere().getNom()+ "( "+ sc.getSeancegenerique().getJour()+ " ["+sc.getSeancegenerique().getDatedeb()+" , "+sc.getSeancegenerique().getDatefin()+"] )");
            
            }
    }
    
    
    
    

}
