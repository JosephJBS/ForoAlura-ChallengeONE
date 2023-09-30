package com.alura.foro.services;

import com.alura.foro.model.dto.topic.TopicCreateData;
import com.alura.foro.model.dto.topic.TopicResponse;
import com.alura.foro.model.dto.topic.TopicUpdateData;

import java.util.List;


public interface TopicService {

    TopicResponse createTopic(TopicCreateData topicCreateData);

    List<TopicResponse> getAllTopics ();

    List<TopicResponse> gellActiveTopics();

    TopicResponse getTopicById(int id);

    TopicResponse updateTopic(TopicUpdateData updateData);

    void deleteTopicById(int id);

}
