package com.alura.foro.services;

import com.alura.foro.model.constans.StatusTopico;
import com.alura.foro.model.dto.topic.TopicCreateData;
import com.alura.foro.model.dto.topic.TopicResponse;
import com.alura.foro.model.dto.topic.TopicUpdateData;
import com.alura.foro.model.entity.Topic;
import com.alura.foro.model.repository.CourseRepository;
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
public class TopicServiceImpl implements TopicService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    CourseRepository courseRepository;


    @Override
    public TopicResponse createTopic(TopicCreateData topicCreateData) {
        if(!userRepository.existsById(topicCreateData.id_user())) return TopicResponse.errorUsuarioNoEncontrado();
        if(!courseRepository.existsById(topicCreateData.id_course())) return TopicResponse.errorCursoNoEncontrado();

        Topic topic = new Topic()
                .builder()
                .id_user(topicCreateData.id_user())
                .id_course(topicCreateData.id_course())
                .fechaCreacion(LocalDateTime.now())
                .mensaje(topicCreateData.mensaje())
                .titulo(topicCreateData.titulo())
                .status(StatusTopico.NO_RESPONDIDO)
                .build();

        topicRepository.save(topic);
        return new TopicResponse(topic);
    }

    @Override
    public List<TopicResponse> getAllTopics() {
        List<TopicResponse> topicResponses = topicRepository.findAll()
                .stream().map(topic -> new TopicResponse(topic))
                .collect(Collectors.toList());

        return topicResponses;
    }

    @Override
    public List<TopicResponse> gellActiveTopics() {
        List<TopicResponse> topicResponses = topicRepository.findByStatus(StatusTopico.NO_RESPONDIDO)
                .stream().map(topic -> new TopicResponse(topic))
                .collect(Collectors.toList());

        return topicResponses;
    }

    @Override
    public TopicResponse getTopicById(int id) {
        return new TopicResponse(topicRepository.findById(id).get());
    }

    @Override
    public TopicResponse updateTopic(TopicUpdateData updateData) {
        if(!courseRepository.existsById(updateData.id_curso())) return TopicResponse.errorCursoNoEncontrado();
        if(!topicRepository.existsById(updateData.id_topic())) return TopicResponse.errorTopicoNoEncontrado();
        Topic update = topicRepository.getReferenceById(updateData.id_topic());

        update.setId_course(update.getId_course());
        update.setTitulo(updateData.titulo());
        update.setMensaje(updateData.mensaje());
        topicRepository.save(update);
        log.info("Info - Topic: Edición exitosa", update);

        return new TopicResponse(update);
    }

    @Override
    public void deleteTopicById(int id) {
        Topic delete = topicRepository.findById(id).get();
        delete.setStatus(StatusTopico.CERRADO);
        topicRepository.save(delete);
    }
}
