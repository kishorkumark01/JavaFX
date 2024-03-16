package org.example.hosdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;


public class PatientSignUpController  {

    @FXML
    private Button back1;

    @FXML
    private TextField editPatient_PatientID;

    @FXML
    private TextField editPatient_email;

    @FXML
    private TextField editPatient_fullName;

    @FXML
    private TextField editPatient_mobileNumber;

    @FXML
    private TextField editPatient_password;

    @FXML
    private Label signup_info;

    @FXML
    private Button editPatient_updateBtn;

    @FXML
    private DatePicker patient_dob;


    private PreparedStatement statement;
    @FXML
    public void onPatientSignUp(ActionEvent event) {

        DBconnection connectNow=new DBconnection();
        Connection connect=connectNow.getConnection();

      try{
          String query="INSERT INTO patient VALUES(?,?,?,?,?,?)";
          statement=connect.prepareStatement(query);
          int patientID = Integer.parseInt(editPatient_PatientID.getText());
          statement.setInt(1,patientID);
          statement.setString(2,editPatient_fullName.getText());
          statement.setString(3,editPatient_email.getText());
          statement.setString(4,editPatient_mobileNumber.getText());
          statement.setString(5,editPatient_password.getText());
          LocalDate dob = patient_dob.getValue();
          Date sqlDate = java.sql.Date.valueOf(dob);
          statement.setDate(6, sqlDate);

          statement.execute();

       } catch (SQLException e) {
         e.printStackTrace();
     }

    if(event.getSource() == editPatient_updateBtn){

        signup_info.setText("Signed Up!");
    }


    }
   public void onLogin() throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Signin.fxml");
   }





}
