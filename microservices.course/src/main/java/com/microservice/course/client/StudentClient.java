package com.microservice.course.client;

import com.microservice.course.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//! Con esto le decimos a Feign que se conecte al microservicio de estudiante
@FeignClient(name = "msvc-student", url = "http://localhost:8090", path = "/api/student")
public interface StudentClient {

    //* El controlador de estudiante tiene un metodo que nos permite obtener todos los estudiantes de un curso, pero este devuelve un ResponseEntity y nosotros no podemos devolver un ResponseEntity Feign entonces tenemos que crear un DTO que nos permita devolver la informacion que necesitamos.
    @GetMapping("/course/{id}")
    List<StudentDto> findAllStudentByCourse(@PathVariable Long id);
}
