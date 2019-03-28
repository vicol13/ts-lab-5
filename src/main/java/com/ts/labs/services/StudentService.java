package com.ts.labs.services;

import com.ts.labs.exceptions.NoSuchStudentException;
import com.ts.labs.pojo.Student;

import java.util.List;

/**
 *  Student service Interface
 *
 */
public interface StudentService {
     boolean modifyStudent(int id , Student student) throws NoSuchStudentException;

     Student getStudent(int id) throws NoSuchStudentException;

     List<Student> getStudents();

     boolean removeStudent(int id) throws NoSuchStudentException;

     boolean addStudent(Student student);
}
