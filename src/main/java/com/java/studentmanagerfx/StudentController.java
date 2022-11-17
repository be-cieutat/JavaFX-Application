package com.java.studentmanagerfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
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
    private Label lblAverageValue;

    @FXML
    private Label lblCount;

    @FXML
    private Label lblCountValue;

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
    private Label lblWarning;

    @FXML
    private Label lblWarningdate;

    @FXML
    private Label lblStudentdetails;

    @FXML
    private ListView<Student> lvListofstudents;

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
        gvalues.add("male");
        gvalues.add("female");
        gvalues.add("other");
        ObservableList<String> gender = FXCollections.observableArrayList(gvalues);
        cmbGender.setItems(gender);
        //endregion Gender

        //region hardcode Students list
        List<Student> hardStudents = new ArrayList<>();
        hardStudents.add(new Student("Boyan", "lolo", "boyan@cooldude.bg", LocalDate.parse("2020-01-08"), "https://post.medicalnewstoday.com/wp-content/uploads/sites/3/2020/02/322868_1100-800x825.jpg",4.3,"Boyan is a cool dude"));
        hardStudents.add(new Student("1", "lili", "male"));
        ObservableList<Student> students = FXCollections.observableArrayList(hardStudents);
        lvListofstudents.setItems(students);

        fetchStudents();

        lvListofstudents.getSelectionModel().selectedItemProperty().addListener(e -> {
            try {
                displayStudentDetails(lvListofstudents.getSelectionModel().getSelectedItem());
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        //endregion Students list

        //region buttonDisable
        btnSave.setDisable(true);
        btnDelete.setDisable(true);
        btnCancel.setDisable(true);
        //endregion buttonDisable

        //region fieldDisable
        txtName.setDisable(true);
        cmbGender.setDisable(true);
        txtEmail.setDisable(true);
        txtMark.setDisable(true);
        txtareaComments.setDisable(true);
        datpickBirthdate.setDisable(true);
        //endregion fieldDisable

        lblWarning.setVisible(false);
        lblWarningdate.setVisible(false);
        lblUpdate();
    }

    private void displayStudentDetails(Student selectedStudent) throws MalformedURLException, FileNotFoundException {
        if (selectedStudent != null) {
            txtName.setText(selectedStudent.getName());
            cmbGender.setValue(selectedStudent.getGender());
            txtEmail.setText(selectedStudent.getEmail());
            datpickBirthdate.setValue(selectedStudent.getBirthDate());
            txtareaComments.setText(selectedStudent.getComments());
            txtMark.setText(String.valueOf(selectedStudent.getMark()));
            //System.out.println(selectedStudent.getPhoto());
            Image image = new Image(selectedStudent.getPhoto());
            imvPhoto.setImage(image);
        }
    }

    public void onNew(){

        lvListofstudents.getSelectionModel().clearSelection();
        txtName.setText("");
        this.cmbGender.setValue(null);
        this.txtEmail.setText("");
        this.txtMark.setText("0");
        this.datpickBirthdate.setValue(LocalDate.parse("1980-01-01"));
        Image image = new Image("https://clipartmag.com/images/outline-of-person-2.png");
        this.imvPhoto.setImage(image);
        this.txtareaComments.setText("");

        //region buttonDisable
        btnEdit.setDisable(true);
        btnSave.setDisable(false);
        btnDelete.setDisable(true);
        btnCancel.setDisable(false);
        //endregion buttonDisable

        //region fieldDisable
        txtName.setDisable(false);
        cmbGender.setDisable(false);
        txtEmail.setDisable(false);
        txtMark.setDisable(false);
        txtareaComments.setDisable(false);
        datpickBirthdate.setDisable(false);
        //endregion fieldDisable

        fetchStudents();
    }

    public void onEdit(){

        //region buttonDisable
        btnAddnewstudent.setDisable(true);
        btnCancel.setDisable(false);
        btnDelete.setDisable(false);
        btnSave.setDisable(false);
        //endregion buttonDisable

        //region fieldDisable
        txtName.setDisable(false);
        cmbGender.setDisable(false);
        txtEmail.setDisable(false);
        txtMark.setDisable(false);
        txtareaComments.setDisable(false);
        datpickBirthdate.setDisable(false);
        //endregion fieldDisable

    }

    public void onDelete(){
        manager.delStudent(lvListofstudents.getSelectionModel().getSelectedItem());
        fetchStudents();
        onCancel();
        lblUpdate();

    }

    public void onCancel(){
        lvListofstudents.getSelectionModel().selectFirst();

        //region buttonDisable
        btnSave.setDisable(true);
        btnEdit.setDisable(false);
        btnAddnewstudent.setDisable(false);
        btnDelete.setDisable(true);
        btnCancel.setDisable(true);
        //endregion buttonDisable

        //region fieldDisable
        txtName.setDisable(true);
        cmbGender.setDisable(true);
        txtEmail.setDisable(true);
        txtMark.setDisable(true);
        txtareaComments.setDisable(true);
        datpickBirthdate.setDisable(true);
        //endregion fieldDisable

        lblWarning.setVisible(false);
        lblWarningdate.setVisible(false);
        lblUpdate();

    }

    public void onSave() {
        if (txtName.getText().isEmpty() == false && txtName.getText() != "" && cmbGender.getValue() != null ){
            if(datpickBirthdate.getValue().isBefore(LocalDate.parse("2001-01-01") ) && datpickBirthdate.getValue().isAfter(LocalDate.parse("1979-12-31") )){
                if (btnAddnewstudent.isDisabled() == true){
                    manager.delStudent(lvListofstudents.getSelectionModel().getSelectedItem());
                }
                Student s = new Student(txtName.getText(),cmbGender.getValue(),txtEmail.getText(),datpickBirthdate.getValue(),imvPhoto.getImage().getUrl(), Double.parseDouble(txtMark.getText()),txtareaComments.getText());
                manager.addStudent(s);
                fetchStudents();

                //region buttonDisable
                btnSave.setDisable(true);
                btnEdit.setDisable(false);
                btnAddnewstudent.setDisable(false);
                btnDelete.setDisable(true);
                btnCancel.setDisable(true);
                lblWarning.setVisible(false);
                lblWarningdate.setVisible(false);
                //endregion buttonDisable
            }
            else{
                lblWarningdate.setVisible(true);
            }

        }
        else{
            lblWarning.setVisible(true);

        }

        lblUpdate();
    }

    public void fetchStudents() {
        List<Student> listStudents = manager.loadStudents();
        if (listStudents != null) {
            ObservableList<Student> students;
            students = FXCollections.observableArrayList(listStudents);
            lvListofstudents.setItems(students);
        }
    }

    public void lblUpdate(){
        DecimalFormat df = new DecimalFormat("0.00");
        lblAverageValue.setText(String.valueOf(df.format(manager.avgMarkStudents())));
        lblCountValue.setText(String.valueOf(manager.countStudents()));
    }

}

