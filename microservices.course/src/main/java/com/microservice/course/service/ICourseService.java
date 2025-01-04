package com.microservice.course.service;

import com.microservice.course.entity.Course;
import com.microservice.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICourseService {
    public List<Course> findAll();
    public Course findById(Long id);
    public void save(Course course);
    public void deleteById(Long id);
    public StudentByCourseResponse findStudentsByCourse(Long id);
}
