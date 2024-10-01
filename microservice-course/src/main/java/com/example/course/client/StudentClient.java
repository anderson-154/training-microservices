package com.example.course.client;

import com.example.course.controller.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-student", url = "localhost:8090/api/student")
public interface StudentClient {

    @GetMapping("/search-by-course/{courseId}")
    List<StudentDTO> finAllStudentsByCourse(@PathVariable Long courseId);


}
