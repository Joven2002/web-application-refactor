package com.system.demo.appl.facade.student;

import com.system.demo.appl.model.student.Student;

import java.util.List;

public interface StudentFacade {

        List<Student> getAllStudents();

        Student getStudentById(String studentId);


    boolean addStudent(Student student);

        boolean updateStudent(Student student);



    }

