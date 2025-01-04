package com.microservice.student.service;

import com.microservice.student.entities.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();
    Student findByid(Long id);
    void save(Student student);
    List<Student> findByCourseId(Long courseId);
    public void deleteById(Long id);
}
