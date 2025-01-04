package com.microservice.course.controller;

import com.microservice.course.entity.Course;
import com.microservice.course.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseServiceImpl courseService;

    @Autowired
    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity saveCourse(@RequestBody Course course){
        courseService.save(course);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<Course>> findAllStudent(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findStudentById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        courseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<?> findStudentsByCourse(@PathVariable Long id){
        return ResponseEntity.ok(courseService.findStudentsByCourse(id));
    }

}
