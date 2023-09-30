package com.alura.foro.services;

import com.alura.foro.model.dto.course.CourseDataCreate;
import com.alura.foro.model.dto.course.CourseResponse;
import com.alura.foro.model.dto.course.CourseUpdateData;

import java.util.List;

public interface CourseService {

    CourseResponse createCourse (CourseDataCreate userDataCreate);

    List<CourseResponse> getAllCourses ();

    List<CourseResponse> getActiveCourses();

    CourseResponse getCourseById(int id);

    CourseResponse updateCourse (CourseUpdateData courseUpdateData);

    void deleteCourseById (int id_course);

}
