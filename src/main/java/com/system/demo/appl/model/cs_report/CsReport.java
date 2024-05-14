package com.system.demo.appl.model.cs_report;

import java.sql.Timestamp;
import java.util.Date;

public class CsReport {
    private Long Id;
    private Date dateOfCs;
    private Timestamp timeIn;
    private Timestamp timeOut;
    private int hoursCompleted;
    private String natureOfWork;
    private String status;
    private String remarks;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getDateOfCs() {
        return dateOfCs;
    }

    public void setDateOfCs(Date dateOfCs) {
        this.dateOfCs = dateOfCs;
    }

    public Timestamp getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Timestamp timeIn) {
        this.timeIn = timeIn;
    }

    public Timestamp getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Timestamp timeOut) {
        this.timeOut = timeOut;
    }

    public int getHoursCompleted() {
        return hoursCompleted;
    }

    public void setHoursCompleted(int hoursCompleted) {
        this.hoursCompleted = hoursCompleted;
    }

    public String getNatureOfWork() {
        return natureOfWork;
    }

    public void setNatureOfWork(String natureOfWork) {
        this.natureOfWork = natureOfWork;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    public CsReport(){

    }
}
