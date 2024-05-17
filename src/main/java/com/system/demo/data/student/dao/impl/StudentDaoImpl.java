package com.system.demo.data.student.dao.impl;


import com.system.demo.data.student.dao.StudentDao;
import com.system.demo.data.utils.QueryConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.system.demo.appl.model.student.Student;
import com.system.demo.data.connection.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;

import static com.system.demo.data.utils.QueryConstant.GET_ALL_STUDENTS_STATEMENT;

public class StudentDaoImpl implements StudentDao {

    public static Logger LOGGER = LoggerFactory.getLogger(StudentDaoImpl.class);

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection con = ConnectionHelper.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(GET_ALL_STUDENTS_STATEMENT);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                students.add(setStudent(rs));
            }
            return students;

        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Student database is empty.");
        return students;
    }


    @Override
    public Student getStudentById(String studentNumber) {
        Student student = null;
        try (Connection con = ConnectionHelper.getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement(QueryConstant.GET_STUDENT_BY_STUDENT_ID_STATEMENT);
            preparedStatement.setString(1, studentNumber);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                LOGGER.debug("STUDENT retrieved successfully.");
                student = setStudent(rs);
            }
        } catch (Exception e) {
            LOGGER.error("Error retrieving Student with ID " + studentNumber + ": " + e.getMessage());
            e.printStackTrace();
        }
        LOGGER.debug("Student not found.");
        return student;
    }

    @Override
    public boolean addStudent(Student student) {

        try (Connection con = ConnectionHelper.getConnection()) {
            PreparedStatement statement = con.prepareStatement(QueryConstant.ADD_STUDENT_STATEMENT);
            statement.setString(1, student.getLastName());
            statement.setString(2, student.getFirstName());
            statement.setString(3, student.getMiddleName());
            statement.setDate(4, student.getBirthdate());
            statement.setString(5, student.getBirthplace());
            statement.setString(6, student.getSex());
            statement.setString(7, student.getCivil_status());
            statement.setString(8, student.getCitizenship());
            statement.setString(9, student.getReligion());
            statement.setString(10, student.getEmail());
            statement.setString(11, student.getAddress());
            statement.setString(12, student.getContactNumber());
            statement.setString(13, student.getStudentNumber());
            statement.setObject(14, student.getSectionId());
            int result = statement.executeUpdate();
            return result == 1 ? true : false;

        } catch (Exception e) {
            LOGGER.error("Error adding student failed " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Student> addStudents(ResultSet rs) {
        return addStudents(rs);
    }

    private Student setStudent(ResultSet rs) {
        try {
            Student student = new Student();
            student.setLastName(rs.getString("last_Name"));
            student.setFirstName(rs.getString("first_Name"));
            student.setMiddleName(rs.getString("middle_Name"));
            student.setBirthdate(rs.getDate("birthdate"));
            student.setBirthplace(rs.getString("birthplace"));
            student.setSex(rs.getString("sex"));
            student.setCivil_status(rs.getString("civil_Status"));
            student.setCitizenship(rs.getString("citizenship"));
            student.setReligion(rs.getString("religion"));
            student.setEmail(rs.getString("email"));
            student.setAddress(rs.getString("address"));
            student.setContactNumber(rs.getString("contact_Number"));
            student.setStudentNumber(rs.getString("student_Number"));
            student.setSectionId(rs.getInt("section_Section_Id"));
            return student;
        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("set Student failed.");
        return setStudent(rs);
    }

    @Override
    public boolean updateStudent(Student student) {
        try (Connection con = ConnectionHelper.getConnection()) {
            PreparedStatement statement = con.prepareStatement(QueryConstant.UPDATE_STATEMENT);
            statement.setInt(1, student.getId());
            statement.setString(2, student.getAddress());
            statement.setDate(3, student.getBirthdate());
            statement.setString(4, student.getBirthplace());
            statement.setString(5, student.getCitizenship());
            statement.setString(6, student.getCivil_status());
            statement.setString(7, student.getContactNumber());
            statement.setString(8, student.getEmail());
            statement.setString(9, student.getFirstName());
            statement.setString(10, student.getLastName());
            statement.setString(11, student.getMiddleName());
            statement.setString(12, student.getReligion());
            statement.setString(13, student.getSex());
            statement.setString(14, student.getStudentNumber());
            statement.setInt(15, student.getSectionId());

            int result = statement.executeUpdate();

            return result == 1;
        } catch (Exception e) {
            LOGGER.error("Error updating Student with ID " + student.getId() + ": " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Student> getStudentsByIdList(List<String> ids) {

        List<Student>studentList = new ArrayList<>();
        try (Connection con = new ConnectionHelper().getConnection()) {
            PreparedStatement statement = con.prepareStatement(QueryConstant.ADD_STUDENT_STATEMENT);
            for(int i=1; i<=ids.size(); i++) {
                statement.setString(i, ids.get(i-1));
            }
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                studentList.add(setStudent(rs));
            }

        } catch (SQLException ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        return studentList;
    }

}
