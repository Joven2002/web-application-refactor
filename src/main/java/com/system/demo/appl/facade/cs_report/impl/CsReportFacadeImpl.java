package com.system.demo.appl.facade.cs_report.impl;

import com.system.demo.appl.facade.cs_report.CsReportFacade;
import com.system.demo.appl.model.cs_report.CsReport;

import java.sql.ResultSet;
import java.util.List;

public class CsReportFacadeImpl implements CsReportFacade {
    private CsReportDao csReportDao;
    public CsReportFacadeImpl(CsReportDao csReportDao) {
        this.csReportDao = csReportDao;
    }

    @Override
    public List<CsReport> getAllCsReports() { return csReportDao.getAllCsReports();
    }

    @Override
    public CsReport getCsReportById(Long id) {
        return null;
    }

    @Override
    public boolean addCsReport(CsReport csReport) {
        return false;
    }

    @Override
    public List<CsReport> addCsReports(ResultSet rs) {
        return null;
    }

    @Override
    public boolean updateCsReport(CsReport csReport) {
        return false;
    }
}
