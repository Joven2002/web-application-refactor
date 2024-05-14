package com.system.demo.appl.facade.cs_report;

import com.system.demo.appl.model.cs_report.CsReport;

import java.sql.ResultSet;
import java.util.List;

public interface CsReportFacade {
    List<CsReport> getAllCsReports();

    CsReport getCsReportById(Long id);

    boolean addCsReport(CsReport csReport);

    List<CsReport> addCsReports(ResultSet rs);

    boolean updateCsReport(CsReport csReport) ;


}
