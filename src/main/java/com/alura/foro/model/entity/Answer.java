package com.alura.foro.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "respuesta")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_answer;
    private int id_user;
    private int id_topic;
    private String mensaje;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private boolean status;

}