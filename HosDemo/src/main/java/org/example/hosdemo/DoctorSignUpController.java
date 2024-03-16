package org.example.hosdemo;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.*;
import java.time.LocalDate;

public class DoctorSignUpController {

    @FXML
    private TextField editDoctor_doctorID;

    @FXML
    private TextField editDoctor_email;

    @FXML
    private TextField editDoctor_fullName;

    @FXML
    private TextField editDoctor_mobileNumber;

    @FXML
    private TextField editDoctor_password;

    @FXML
    private TextField editDoctor_specialized;

    @FXML
    private Button editDoctor_updateBtn;

    @FXML
    private DatePicker enddate;

    @FXML
    private DatePicker startdate;

    @FXML
    private Button back;

    @FXML
    private Label doc_signup_info;

    private PreparedStatement statement;

    @FXML
   public void onDoctorSignUp(ActionEvent event) throws IOException {
        DBconnection connectNow=new DBconnection();
        Connection connect=connectNow.getConnection();
        try{
            String query="INSERT INTO doctor VALUES(?,?,?,?,?,?,?,?)";
            statement=connect.prepareStatement(query);
            int doctorID = Integer.parseInt(editDoctor_doctorID.getText());
            statement.setInt(1,doctorID);
            statement.setString(2,editDoctor_fullName.getText());
            statement.setString(3,editDoctor_email.getText());
            statement.setString(4,editDoctor_mobileNumber.getText());
            statement.setString(5,editDoctor_specialized.getText());
            statement.setString(6,editDoctor_password.getText());
            LocalDate sd = startdate.getValue();
            Date sqlDate = java.sql.Date.valueOf(sd);
            statement.setDate(7, sqlDate);

            LocalDate ed = enddate.getValue();
            Date sqlDate1 = java.sql.Date.valueOf(ed);
            statement.setDate(8, sqlDate1);

            statement.execute();


        }catch(Exception e){
            e.printStackTrace();
        }

        if(event.getSource() == editDoctor_updateBtn){
            doc_signup_info.setText("Signed Up!");
        }

    }

    @FXML
    public void userLogOut(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Signin.fxml");
    }

}

