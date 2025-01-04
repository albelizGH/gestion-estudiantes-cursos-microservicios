package com.microservice.course.http.response;

import com.microservice.course.dto.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//! Esta clase es un DTO que se utiliza para devolver la información de los estudiantes de un curso al cliente.

@Builder
public record StudentByCourseResponse(
        String courseName,
        String teacher,
        List<StudentDto> studentDtoList
) {
}
