package com.alura.foro.model.repository;

import com.alura.foro.model.constans.StatusTopico;
import com.alura.foro.model.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Integer>{

    List<Topic> findByStatus(StatusTopico statusTopico);
}