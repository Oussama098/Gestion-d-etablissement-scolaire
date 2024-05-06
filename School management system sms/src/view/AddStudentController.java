package view;

import db.*;
import db.EtudiantController;
import db.filiereController;
import db.niveauController;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.*;
import model.user;

public class AddStudentController implements Initializable {

@FXML
    private AnchorPane main_form;

    @FXML
    private TextField student_ClassID;
    
    @FXML
    private TextField student_id;

    @FXML
    private TextField student_Classe;

    @FXML
    private Button student_ClearForm;

    @FXML
    private Button student_addBtn;

    @FXML
    private DatePicker student_birthDate;

    @FXML
    private TextField student_birthplace;

    @FXML
    private ComboBox<?> student_cycle;

    @FXML
    private TextField student_email;

    @FXML
    private ComboBox<?> student_filiere;

    @FXML
    private TextField student_fname;

    @FXML
    private ComboBox<?> student_gender;

    @FXML
    private ImageView student_imageView;

    @FXML
    private Button student_importBtn;

    @FXML
    private TextField student_lname;

    @FXML
    private ComboBox<?> student_niveau;

    @FXML
    private TextField student_phone;

    private Image image;
    
    private EtudiantController etd = new EtudiantController();
    
    private AlertMessage alert = new AlertMessage();
    
    private CycleController cycle = new CycleController();
    
    private niveauController niveau = new niveauController();
    
    private filiereController filiere = new filiereController();
    
    private ClasseController classe = new ClasseController();

    @FXML
    void ClearBtn(ActionEvent event) {
        if(event.getSource() == student_ClearForm){
            student_fname.clear();
            student_lname.clear();
            student_birthDate.setValue(null);
            student_gender.getSelectionModel().clearSelection();
            student_email.clear();
            student_phone.clear();
            student_birthplace.clear();
            imagePath="";
            student_imageView.setImage(null);
            student_ClassID.clear();
            student_Classe.clear();
            student_cycle.getSelectionModel().clearSelection();
            student_filiere.getSelectionModel().clearSelection();
            student_niveau.getSelectionModel().clearSelection();
        }
    }
    
    void ClearBtn() {
        
            student_fname.clear();
            student_lname.clear();
            student_birthDate.setValue(null);
            student_gender.getSelectionModel().clearSelection();
            student_email.clear();
            student_phone.clear();
            student_birthplace.clear();
            imagePath="";
            student_imageView.setImage(null);
            student_ClassID.clear();
            student_Classe.clear();
            student_cycle.getSelectionModel().clearSelection();
            student_filiere.getSelectionModel().clearSelection();
            student_niveau.getSelectionModel().clearSelection();
        
    }

    boolean formValidate() {
        if (student_fname.getText().isEmpty() ||
            student_lname.getText().isEmpty() ||
            student_email.getText().isEmpty() ||
            student_phone.getText().isEmpty() ||
            student_birthDate.getValue() == null ||
            student_gender.getSelectionModel().isEmpty() ||
            student_birthplace.getText().isEmpty()) {
            return false;
        }
        return true;
    }
    @FXML
    void addBtn(ActionEvent event) {
        if(event.getSource() == student_addBtn){
            if(!formValidate()){
                alert.errorMessage("Form Invalid");
                return;
            }
            String fname=student_fname.getText();
            String lname = student_lname.getText();
            String email = student_email.getText();
            String Phone =student_phone.getText();
            String gender;
            String birthDate = student_birthDate.getValue().toString();
            String birthPlace =student_birthplace.getText();
            int classeId = getClasseID(id_niveau, id_filiere, id_cycle); // Example value, replace with actual ID
            int filiereId = Integer.parseInt(student_filiere.getSelectionModel().getSelectedItem().toString().split(":")[0]);
            if( student_gender.getSelectionModel().getSelectedItem().toString().equals("Male")){
                gender="M";
            }else{
                gender="F";
            }
            try {
                int userId = etd.insert(new user(lname, fname, email, birthDate, birthPlace, Phone, gender, imagePath));
                etd.insert(new etudiant(new user(userId), new filiere(filiereId) , new classe(classeId)));
                alert.successMessage("L'etudiant est ajoutee avec succes");
                ClearBtn();
            } catch (Exception e) {
                alert.errorMessage(e.getMessage());
            }
            
        }
    }

    @FXML
    void countAge(ActionEvent event) {

    }

