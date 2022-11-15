package com.java.studentmanagerfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    DBManager manager;

    //region FXML variables
    @FXML
    private AnchorPane anchPanel;

    @FXML
    private Button btnAddnewstudent;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSave;

    @FXML
    private ComboBox<String> cmbGender;

    @FXML
    private DatePicker datpickBirthdate;

    @FXML
    private ImageView imvPhoto;

    @FXML
    private Label lblAverage;

    @FXML
    private Label lblBirthdate;

    @FXML
    private Label lblComments;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblGender;

    @FXML
    private Label lblListofstudents;

    @FXML
    private Label lblMark;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPhoto;

    @FXML
    private Label lblStudentdetails;

    @FXML
    private ListView<Student> lvListofstudents;

    @FXML
    private TextField  txtAverage;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtMark;

    @FXML
    private TextField txtName;

    @FXML
    private TextArea txtareaComments;
    //endregion FXML variables

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        manager = new DBManager();

        //region Gender
        List<String> gvalues = new ArrayList<String>();
        gvalues.add("Male");
        gvalues.add("Female");
        ObservableList<String> gender = FXCollections.observableArrayList(gvalues);
        cmbGender.setItems(gender);
        //endregion Gender

        //region Students list
        List<Student> hardStudents = new ArrayList<>();
        hardStudents.add(new Student(1, "lolo", "female"));
        hardStudents.add(new Student(2, "lili", "male"));
        ObservableList<Student> students = FXCollections.observableArrayList(hardStudents);
        lvListofstudents.setItems(students);

        fetchStudents();

        lvListofstudents.getSelectionModel().selectedItemProperty().addListener(e -> displayStudentDetails(lvListofstudents.getSelectionModel().getSelectedItem()));
        //endregion Students list
    }

    private void displayStudentDetails(Student selectedStudent) {
        if (selectedStudent != null) {
            txtName.setText(selectedStudent.getName());
            cmbGender.setValue(selectedStudent.getGender());
        }
    }

    public void onNew(){
        lvListofstudents.getSelectionModel().clearSelection();
        this.txtName=null;
        this.cmbGender.setValue(null);
    }

    public void onCancel(){
        lvListofstudents.getSelectionModel().selectFirst();
    }

    public void onSave() {
        Student s= new Student( txtName.getText(),cmbGender.getValue());
        manager.addStudent(s);
        fetchStudents();
    }

    public void fetchStudents() {
        List<Student> listStudents = manager.loadStudents();
        if (listStudents != null) {
            ObservableList<Student> students;
            students = FXCollections.observableArrayList(listStudents);
            lvListofstudents.setItems(students);
        }
    }
}