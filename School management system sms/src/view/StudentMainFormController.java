package view;

import db.AbsenceEtudiantController;
import db.DocJustifAbsEtudiantController;
import db.EtudiantController;
import db.NotesController;
import db.SeanceController;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.absenceetudiant;
import model.docjustifabsetudiant;
import model.seance;

public class StudentMainFormController implements Initializable{

    @FXML
    private TextField ABSeanceID;

    @FXML
    private DatePicker ABjustifdocDateDeb;

    @FXML
    private DatePicker ABjustifdocDateDepot;

    @FXML
    private DatePicker ABjustifdocDateFin;

    @FXML
    private TextField ABjustifdocName;

    @FXML
    private TextField ABjustifdocObservation;

    @FXML
    private TextField ABjustifdocPath;

    @FXML
    private ComboBox<?> ABjustifdocType;

    @FXML
    private Button Absence_addJustbtn;

    @FXML
    private Button Absence_importbtn;

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
    private TableColumn<?, ?> absence_HeureFin;

    @FXML
    private TableColumn<?, ?> absence_Matiere;

    @FXML
    private Button absence_clearBtn;

    @FXML
    private TableColumn<?, ?> absence_date;

    @FXML
    private TableColumn<?, ?> absence_heureDeb;

    @FXML
    private TableColumn<?, ?> absence_jour;

    @FXML
    private TableColumn<?, ?> absence_module;

    @FXML
    private TableColumn<?, ?> absence_seanceID;

    @FXML
    private TableView<seance> absence_tableView;

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
    private AnchorPane student_Abcence;

    @FXML
    private Button student_AbsenceBtn;

    @FXML
    private Button student_MarksBtn;

    @FXML
    private Label student_id;

    @FXML
    private Label subjectDATA;
    
     @FXML
    private TableColumn<?, ?> MarksMatiere;

    @FXML
    private TableColumn<?, ?> MarksNoteCC;

    @FXML
    private TableColumn<?, ?> MarksNoteExamen;

    @FXML
    private TableColumn<?, ?> MarksNoteTP;

    @FXML
    private TableView<?> MarksTableView;
    
    
    @FXML
    private AnchorPane MarksForm;
    
    SeanceController SC = new SeanceController();
    
    ArrayList<seance> seance =SC.getSessionDataByStudent(InscriptionController.autoDATA.getUser().getId_user());
    
    AbsenceEtudiantController absence = new AbsenceEtudiantController();
    
    DocJustifAbsEtudiantController docjustif = new DocJustifAbsEtudiantController();
    
    AlertMessage alert = new AlertMessage();
    
    NotesController note = new NotesController();
    
