package com.update.app.facade.employee.impl;

import com.update.app.model.employee.Employee;
import com.update.app.model.employee.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeFacadeImplTest {

    private EmployeeDao studentDao = mock(EmployeeDao.class);

    private List<Employee> employees = new ArrayList<>();


    @BeforeEach
    void setUp() {
        Student student1 = new Student("CT21-0073", "Amulong", "kate", "itaas", "female", "09-07-03", "Catholic", "amulong@gmail.com", "tagaytay", "009912132");
        Student student2 = new Student("CT21-0073", "Amulong", "kate", "itaas", "female", "09-07-03", "Catholic", "amulong@gmail.com", "tagaytay", "009912132");

        students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        studentDao = mock(StudentDao.class);
    }


    @Test
    void testGetAllStudents() {
        when(studentDao.getAllStudents()).thenReturn(students);

        List<Student> expectedStudents = studentDao.getAllStudents();
        assertEquals(expectedStudents, students);
        assertEquals(expectedStudents.size(), 2L);
    }

    @Test
    void testGetStudentById() {
        Student student = new Student("CT21-0073", "Amulong", "kate", "itaas", "female", "09-07-03", "Catholic", "amulong@gmail.com", "tagaytay", "009912132");
        students.add(student);

        when(studentDao.getStudentById("CT21-0073")).thenReturn(student);

        Student expectedStudent = studentDao.getStudentById("CT21-0073");
        assertEquals(expectedStudent, student);
        assertEquals(expectedStudent.getLastName(), "Amulong");
    }
}
