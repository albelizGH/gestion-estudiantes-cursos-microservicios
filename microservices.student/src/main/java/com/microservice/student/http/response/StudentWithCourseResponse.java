package com.microservice.student.http.response;

import com.microservice.student.dto.CourseInfoDto;
import lombok.Builder;

@Builder
public record StudentWithCourseResponse(String name,
                                        String lastName,
                                        String email,
                                        CourseInfoDto courseInformation) {
}
