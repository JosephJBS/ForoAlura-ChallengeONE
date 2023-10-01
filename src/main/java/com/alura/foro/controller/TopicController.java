package com.alura.foro.controller;

import com.alura.foro.model.dto.topic.TopicCreateData;
import com.alura.foro.model.dto.topic.TopicResponse;
import com.alura.foro.model.dto.topic.TopicUpdateData;
import com.alura.foro.services.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topic")
@SecurityRequirement(name = "bearer-key")
public class TopicController {

    @Autowired
    TopicService topicService;

    @GetMapping
    @Operation(summary = "Lista tópicos activos e inactivos")
    public ResponseEntity<List<TopicResponse>> getAllTopics(){
        return ResponseEntity.ok(topicService.getAllTopics()) ;
    }

    @GetMapping("/active")
    @Operation(summary = "Lista tópicos activos")
    public ResponseEntity<List<TopicResponse>> getActiveTopic(){
        return ResponseEntity.ok(topicService.gellActiveTopics());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene un tópico en especifico por su id")
    public ResponseEntity<TopicResponse> getTopicById(@PathVariable int id){
        return ResponseEntity.ok(topicService.getTopicById(id));
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Crea una nuevo tópico")
    public ResponseEntity<TopicResponse>  createTopic(@RequestBody @Valid TopicCreateData topicCreateData){
        return ResponseEntity.ok(topicService.createTopic(topicCreateData));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Actualiza información sobre un tópico")
    public ResponseEntity<TopicResponse> updateTopic (@RequestBody @Valid TopicUpdateData updateData){
        return ResponseEntity.ok(topicService.updateTopic(updateData));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminación lógica de un tópico")
    public ResponseEntity<?> deleteTopic(@PathVariable int id){
        topicService.deleteTopicById(id);
        return ResponseEntity.noContent().build();
    }





}
