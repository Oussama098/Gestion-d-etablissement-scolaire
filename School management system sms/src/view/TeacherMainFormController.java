package view;

import db.AbsenceEtudiantController;
import db.EtudiantController;
import db.SeanceController;
import db.enseignantController;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.enseignant;
import model.*;
import model.seance;

public class TeacherMainFormController implements Initializable {

    @FXML
    private TableView<etudiant> Abcense_tableView;

    @FXML
    private TableColumn<?, ?> AbsenceStudent_ID;
    
    @FXML
    private TextField AddMarkEtudiantID;

    @FXML
    private TableColumn<?, ?> AbsenceStudent_LName;

    @FXML
    private TableColumn<?, ?> AbsenceStudent_check;

    @FXML
    private TableColumn<?, ?> AbsenceStudent_classe;

    @FXML
    private TableColumn<?, ?> AbsenceStudent_fname;

    @FXML
    private Button Absence_btn;

    @FXML
    private AnchorPane Absence_form;

    @FXML
    private TextField AddMarkNoteCC;

    @FXML
    private TextField AddMarkNoteExamen;

    @FXML
    private TextField AddMarkNoteTP;

    @FXML
    private AnchorPane AddMarksForm;

    @FXML
    private Label ClassesData;

    @FXML
    private AnchorPane Classes_Form;

    @FXML
    private Button Classes_btn;

    @FXML
    private Label Email;

    @FXML
    private Label FullName;

    @FXML
    private TableColumn<note, ?> MarkEtudiantExamen;

    @FXML
    private TableColumn<etudiant, ?> MarkEtudiantID;

    @FXML
    private TableColumn<etudiant, ?> MarkEtudiantNomComplet;

    @FXML
    private TableColumn<note, ?> MarkEtudiantNoteCC;

    @FXML
    private TableColumn<note, ?> MarkEtudiantNoteTP;
    
    @FXML
    private TableColumn<etudiant, ?> MarkEtudiantClasse;

    @FXML
    private Button MarksBtn;

    @FXML
    private TableView<etudiant> MarksTableView;

    @FXML
    private TableColumn<?, ?> Students_col_BirthPlace;

    @FXML
    private TableColumn<?, ?> Students_col_Birthday;

    @FXML
    private TableColumn<?, ?> Students_col_Lname;

    @FXML
    private ComboBox<?> MarksClasses;
    
    @FXML
    private TableColumn<?, ?> Students_col_email;

    @FXML
    private TableColumn<?, ?> Students_col_filiere;

    @FXML
    private TableColumn<?, ?> Students_col_fname;

    @FXML
    private TableColumn<?, ?> Students_col_gender;

    @FXML
    private TableColumn<?, ?> Students_col_phone;

    @FXML
    private TableColumn<?, ?> Students_col_studentID;

    @FXML
    private TableView<?> Students_tableView;

    @FXML
    private AnchorPane TeacherDATA;

    @FXML
    private Label TeacherID;

    @FXML
    private Button TshDataBTN;

    @FXML
    private ComboBox<?> absenceClasses;

    @FXML
    private Button absence_addBtn;

    @FXML
    private Label birthday;

    @FXML
    private Label birthplace;

    @FXML
    private Circle circle_image;

    @FXML
    private Button clearBtn;

    @FXML
    private Button clearBtn1;

    @FXML
    private ComboBox<?> comboSeanceByClass;

    @FXML
    private Label current_form;

    @FXML
    private Label greet_name;

    @FXML
    private Button logout_btn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Label phone;

    @FXML
    private ComboBox<?> populateClasses;

    @FXML
    private Label sexe;

    
    private enseignantController tsh = new enseignantController();
    
    private SeanceController sc = new SeanceController();
    
    private enseignant teacher = tsh.getTeacherById(InscriptionController.autoDATA.getUser().getId_user());
    
    private ArrayList<seance> seance = sc.getSessionByTeacher(InscriptionController.autoDATA.getUser().getId_user());

    private AlertMessage alert = new AlertMessage();
    
    private EtudiantController etd = new EtudiantController();
    
    private AbsenceEtudiantController absence = new AbsenceEtudiantController();
    
