package com.alura.foro.model.dto.topic;

import com.alura.foro.model.constans.StatusTopico;
import com.alura.foro.model.constans.TopicErrors;
import com.alura.foro.model.entity.Topic;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TopicResponse {
    private int id_topic;
    private int id_curso;
    private int id_user;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private StatusTopico status;
    private TopicErrors topicErrors;

    public TopicResponse(Topic topic) {
        this.id_topic = topic.getId_topic();
        this.id_curso = topic.getId_course();
        this.id_user=topic.getId_user();
        this.titulo=topic.getTitulo();
        this.mensaje = topic.getMensaje();
        this.fechaCreacion=topic.getFechaCreacion();
        this.status = topic.getStatus();
        this.topicErrors = TopicErrors.SIN_ERROR;
    }

    public TopicResponse() {
    }


    public static TopicResponse errorUsuarioNoEncontrado(){
        TopicResponse topicError = new TopicResponse();
        topicError.setTopicErrors(TopicErrors.USER_NO_EXIST);
        return topicError;
    }

    public static TopicResponse errorCursoNoEncontrado(){
        TopicResponse topicError = new TopicResponse();
        topicError.setTopicErrors(TopicErrors.COURSE_NO_EXIST);
        return topicError;
    }

    public static TopicResponse errorTopicoNoEncontrado(){
        TopicResponse topicError = new TopicResponse();
        topicError.setTopicErrors(TopicErrors.TOPIC_NO_EXIST);
        return topicError;
    }
}
