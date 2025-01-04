package com.microservice.course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
public record StudentDto(
        String name,
        String lastName,
        String email,
        Long courseId) {}
