package com.alura.foro.controller;

import com.alura.foro.model.dto.answer.AnswerCreateData;
import com.alura.foro.model.dto.answer.AnswerResponse;
import com.alura.foro.model.dto.answer.AnswerUpdateData;
import com.alura.foro.services.AnswerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answer")
@SecurityRequirement(name = "bearer-key")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @PostMapping
    @Operation(summary = "Crea una nueva respuesta para un tópico")
    public ResponseEntity<AnswerResponse> createAnswer(@RequestBody @Valid AnswerCreateData data){
        return ResponseEntity.ok(answerService.createAnswer(data));
    }

    @GetMapping
    @Operation(summary = "Lista respuestas activas e inactivas")
    public ResponseEntity<List<AnswerResponse>> getAllAnswer(){
        return ResponseEntity.ok(answerService.getAllAnswer());
    }

    @GetMapping("/active")
    @Operation(summary = "Lista respuestas activas")
    public ResponseEntity<List<AnswerResponse>> getActiveAnswer(){
        return ResponseEntity.ok(answerService.getActiveAnswer());
    }

    @GetMapping("/active/{id_topic}")
    @Operation(summary = "Lista las respuestas obtenidas a travez del id del tópico")
    public ResponseEntity<List<AnswerResponse>> getAnswerByTopicId(@PathVariable int id_topic){
        return ResponseEntity.ok(answerService.getActiveAnswerByTopicId(id_topic));
    }

    @PutMapping
    @Operation(summary = "Actualiza el mensaje de una respuesta")
    public ResponseEntity<AnswerResponse> updateAnswer(@RequestBody @Valid AnswerUpdateData data){
        return ResponseEntity.ok(answerService.updateAnswer(data));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminación lógica de una respuesta")
    public ResponseEntity<?> deleteAnswer (@PathVariable int id){
        answerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }

}
