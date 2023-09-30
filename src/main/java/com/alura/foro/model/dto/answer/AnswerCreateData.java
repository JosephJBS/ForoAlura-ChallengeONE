package com.alura.foro.model.dto.answer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record AnswerCreateData (
        @NotNull
        int id_user,
        @NotNull
        int id_topic,
        @NotBlank
        String mensaje
){
}
