package view;

import db.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import db.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TablePosition;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.classe;
import model.enseignant;
import model.etudiant;
import model.filiere;
import model.*;
import model.user;
import org.apache.poi.ss.usermodel.*;
import java.util.Iterator;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import model.cycle;
import model.specialite;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import static org.apache.poi.hssf.usermodel.HeaderFooter.fontSize;

public class AdminMainFormController implements Initializable {
    
    @FXML
    private ComboBox<?> ABSComboBox;
    
    @FXML
    private ComboBox<String> AbsenceClasses;
    
    @FXML
    private BarChart<String, Number> AbsenceChart;
    
    @FXML
    private Button Absencebtn;
    
    @FXML
    private AnchorPane AbsenceForm;
    
    @FXML
    private CategoryAxis Months;

    @FXML
    private NumberAxis NbrAbs;

    @FXML
    private ComboBox<?> Classes;

     @FXML
    private TableColumn<?, ?> AbsenceStudentCheck;

    @FXML
    private TableColumn<?, ?> AbsenceStudentClass;

    @FXML
    private TableColumn<?, ?> AbsenceStudentFullName;

    @FXML
    private TableColumn<?, ?> AbsenceStudentID;

    @FXML
    private TableColumn<?, ?> AbsenceStudentAbsCount;
    
    @FXML
    private Button GenratePDF;
    
    @FXML
    private TableView<absenceetudiant> AbcenseTableView;
    @FXML
    private Button ClearComboBox;

    @FXML
    private Button Student_Import;

    @FXML
    private Button Student_addBtn;

    @FXML
    private TableColumn<?, ?> Student_col_BirthDay;

    @FXML
    private TableColumn<?, ?> Student_col_BirthPlace;

    @FXML
    private TableColumn<?, ?> Student_col_Class;

    @FXML
    private TableColumn<?, ?> Student_col_Email;

    @FXML
    private TableColumn<?, ?> Student_col_Fname;

    @FXML
    private TableColumn<?, ?> Student_col_Gender;

    @FXML
    private TableColumn<?, ?> Student_col_Lname;

    @FXML
    private TableColumn<?, ?> Student_col_phone;

    @FXML
    private TableColumn<?, ?> Student_col_studentID;

    @FXML
    private Button Student_deleteBtn;

    @FXML
    private TableView<?> Student_tableView;

    @FXML
    private Button Student_updateBtn;

    @FXML
    private TableColumn<?, ?> Teacher_col_BirthDate;

    @FXML
    private TableColumn<?, ?> Teacher_col_BirthPlace;

    @FXML
    private TableColumn<?, ?> Teacher_col_Cycle;

    @FXML
    private TableColumn<?, ?> Teacher_col_email;

    @FXML
    private TableColumn<?, ?> Teacher_col_fname;

    @FXML
    private TableColumn<?, ?> Teacher_col_gender;

    @FXML
    private TableColumn<?, ?> Teacher_col_lname;

    @FXML
    private TableColumn<?, ?> Teacher_col_phone;

    @FXML
    private TableColumn<?, ?> Teacher_col_photo;

    @FXML
    private TableColumn<?, ?> Teacher_col_specility;

    @FXML
    private TableColumn<?, ?> Teacher_col_teacherID;

    @FXML
    private TableView<?> Teacher_tableView;

    @FXML
    private Button addStudent_btn;

    @FXML
    private AnchorPane addStudent_form;

    @FXML
    private DatePicker addTeacher_BirthDay;

    @FXML
    private TextField addTeacher_BirthPlace;

    @FXML
    private TextField addTeacher_Email;

    @FXML
    private TextField addTeacher_Phone;

    @FXML
    private Button addTeacher_addBtn;

    @FXML
    private Button addTeacher_btn;

    @FXML
    private Button addTeacher_clearBtn;

    @FXML
    private ComboBox<String> addTeacher_cycle;

    @FXML
    private Button addTeacher_deleteBtn;

    @FXML
    private TextField addTeacher_fname;

    @FXML
    private AnchorPane addTeacher_form;

    @FXML
    private ComboBox<String> addTeacher_gender;

    @FXML
    private ImageView addTeacher_imageView;

    @FXML
    private Button addTeacher_importBtn;

    @FXML
    private TextField addTeacher_lname;

    @FXML
    private ComboBox<String> addTeacher_speciality;

    @FXML
    private TextField addTeacher_teacherID;

    @FXML
    private Button addTeacher_updateBtn;

    @FXML
    private Label dashboard_CL;

    @FXML
    private Label dashboard_TS;

    @FXML
    private Label dashboard_TT;

    @FXML
    private Button dashboard_btn;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Label greet_username;

    @FXML
    private Button logout_btn;
    
    @FXML
    private ComboBox<?> CBMarksClass;
    
    @FXML
    private PieChart MarksChart;
    
        @FXML
    private Button aftClassesAdd;

    @FXML
    private Button aftClassesDelete;

    @FXML
    private ListView<?> aftClassesListView;

    @FXML
    private ComboBox<?> aftTeachers;
    
    @FXML
    private Button affecterBtn;
    
    @FXML
    private AnchorPane affectClassesForm;
    
    @FXML
    private ListView<String> aftClassesToTeacherListView;
    
    private Image image;
    
    private EtudiantController etd = new EtudiantController();
    
