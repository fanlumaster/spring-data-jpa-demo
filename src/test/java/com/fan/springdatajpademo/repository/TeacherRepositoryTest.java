package com.fan.springdatajpademo.repository;

import java.util.List;

import com.fan.springdatajpademo.entity.Course;
import com.fan.springdatajpademo.entity.Teacher;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();
        Course courseJava = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Chen")
                .lastName("ChangQing")
                // .courses(List.of(courseDBA, courseJava))
                .build();

        teacherRepository.save(teacher);
    }
}
