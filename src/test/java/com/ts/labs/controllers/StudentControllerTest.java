package com.ts.labs.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ts.labs.exceptions.NoSuchStudentException;
import com.ts.labs.pojo.Student;
import com.ts.labs.services.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService service;

    @Autowired
    ObjectMapper mapper;

    Student s;
    int studentId;

    @Before
    public void setUp() throws Exception {
        s = new Student("name","surname","1","adress");
        studentId=1;
    }

    @Test
    public void getStudents() throws Exception {

        Mockito.when(service.getStudents()).thenReturn(Arrays.asList(s));


        mockMvc.perform(get("/student/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)));


    }

    @Test
    public void getStudent() throws Exception {

        Mockito.when(service.getStudent(studentId)).thenReturn(s);

        mockMvc.perform(get("/student?id="+studentId))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(s.getName())));
    }

    @Test
    public void addStudent() throws Exception {

       Mockito.when(service.addStudent(s)).thenReturn(true);

       mockMvc.perform(post("/student")
               .contentType(MediaType.APPLICATION_JSON)
               .content(mapper.writeValueAsString(s)))
                    .andExpect(status().isOk());

    }

    @Test
    public void modifyStudent() throws Exception {
        Mockito.when(service.modifyStudent(1,s)).thenReturn(true);

        mockMvc.perform(put("/student?id="+studentId)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(s)))
                    .andExpect(status().isOk());
    }

    @Test
    public void deleteStudent() throws Exception {
        Mockito.when(service.removeStudent(studentId)).thenReturn(true);

        mockMvc.perform(delete("/student?id="+studentId))
                .andExpect(status().isOk());
    }

    /**
     *  Negative scenarios
     */

    @Test
    public void getStudentWithNegativeId() throws Exception {
        Mockito.when(service.getStudent(studentId))
                .thenThrow( new NoSuchStudentException("testing"));

        mockMvc.perform(get("/student?id="+studentId))
                .andExpect(status().isNotFound());

    }



}