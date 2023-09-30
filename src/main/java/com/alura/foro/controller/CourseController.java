package com.alura.foro.controller;

import com.alura.foro.model.dto.course.CourseDataCreate;
import com.alura.foro.model.dto.course.CourseResponse;
import com.alura.foro.model.dto.course.CourseUpdateData;
import com.alura.foro.services.CourseService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAllCourses (){
        return ResponseEntity.ok(courseService.getAllCourses()) ;
    }

    @GetMapping("/active")
    public ResponseEntity<List<CourseResponse>> getActiveCourses (){
        return ResponseEntity.ok(courseService.getAllCourses()) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> getUserById (@PathVariable int id){
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CourseResponse> createCourse (@RequestBody @Valid CourseDataCreate dataCreate){
        return  ResponseEntity.ok(courseService.createCourse(dataCreate));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<CourseResponse> updateCourse (@RequestBody @Valid CourseUpdateData courseUpdateData){
        return  ResponseEntity.ok(courseService.updateCourse(courseUpdateData));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delteCourse(@PathVariable int id){
        courseService.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }


}