    @FXML
    void ClearBtn(ActionEvent event) {
        if (event.getSource() == clearBtn ){
            populateClasses.getSelectionModel().clearSelection();
            populateClasses.setPromptText("Choose...");
        }
    }


    @FXML
    void switchForm(ActionEvent event) {
        if (event.getSource() == TshDataBTN ){
            TeacherDATA.setVisible(true);
            Classes_Form.setVisible(false);
            Absence_form.setVisible(false);
            AddMarksForm.setVisible(false);
            TeacherID.setText(teacher.getUser().getId_user()+"");
            FullName.setText(teacher.getUser().getNom() + " "+ teacher.getUser().getPrenom());
            Email.setText(teacher.getUser().getEmail());
            birthday.setText(teacher.getUser().getDateNais());
            birthplace.setText(teacher.getUser().getLieuNais());
            phone.setText(teacher.getUser().getTele());
            if(teacher.getUser().getSexe().equals("M")){
                sexe.setText("Male");
            }else{
                sexe.setText("Female");
            }
            for (seance ob : seance) {
                ClassesData.setText(ob.getSeancegenerique().getClasse().getClassegenerique().getCycle().getCode()+" "+ob.getSeancegenerique().getClasse().getClassegenerique().getNiveau().getCode()+" " + ob.getSeancegenerique().getClasse().getClassegenerique().getFiliere().getCode()+" : " + ob.getSeancegenerique().getJour()+"  "+ob.getSeancegenerique().getDatedeb() + "h -->" + ob.getSeancegenerique().getDatefin()+"\n");
            }
            
        }
        if (event.getSource() == Classes_btn){
            Classes_Form.setVisible(true);
            TeacherDATA.setVisible(false);
            Absence_form.setVisible(false);
            AddMarksForm.setVisible(false);
            populateComboBoxByClasses(populateClasses);
            try {
                DispalyStudentsData();
            } catch (Exception e) {
                e.printStackTrace();
                alert.errorMessage(e.getMessage());
            }
        }
        if (event.getSource() == Absence_btn ){
            Absence_form.setVisible(true);
            Classes_Form.setVisible(false);
            TeacherDATA.setVisible(false);
            AddMarksForm.setVisible(false);
            populateComboBoxByClasses(absenceClasses);
            //DispalyStudentABdata();
        }
        if (event.getSource() == MarksBtn ){
            AddMarksForm.setVisible(true);
            Absence_form.setVisible(false);
            Classes_Form.setVisible(false);
            TeacherDATA.setVisible(false);
            populateComboBoxByClasses(MarksClasses);
            populateMarksTableView();
        }
        
    }
    
    void populateComboBoxByClasses(ComboBox cb){
        ObservableList items = FXCollections.observableArrayList();
            for (seance ob : seance) {
                //ClassMap.put(ob.getSeancegenerique().getClasse().getId_classe(), ob.getSeancegenerique().getClasse().getClassegenerique().getCycle().getCode()+" "+ob.getSeancegenerique().getClasse().getClassegenerique().getNiveau().getCode()+" " + ob.getSeancegenerique().getClasse().getClassegenerique().getFiliere().getCode());
                items.add(ob.getSeancegenerique().getClasse().getId_classe()+":"+ob.getSeancegenerique().getClasse().getClassegenerique().getCycle().getCode()+" "+ob.getSeancegenerique().getClasse().getClassegenerique().getNiveau().getCode()+" " + ob.getSeancegenerique().getClasse().getClassegenerique().getFiliere().getCode());
            }
        cb.setItems(items);
    }
    
//    @FXML
//    void ClassesForm(ActionEvent event) {
//        
//            
//        
////        System.out.println(getSelectedId());
//    }
    
