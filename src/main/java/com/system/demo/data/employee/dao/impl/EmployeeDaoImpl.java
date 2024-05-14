package com.system.demo.data.employee.dao.impl;

import com.system.demo.appl.model.employee.Employee;
import com.system.demo.appl.model.station.Station;
import com.system.demo.data.connection.ConnectionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

import static com.system.demo.data.utils.QueryConstant.*;

public class EmployeeDaoImpl {


    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    /**
     * Constructor for EmployeeDaoImpl.
     * */
    public EmployeeDaoImpl() {
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = ConnectionHelper.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(GET_ALL_EMPLOYEE_STATEMENT);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getLong("id"));
                employee.setLastName(rs.getString("last_name"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setMiddleName(rs.getString("middle_name"));
                employee.setBirthdate(rs.getDate("birthdate"));
                employee.setBirthplace(rs.getString("birthplace"));
                employee.setSex(rs.getString("sex"));
                employee.setCivilStatus(rs.getString("civil_status"));
                employee.setCitizenship(rs.getString("citizenship"));
                employee.setReligion(rs.getString("religion"));
                employee.setHeight(rs.getDouble("height"));
                employee.setWeight(rs.getDouble("weight"));
                employee.setEmail(rs.getString("email"));
                employee.setAddress(rs.getString("address"));
                employee.setContactNumber(rs.getString("contact_number"));
                employee.setSssNo(rs.getString("sss_no"));
                employee.setTinNo(rs.getString("tin_no"));
                employee.setPagibigNo(rs.getString("pagibig_no"));
                employee.setEmployeeNumber(rs.getString("employee_number"));
                employee.setPositionInRc(rs.getString("position_in_rc"));
                employee.setDateEmployed(rs.getDate("date_employed"));
                employee.setStation((Station) rs.getObject("station"));
                employees.add(employee);
            }
            LOGGER.info("Employee retrieved successfully.");
        } catch (SQLException e) {
            LOGGER.warn("Error retrieving all Employees." + e.getMessage());
            e.printStackTrace();
        }
        LOGGER.debug("Employee database is empty.");
        return employees;
    }


    @Override
    public Employee getEmployeeById(Long id) {
        try (Connection connection = ConnectionHelper.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(GET_EMPLOYEE_BY_ID_STATEMENT);
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    LOGGER.debug("Employee retrieved successfully.");
                    return setEmployee(rs);
                }
            }
        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Employee not found.");
        return null;
    }


    @Override
    public boolean addEmployee(Employee employee) {
        try (Connection connection = ConnectionHelper.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(ADD_EMPLOYEE_STATEMENT);
            stmt.setLong(1, employee.getId());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getFirstName());
            stmt.setString(4, employee.getMiddleName());
            stmt.setDate(5, employee.getBirthdate());
            stmt.setString(6, employee.getBirthplace());
            stmt.setString(7, employee.getSex());
            stmt.setString(8, employee.getCivilStatus());
            stmt.setString(9, employee.getCitizenship());
            stmt.setString(10, employee.getReligion());
            stmt.setDouble(11, employee.getHeight());
            stmt.setDouble(12, employee.getWeight());
            stmt.setString(13, employee.getEmail());
            stmt.setString(14, employee.getAddress());
            stmt.setString(15, employee.getContactNumber());
            stmt.setString(16, employee.getSssNo());
            stmt.setString(17, employee.getTinNo());
            stmt.setString(18, employee.getPagibigNo());
            stmt.setString(19, employee.getEmployeeNumber());
            stmt.setString(20, employee.getPositionInRc());
            stmt.setDate(21, employee.getDateEmployed());
            stmt.setObject(22, employee.getStation());

            int result = stmt.executeUpdate();
            return result == 1;
        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Adding employee failed.");
        return false;
    }


    @Override
    public boolean updateEmployee(Employee employee) {
        try (Connection connection = ConnectionHelper.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(UPDATE_STATEMENT);
            stmt.setLong(1, employee.getId());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getFirstName());
            stmt.setString(4, employee.getMiddleName());
            stmt.setDate(5, employee.getBirthdate());
            stmt.setString(6, employee.getBirthplace());
            stmt.setString(7, employee.getSex());
            stmt.setString(8, employee.getCivilStatus());
            stmt.setString(9, employee.getCitizenship());
            stmt.setString(10, employee.getReligion());
            stmt.setDouble(11, employee.getHeight());
            stmt.setDouble(12, employee.getWeight());
            stmt.setString(13, employee.getEmail());
            stmt.setString(14, employee.getAddress());
            stmt.setString(15, employee.getContactNumber());
            stmt.setString(16, employee.getSssNo());
            stmt.setString(17, employee.getTinNo());
            stmt.setString(18, employee.getPagibigNo());
            stmt.setString(19, employee.getEmployeeNumber());
            stmt.setString(20, employee.getPositionInRc());
            stmt.setDate(21, employee.getDateEmployed());
            stmt.setObject(22, employee.getStation());

            int result = stmt.executeUpdate();
            return result == 1;
        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Updating employee failed.");
        return false;
    }


    private Employee setEmployee(ResultSet rs) {
        try {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setLastName(rs.getString("last_name"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setMiddleName(rs.getString("middle_name"));
            employee.setBirthdate(rs.getDate("birthdate"));
            employee.setBirthplace(rs.getString("birthplace"));
            employee.setSex(rs.getString("sex"));
            employee.setCivilStatus(rs.getString("civil_status"));
            employee.setCitizenship(rs.getString("citizenship"));
            employee.setReligion(rs.getString("religion"));
            employee.setHeight(rs.getDouble("height"));
            employee.setWeight(rs.getDouble("weight"));
            employee.setEmail(rs.getString("email"));
            employee.setAddress(rs.getString("address"));
            employee.setContactNumber(rs.getString("contact_number"));
            employee.setSssNo(rs.getString("sss_no"));
            employee.setTinNo(rs.getString("tin_no"));
            employee.setPagibigNo(rs.getString("pagibig_no"));
            employee.setEmployeeNumber(rs.getString("employee_number"));
            employee.setPositionInRc(rs.getString("position_in_rc"));
            employee.setDateEmployed(rs.getDate("date_employed"));
            employee.setStation((Station) rs.getObject("station"));
            return employee;
        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("No employee was set.");
        return null;
    }}
