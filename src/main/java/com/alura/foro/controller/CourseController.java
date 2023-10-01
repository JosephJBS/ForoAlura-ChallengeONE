package com.alura.foro.controller;

import com.alura.foro.model.dto.course.CourseDataCreate;
import com.alura.foro.model.dto.course.CourseResponse;
import com.alura.foro.model.dto.course.CourseUpdateData;
import com.alura.foro.services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@SecurityRequirement(name = "bearer-key")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping
    @Operation(summary = "Lista cursos activos e inactivos")
    public ResponseEntity<List<CourseResponse>> getAllCourses (){
        return ResponseEntity.ok(courseService.getAllCourses()) ;
    }

    @GetMapping("/active")
    @Operation(summary = "Lista cursos acitvos")
    public ResponseEntity<List<CourseResponse>> getActiveCourses (){
        return ResponseEntity.ok(courseService.getAllCourses()) ;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene un curso en especifico por su id")
    public ResponseEntity<CourseResponse> getUserById (@PathVariable int id){
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Crea un nuevo curso")
    public ResponseEntity<CourseResponse> createCourse (@RequestBody @Valid CourseDataCreate dataCreate){
        return  ResponseEntity.ok(courseService.createCourse(dataCreate));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Actualiza información sobre un curso")
    public ResponseEntity<CourseResponse> updateCourse (@RequestBody @Valid CourseUpdateData courseUpdateData){
        return  ResponseEntity.ok(courseService.updateCourse(courseUpdateData));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Eliminación lógica de un curso")
    public ResponseEntity<?> delteCourse(@PathVariable int id){
        courseService.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }


}
