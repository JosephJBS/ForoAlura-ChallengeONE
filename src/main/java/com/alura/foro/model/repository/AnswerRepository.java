package com.alura.foro.model.repository;

import com.alura.foro.model.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer > {

    List<Answer> findByStatusTrue();

    List<Answer> findByStatusTrueAndIdTopic (int idTopic);

}
