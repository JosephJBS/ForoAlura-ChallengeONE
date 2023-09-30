package com.alura.foro.model.dto.answer;

import com.alura.foro.model.constans.AnswerError;
import com.alura.foro.model.entity.Answer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnswerResponse {
    private int id_answer;
    private int id_user;
    private int id_topic;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private boolean status;
    private AnswerError answerError;

    public AnswerResponse(){}

    public AnswerResponse(Answer answer){
        this.id_user = answer.getId_user();
        this.id_answer = answer.getId_answer();
        this.id_topic = answer.getIdTopic();
        this.mensaje = answer.getMensaje();
        this.fechaCreacion = answer.getFechaCreacion();
        this.status = answer.isStatus();
        this.answerError = AnswerError.NO_ERROR;
    }

    public static AnswerResponse errorUsuarioNoEncontrado(){
        AnswerResponse answerResponse = new AnswerResponse();
        answerResponse.setAnswerError(AnswerError.USER_NO_EXIST);
        return answerResponse;
    }

    public static AnswerResponse errorTopicoNoEncontrado(){
        AnswerResponse answerResponse = new AnswerResponse();
        answerResponse.setAnswerError(AnswerError.TOPIC_NO_EXIST);
        return answerResponse;
    }

}
