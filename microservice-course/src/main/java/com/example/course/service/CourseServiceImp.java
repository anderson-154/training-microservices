package com.example.course.service;

import com.example.course.client.StudentClient;
import com.example.course.controller.dto.StudentDTO;
import com.example.course.entities.Course;
import com.example.course.http.response.StudentByCourseResponse;
import com.example.course.persistence.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServiceImp implements ICourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long courseId) {
        //Consultar el curso
        Course course = courseRepository.findById(courseId).orElse(new Course());
        //Obtener los estudiantes
        List<StudentDTO> studentDTOList = studentClient.finAllStudentsByCourse(courseId);

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
