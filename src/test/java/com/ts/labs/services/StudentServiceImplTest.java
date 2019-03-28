package com.ts.labs.services;

import com.ts.labs.LabsApplication;
import com.ts.labs.exceptions.NoSuchStudentException;
import com.ts.labs.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LabsApplication.class)

public class StudentServiceImplTest {

    @Autowired
    StudentService service;

    @Test(expected = NoSuchStudentException.class)
    public void getStudent() throws NoSuchStudentException {
        service.getStudent(-1);
    }

    @Test
    public void modifyStudent() throws NoSuchStudentException {
        Student temp = service.getStudent(1);
        Student temp2 = new Student("name","surname","1","Ion Vasile");
        service.modifyStudent(1,temp2);
        assertNotEquals(temp,service.getStudent(1));
    }

    @Test
    public void getStudents() {
        assertNotNull(service.getStudents());
    }

    @Test
    public void removeStudent() throws NoSuchStudentException {
        int initSize = service.getStudents().size();
        service.removeStudent(1);

        assertEquals(initSize-1,service.getStudents().size());
    }

    @Test
    public void addStudent() {
        int initSize = service.getStudents().size();
        service.addStudent(new Student("name","surname","1","Ion Vasile"));
        assertEquals(initSize+1,service.getStudents().size());
    }
}