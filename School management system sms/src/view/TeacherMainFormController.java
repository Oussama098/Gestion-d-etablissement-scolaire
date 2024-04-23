package view;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javax.swing.JOptionPane;
import model.enseignant;
import model.seance;

public class TeacherMainFormController implements Initializable {

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
    private TableColumn<?, ?> Students_col_Birthday;

    @FXML
    private TableColumn<?, ?> Students_col_Lname;

    @FXML
    private TableColumn<?, ?> Students_col_cycle;

    @FXML
    private TableColumn<?, ?> Students_col_filiere;

    @FXML
    private TableColumn<?, ?> Students_col_fname;

    @FXML
    private TableColumn<?, ?> Students_col_gender;

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
    private Button clearBtn;

    @FXML
    private Label birthday;

    @FXML
    private Label birthplace;

    @FXML
    private Circle circle_image;

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

    @FXML
    private AnchorPane subjectHandle_form;

    @FXML
    private Button subjecthandle_addBtn;

    @FXML
    private Button subjecthandle_clearBtn;

    @FXML
    private ComboBox<?> subjecthandle_code;

    @FXML
    private TableColumn<?, ?> subjecthandle_col_dateInsert;

    @FXML
    private TableColumn<?, ?> subjecthandle_col_status;

    @FXML
    private TableColumn<?, ?> subjecthandle_col_subjectCode;

    @FXML
    private TableColumn<?, ?> subjecthandle_col_subjectName;

    @FXML
    private Button subjecthandle_removeBtn;

    @FXML
    private ComboBox<?> subjecthandle_status;

    @FXML
    private ComboBox<?> subjecthandle_subject;

    @FXML
    private TableView<?> subjecthandle_tableView;
    
    private enseignantController tsh = new enseignantController();
    
    private SeanceController sc = new SeanceController();
    
    private enseignant teacher = tsh.getTeacherById(InscriptionController.autoDATA.getUser().getId_user());
    
    private ArrayList<seance> seance = sc.getSessionByTeacher(InscriptionController.autoDATA.getUser().getId_user());

    private AlertMessage alert = new AlertMessage();
    
    private Map<Integer, String> ClassMap = new HashMap<>();
    
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
    }
    
    @FXML
    void ClassesForm(ActionEvent event) {
        ObservableList items = FXCollections.observableArrayList();
        for (seance ob : seance) {
            ClassMap.put(ob.getSeancegenerique().getClasse().getId_classe(), ob.getSeancegenerique().getClasse().getClassegenerique().getCycle().getCode()+" "+ob.getSeancegenerique().getClasse().getClassegenerique().getNiveau().getCode()+" " + ob.getSeancegenerique().getClasse().getClassegenerique().getFiliere().getCode());
            items.add(ob.getSeancegenerique().getClasse().getClassegenerique().getCycle().getCode()+" "+ob.getSeancegenerique().getClasse().getClassegenerique().getNiveau().getCode()+" " + ob.getSeancegenerique().getClasse().getClassegenerique().getFiliere().getCode());
        }
        if (event.getSource() == Classes_btn ){
            Classes_Form.setVisible(true);
            TeacherDATA.setVisible(false);
            populateClasses.setItems(items);
            
            try {
                DispalyStudentsData();
            } catch (Exception e) {
                alert.errorMessage(e.getMessage());
            }
            
        }
//        System.out.println(getSelectedId());
    }
    
    public int getSelectedId() {
        String selectedCode = populateClasses.getValue().toString();
        for (Map.Entry<Integer, String> entry : ClassMap.entrySet()) {
            if (entry.getValue().equals(selectedCode)) {
                return entry.getKey();
            }
        }
        return -1;
    }
    public void DispalyStudentsData(){
        
        Students_col_studentID.setCellValueFactory(new PropertyValueFactory<>("id_etudiant"));
        Students_col_fname.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Students_col_Lname.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Students_col_gender.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        Students_col_Birthday.setCellValueFactory(new PropertyValueFactory<>("dateNais"));
//        Students_col_cycle.setCellValueFactory(new PropertyValueFactory<>("Cycle"));
        Students_col_filiere.setCellValueFactory(new PropertyValueFactory<>("code"));
        Students_tableView.setItems(tsh.getAllStudentsByTeacher(InscriptionController.autoDATA.getUser().getId_user()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TeacherDATA.setVisible(true);
            Classes_Form.setVisible(false);
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
    

    @FXML
    void addStudentSelectitem(MouseEvent event) {

    }

    @FXML
    void logoutBtn(ActionEvent event) {

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
    void subjectHandleSelectItem(MouseEvent event) {

    }

    @FXML
    void subjectHandleSubjectCodeList(ActionEvent event) {

    }

    
    
    

}


