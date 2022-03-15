package com.fan.springdatajpademo.repository;

import java.util.List;

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
                .guardianName("Lu")
                .guardianMobil("12345678")
                .build();

        studentReopsitory.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentReopsitory.findAll();

        System.out.println("studentList = " + studentList);
    }
}
