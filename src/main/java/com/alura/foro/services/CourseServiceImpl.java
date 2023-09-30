package com.alura.foro.services;

import com.alura.foro.model.dto.course.CourseDataCreate;
import com.alura.foro.model.dto.course.CourseResponse;
import com.alura.foro.model.dto.course.CourseUpdateData;
import com.alura.foro.model.entity.Course;
import com.alura.foro.model.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;

    @Override
    public CourseResponse createCourse(CourseDataCreate userDataCreate) {
        Course course = new Course()
                .builder()
                .nombre(userDataCreate.nombre())
                .categoria(userDataCreate.categoria())
                .status(true)
                .build();

        courseRepository.save(course);

        return new CourseResponse(course);
    }

    @Override
    public List<CourseResponse> getAllCourses() {
       List<CourseResponse>  courseResponses = courseRepository.findAll()
               .stream()
               .map(course -> new CourseResponse(course))
                       .collect(Collectors.toList());
       return courseResponses;
    }

    @Override
    public List<CourseResponse> getActiveCourses() {
        List<CourseResponse>  courseResponses = courseRepository.findByStatusTrue()
                .stream()
                .map(course -> new CourseResponse(course))
                .collect(Collectors.toList());
        return courseResponses;
    }

    @Override
    public CourseResponse getCourseById(int id) {
        return new CourseResponse(courseRepository.findById(id).get());
    }

    @Override
    public CourseResponse updateCourse(CourseUpdateData courseUpdateData) {
        Course course = courseRepository.getReferenceById(courseUpdateData.id_course());

        course.setNombre(courseUpdateData.nombre());
        course.setCategoria(course.getCategoria());

        log.info("Info - Course : Edicion Exitosa {}",course);
        courseRepository.save(course);

        return new CourseResponse(course);
    }

    @Override
    public void deleteCourseById(int id_course) {
        Course course = courseRepository.findById(id_course).get();
        course.setStatus(false);
        courseRepository.save(course);
    }
}
