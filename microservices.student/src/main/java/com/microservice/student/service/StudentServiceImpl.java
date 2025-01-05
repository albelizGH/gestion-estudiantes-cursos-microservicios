package com.microservice.student.service;

import com.microservice.student.client.CourseClient;
import com.microservice.student.dto.CourseInfoDto;
import com.microservice.student.entities.Student;
import com.microservice.student.http.response.StudentWithCourseResponse;
import com.microservice.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository studentRepository;
    private final CourseClient courseClient;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, CourseClient courseClient) {
        this.studentRepository = studentRepository;
        this.courseClient = courseClient;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findByid(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findByCourseId(Long courseId) {
        return studentRepository.findByCourseId(courseId);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentWithCourseResponse findStudentWithCourse(Long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        CourseInfoDto courseInfoDto = courseClient.findCourseById(student.getCourseId());

        return StudentWithCourseResponse.builder()
                .name(student.getName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .courseInformation(courseInfoDto)
                .build();
    }

}