    private enseignantController tsh = new enseignantController();
    
    private ClasseController cl = new ClasseController();
    
    private SeanceController sc = new SeanceController();
    
    private CycleController cycle = new CycleController();
    
    private filiereController filiere = new filiereController();
    
    private niveauController niveau = new niveauController();
    
    private specialiteController specialite = new specialiteController();
    
    private enseignant teacher = tsh.getTeacherById(InscriptionController.autoDATA.getUser().getId_user());
    
    private AbsenceEtudiantController absence= new AbsenceEtudiantController();
    
    private NotesController note = new NotesController();
    
    private SeanceGeneriqueController sg = new SeanceGeneriqueController();
    
    private AlertMessage alert = new AlertMessage();

    @FXML
    void switchForm(ActionEvent event) {
        if (event.getSource() == dashboard_btn) {
            dashboard_form.setVisible(true);
            dashboard_CL.setText(cl.CountClasses()+"");
            dashboard_TS.setText(etd.CountStudents()+"");
            dashboard_TT.setText(tsh.countAllTeachers()+"");
            populateABSclasses(ABSComboBox);
            populateABSclasses(CBMarksClass);
            AbsenceChartDS();
            MarksChart();
            addStudent_form.setVisible(false);
            addTeacher_form.setVisible(false);
            AbsenceForm.setVisible(false);
            affectClassesForm.setVisible(false);
        }
        if (event.getSource() == addStudent_btn) {
            addStudent_form.setVisible(true);
            addTeacher_form.setVisible(false);
            dashboard_form.setVisible(false);
            affectClassesForm.setVisible(false);
            AbsenceForm.setVisible(false);
            populateCBclasses();
            populateStudentTableView();
        }
        if (event.getSource() == addTeacher_btn) {
            dashboard_form.setVisible(false);
            addStudent_form.setVisible(false);
            addTeacher_form.setVisible(true);
            AbsenceForm.setVisible(false);
            affectClassesForm.setVisible(false);
            populateTeacherTableView();
            populateCBGender();
            populateCBSpeciality();
            populateCBCycle();
            addTeacherClearBtn();
        }
        if(event.getSource() == Absencebtn){
            AbsenceForm.setVisible(true);
            dashboard_form.setVisible(false);
            addStudent_form.setVisible(false);
            addTeacher_form.setVisible(false);
            affectClassesForm.setVisible(false);
            populateABSclasses(AbsenceClasses);
//            populateAbsenceTableView();
        }
        if(event.getSource() == affecterBtn){
            affectClassesForm.setVisible(true);
            AbsenceForm.setVisible(false);
            dashboard_form.setVisible(false);
            addStudent_form.setVisible(false);
            addTeacher_form.setVisible(false);
            populateAftTeachersComboBox();
        }
    }

