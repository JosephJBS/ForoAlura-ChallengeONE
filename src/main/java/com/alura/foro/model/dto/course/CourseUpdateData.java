package com.alura.foro.model.dto.course;

import jakarta.validation.constraints.NotNull;

public record CourseUpdateData (
        @NotNull
        int id_course,
        String nombre,
        String categoria
)
{

}
