package com.system.demo.appl.model.violation;

import com.system.demo.appl.model.employee.Employee;
import com.system.demo.appl.model.offense.Offense;
import com.system.demo.appl.model.student.Student;

import java.util.Date;
import java.util.List;

public class Violation {
    private Long Id;
    private Date dateOfNotice;
     private Student student;
    private Offense offense;
    private int warningNumber;
    private int csHours;
    private String disciplinaryAction;
    private Employee approvedBy;
    private List<Employee> notedBy;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getDateOfNotice() {
        return dateOfNotice;
    }

    public void setDateOfNotice(Date dateOfNotice) {
        this.dateOfNotice = dateOfNotice;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Offense getOffense() {
        return offense;
    }

    public void setOffense(Offense offense) {
        this.offense = offense;
    }

    public int getWarningNumber() {
        return warningNumber;
    }

    public void setWarningNumber(int warningNumber) {
        this.warningNumber = warningNumber;
    }

    public int getCsHours() {
        return csHours;
    }

    public void setCsHours(int csHours) {
        this.csHours = csHours;
    }

    public String getDisciplinaryAction() {
        return disciplinaryAction;
    }

    public void setDisciplinaryAction(String disciplinaryAction) {
        this.disciplinaryAction = disciplinaryAction;
    }

    public List<Employee> getNotedBy() {
        return notedBy;
    }

    public void setNotedBy(List<Employee> notedBy) {
        this.notedBy = notedBy;
    }

    public Employee getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Employee approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Violation(){

    }

}
