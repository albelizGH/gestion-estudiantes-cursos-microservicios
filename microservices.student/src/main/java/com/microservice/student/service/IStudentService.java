package com.microservice.student.service;

import com.microservice.student.entities.Student;
import com.microservice.student.http.response.StudentWithCourseResponse;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();
    Student findByid(Long id);
    void save(Student student);
    List<Student> findByCourseId(Long courseId);
    void deleteById(Long id);
    StudentWithCourseResponse findStudentWithCourse(Long id);
}
