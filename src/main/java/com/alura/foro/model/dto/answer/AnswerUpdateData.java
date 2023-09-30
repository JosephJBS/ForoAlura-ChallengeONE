package com.alura.foro.model.dto.answer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnswerUpdateData(
        @NotNull
        int id_answer,
        @NotBlank
        String mensaje
) {
}
