package org.example.hosdemo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class Patientdashboard implements Initializable {

    @FXML
    private TableColumn<PatientDashBoardDB, Date> apt_date;

    @FXML
    private TableColumn<PatientDashBoardDB, Integer> apt_id;

    @FXML
    private TableColumn<PatientDashBoardDB, String> apt_slot;

    @FXML
    private TableColumn<PatientDashBoardDB, String> apt_status;

    @FXML
    private Button back2;

    @FXML
    private Button book;

    @FXML
    private TableColumn<PatientDashBoardDB, Integer> doct_id;

    @FXML
    private TableColumn<PatientDashBoardDB, Integer> pat_id;

    @FXML
    void onBookAppointment(ActionEvent event) throws IOException {
               HelloApplication m=new HelloApplication();
               m.changeScene("patientappointment.fxml");
    }
        public void onPatientDashBoardBackClicked() throws IOException {
             HelloApplication m = new HelloApplication();
             m.changeScene("Signin.fxml");
        }

        ObservableList<PatientDashBoardDB> list= FXCollections.observableArrayList(

        );
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
