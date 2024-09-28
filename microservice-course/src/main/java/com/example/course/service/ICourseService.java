package com.example.course.service;

import com.example.course.entities.Course;
import com.example.course.persistence.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();
    Course findById(Long id);
    void save(Course course);

}
