package com.github.vitormozer9.courses_api.modules.courses.useCases;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.vitormozer9.courses_api.modules.courses.entities.CourseEntity;
import com.github.vitormozer9.courses_api.modules.courses.repositories.CourseRepository;

public class CreateCourseUseCase {
    
    @Autowired
    CourseRepository courseRepository;

    public void createCourse(CourseEntity courseEntity){
        //Verificar no optional se existe um curso com o mesmo nome
        this.courseRepository
        .findByName(courseEntity.getName())
        .ifPresent((course) -> {
            //throw CourseFoundException
            System.out.println("Course alredy exists!");
            return;
        });

        //return this.courseRepository.save(courseEntity);
    }
}
