package com.alura.foro.model.dto.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicCreateData (
        @NotNull
        int id_user,
        @NotNull
        int id_course,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje
){
}
