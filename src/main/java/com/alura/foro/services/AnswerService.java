package com.alura.foro.services;

import com.alura.foro.model.dto.answer.AnswerCreateData;
import com.alura.foro.model.dto.answer.AnswerResponse;
import com.alura.foro.model.dto.answer.AnswerUpdateData;

import java.util.List;

public interface AnswerService {

    AnswerResponse createAnswer(AnswerCreateData data);

    List<AnswerResponse> getAllAnswer();

    List<AnswerResponse> getActiveAnswer();

    List<AnswerResponse> getActiveAnswerByTopicId(int id_topic);

    AnswerResponse getAnswerById(int id_answer);

    AnswerResponse updateAnswer(AnswerUpdateData data);

    void deleteAnswer(int id_answer);
}
