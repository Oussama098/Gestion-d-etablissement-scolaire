package view;

import db.*;
import model.*;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.enseignant;

public class DataGeneralController implements Initializable{

    @FXML
    private AnchorPane DashbordForm;

    @FXML
    private AnchorPane MaternelleForm;

    @FXML
    private Button MaternelleFormBtn;

    @FXML
    private ListView<?> PriClasseListView;

    @FXML
    private ListView<?> PriStudentsListView;

    @FXML
    private ListView<?> PriTeacherListView;

    @FXML
    private AnchorPane PrimaireForm;

    @FXML
    private Button homePage;
    @FXML
    private Button PrimaireFormBtn;

    @FXML
    private ListView<?> SecClasseListView;

    @FXML
    private ListView<?> SecStudentsListView;

    @FXML
    private ListView<?> SecTeacherListView;

    @FXML
    private ListView<?> colClasseListView;

    @FXML
    private ListView<?> colStudentsListView;

    @FXML
    private ListView<?> colTeacherListView;

    @FXML
    private AnchorPane collegeForm;

    @FXML
    private Button collegeFormBtn;

    @FXML
    private ListView<?> matClasseListView;

    @FXML
    private ListView<?> matStudentsListView;

    @FXML
    private ListView<?> matTeacherListView;

    @FXML
    private AnchorPane secondaireForm;

    @FXML
    private Button secondaireFormBtn;

    @FXML
    private Button returnBtn;
    
    private enseignantController teacher = new enseignantController();
    
    private CycleController cycle = new CycleController();
    
    private SeanceController seance = new SeanceController();
    
    private EtudiantController etudiant = new EtudiantController();
    
    
    @FXML
    void switchForm(ActionEvent event) {
        if(event.getSource()==MaternelleFormBtn){
            DashbordForm.setVisible(false);
            MaternelleForm.setVisible(true);
            PrimaireForm.setVisible(false);
            collegeForm.setVisible(false);
            secondaireForm.setVisible(false);
            populateTeacherListView(matTeacherListView , "maternelle");
                    
        }
        if(event.getSource()==PrimaireFormBtn){
            DashbordForm.setVisible(false);
            MaternelleForm.setVisible(false);
            PrimaireForm.setVisible(true);
            collegeForm.setVisible(false);
            secondaireForm.setVisible(false);
            populateTeacherListView(PriTeacherListView , "Primaire");
        }
        if(event.getSource()==collegeFormBtn){
            DashbordForm.setVisible(false);
            MaternelleForm.setVisible(false);
            PrimaireForm.setVisible(false);
            collegeForm.setVisible(true);
            secondaireForm.setVisible(false);
            populateTeacherListView(colTeacherListView , "Collège");
        }
        if(event.getSource()==secondaireFormBtn){
            DashbordForm.setVisible(false);
            MaternelleForm.setVisible(false);
            PrimaireForm.setVisible(false);
            collegeForm.setVisible(false);
            secondaireForm.setVisible(true);
            populateTeacherListView(SecTeacherListView , "Secondaire");
        }
        if(event.getSource()==returnBtn){
            DashbordForm.setVisible(true);
            MaternelleForm.setVisible(false);
            PrimaireForm.setVisible(false);
            collegeForm.setVisible(false);
            secondaireForm.setVisible(false);
        }
        if(event.getSource()==homePage){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("accueil.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Page D'Accueil");
                stage.setResizable(false);
                stage.show();
                homePage.getScene().getWindow().hide();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void populateTeacherListView(ListView list , String nomCycle){
        ObservableList items = FXCollections.observableArrayList();
        for (enseignant item : cycle.getAllTeachersByCycle(nomCycle)) {
            items.add(item.getId_enseignant()+":"+item.getNom() +" " +item.getPrenom());
        }
        list.setItems(items);
    }
    
    void populateClassesListView(ListView listTeacher , ListView listClasses){
        ObservableList items = FXCollections.observableArrayList();
        if(listTeacher.getSelectionModel().getSelectedItem()!=null){
            int id_enseignant = Integer.parseInt(listTeacher.getSelectionModel().getSelectedItem().toString().split(":")[0]);
            for (seance item : seance.getSessionByTeacher(teacher.getUserByIdTeacher(id_enseignant).getId_user())) {
                items.add(item.getSeancegenerique().getClasse().getId_classe()+":"+item.getSeancegenerique().getClasse().getClassegenerique().getCycle().getCode()+" "+item.getSeancegenerique().getClasse().getClassegenerique().getNiveau().getCode()+" " + item.getSeancegenerique().getClasse().getClassegenerique().getFiliere().getCode());
            }
            listClasses.setItems(items);     
        }
           
    }
    
    void populateStudentsListView(ListView listClasse , ListView listStudents){
        ObservableList items = FXCollections.observableArrayList();
        if(listClasse.getSelectionModel().getSelectedItem()!=null){
            int id_classe = Integer.parseInt(listClasse.getSelectionModel().getSelectedItem().toString().split(":")[0]);
            for (etudiant item : etudiant.getAllStudentsByClasse(id_classe)) {
                items.add(item.getNomComplet());
            }
            listStudents.setItems(items);    
        }
             
    }
        


    @FXML
    void PriClasseListViewSelected(MouseEvent event) {
        populateStudentsListView(PriClasseListView, PriStudentsListView);
    }

    @FXML
    void PriTeacherListViewSelected(MouseEvent event) {
        populateClassesListView(PriTeacherListView, PriClasseListView);
    }

    @FXML
    void SecClasseListViewSelected(MouseEvent event) {
        populateStudentsListView(SecClasseListView, SecStudentsListView);
    }

    @FXML
    void SecTeacherListViewSelected(MouseEvent event) {
        //System.out.println(Integer.parseInt(SecTeacherListView.getSelectionModel().getSelectedItem().toString().split(":")[0]));
        populateClassesListView(SecTeacherListView, SecClasseListView);     
    }

    @FXML
    void colClasseListViewSelected(MouseEvent event) {
        populateStudentsListView(colClasseListView, colStudentsListView);
    }

    @FXML
    void colTeacherListViewSelected(MouseEvent event) {
        populateClassesListView(colTeacherListView, colClasseListView);
    }

    @FXML
    void matClasseListViewSelected(MouseEvent event) {
        populateStudentsListView(matClasseListView, matStudentsListView);
    }
    
    @FXML
    void MatTeacherListViewSelected(MouseEvent event) {
        populateClassesListView(matTeacherListView, matClasseListView);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DashbordForm.setVisible(true);
        MaternelleForm.setVisible(false);
        PrimaireForm.setVisible(false);
        collegeForm.setVisible(false);
        secondaireForm.setVisible(false);
    }

}
