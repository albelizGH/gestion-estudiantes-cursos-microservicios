package com.microservice.student.client;

import com.microservice.student.dto.CourseInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//! Con esto le decimos a Feign que se conecte al microservicio de curso
@FeignClient(name = "msvc-course", url = "http://localhost:9090", path = "/api/course")
public interface CourseClient {

    @GetMapping("/{id}")
    CourseInfoDto findCourseById(@PathVariable Long id);

}
