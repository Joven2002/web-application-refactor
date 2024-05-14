package com.system.demo.appl.model.cs_slip;

import com.system.demo.appl.model.violation.Violation;
import com.system.demo.appl.model.cs_report.CsReport;
import com.system.demo.appl.model.station.Station;
import com.system.demo.appl.model.student.Student;

import java.util.List;

public class CsSlip {
    private Long id;

    private Student student;
    private String reasonOfCs;

    private Station areaOfCommServ;

    private List<CsReport> reports;

    private List<Violation> violations;
    private int deduction;

    public int getHoursRequired() {
        int totalCsHours = violations.stream().mapToInt(Violation::getCsHours).sum();
        return totalCsHours - deduction;

    }
}
