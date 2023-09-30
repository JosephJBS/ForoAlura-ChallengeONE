package com.alura.foro.services;

import com.alura.foro.model.dto.answer.AnswerCreateData;
import com.alura.foro.model.dto.answer.AnswerResponse;
import com.alura.foro.model.dto.answer.AnswerUpdateData;
import com.alura.foro.model.entity.Answer;
import com.alura.foro.model.repository.AnswerRepository;
import com.alura.foro.model.repository.TopicRepository;
import com.alura.foro.model.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;


    @Override
    public AnswerResponse createAnswer(AnswerCreateData data) {
        if (!userRepository.existsById(data.id_user())) return AnswerResponse.errorUsuarioNoEncontrado();
        if (!topicRepository.existsById(data.id_topic())) return AnswerResponse.errorTopicoNoEncontrado();

        Answer create = new Answer()
                .builder()
                .id_user(data.id_user())
                .idTopic(data.id_topic())
                .mensaje(data.mensaje())
                .fechaCreacion(LocalDateTime.now())
                .status(true)
                .build();
        answerRepository.save(create);
        return new AnswerResponse(create);
    }

    @Override
    public List<AnswerResponse> getAllAnswer() {
        List<AnswerResponse> found = answerRepository
                .findAll()
                .stream().map(AnswerResponse::new)
                .collect(Collectors.toList());
        return found;
    }

    @Override
    public List<AnswerResponse> getActiveAnswer() {
        List<AnswerResponse> found = answerRepository
                .findByStatusTrue()
                .stream().map(AnswerResponse::new)
                .collect(Collectors.toList());
        return found;
    }

    @Override
    public List<AnswerResponse> getActiveAnswerByTopicId(int id_topic) {
        List<AnswerResponse> found = answerRepository
                .findByStatusTrueAndIdTopic(id_topic)
                .stream().map(AnswerResponse::new)
                .collect(Collectors.toList());
        return found;
    }

    @Override
    public AnswerResponse getAnswerById(int id_answer) {
        return new AnswerResponse(answerRepository.findById(id_answer).get()) ;
    }

    @Override
    public AnswerResponse updateAnswer(AnswerUpdateData data) {
        Answer update = answerRepository.findById(data.id_answer()).get();
        update.setMensaje(data.mensaje());
        update.setFechaCreacion(LocalDateTime.now());
        answerRepository.save(update);
        return new AnswerResponse(update);
    }

    @Override
    public void deleteAnswer(int id_answer) {
        Answer answer = answerRepository.getReferenceById(id_answer);
        answer.setStatus(false);
        answerRepository.save(answer);
    }
}