    @FXML
    void PopulateByClasses(ActionEvent event) {
        if (event.getSource() == populateClasses ) {
            if(populateClasses.getSelectionModel().getSelectedItem()!=null){
                DispalyStudentsDataByClasse();
            }else{
                DispalyStudentsData();
            }
            
        }
    }
    
//    public int getSelectedId() {
//        String selectedCode = populateClasses.getValue().toString();
//        for (Map.Entry<Integer, String> entry : ClassMap.entrySet()) {
//            if (entry.getValue().equals(selectedCode)) {
//                return entry.getKey();
//            }
//        }
//        return -1;
//    }
    void DispalyStudentsData(){
        Students_col_studentID.setCellValueFactory(new PropertyValueFactory<>("id_etudiant"));
        Students_col_fname.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Students_col_Lname.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Students_col_Birthday.setCellValueFactory(new PropertyValueFactory<>("dateNais"));
        Students_col_BirthPlace.setCellValueFactory(new PropertyValueFactory<>("LieuNais"));
        Students_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        Students_col_gender.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        Students_col_phone.setCellValueFactory(new PropertyValueFactory<>("tele"));
        Students_col_filiere.setCellValueFactory(new PropertyValueFactory<>("nomClasse"));
        Students_tableView.setItems(tsh.getAllStudentsByTeacher(InscriptionController.autoDATA.getUser().getId_user()));
    }
    
    void DispalyStudentABdata(){
        int id_classe = Integer.parseInt(absenceClasses.getSelectionModel().getSelectedItem().toString().split(":")[0]);
        int id_seance = Integer.parseInt(comboSeanceByClass.getSelectionModel().getSelectedItem().toString().split(":")[0]);
        AbsenceStudent_ID.setCellValueFactory(new PropertyValueFactory<>("id_etudiant"));
        AbsenceStudent_fname.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        AbsenceStudent_LName.setCellValueFactory(new PropertyValueFactory<>("nom"));
        AbsenceStudent_classe.setCellValueFactory(new PropertyValueFactory<>("nomClasse"));
        AbsenceStudent_check.setCellValueFactory(new PropertyValueFactory<>("select"));
        Abcense_tableView.setItems(etd.getAllStudentsByClasseAndSeance(id_classe, id_seance));
        
    }
    
    void DispalyStudentsDataByClasse(){
        String selectedClass = populateClasses.getSelectionModel().getSelectedItem().toString();
        int id_classe = Integer.parseInt(selectedClass.split(":")[0]);
        if(selectedClass != null){
            Students_col_studentID.setCellValueFactory(new PropertyValueFactory<>("id_etudiant"));
            Students_col_fname.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            Students_col_Lname.setCellValueFactory(new PropertyValueFactory<>("nom"));
            Students_col_Birthday.setCellValueFactory(new PropertyValueFactory<>("dateNais"));
            Students_col_BirthPlace.setCellValueFactory(new PropertyValueFactory<>("LieuNais"));
            Students_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
            Students_col_gender.setCellValueFactory(new PropertyValueFactory<>("sexe"));
            Students_col_phone.setCellValueFactory(new PropertyValueFactory<>("tele"));
            Students_col_filiere.setCellValueFactory(new PropertyValueFactory<>("nomClasse"));
            Students_tableView.setItems(tsh.getAllStudentsByTeacherAndClasse(InscriptionController.autoDATA.getUser().getId_user(),id_classe));
        }
    }

    @FXML
    void addStudentSelectitem(MouseEvent event) {

    }

