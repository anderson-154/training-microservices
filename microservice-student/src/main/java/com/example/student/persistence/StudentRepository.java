package com.example.student.persistence;

import com.example.student.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.courseId = :courseId")
    List<Student> findAllStudent(Long courseId);
    //List<Student> findAllByCourseId (Long courseId); //misma forma de llamar diferentes metodos el de ariba con @Query

}
