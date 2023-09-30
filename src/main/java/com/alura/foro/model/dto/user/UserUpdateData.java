package com.alura.foro.model.dto.user;

import org.antlr.v4.runtime.misc.NotNull;

public record UserUpdateData(
        @NotNull int id,
        String nombre,
        String email,
        String password
) {
}
