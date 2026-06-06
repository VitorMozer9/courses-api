package com.github.vitormozer9.courses_api.modules.courses.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.vitormozer9.courses_api.modules.courses.dto.UpdateCourseDTO;
import com.github.vitormozer9.courses_api.modules.courses.entities.CourseEntity;
import com.github.vitormozer9.courses_api.modules.courses.repositories.CourseRepository;

@Service
public class UpdateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity update(UUID id, UpdateCourseDTO updateCourseDTO){
        var course = this.courseRepository
                         .findById(id)
                         .orElseThrow(() -> new RuntimeException("Course nor found!"));

        if (updateCourseDTO.name() != null) {
            course.setName(updateCourseDTO.name());
        }

        if (updateCourseDTO.category() != null) {
            course.setCategory(updateCourseDTO.category());
        }

        return this.courseRepository.save(course);

    }   
}
