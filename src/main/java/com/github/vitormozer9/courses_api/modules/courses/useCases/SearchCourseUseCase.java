package com.github.vitormozer9.courses_api.modules.courses.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.vitormozer9.courses_api.modules.courses.entities.CourseEntity;
import com.github.vitormozer9.courses_api.modules.courses.repositories.CourseRepository;

@Service
public class SearchCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity searchById(UUID id){
        return this.courseRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("course not found!"));
    }

}
