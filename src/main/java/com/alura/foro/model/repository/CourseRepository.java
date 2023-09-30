package com.alura.foro.model.repository;

import com.alura.foro.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    List<Course> findByStatusTrue();

}
