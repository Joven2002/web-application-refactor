package com.system.demo.data.student.dao;

import com.system.demo.appl.model.student.Student;

import java.sql.ResultSet;
import java.util.List;

public interface StudentDao {

    List<Student> getAllStudents();


    Student getStudentById(String studentNumber);


    boolean addStudent(Student student);

    List<Student> addStudents(ResultSet rs);

    List<Student> getStudentsByIdList(List<String> ids);

    boolean updateStudent(Student student) ;


}