    public void switchForm(ActionEvent event){
        if(event.getSource()== studentInformation_btn){
            StudentDATA.setVisible(true);
            student_Abcence.setVisible(false);
            MarksForm.setVisible(false);
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
                System.out.println(sc.getSeancegenerique().getClasse().getClassegenerique().getNiveau().getCode()+" "+ sc.getSeancegenerique().getClasse().getClassegenerique().getFiliere().getCode());
                subjectDATA.setText( sc.getSeancegenerique().getModule().getNom()+" : "+sc.getSeancegenerique().getMatiere().getNom()+ "( "+ sc.getSeancegenerique().getJour()+ " ["+sc.getSeancegenerique().getDatedeb()+" , "+sc.getSeancegenerique().getDatefin()+"] )");
            }
        }
        if(event.getSource()==student_MarksBtn){
            MarksForm.setVisible(true);
            student_Abcence.setVisible(false);
            StudentDATA.setVisible(false);
            populateMarksTableView();
        }
        if(event.getSource()==student_AbsenceBtn){
            student_Abcence.setVisible(true);
            StudentDATA.setVisible(false);
            MarksForm.setVisible(false);
            populateTypeJustDoc();
            populateAbsence_tableView();
            enabledField(true);
            AbsenceClearBtn();
        } 
    }
    
    void populateTypeJustDoc(){
        ObservableList typesDocuments = FXCollections.observableArrayList(
                "Certificat médical",
                "Attestation de décès",
                "Convocation officielle",
                "Certificat de participation à un événement",
                "Justificatif de transport",
                "Lettre d'excuse des parents",
                "Attestation de travail"
        );
        ABjustifdocType.setItems(typesDocuments);
    }
    
    void enabledField(boolean bool){
        ABjustifdocName.setDisable(bool);
        ABjustifdocDateDepot.setDisable(bool);
        ABjustifdocDateDeb.setDisable(bool);
        ABjustifdocDateFin.setDisable(bool);
        ABjustifdocType.setDisable(bool);
        ABjustifdocObservation.setDisable(bool);
        ABjustifdocPath.setDisable(bool);
        Absence_importbtn.setDisable(bool);
        Absence_addJustbtn.setDisable(bool);
        absence_clearBtn.setDisable(bool);
    }
    
    void populateAbsence_tableView(){
        ObservableList<seance> seance = FXCollections.observableArrayList(absence.getAllAbsenceNoJustifiedByStudent(InscriptionController.autoDATA.getUser().getId_user()));
        absence_seanceID.setCellValueFactory(new PropertyValueFactory<>("id_seance"));
        absence_Matiere.setCellValueFactory(new PropertyValueFactory<>("nomMatiere"));
        absence_module.setCellValueFactory(new PropertyValueFactory<>("nomModule"));
        absence_jour.setCellValueFactory(new PropertyValueFactory<>("jour"));
        absence_heureDeb.setCellValueFactory(new PropertyValueFactory<>("heureDeb"));
        absence_HeureFin.setCellValueFactory(new PropertyValueFactory<>("heureFin"));
        absence_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        absence_tableView.setItems(seance);
    }
    
    int getAbsenceID(int seance , int etudiant){
        return absence.getabsenceetudiantIdByseanceIdAndStudent(seance, etudiant).getId();
    }
    
    @FXML
    void AbsenceClearBtn() {
        ABjustifdocName.clear();
        ABjustifdocDateDepot.setValue(null);
        ABjustifdocDateDeb.setValue(null);
        ABjustifdocDateFin.setValue(null);
        ABjustifdocType.getSelectionModel().clearSelection();
        ABjustifdocObservation.clear();
        ABjustifdocPath.clear();
    }
    
    public boolean formValid() {
        boolean isValid = true;
        if (ABjustifdocName.getText().isEmpty() ||
            ABjustifdocDateDepot.getValue() == null ||
            ABjustifdocDateDeb.getValue() == null ||
            ABjustifdocDateFin.getValue() == null ||
            ABjustifdocType.getSelectionModel().isEmpty() ||
            ABjustifdocObservation.getText().isEmpty() ||
            ABjustifdocDateFin.getValue().isAfter(ABjustifdocDateDeb.getValue()) ||
            ABjustifdocPath.getText().isEmpty()) {
            isValid = false;
        }
        return isValid;
    }


    @FXML
    void AbsenceSelectitem(MouseEvent event) {
        seance SelectedSeance= absence_tableView.getSelectionModel().getSelectedItem();
        if(SelectedSeance!=null){
            ABSeanceID.setText(String.valueOf(SelectedSeance.getId_seance()));
            enabledField(false);
        }
        else{
            enabledField(true);
        }
    }

    @FXML
    void AbsenceaddJustbtn(ActionEvent event) {
        int id_seance = Integer.parseInt(ABSeanceID.getText());
        String Nom=ABjustifdocName.getText();
        Date dateDepot = Date.valueOf(ABjustifdocDateDepot.getValue());
        Date dateDebut =Date.valueOf(ABjustifdocDateDeb.getValue());
        Date dateFin = Date.valueOf(ABjustifdocDateFin.getValue());
        String Type = ABjustifdocType.getSelectionModel().getSelectedItem().toString();
        String observation = ABjustifdocObservation.getText();
        String path = ABjustifdocPath.getText();
        int id_absence= getAbsenceID(id_seance, InscriptionController.autoDATA.getUser().getId_user());
        if(formValid()){
            alert.errorMessage("la formulaire invalide");
            return;
        }
        try {
            int id_doc= docjustif.insert(new docjustifabsetudiant( Nom, dateDepot, dateDebut, dateFin, path, Type, dateDepot, observation));
            absence.update(new absenceetudiant(id_absence, null, null, true, " ", new docjustifabsetudiant(id_doc)));
            alert.successMessage("vous etes ajoutee le document justificatif avec succes");
            populateAbsence_tableView();
            enabledField(true);
            AbsenceClearBtn();
            
        } catch (Exception e) {
            e.printStackTrace();
            alert.errorMessage("error");
        }
    }

    @FXML
    void Absenceimportbtn(ActionEvent event) {
        FileChooser open = new FileChooser();
            open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Open File", "*.jpg", "*.jpeg", "*.png" , "*.pdf"));

            File file = open.showOpenDialog(Absence_importbtn.getScene().getWindow());

            if (file != null) {
                ABjustifdocPath.setText(file.getAbsolutePath());
            }

    }

    void populateMarksTableView(){
        ObservableList items = note.getMarksForEachStudent(InscriptionController.autoDATA.getUser().getId_user());
        MarksMatiere.setCellValueFactory(new PropertyValueFactory<>("matiere"));
        MarksNoteCC.setCellValueFactory(new PropertyValueFactory<>("noteCC"));
        MarksNoteTP.setCellValueFactory(new PropertyValueFactory<>("noteTP"));
        MarksNoteExamen.setCellValueFactory(new PropertyValueFactory<>("noteExamen"));
        MarksTableView.setItems(items);
    }
    
    @FXML
    void Logout(ActionEvent event) {
        if(alert.confirmMessage("Vous Voulez Déconnecté(e) !!")){
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            try {
                // Load the inscriptionForm.fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Inscription.fxml"));
                Parent root = loader.load();

                // Hide the current stage
                stage.hide();

                // Create a new stage for the inscription form
                Stage newStage = new Stage();
                newStage.setScene(new Scene(root));
                newStage.setTitle("Inscription Form");
                newStage.setResizable(false);
                newStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            StudentDATA.setVisible(true);
            student_Abcence.setVisible(false);
            MarksForm.setVisible(false);
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
            Classe.setText(sc.getSeancegenerique().getClasse().getClassegenerique().getNiveau().getCode()+" "+ sc.getSeancegenerique().getClasse().getClassegenerique().getFiliere().getCode()+" "+sc.getSeancegenerique().getClasse().getClassegenerique().getCycle().getCode());
            subjectDATA.setText( sc.getSeancegenerique().getModule().getNom()+" : "+sc.getSeancegenerique().getMatiere().getNom()+ "( "+ sc.getSeancegenerique().getJour()+ " ["+sc.getSeancegenerique().getDatedeb()+" , "+sc.getSeancegenerique().getDatefin()+"] )");
                //System.out.println( sc.getSeancegenerique().getModule().getNom()+" : "+sc.getSeancegenerique().getMatiere().getNom()+ "( "+ sc.getSeancegenerique().getJour()+ " ["+sc.getSeancegenerique().getDatedeb()+" , "+sc.getSeancegenerique().getDatefin()+"] )");
            
            }
    }   

}
