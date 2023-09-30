package com.alura.foro.model.dto.course;

import jakarta.validation.constraints.NotBlank;

public record CourseDataCreate(
        @NotBlank
        String nombre,
        @NotBlank
        String categoria
) {
}
