package com.fan.springdatajpademo.repository;

import com.fan.springdatajpademo.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentReopsitory extends JpaRepository<Student, Long> {

}
