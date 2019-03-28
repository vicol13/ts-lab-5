package com.ts.labs.data;

import com.ts.labs.LabsApplication;
import com.ts.labs.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LabsApplication.class)
public class DataSourceTest {


    @Autowired
    MyDataSourceClass dataSource;

    @Test
    public void getStudents() {
        assertNotNull(dataSource.getStudents());
    }

    @Test
    public void getSudent() throws Exception {
        assertNotNull(dataSource.getStudent(0));
    }

    @Test(expected = Exception.class)
    public void getSudent2() throws Exception {
        dataSource.getStudent(-1);
    }


    @Test
    public void addStudent() {
            int initSize= dataSource.getStudents().size();
            dataSource.addStudent(new Student("name","name","phone","adress"));
            assertEquals(initSize+1,dataSource.getStudents().size());
    }

    @Test
    public void removeStudent() {
        int initSize= dataSource.getStudents().size();
        dataSource.removeStudent(0);
        assertEquals(initSize-1,dataSource.getStudents().size());
    }

    @Test
    public void removeSudent() {
        int initSize= dataSource.getStudents().size();
        dataSource.removeStudent(new Student("vasile","vasilache","1","Ion Creanga"));
        assertEquals(initSize-1,dataSource.getStudents().size());
    }
}