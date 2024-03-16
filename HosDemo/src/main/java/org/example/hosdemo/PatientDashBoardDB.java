package org.example.hosdemo;

import java.util.Date;

public class PatientDashBoardDB {
    int apt_id,doct_id,pat_id;
    String apt_slot,apt_status;
    Date apt_date;

    public int getApt_id() {
        return apt_id;
    }

    public void setApt_id(int apt_id) {
        this.apt_id = apt_id;
    }

    public int getPat_id() {
        return pat_id;
    }

    public void setPat_id(int pat_id) {
        this.pat_id = pat_id;
    }

    public int getDoct_id() {
        return doct_id;
    }

    public void setDoct_id(int doct_id) {
        this.doct_id = doct_id;
    }

    public String getApt_slot() {
        return apt_slot;
    }

    public void setApt_slot(String apt_slot) {
        this.apt_slot = apt_slot;
    }

    public String getApt_status() {
        return apt_status;
    }

    public void setApt_status(String apt_status) {
        this.apt_status = apt_status;
    }

    public Date getApt_date() {
        return apt_date;
    }

    public void setApt_date(Date apt_date) {
        this.apt_date = apt_date;
    }

    public PatientDashBoardDB(int apt_id, int pat_id, int doct_id, String apt_slot, String apt_status, Date apt_date) {
        this.apt_id = apt_id;
        this.pat_id= pat_id;
        this.doct_id = doct_id;
        this.apt_slot=apt_slot;
        this.apt_status=apt_status;
        this.apt_date=apt_date;
    }

}
