package com.fan.springdatajpademo.repository;

import java.util.List;

import com.fan.springdatajpademo.entity.Course;
import com.fan.springdatajpademo.entity.CourseMaterial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .title(".net")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.fanyfull.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourses() {
        List<CourseMaterial> courseMaterials = repository.findAll();

        System.out.println("courseMatetial = " + courseMaterials);
    }
}
