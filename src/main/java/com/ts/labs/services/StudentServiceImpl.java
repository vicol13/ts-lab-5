package com.ts.labs.services;

import com.ts.labs.data.MyDataSourceClass;
import com.ts.labs.exceptions.NoSuchStudentException;
import com.ts.labs.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    MyDataSourceClass dataSourceClass;


    @Override
    public boolean modifyStudent(int id , Student s) throws NoSuchStudentException {
        if(id>= 0 && id <= dataSourceClass.getStudents().size()){
           dataSourceClass.modifyStudent(id,s);
           return true;
        }
        throw new NoSuchStudentException("can't modify student with this id[" + id+"] doesn't exist");
    }



    @Override
    public Student getStudent(int id) throws NoSuchStudentException {
        if(id>= 0 && id < dataSourceClass.getStudents().size()){
            return dataSourceClass.getStudent(id);
        }
        throw new NoSuchStudentException("can't get student with this  id[" + id+"] doesn't exist");
    }



    @Override
    public List<Student> getStudents() {
        return dataSourceClass.getStudents();
    }


    @Override
    public boolean removeStudent(int id) throws NoSuchStudentException {
        if(id>= 0 && id < dataSourceClass.getStudents().size()){
            dataSourceClass.removeStudent(id);
            return true;
        }
        throw new NoSuchStudentException("can't delete student with this  id[" + id+"] doesn't exist");
    }

    @Override
    public boolean addStudent(Student student) {
        try {
            dataSourceClass.addStudent(student);
            return true;
        }catch (Exception e){
            return false;
        }

    }


}
