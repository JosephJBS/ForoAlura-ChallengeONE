package com.alura.foro.model.dto.course;

import com.alura.foro.model.entity.Course;

public record CourseResponse(
        int id,
        String nombre,
        String categoria,
        boolean status
) {
    public CourseResponse(Course course){
        this(course.getId_course(),
                course.getNombre(),
                course.getCategoria(),
                course.isStatus());
    }
}
