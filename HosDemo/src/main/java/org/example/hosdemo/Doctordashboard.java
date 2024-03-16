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

public class Doctordashboard implements Initializable {

    @FXML
    private Button accept_btn;

    @FXML
    private Button back3;

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
    private TextField doc_apid;

    @FXML
    private TextField doc_date;

    @FXML
    private TextField doc_slot;


    @FXML
    private Button reject_btn;

    @FXML
    private TableView<Appointment> tvPatientAp;

    @FXML
   public void onAcceptClicked(ActionEvent event) {
         if(event.getSource()==accept_btn) {
             acceptupdateRecord();
         }
    }

    @FXML
    public void onRejectClicked(ActionEvent event) {
           if(event.getSource()==reject_btn){
               rejectupdateRecord();
           }
    }
    public void onDoctorDashBoardBack() throws IOException {
        HelloApplication m=new HelloApplication();
        m.changeScene("Signin.fxml");
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

    public void acceptupdateRecord(){
        String query = "UPDATE appointmentTable SET slot = '" + doc_slot.getText() +"', apstatus = '" + "Accepted" +"', apdate = '" + doc_date.getText() + "' WHERE apoid = "+ doc_apid.getText() + " ";
        executeQuery(query);
        showAppointment();
    }

    public void rejectupdateRecord(){
        String query = "UPDATE appointmentTable SET slot = '" + doc_slot.getText() +"', apstatus = '" + "Rejected" +"', apdate = '" + doc_date.getText() + "' WHERE apoid = "+ doc_apid.getText() + " ";
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