    @FXML
    void logoutBtn(ActionEvent event) {
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
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void FillSeanceComboBox(){
        ObservableList items= FXCollections.observableArrayList();
        if(absenceClasses.getSelectionModel().getSelectedItem()!=null){
            int id_classe=Integer.parseInt(absenceClasses.getSelectionModel().getSelectedItem().toString().split(":")[0]);
            for (seance ob : sc.getSessionByClass(id_classe)) {
                items.add(ob.getId_seance()+":"+ob.getSeancegenerique().getJour()+" "+ob.getSeancegenerique().getDatedeb()+"->" + ob.getSeancegenerique().getDatedeb()+" "+ob.getDate().toString());
            }
            comboSeanceByClass.setItems(items);
        }
        
    }
    
    void FillAbsenceTableView(){
        if(absenceClasses.getSelectionModel().getSelectedItem()!=null && comboSeanceByClass.getSelectionModel().getSelectedItem()!=null){
            DispalyStudentABdata();
        }
    }
    
    @FXML
    void subjectHandleAddBtn(ActionEvent event) {

    }

    @FXML
    void subjectHandleClearBtn(ActionEvent event) {

    }

    @FXML
    void subjectHandleRemoveBtn(ActionEvent event) {

    }

    @FXML
    void AbsenceStudentSelectItem(MouseEvent event) {

    }

    @FXML
    void subjectHandleSubjectCodeList(ActionEvent event) {

    }
    
    

    @FXML
    void ClearCBClassesAB(ActionEvent event) {
        if(event.getSource()==clearBtn1){
            absenceClasses.getSelectionModel().clearSelection();
            comboSeanceByClass.getSelectionModel().clearSelection();
            Abcense_tableView.getItems().clear();
        }
        
        
    }


    @FXML
    void populateABClasses(ActionEvent event) {
        if (event.getSource() == absenceClasses ) {
            if(populateClasses.getSelectionModel().getSelectedItem()!=null){
                DispalyStudentsDataByClasse();
            }else{
                DispalyStudentsData();
            }
            
        }
    }

    @FXML
    void AbsenceAddBtn(ActionEvent event) {
        ObservableList<etudiant> selectedStudents = FXCollections.observableArrayList();
        for (etudiant etudiant : Abcense_tableView.getItems()) {
            if (etudiant.getSelect().isSelected() &&comboSeanceByClass.getSelectionModel().getSelectedItem()!=null) {
                selectedStudents.add(etudiant);
                int id_etudiant = etudiant.getId_etudiant();
                int id_seance= Integer.parseInt(comboSeanceByClass.getSelectionModel().getSelectedItem().toString().split(":")[0]);
                boolean justification= false;
                String motif = "";
                try {
                    absence.insert(new absenceetudiant(new etudiant(id_etudiant), new seance(id_seance), justification, motif));
                }catch (Exception e) {
                    e.printStackTrace();
                    alert.errorMessage(e.getMessage());
                    return;
                }
            }
            
        }
        alert.successMessage("L' absence est ajoutee succes");
        //System.out.println(selectedStudents);
        
    }
    
    void populateMarksTableView(){
        ObservableList ListEtudiant = tsh.getAllStudentsByTeacher(InscriptionController.autoDATA.getUser().getId_user());
        MarkEtudiantID.setCellValueFactory(new PropertyValueFactory<>("id_etudiant"));
        MarkEtudiantNomComplet.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
        MarkEtudiantClasse.setCellValueFactory(new PropertyValueFactory<>("nomClasse"));
//        MarkEtudiantNoteCC.setCellValueFactory(new PropertyValueFactory<>("noteCC"));
//        MarkEtudiantNoteTP.setCellValueFactory(new PropertyValueFactory<>("noteTP"));
//        MarkEtudiantExamen.setCellValueFactory(new PropertyValueFactory<>("noteExamen"));
        MarksTableView.setItems(ListEtudiant);
    }
    
    
    @FXML
    void MarksSelectItem(MouseEvent event) {
        etudiant etudiant = MarksTableView.getSelectionModel().getSelectedItem();
        if(etudiant!=null){
            AddMarkEtudiantID.setText(etudiant.getId_etudiant()+"");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TeacherDATA.setVisible(true);
        Classes_Form.setVisible(false);
        Absence_form.setVisible(false);
        AddMarksForm.setVisible(false);
        TeacherID.setText(teacher.getUser().getId_user()+"");
        FullName.setText(teacher.getUser().getNom() + " "+ teacher.getUser().getPrenom());
        Email.setText(teacher.getUser().getEmail());
        birthday.setText(teacher.getUser().getDateNais());
        birthplace.setText(teacher.getUser().getLieuNais());
        phone.setText(teacher.getUser().getTele());
        if(teacher.getUser().getSexe().equals("M")){
            sexe.setText("Male");
        }else{
            sexe.setText("Female");
        }
        for (seance ob : seance) {
            ClassesData.setText(ob.getSeancegenerique().getClasse().getClassegenerique().getCycle().getCode()+" "+ob.getSeancegenerique().getClasse().getClassegenerique().getNiveau().getCode()+" " + ob.getSeancegenerique().getClasse().getClassegenerique().getFiliere().getCode()+" : " + ob.getSeancegenerique().getJour()+"  "+ob.getSeancegenerique().getDatedeb() + "h -->" + ob.getSeancegenerique().getDatefin()+"\n");
        }
        
        absenceClasses.setOnAction(event -> FillSeanceComboBox());
        
        comboSeanceByClass.setOnAction(event -> FillAbsenceTableView());

            
            
    }


    
    

}


