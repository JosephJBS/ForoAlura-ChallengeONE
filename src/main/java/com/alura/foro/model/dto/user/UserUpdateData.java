package com.alura.foro.model.dto.user;


import jakarta.validation.constraints.NotNull;

public record UserUpdateData(
        @NotNull int id,
        String nombre,
        String email,
        String password
) {
}
