package com.ts.labs.data;

import com.ts.labs.pojo.Student;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MyDataSourceClass {
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudent(int i) {
        return students.get(i);
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void removeStudent(int i) {
        students.remove(i);
    }

    public void removeStudent(Student s) {
        students.remove(s);
    }

    public void modifyStudent(int id, Student s) {
        students.set(id, s);
    }


    @PostConstruct
    private void init() {
        students.add(new Student("vasile", "vasilache", "1", "Ion Creanga"));
        students.add(new Student("giovani", "papusoi", "2", "Ion Frunza"));
        students.add(new Student("tudor", "kapushon", "3", "Ion Radacina"));
        students.add(new Student("anatolii", "orange", "4", "Ion Cireasa"));
        students.add(new Student("juan", "moldcell", "5", "Ion Mugure"));
        students.add(new Student("pablito", "unite", "6", "Ion Tulpina"));
    }

}
