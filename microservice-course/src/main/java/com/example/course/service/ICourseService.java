package com.example.course.service;

import com.example.course.entities.Course;
import com.example.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();
    Course findById(Long id);
    void save(Course course);
    StudentByCourseResponse findStudentsByIdCourse(Long courseId);

}
