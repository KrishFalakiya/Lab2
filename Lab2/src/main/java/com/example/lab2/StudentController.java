import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class StudentController {
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField majorField;

    private ObservableList<Student> studentList = FXCollections.observableArrayList();

    @FXML
    private void addStudent(ActionEvent event) {
        if (idField.getText().isEmpty() || nameField.getText().isEmpty() || majorField.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all fields before adding a student.");
            alert.showAndWait();
            return;
        }

        Student newStudent = new Student(idField.getText(), nameField.getText(), majorField.getText());
        studentList.add(newStudent);
        idField.clear();
        nameField.clear();
        majorField.clear();
    }

    @FXML
    private void deleteStudent(ActionEvent event) {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            studentList.remove(selectedStudent);
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please select a student to delete.");
            alert.showAndWait();
        }
    }

    @FXML
    public void initialize() {
        TableColumn<Student, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, String> majorColumn = new TableColumn<>("Major");
        majorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));

        studentTable.getColumns().addAll(idColumn, nameColumn, majorColumn);
        studentTable.setItems(studentList);
    }
}
