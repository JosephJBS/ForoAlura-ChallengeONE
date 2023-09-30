package com.alura.foro.model.dto.topic;

import jakarta.validation.constraints.NotNull;

public record TopicUpdateData
        (
            @NotNull
            int id_topic,
            int id_curso,
            String titulo,
            String mensaje
        ) {
}
