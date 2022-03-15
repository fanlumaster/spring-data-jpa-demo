package com.fan.springdatajpademo.repository;

import java.util.List;

import com.fan.springdatajpademo.entity.Guardian;
import com.fan.springdatajpademo.entity.Student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentReopsitoryTest {
    @Autowired
    private StudentReopsitory studentReopsitory;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("lxyfl6688@gmail.com")
                .firstName("fany")
                .lastName("full")
                // .guardianName("Lu")
                // .guardianEmail("lu@email.com")
                // .guardianMobil("12345678")
                .build();

        studentReopsitory.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("lu@email.com")
                .name("Lu")
                .mobile("12345678")
                .build();

        Student student = Student.builder()
                .firstName("Fany")
                .emailId("fany@gmail.com")
                .lastName("Full")
                .guardian(guardian)
                .build();

        studentReopsitory.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentReopsitory.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentReopsitory.findByFirstName("Fany");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentReopsitory.findByFirstNameContaining("Fa");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentReopsitory.findByGuardianName("Lu");

        System.out.println("students = " + students);
    }
}
