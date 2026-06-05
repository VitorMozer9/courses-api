package com.github.vitormozer9.courses_api.modules.courses.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.vitormozer9.courses_api.modules.courses.entities.CourseEntity;
import com.github.vitormozer9.courses_api.modules.courses.repositories.CourseRepository;

@Service
public class ListCoursesUseCase {

    @Autowired
    private CourseRepository courseRepository;

        public List<CourseEntity> execute(String name, String category){
        
        if (name != null && category != null) {
            return this.courseRepository
                   .findAllByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(name,category);
        }

        if (name != null) {
            return this.courseRepository.findAllByNameContainingIgnoreCase(name);
        }

        if (category != null) {
            return this.courseRepository.findAllByCategoryContainingIgnoreCase(category);
        }

        return this.courseRepository.findAll();
        
    }   
}
