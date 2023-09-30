package com.alura.foro.controller;

import com.alura.foro.model.dto.topic.TopicCreateData;
import com.alura.foro.model.dto.topic.TopicResponse;
import com.alura.foro.model.dto.topic.TopicUpdateData;
import com.alura.foro.services.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topic")
public class TopicController {

    @Autowired
    TopicService topicService;

    @GetMapping
    public List<TopicResponse> getAllTopics(){
        return topicService.getAllTopics();
    }

    @GetMapping("/active")
    public List<TopicResponse> getActiveTopic(){
        return topicService.gellActiveTopics();
    }

    @GetMapping("/{id}")
    public TopicResponse getTopicById(@PathVariable int id){
        return topicService.getTopicById(id);
    }

    @PostMapping
    public TopicResponse createTopic(@RequestBody @Valid TopicCreateData topicCreateData){
        return topicService.createTopic(topicCreateData);
    }

    @PutMapping
    public TopicResponse updateTopic (@RequestBody @Valid TopicUpdateData updateData){
        return topicService.updateTopic(updateData);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable int id){
        topicService.deleteTopicById(id);
    }





}
