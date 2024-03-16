package org.example.hosdemo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class patientAppointmentRequest implements Initializable {


    @FXML
    private Button back4;

    @FXML
    private Button cancel_btn;

    @FXML
    private TableColumn<Appointment, Integer> col_apid;

    @FXML
    private TableColumn<Appointment, String> col_date;

    @FXML
    private TableColumn<Appointment, String> col_pname;

    @FXML
    private TableColumn<Appointment, String> col_slot;

    @FXML
    private TableColumn<Appointment, String> col_status;

    @FXML
    private TextField p_apid;

    @FXML
    private TextField p_date;

    @FXML
    private TextField p_name;

    @FXML
    private TextField p_slot;



    @FXML
    private Button request_btn;

    @FXML
    private TableView<Appointment> tvPatientAp;

    @FXML
    void onCancelClicked(ActionEvent event) {
           if(event.getSource() == cancel_btn){
               deleteRecord();
           }
    }

    @FXML
    void onPatientAppointmentBack(ActionEvent event) throws IOException {
             HelloApplication m=new HelloApplication();
             m.changeScene("PatientDashBoard.fxml");
    }

    @FXML
    void onRequestClicked(ActionEvent event) {
           if(event.getSource() == request_btn){
               insertRecord();
           }
    }

    public ObservableList<Appointment> getAppointmentList(){
        ObservableList<Appointment> appointmentList= FXCollections.observableArrayList();
        DBconnection connectNow=new DBconnection();
        Connection connection=connectNow.getConnection();
        String query="SELECT * FROM appointmentTable";
        Statement st;
        ResultSet rs;
        try{
            st= connection.createStatement();
            rs=st.executeQuery(query);
            Appointment appointments;
            while(rs.next()){
                appointments=new Appointment(rs.getInt("apoid"),rs.getString("patientname"),rs.getString("slot"),rs.getString("apstatus"),rs.getString("apdate"));
                appointmentList.add(appointments);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return appointmentList;
    }
        public void showAppointment(){
           ObservableList<Appointment> list=getAppointmentList();
           col_apid.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("apoid"));
           col_pname.setCellValueFactory(new PropertyValueFactory<Appointment,String>("patientname"));
           col_slot.setCellValueFactory(new PropertyValueFactory<Appointment,String>("slot"));
           col_status.setCellValueFactory(new PropertyValueFactory<Appointment,String>("apstatus"));
           col_date.setCellValueFactory(new PropertyValueFactory<Appointment,String>("apdate"));

           tvPatientAp.setItems(list);
        }

        public void insertRecord(){
             String  query= "INSERT INTO appointmentTable VALUES (" + p_apid.getText() + ",'" + p_name.getText() + "','" + p_slot.getText() + "','" + "Pending" + "','" + p_date.getText() + "')";
            executeQuery(query);
             showAppointment();
        }

        public void deleteRecord(){
          String query = "DELETE FROM appointmentTable WHERE apoid = " + p_apid.getText() + " ";
          executeQuery(query);
          showAppointment();
        }

        public void executeQuery(String query){
            DBconnection connectNow=new DBconnection();
            Connection connection=connectNow.getConnection();
            Statement st;
            try{
                st = connection.createStatement();
                st.executeUpdate(query);
            }catch (Exception e){
                 e.printStackTrace();
            }
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showAppointment();
    }
}
