package com.alura.foro.controller;

import com.alura.foro.model.dto.answer.AnswerCreateData;
import com.alura.foro.model.dto.answer.AnswerResponse;
import com.alura.foro.model.dto.answer.AnswerUpdateData;
import com.alura.foro.services.AnswerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @PostMapping
    public ResponseEntity<AnswerResponse> createAnswer(@RequestBody @Valid AnswerCreateData data){
        return ResponseEntity.ok(answerService.createAnswer(data));
    }

    @GetMapping
    public ResponseEntity<List<AnswerResponse>> getAllAnswer(){
        return ResponseEntity.ok(answerService.getAllAnswer());
    }

    @GetMapping("/active")
    public ResponseEntity<List<AnswerResponse>> getActiveAnswer(){
        return ResponseEntity.ok(answerService.getActiveAnswer());
    }

    @GetMapping("/active/{id_topic}")
    public ResponseEntity<List<AnswerResponse>> getAnswerByTopicId(@PathVariable int id_topic){
        return ResponseEntity.ok(answerService.getActiveAnswerByTopicId(id_topic));
    }

    @PutMapping
    public ResponseEntity<AnswerResponse> updateAnswer(@RequestBody @Valid AnswerUpdateData data){
        return ResponseEntity.ok(answerService.updateAnswer(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnswer (@PathVariable int id){
        answerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }

}