    void AbsenceChartDS(){
        AbsenceChart.getData().clear();
        XYChart.Series chart = new XYChart.Series();
        ResultSet rs= absence.getAbsenceByMonth();
        String Month = new String();
        try {
            while (rs.next()) {   
                switch (rs.getInt(1)) {
                     case 1:
                    Month = "janvier";
                    break;
                case 2:
                    Month = "février";
                    break;
                case 3:
                    Month = "mars";
                    break;
                case 4:
                    Month = "avril";
                    break;
                case 5:
                    Month = "mai";
                    break;
                case 6:
                    Month = "juin";
                    break;
                case 7:
                    Month = "juillet";
                    break;
                case 8:
                    Month = "août";
                    break;
                case 9:
                    Month = "septembre";
                    break;
                case 10:
                    Month = "octobre";
                    break;
                case 11:
                    Month = "novembre";
                    break;
                case 12:
                    Month = "décembre";
                    break;
                    }
               chart.getData().add(new XYChart.Data<>(Month , rs.getInt(2)));
               // System.out.println(Month +" : "+ rs.getInt(2));
            }
            AbsenceChart.getData().addAll(chart);
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
    
    @FXML
    void GeneratePDFbtn(ActionEvent event) {
        ObservableList<absenceetudiant> selectedStudents = FXCollections.observableArrayList();
        for (absenceetudiant etudiant : AbcenseTableView.getItems()) {
            if (etudiant.getSelect().isSelected()) {
                selectedStudents.add(etudiant);
                String nomComplet = etudiant.getNomComplet();
                try (PDDocument document = new PDDocument()) {
                    PDPage page = new PDPage(PDRectangle.A4);
                    document.addPage(page);
                    PDFont font = PDType1Font.HELVETICA;
                    try (PDPageContentStream contentStream = new PDPageContentStream(document, page, AppendMode.APPEND, true)) {
                        File file = new File("C:/Users/oussa/OneDrive/Bureau/ministre.jpg");
                        PDImageXObject image = PDImageXObject.createFromFileByContent(file, document);
                        contentStream.drawImage(image, 50, 750, 500, 100);
                        contentStream.beginText();
                        contentStream.setFont(font, 12);
                        // Adjust the starting coordinates for A4
                        contentStream.newLineAtOffset(72, 750);
                        PDFont pdfFont = PDType1Font.HELVETICA;
                        float fontSize = 12;
                        float leading = 1.5f * fontSize;

                        PDRectangle mediabox = page.getMediaBox();
                        float margin = 72;
                        float width = mediabox.getWidth() - 2 * margin;

                        String greeting = "Bonjour "+nomComplet+",";

                        String paragraph1 = "Nous tenons à vous rappeler que votre nombre d'heures d'absence a atteint 10 heures.";
                        String paragraph2 = "Nous vous demandons de respecter les horaires prévus selon votre emploi du temps";
                        String paragraph3 = "afin d'éviter d'éventuels problèmes académiques. Veuillez nous contacter en cas de ";
                        String paragraph4 = "circonstances particulières nécessitant un changement dans votre situation académique.";
                        String paragraph5 = "Nous tenons également à vous informer qu'en cas d'atteinte de 15 heures d'absence, nous";
                        String paragraph6 = "serons amenés à rédiger un rapport qui sera envoyé à votre famille.";
                        String paragraph7 = "Nous vous remercions pour votre compréhension et votre coopération.";
                        String paragraph8 = "                                                                                           Signature:";


                        List<String> lines = new ArrayList<String>();
                        lines.add("");
                        lines.add("");
                        lines.add("");
                        lines.add("");
                        lines.add(greeting);
                        lines.add("");
                        lines.add("");
                        lines.add("");
                        lines.add(paragraph1);
                        lines.add("");
                        lines.add(paragraph2);
                        lines.add("");
                        lines.add(paragraph3);
                        lines.add("");
                        lines.add(paragraph4);
                        lines.add("");
                        lines.add(paragraph5);
                        lines.add("");
                        lines.add(paragraph6);
                        lines.add("");
                        lines.add(paragraph7);
                        lines.add("");
                        lines.add("");
                        lines.add("");
                        lines.add("");
                        lines.add(paragraph8);

                        for (String line : lines) {
                            contentStream.showText(line);
                            contentStream.newLineAtOffset(0, -leading);
                        }

                        contentStream.endText();
                        contentStream.close();
                    }

                    document.save("C:/Users/oussa/OneDrive/Bureau/"+nomComplet+".pdf");
//                    File file = new File("C:/Users/oussa/OneDrive/Bureau/HelloWorldWithImage.pdf");
//                    Desktop.getDesktop().open(file);
                } catch (Exception e) {
                    e.printStackTrace();
                    alert.errorMessage("erreur");
                    return;
                }
            }
        }
        if(selectedStudents.isEmpty()){
            alert.errorMessage("Selectionner un element");
        }else{
            alert.successMessage("Succes");
        }
    }
    
    void MarksChart(){
        try {
            ResultSet rs = note.getMarksStudents();
            ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
            if(rs.next()) {                
                pieData.add(new PieChart.Data("> la moyenne" , rs.getInt(1)));
                pieData.add(new PieChart.Data("< la moyenne" , rs.getInt(2)));
                pieData.add(new PieChart.Data("= moyenne" , rs.getInt(3)));
            }
        MarksChart.setData(pieData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    void MarksChartByClasse(int id_classe){
        try {
            ResultSet rs = note.getMarksStudentsByClasse(id_classe);
            ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
            if(rs.next()) {                
                pieData.add(new PieChart.Data("> la moyenne" , rs.getInt(1)));
                pieData.add(new PieChart.Data("< la moyenne" , rs.getInt(2)));
                pieData.add(new PieChart.Data("= moyenne" , rs.getInt(3)));
            }
        MarksChart.setData(pieData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    void AbsenceChartDSByClasse(int id_classe){
        AbsenceChart.getData().clear();
        int id_ABSclasse= Integer.parseInt(ABSComboBox.getSelectionModel().getSelectedItem().toString().split(":")[0]);
        XYChart.Series chart = new XYChart.Series();
        ResultSet rs= absence.getAbsenceByMonth(id_ABSclasse);
        String Month = new String();
        try {
            while (rs.next()) {   
                switch (rs.getInt(1)) {
                     case 1:
                    Month = "janvier";
                    break;
                case 2:
                    Month = "février";
                    break;
                case 3:
                    Month = "mars";
                    break;
                case 4:
                    Month = "avril";
                    break;
                case 5:
                    Month = "mai";
                    break;
                case 6:
                    Month = "juin";
                    break;
                case 7:
                    Month = "juillet";
                    break;
                case 8:
                    Month = "août";
                    break;
                case 9:
                    Month = "septembre";
                    break;
                case 10:
                    Month = "octobre";
                    break;
                case 11:
                    Month = "novembre";
                    break;
                case 12:
                    Month = "décembre";
                    break;
                    }
               chart.getData().add(new XYChart.Data<>(Month , rs.getInt(2)));
                //System.out.println(Month +" : "+ rs.getInt(2));
            }
            AbsenceChart.getData().addAll(chart);
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
    

    
    void populateTeacherTableView(){
        ObservableList teachers = FXCollections.observableArrayList(tsh.getAllTeachers());
        Teacher_col_teacherID.setCellValueFactory(new PropertyValueFactory<>("id_enseignant"));
        Teacher_col_fname.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Teacher_col_lname.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Teacher_col_BirthDate.setCellValueFactory(new PropertyValueFactory<>("dateNais"));
        Teacher_col_BirthPlace.setCellValueFactory(new PropertyValueFactory<>("lieuNais"));
        Teacher_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        Teacher_col_gender.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        Teacher_col_phone.setCellValueFactory(new PropertyValueFactory<>("tele"));
        Teacher_col_specility.setCellValueFactory(new PropertyValueFactory<>("nomSpecialite"));
        Teacher_col_Cycle.setCellValueFactory(new PropertyValueFactory<>("nomCycle"));
        Teacher_col_photo.setCellValueFactory(new PropertyValueFactory<>("photo"));
        Teacher_tableView.setItems(teachers);
    }
    
    void populateCBclasses(){
        ObservableList items = FXCollections.observableArrayList();
            for (classe ob : cl.getAllClasses()) {
                //System.out.println(ob.getClassegenerique().getNiveau().getCode()+" "+ob.getClassegenerique().getFiliere().getCode()+" "+ob.getClassegenerique().getCycle().getCode());
                //ClassMap.put();
                items.add(ob.getId_classe()+":"+ob.getClassegenerique().getNiveau().getCode()+" "+ob.getClassegenerique().getFiliere().getCode()+" "+ob.getClassegenerique().getCycle().getCode());
            }
            Classes.setItems(items);
    }
    
    void populateABSclasses(ComboBox cb){
        cb.getItems().clear();
        ObservableList items = FXCollections.observableArrayList();
        items.add("tous");
            for (classe ob : cl.getAllClasses()) {
                //System.out.println(ob.getClassegenerique().getNiveau().getCode()+" "+ob.getClassegenerique().getFiliere().getCode()+" "+ob.getClassegenerique().getCycle().getCode());
                //ClassMap.put();
                items.add(ob.getId_classe()+":"+ob.getClassegenerique().getNiveau().getCode()+" "+ob.getClassegenerique().getFiliere().getCode()+" "+ob.getClassegenerique().getCycle().getCode());
            }
        cb.setItems(items);
    }
    
    void populateAbsenceTableView(){
//        int id_classe = Integer.parseInt(AbsenceClasses.getSelectionModel().getSelectedItem().split(":")[0]);
//        System.out.println(id_classe);
//        if(AbsenceClasses.getSelectionModel().getSelectedItem()!= null ){
            AbsenceStudentID.setCellValueFactory(new PropertyValueFactory<>("id_etudiant"));
            AbsenceStudentFullName.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
            AbsenceStudentAbsCount.setCellValueFactory(new PropertyValueFactory<>("NbrAbs"));
            AbsenceStudentClass.setCellValueFactory(new PropertyValueFactory<>("nomClasse"));
            AbsenceStudentCheck.setCellValueFactory(new PropertyValueFactory<>("select"));
            AbcenseTableView.setItems(absence.CountAbsenceOfEachStudent(1));
//        }
        
    }
    
    
    void populateStudentTableView(){
        ObservableList students = etd.getAllStudents();
        Student_col_studentID.setCellValueFactory(new PropertyValueFactory<>("id_etudiant"));
        Student_col_Fname.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Student_col_Lname.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Student_col_BirthDay.setCellValueFactory(new PropertyValueFactory<>("dateNais"));
        Student_col_BirthPlace.setCellValueFactory(new PropertyValueFactory<>("lieuNais"));
        Student_col_Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        Student_col_Gender.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        Student_col_phone.setCellValueFactory(new PropertyValueFactory<>("tele"));
        Student_col_Class.setCellValueFactory(new PropertyValueFactory<>("nomClasse"));
        Student_tableView.setItems(students);
    }
    
    void populateStudentTableViewByClasse(){
        String selectedClass = Classes.getSelectionModel().getSelectedItem().toString();
        int id_classe = Integer.parseInt(selectedClass.split(":")[0]);
        if(selectedClass != null){
            ObservableList students = etd.getAllStudentsByClasse(id_classe);
            Student_col_studentID.setCellValueFactory(new PropertyValueFactory<>("id_etudiant"));
            Student_col_Fname.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            Student_col_Lname.setCellValueFactory(new PropertyValueFactory<>("nom"));
            Student_col_BirthDay.setCellValueFactory(new PropertyValueFactory<>("dateNais"));
            Student_col_BirthPlace.setCellValueFactory(new PropertyValueFactory<>("lieuNais"));
            Student_col_Email.setCellValueFactory(new PropertyValueFactory<>("email"));
            Student_col_Gender.setCellValueFactory(new PropertyValueFactory<>("sexe"));
            Student_col_phone.setCellValueFactory(new PropertyValueFactory<>("tele"));
            Student_col_Class.setCellValueFactory(new PropertyValueFactory<>("nomClasse"));
            Student_tableView.setItems(students);
        }
    }
    
    @FXML
    void populateByABSClass(ActionEvent event) {
        if(ABSComboBox.getSelectionModel().getSelectedItem().toString().equals("tous")){
            AbsenceChartDS();
            return;
        }
        String selectedClass = ABSComboBox.getSelectionModel().getSelectedItem().toString();
        int id_classe = Integer.parseInt(selectedClass.split(":")[0]);
        if(selectedClass != null && !selectedClass.equals("tous")){
            AbsenceChart.getData().clear();
            AbsenceChartDSByClasse(id_classe);
        }
    }
    
    @FXML
    void populateMarksByClasses(ActionEvent event) {
        if(CBMarksClass.getSelectionModel().getSelectedItem().toString().equals("tous")){
            MarksChart();
            return;
        }
        String selectedClass = CBMarksClass.getSelectionModel().getSelectedItem().toString();
        int id_classe = Integer.parseInt(selectedClass.split(":")[0]);
        if(selectedClass != null && !selectedClass.equals("tous")){
            MarksChart.getData().clear();
            MarksChartByClasse(id_classe);
        }
    }
    private String imagePath;
    @FXML
    void addTeacherImportBtn(ActionEvent event) {
        if(event.getSource() == addTeacher_importBtn){
            FileChooser open = new FileChooser();
            open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Open Image", "*.jpg", "*.jpeg", "*.png"));

            File file = open.showOpenDialog(addTeacher_importBtn.getScene().getWindow());

            if (file != null) {
                imagePath = file.getAbsolutePath();
                image = new Image(file.toURI().toString(), 100, 113, false, true);
                addTeacher_imageView.setImage(image);
            }
        }
    }
    
    @FXML
    void addTeacherAddBtn(ActionEvent event){
       if(event.getSource() == addTeacher_addBtn){
           if(!formValidate()){
               alert.errorMessage("Form Invalide");
               return;
           }
           String lname=addTeacher_lname.getText();
           String fname=addTeacher_fname.getText();
           String BirthDay= addTeacher_BirthDay.getValue().toString();
           DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
           DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
           LocalDate datenaissance = LocalDate.parse(BirthDay, inputFormatter);
           String formattedDate = datenaissance.format(outputFormatter);
//           System.out.println(datenaissance);
           String BirthPlace=addTeacher_BirthPlace.getText();
           String Email=addTeacher_Email.getText();
           String Phone=addTeacher_Phone.getText();
           String Gender;
           String speciality=addTeacher_speciality.getSelectionModel().getSelectedItem().toString();
           String cycle = addTeacher_cycle.getSelectionModel().getSelectedItem().toString();
           if(addTeacher_gender.getSelectionModel().getSelectedItem().toString().equals("Male")){
                Gender="M";
            }else{
                Gender="F";
            }
           int specialiteID= Integer.parseInt(speciality.split(":")[0]);
           int CycleID=Integer.parseInt(cycle.split(":")[0]);
           try {
               if(!tsh.ExistTeacher(lname, fname, Email)){
                   int userId = tsh.insert(new user(lname, fname, Email, formattedDate, BirthPlace, Phone, Gender, imagePath));
                   tsh.insert(new enseignant(new user(userId),new cycle(CycleID) , new specialite(specialiteID)));
                   alert.successMessage("L'enseignant est ajoute avec succes");
                   populateTeacherTableView();
               }else{
                   tsh.update(new user(Integer.parseInt(addTeacher_teacherID.getText()), lname, fname, Email, formattedDate, BirthPlace, Phone, Gender, imagePath));
                   tsh.update(new enseignant(new user(Integer.parseInt(addTeacher_teacherID.getText())),new cycle(Integer.parseInt(addTeacher_cycle.getSelectionModel().getSelectedItem().split(":")[0])), new specialite(Integer.parseInt(addTeacher_speciality.getSelectionModel().getSelectedItem().split(":")[0]))));
                   alert.successMessage("The Teacheer updated successfully");
                   addTeacherClearBtn();
                   Teacher_tableView.getItems().clear();
                   populateTeacherTableView();
               }
                
           } catch (Exception e) {
               alert.errorMessage(e.getMessage());
           }
           
       }
    }
    
    void populateCBGender(){
        ObservableList gender = FXCollections.observableArrayList();
        gender.add("Female");
        gender.add("Male");
        addTeacher_gender.setItems(gender);
    }
    
    void populateCBSpeciality(){
        ObservableList specialite =FXCollections.observableArrayList();;
        for (specialite ob : this.specialite.getAllSpecialite()) {
            specialite.add(ob.getId_specialite() +":"+ob.getNom());
        }
        addTeacher_speciality.setItems(specialite);
    }
    
    void populateCBCycle(){
        ObservableList List = FXCollections.observableArrayList();
        for (cycle ob : cycle.getAllCycles()) {
            List.add(ob.getId_cycle()+":"+ob.getNom());

        }
        addTeacher_cycle.setItems(List);
    }
        
    @FXML
    void ClearCombo(ActionEvent event) {
        if (event.getSource() == ClearComboBox) {
            Classes.getSelectionModel().clearSelection();
            populateStudentTableView();
            
        }
    }
    
    @FXML
    void PopulateByClasses(ActionEvent event) {
        if (event.getSource() == Classes) {
            populateStudentTableViewByClasse();
        }
    }
    
    private boolean isAddStudentWindowOpen = false;

    @FXML
    void addStudentAdd() {
        if (!isAddStudentWindowOpen) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddStudent.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Ajouter Etudiant");
                stage.setResizable(false);
                stage.show();

                isAddStudentWindowOpen = true;

                stage.setOnHidden(event -> {
                    isAddStudentWindowOpen = false;
                });
            } catch (Exception e) {
                e.printStackTrace();
                alert.errorMessage(e.getMessage());
            }
        }
    }

    @FXML
    void addStudentDeleteBtn(ActionEvent event) {
        if (event.getSource() == Student_deleteBtn){
            etudiant sData = (etudiant) Student_tableView.getSelectionModel().getSelectedItem();
            if (sData == null) {
                alert.errorMessage("S'il vous plaît, veuillez d'abord sélectionner un élément.");
                return;
            }
//            int num = sData.getId_etudiant();
            if (alert.confirmMessage("Êtes-vous sûr de vouloir supprimer l'étudiant ID : "+ sData.getNom() + " " +sData.getPrenom()+ " ?")) {
                try {
                    if(etd.delete(new user(sData.getNom(), sData.getPrenom(), sData.getEmail(), sData.getDateNais(), sData.getLieuNais(), sData.getTele(), sData.getSexe()))>0){
                        alert.successMessage("Supprimer avec succes!");
                        populateStudentTableView();
                    }
                } catch (Exception e) {
                    alert.errorMessage(e.getMessage());
                }
            }
        }
        

       
    }
    
    static etudiant selectedStudent = new etudiant();
    @FXML
    void addStudentUpdateBtn(ActionEvent event) {
        if (event.getSource() == Student_updateBtn){
            etudiant sData = (etudiant) Student_tableView.getSelectionModel().getSelectedItem();
            if (sData == null) {
                alert.errorMessage("Please select an item first");
                return;
            }
            int num = sData.getId_etudiant();
            selectedStudent = new etudiant(num, new user(sData.getNom(), sData.getPrenom(), sData.getEmail(), sData.getDateNais(), sData.getLieuNais(), sData.getTele(), sData.getSexe(), " "), new filiere(sData.getCode()), null);
            try {
                Parent root = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Modifier Etudiant");
                stage.setResizable(false);
                stage.setScene(new Scene(root));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
     @FXML
    void addStudentImportButton(ActionEvent event) {
        if(event.getSource() == Student_Import){
            FileChooser open = new FileChooser();
            open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Open Image", "*.xlsx" , "*.xls"));
            File file = open.showOpenDialog(Student_Import.getScene().getWindow());
            int userID;
            if (file != null) {
                try {
                    FileInputStream fis = new FileInputStream(file);
                    Workbook workbook = WorkbookFactory.create(fis);
                    Sheet sheet = workbook.getSheetAt(0);

                    // Assuming your Excel sheet has headers
                    Iterator<Row> rowIterator = sheet.iterator();
                    if (rowIterator.hasNext()) {
                        rowIterator.next();
                    }
                    while (rowIterator.hasNext()) {
                        Row currentRow = rowIterator.next();
                        Iterator<Cell> cellIterator = currentRow.iterator();
                        while (cellIterator.hasNext()) {
                            String Nom = cellIterator.next().getStringCellValue();
                            String Prenom = cellIterator.next().getStringCellValue();
                            String DateNais = cellIterator.next().getStringCellValue();
                            String  LieuNais=cellIterator.next().getStringCellValue();
                            String  Email= cellIterator.next().getStringCellValue();
                            String Sexe = cellIterator.next().getStringCellValue();
                            String Tele =cellIterator.next().getStringCellValue();
                            String Classe=cellIterator.next().getStringCellValue();
                            //System.out.println(Classe);
                            int Classe_id=cl.getClassByCycleNiveauFiliere(cycle.getcycleByCode(Classe.split(" ")[2]).getId_cycle(), niveau.getNiveauByCode(Classe.split(" ")[0]).getId_niveau(), filiere.getFiliereByCode(Classe.split(" ")[1]).getId_filiere()).getId_classe();
                            int filiere_id=filiere.getFiliereByCode(Classe.split(" ")[1]).getId_filiere();
                            userID=etd.insert(new user(Nom, Prenom, Email, DateNais, LieuNais, Tele, Sexe));
                            etd.insert(new etudiant(new user(userID), new filiere(filiere_id), new classe(Classe_id)));
                        }
 
                    }
                     workbook.close();
                        fis.close();
                        alert.successMessage("Les étudiants sont ajoutés aves succès");
                        populateStudentTableView();
                }catch(Exception e){
                    e.printStackTrace();
                    alert.errorMessage(e.getMessage());
                }
            }
    }
    }


    @FXML
    void addTeacherClearBtn() {
        addTeacher_teacherID.clear();
        addTeacher_fname.clear();
        addTeacher_lname.clear();
        addTeacher_BirthDay.setValue(null);
        addTeacher_BirthPlace.clear();
        addTeacher_Email.clear();
        addTeacher_Phone.clear();
        addTeacher_imageView.setImage(null);
        addTeacher_gender.getSelectionModel().clearSelection();
        addTeacher_speciality.getSelectionModel().clearSelection();
        addTeacher_cycle.getSelectionModel().clearSelection();
    }

    @FXML
    void addTeacherDeleteBtn(ActionEvent event) {
        enseignant sData = (enseignant) Teacher_tableView.getSelectionModel().getSelectedItem();
            if (sData == null) {
                alert.errorMessage("Please select an item first");
                return;
            }
//            int num = sData.getId_etudiant();
            if (alert.confirmMessage("Are you sure you want to Delete Teacher ID: "+ sData.getNom() + " " +sData.getPrenom()+ "?")) {
                try {
                    if(tsh.delete(new user(sData.getNom(), sData.getPrenom(), sData.getEmail(), sData.getDateNais(), sData.getLieuNais(), sData.getTele(), sData.getSexe()))>0){
                        alert.successMessage("Deleted successfully!");
                        populateTeacherTableView();
                    }
                } catch (Exception e) {
                    alert.errorMessage(e.getMessage());
                }
            }
    }
    
    @FXML
    void addTeacherUpdateBtn(ActionEvent event) {
        try {
            enseignant tshData = (enseignant) Teacher_tableView.getSelectionModel().getSelectedItem();
            if (tshData == null) {
                alert.errorMessage("Please select an item first");
                return;
            }
            int id_user =tsh.getUserByIdTeacher(Integer.parseInt(addTeacher_teacherID.getText())).getId_user();
            //System.out.println(id_user);
            String fname=addTeacher_fname.getText();
            //System.out.println(fname);
            String lname=addTeacher_lname.getText();
            //System.out.println(lname);
            LocalDate selectedDate = addTeacher_BirthDay.getValue();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dateNais= selectedDate.format(formatter);
            //System.out.println(dateNais);
            String LieuNais= addTeacher_BirthPlace.getText();
            //System.out.println(LieuNais);
            String Email = addTeacher_Email.getText();
            //System.out.println(Email);
            String Tele=addTeacher_Phone.getText();
            //System.out.println(Tele);
            String gender;
            if(addTeacher_gender.getSelectionModel().getSelectedItem().equals("Male")){
                gender = "M";
            }else{
                gender = "F";
            }
            //System.out.println(gender);
            Image image = addTeacher_imageView.getImage();
            String imageP= new String();
            if (image != null) {
                imageP = image.getUrl();
                System.out.println("Image Path: " + imagePath);
            }
            tsh.update(new user(id_user, lname, fname, Email, dateNais, LieuNais, Tele, gender, imageP));
            tsh.update(new enseignant(new user(id_user),new cycle(Integer.parseInt(addTeacher_cycle.getSelectionModel().getSelectedItem().split(":")[0])), new specialite(Integer.parseInt(addTeacher_speciality.getSelectionModel().getSelectedItem().split(":")[0]))));
            alert.successMessage("The Teacheer updated successfully");
            addTeacherClearBtn();
            Teacher_tableView.getItems().clear();
            populateTeacherTableView();
        } catch (Exception e) {
            alert.errorMessage(e.getMessage());
        }
    }
    
    boolean formValidate() {
        if (addTeacher_fname.getText().isEmpty() ||
            addTeacher_lname.getText().isEmpty() ||
            addTeacher_BirthDay.getValue() == null ||
            addTeacher_BirthPlace.getText().isEmpty() ||
            addTeacher_Email.getText().isEmpty() ||
            addTeacher_Phone.getText().isEmpty() ||
//            addTeacher_imageView.getImage() == null ||
            addTeacher_gender.getSelectionModel().isEmpty() ||
            addTeacher_speciality.getSelectionModel().isEmpty() ||
            addTeacher_cycle.getSelectionModel().isEmpty()) {
            return false;
        }
        return true;
    }
    
    void FillForm(enseignant Data){
        addTeacher_teacherID.setText(Data.getId_enseignant()+"");
        addTeacher_fname.setText(Data.getPrenom());
        addTeacher_lname.setText(Data.getNom());
        String dateString = Data.getDateNais(); // Example date string in yyyy-MM-dd format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        addTeacher_BirthDay.setValue(LocalDate.parse(dateString, formatter));
        addTeacher_BirthPlace.setText(Data.getLieuNais());
        addTeacher_Email.setText(Data.getEmail());
        addTeacher_Phone.setText(Data.getTele());
        System.out.println(Data.getPhoto());
//        image = new Image(Data.getPhoto(), 100, 113, false, true);
//        addTeacher_imageView.setImage(image);
        String gender;
        if(Data.getSexe().equals("M")){
            gender = "Male";
        }else{
            gender = "Female";
        }
        addTeacher_gender.getSelectionModel().select(gender);
        addTeacher_speciality.getSelectionModel().select(specialite.getSpecialiteByName(Data.getNomSpecialite()).getId_specialite()+":"+Data.getNomSpecialite());
        addTeacher_cycle.getSelectionModel().select(cycle.getcycleByName(Data.getNomCycle()).getId_cycle()+":"+Data.getNomCycle());
    }
    
    @FXML
    void addTeacherSelectItems(MouseEvent event) {
        addTeacherClearBtn();
        if(Teacher_tableView.getSelectionModel().getSelectedItem()!=null){
            enseignant tshData = (enseignant) Teacher_tableView.getSelectionModel().getSelectedItem();
            FillForm(tshData);
        }
    }

    
    
    @FXML
    void addStudentAddBtn(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addStudent_form.setVisible(false);
        addTeacher_form.setVisible(false);
        dashboard_form.setVisible(true);
        AbsenceForm.setVisible(false);
        affectClassesForm.setVisible(false);
        dashboard_CL.setText(cl.CountClasses()+"");
        dashboard_TS.setText(etd.CountStudents()+"");
        dashboard_TT.setText(tsh.countAllTeachers()+"");
        populateABSclasses(ABSComboBox);
        populateABSclasses(CBMarksClass);
        AbsenceChartDS();
        MarksChart();
//        Teacher_tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//            if (newSelection != null) {
//                FillForm((enseignant)newSelection);
//            }
//        });
    }

    

    
    @FXML
    void populateABSTableViewByClasse(ActionEvent event) {
        if(AbsenceClasses.getSelectionModel().getSelectedItem()!=null){
            if(AbsenceClasses.getSelectionModel().getSelectedItem().equals("tous")){
                AbcenseTableView.getSelectionModel().clearSelection();
            }else{
                int id_classe = Integer.parseInt(AbsenceClasses.getSelectionModel().getSelectedItem().split(":")[0]);
                AbsenceStudentID.setCellValueFactory(new PropertyValueFactory<>("id_etudiant"));
                AbsenceStudentFullName.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
                AbsenceStudentAbsCount.setCellValueFactory(new PropertyValueFactory<>("NbrAbs"));
                AbsenceStudentClass.setCellValueFactory(new PropertyValueFactory<>("nomClasse"));
                AbsenceStudentCheck.setCellValueFactory(new PropertyValueFactory<>("select"));
                AbcenseTableView.setItems(absence.CountAbsenceOfEachStudent(id_classe));
            }
        }
    }

   

    
    @FXML
    void logoutBtn(ActionEvent event) {
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
                newStage.setTitle("Page de Connexion");
                newStage.setResizable(false);
                newStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    @FXML
    void countAge(ActionEvent event) {

    }

    
    @FXML
    void aftClassesAddBtn(ActionEvent event) {
        if(aftClassesToTeacherListView.getSelectionModel().getSelectedItem()==null){
            alert.errorMessage("Veuillez Choisir un element");
            return;
        }
        System.out.println(aftClassesToTeacherListView.getSelectionModel().getSelectedItems());
        int id_enseignant = Integer.parseInt(aftTeachers.getSelectionModel().getSelectedItem().toString().split(":")[0]);
        for (String ob : aftClassesToTeacherListView.getSelectionModel().getSelectedItems()) {
            int id_classe=Integer.parseInt(ob.split(":")[0]);
            try{
                int seancegenerique = sg.insert(new seancegenerique(new enseignant(id_enseignant), new classe(id_classe)));
                //System.out.println(seancegenerique);
                sc.insert(new seance(new seancegenerique(seancegenerique)));   
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(aftClassesToTeacherListView.getSelectionModel().getSelectedItems()!=null){
            alert.successMessage("Les Classes sont affectee avec succes");
        }
        else{
            alert.successMessage("error");
        }
        populateAftTeachers();
    }
    @FXML
    void aftClassesDeleteBtn(ActionEvent event) {
        if(aftClassesListView.getSelectionModel().getSelectedItem()==null){
            alert.errorMessage("Veuillez Choisir un element");
            return;
        }
            
        int id_enseignant = Integer.parseInt(aftTeachers.getSelectionModel().getSelectedItem().toString().split(":")[0]);
        int id_classe=Integer.parseInt(aftClassesListView.getSelectionModel().getSelectedItem().toString().split(":")[0]);
        try {
            if(sg.delete(new seancegenerique(new enseignant(id_enseignant) , new classe(id_classe)))>0){
                alert.successMessage("La Classe est supprimee avec succes");
            }
        } catch (Exception e) {
            e.printStackTrace();
            alert.successMessage("error");
        }
        populateAftTeachers();
    }

    
        @FXML
    void AftSelectedClassesListView(MouseEvent event) {

    }

    @FXML
    void populateAftTeachers() {
        ObservableList list = FXCollections.observableArrayList();
        if(aftTeachers.getSelectionModel().getSelectedItem()!=null){
            int id_enseignant = Integer.parseInt(aftTeachers.getSelectionModel().getSelectedItem().toString().split(":")[0]);
            for (seance ob : sc.getSessionByTeacher(tsh.getUserByIdTeacher(id_enseignant).getId_user())) {
                list.add(ob.getSeancegenerique().getClasse().getId_classe()+":"+ob.getSeancegenerique().getClasse().getClassegenerique().getNiveau().getCode() +" "+ob.getSeancegenerique().getClasse().getClassegenerique().getFiliere().getCode() +" "+ob.getSeancegenerique().getClasse().getClassegenerique().getCycle().getCode());
            }
            aftClassesListView.setItems(list);
        }
        
        populateAaftTeachers();
    }
    
    void populateAaftTeachers(){
        aftClassesToTeacherListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObservableList list = FXCollections.observableArrayList();
        if(aftTeachers.getSelectionModel().getSelectedItem()!=null){
            int id_enseignant = Integer.parseInt(aftTeachers.getSelectionModel().getSelectedItem().toString().split(":")[0]);
            for (seancegenerique ob : sc.getNotSessionByTeacher(tsh.getUserByIdTeacher(id_enseignant).getId_user())) {
                list.add(ob.getClasse().getId_classe()+":"+ob.getClasse().getClassegenerique().getNiveau().getCode() +" "+ob.getClasse().getClassegenerique().getFiliere().getCode() +" "+ob.getClasse().getClassegenerique().getCycle().getCode());
            }
            aftClassesToTeacherListView.setItems(list);
        }
    }
    
   
    
    void populateAftTeachersComboBox(){
        ObservableList list = FXCollections.observableArrayList();
        for(enseignant item : tsh.getAllTeachers()){
            list.add(item.getId_enseignant()+":"+item.getPrenom()+" " +item.getNom());
        }
        aftTeachers.setItems(list);
    }
}
