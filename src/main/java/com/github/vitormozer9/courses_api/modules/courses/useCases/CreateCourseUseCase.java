package com.github.vitormozer9.courses_api.modules.courses.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.vitormozer9.courses_api.modules.courses.entities.CourseEntity;
import com.github.vitormozer9.courses_api.modules.courses.repositories.CourseRepository;

@Service
public class CreateCourseUseCase {
    
    @Autowired
    CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity){
        //Verificar no optional se existe um curso com o mesmo nome
        this.courseRepository
        .findByName(courseEntity.getName())
        .ifPresent((course) -> {
            //throw CourseFoundException
            throw new RuntimeException("Course already exists!");
        });

        return this.courseRepository.save(courseEntity);
    } 
}