    private String imagePath;
    @FXML
    void importBtn(ActionEvent event) {
        if(event.getSource() == student_importBtn){
            FileChooser open = new FileChooser();
            open.getExtensionFilters().add(new ExtensionFilter("Open Image", "*.jpg", "*.jpeg", "*.png"));

            File file = open.showOpenDialog(student_importBtn.getScene().getWindow());

            if (file != null) {
                imagePath = file.getAbsolutePath();
                image = new Image(file.toURI().toString(), 100, 113, false, true);
                student_imageView.setImage(image);
            }
        }
        
    }
    
    void populateGender(){
        ArrayList<String> gender = new ArrayList();
        gender.add("Female");
        gender.add("Male");
        ObservableList items = FXCollections.observableArrayList(gender);
        student_gender.setItems(items);
    }
    
    void populateCycle(){
        ObservableList List = FXCollections.observableArrayList();
        for (cycle ob : cycle.getAllCycles()) {
            List.add(ob.getId_cycle()+":"+ob.getNom());

        }
        student_cycle.setItems(List);
    }
    
    void populateFiliere(){
        ObservableList List = FXCollections.observableArrayList();
        for (filiere ob : filiere.getAllFiliere()) {
            List.add(ob.getId_filiere()+":"+ob.getNom());

        }
        student_filiere.setItems(List);
    }
    
    void populateNiveau(){
        ObservableList List = FXCollections.observableArrayList();
        for (niveau ob : niveau.getAllLevel()) {
            List.add(ob.getId_niveau()+":"+ob.getNom());
        }
        student_niveau.setItems(List);
    }
    
    int getClasseID(int id_niveau , int id_filiere  , int id_cycle){
        int id = classe.getClassByCycleNiveauFiliere(id_cycle, id_niveau, id_filiere).getId_classe();
        return id;
    }
    
    String getClasse(int id_niveau , int id_filiere  , int id_cycle){
        String Nom = classe.getClassByCycleNiveauFiliere(id_cycle, id_niveau, id_filiere).getClassegenerique().getNiveau().getCode() +" "+classe.getClassByCycleNiveauFiliere(id_cycle, id_niveau, id_filiere).getClassegenerique().getFiliere().getCode();
        return Nom;
    }
    
    private int id_niveau,id_filiere , id_cycle;
    void FillClassTextFields(){
        Object niveauSelectedItem = student_niveau.getSelectionModel().getSelectedItem();
        Object cycleSelectedItem = student_cycle.getSelectionModel().getSelectedItem();
        Object filiereSelectedItem = student_filiere.getSelectionModel().getSelectedItem();
        student_ClassID.clear();
        student_Classe.clear();
        if (niveauSelectedItem != null && cycleSelectedItem != null && filiereSelectedItem != null) {
            id_niveau=Integer.parseInt(niveauSelectedItem.toString().split(":")[0]);
            id_filiere=Integer.parseInt(filiereSelectedItem.toString().split(":")[0]);
            id_cycle=Integer.parseInt(cycleSelectedItem.toString().split(":")[0]);
            try {
                student_Classe.setText(getClasse(id_niveau, id_filiere, id_cycle));
                student_ClassID.setText(String.valueOf(getClasseID(id_niveau, id_filiere, id_cycle)));
            } catch (Exception e) {
                alert.errorMessage(e.getMessage());
                student_niveau.getSelectionModel().clearSelection();
                student_cycle.getSelectionModel().clearSelection();
                student_filiere.getSelectionModel().clearSelection();
            }
            

        }
    }
    
    
        
    
    
    

//    public void importBtn() {
//
//        FileChooser open = new FileChooser();
//        open.getExtensionFilters().add(new ExtensionFilter("Open Image", "*.jpg", "*.jpeg", "*.png"));
//
//        File file = open.showOpenDialog(student_importBtn.getScene().getWindow());
//
//        if (file != null) {
////            ListData.path = file.getAbsolutePath();
//
//            image = new Image(file.toURI().toString(), 100, 113, false, true);
//            student_imageView.setImage(image);
//        }
//    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateGender();
        populateNiveau();
        populateFiliere();
        populateCycle();
//        CycleCombo();
//        comboFiliere();
//        comboNiveau();
        student_niveau.setOnAction(event -> FillClassTextFields());
        student_cycle.setOnAction(event -> FillClassTextFields());
        student_filiere.setOnAction(event -> FillClassTextFields());
        
    }
    
    
}
