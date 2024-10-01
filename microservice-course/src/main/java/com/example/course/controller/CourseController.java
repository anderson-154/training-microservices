package com.example.course.controller;

import com.example.course.entities.Course;
import com.example.course.service.CourseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses/")
public class CourseController {

    @Autowired
    private CourseServiceImp courseService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void courseService(@RequestBody Course course){
        courseService.save(course);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCourses(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/search-students/{courseId}")
    public ResponseEntity<?> finAllStudentsByCourseId(@PathVariable Long courseId){
        return ResponseEntity.ok(courseService.findStudentsByIdCourse(courseId));
    }


}
