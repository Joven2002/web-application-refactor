package com.system.demo.data.student.dao;

import com.system.demo.appl.model.student.Student;

import java.sql.ResultSet;
import java.util.List;

public interface StudentDao {

    List<Student> getAllStudents();


    Student getStudentById(Long id);


    boolean addStudent(Student student);

    List<Student> addStudents(ResultSet rs);


    boolean updateStudent(Student student) ;


    Student findStudentByEmail(String email);

}
