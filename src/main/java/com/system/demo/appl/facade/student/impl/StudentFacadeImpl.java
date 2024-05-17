package com.system.demo.appl.facade.student.impl;

import com.system.demo.appl.facade.student.StudentFacade;
import com.system.demo.appl.model.student.Student;
import com.system.demo.data.student.dao.StudentDao;

import java.util.List;

public class StudentFacadeImpl implements StudentFacade {

    private StudentDao studentDao;
    public StudentFacadeImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudents() { return studentDao.getAllStudents(); }


    @Override
    public Student getStudentById(String studentNumber) {
        return studentDao.getStudentById(studentNumber);
    }

    @Override
    public boolean addStudent(Student student) {
        boolean result = false;
        try {
            Student targetStudent = getStudentById(student.getStudentNumber());
            if(targetStudent != null) {
                throw new Exception("Student to add already exists. ");
            }
            result = studentDao.addStudent(student);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean updateStudent(Student student) {
        boolean result = false;
        try {
            Student targetStudent = getStudentById(student.getStudentNumber());
            if (targetStudent == null) {
                throw new Exception("Student to update not found. ");
            }
            result = studentDao.updateStudent(student);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }


}
