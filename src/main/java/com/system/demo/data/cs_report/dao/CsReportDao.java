package com.system.demo.data.cs_report.dao;

import com.system.demo.appl.model.cs_report.CsReport;
import com.system.demo.appl.model.student.Student;

import java.sql.ResultSet;
import java.util.List;

public interface CsReportDao {

    List<CsReport> getAllCsReports();

    Student getCsReportById(Long id);

    boolean addCsReport(CsReport csReport);

    List<CsReport> addCsReports(ResultSet rs);

    boolean updateCsReport(CsReport csReport) ;

}
