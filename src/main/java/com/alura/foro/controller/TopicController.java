package com.alura.foro.controller;

import com.alura.foro.model.dto.topic.TopicCreateData;
import com.alura.foro.model.dto.topic.TopicResponse;
import com.alura.foro.model.dto.topic.TopicUpdateData;
import com.alura.foro.services.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topic")
public class TopicController {

    @Autowired
    TopicService topicService;

    @GetMapping
    public ResponseEntity<List<TopicResponse>> getAllTopics(){
        return ResponseEntity.ok(topicService.getAllTopics()) ;
    }

    @GetMapping("/active")
    public ResponseEntity<List<TopicResponse>> getActiveTopic(){
        return ResponseEntity.ok(topicService.gellActiveTopics());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponse> getTopicById(@PathVariable int id){
        return ResponseEntity.ok(topicService.getTopicById(id));
    }

    @PostMapping
    public ResponseEntity<TopicResponse>  createTopic(@RequestBody @Valid TopicCreateData topicCreateData){
        return ResponseEntity.ok(topicService.createTopic(topicCreateData));
    }

    @PutMapping
    public ResponseEntity<TopicResponse> updateTopic (@RequestBody @Valid TopicUpdateData updateData){
        return ResponseEntity.ok(topicService.updateTopic(updateData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTopic(@PathVariable int id){
        topicService.deleteTopicById(id);
        return ResponseEntity.noContent().build();
    }





}
