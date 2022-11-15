module com.java.studentmanagerfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.java.studentmanagerfx to javafx.fxml;
    exports com.java.studentmanagerfx;
}