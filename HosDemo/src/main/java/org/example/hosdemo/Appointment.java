package org.example.hosdemo;

public class Appointment {
    public int getApoid() {
        return apoid;
    }

    public String getPatientname() {
        return patientname;
    }

    private int apoid;

    public String getApdate() {
        return apdate;
    }

    public String getApstatus() {
        return apstatus;
    }

    public String getSlot() {
        return slot;
    }

    private String patientname;
    private String slot;
    private String apstatus;
    private String apdate;



    public Appointment(int apoid, String patientname, String slot, String apstatus, String apdate) {
        this.apoid = apoid;
        this.patientname=patientname;
        this.slot=slot;
        this.apstatus=apstatus;
        this.apdate=apdate;
    }
}
