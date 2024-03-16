package org.example.hosdemo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.lang.String;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SignInController {

    @FXML
    private TextField email;

    @FXML
    private Button logButton;

    @FXML
    private PasswordField passwrd;

    @FXML
    private Label wrongLogIn;

    @FXML
    private Button DoctorlogButton;

    @FXML
    private Button patientlogButton;

    @FXML
    public void onPatientLogClick(ActionEvent event) throws IOException {
        if(email.getText().isBlank()==false && passwrd.getText().isBlank()==false){
            PatientCheckLogin();
        }else{
            wrongLogIn.setText("Please enter username and password");
        }

    }
    @FXML
    void onDoctorLogClick(ActionEvent event) throws IOException {
        if(email.getText().isBlank()==false && passwrd.getText().isBlank()==false){
            DoctorCheckLogin();
        }else{
            wrongLogIn.setText("Please enter username and password");
        }
    }
    public void PatientCheckLogin() throws IOException{

        DBconnection connectNow=new DBconnection();
        Connection connect=connectNow.getConnection();

        String verifyLogin="Select count(1) from patient where pemail= '"+email.getText() + "' And ppassword='"+passwrd.getText()+"'";
          HelloApplication m = new HelloApplication();
          try{
              Statement statement=connect.createStatement();
              ResultSet queryResult=statement.executeQuery(verifyLogin);
              while(queryResult.next()) {
                  if (queryResult.getInt(1) == 1) {
                      wrongLogIn.setText("Successfully LoggedIn");
                      m.changeScene("patientappointment.fxml");
                  }
                  else{
                      wrongLogIn.setText("Invalid username or passord.Try again!");
                  }
              }
          }
          catch (Exception e){
              e.printStackTrace();
              e.getCause();
          }

    }
    public void DoctorCheckLogin(){
        DBconnection connectNow=new DBconnection();
        Connection connect=connectNow.getConnection();

        String verifyDoctorLogin="Select count(1) from doctor where demail= '"+email.getText() + "' And dpassword='"+passwrd.getText()+"'";
        HelloApplication m = new HelloApplication();
        try{
            Statement statement=connect.createStatement();
            ResultSet queryResult=statement.executeQuery(verifyDoctorLogin);
            while(queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    wrongLogIn.setText("Successfully LoggedIn");
                    m.changeScene("DoctorDashBoard.fxml");
                }
                else{
                    wrongLogIn.setText("Invalid username or password.Try again!");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void onDoctorSignUp() throws IOException{
        HelloApplication m=new HelloApplication();
        m.changeScene("Sign-Up.fxml");
    }
    public void onPatientSignUp() throws IOException{
        HelloApplication m=new HelloApplication();
        m.changeScene("PatientSignUp.fxml");
    }

}

