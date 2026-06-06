package com.github.vitormozer9.courses_api.modules.courses.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.vitormozer9.courses_api.modules.courses.repositories.CourseRepository;

@Service
public class DeleteCourseUseCase {
    
    @Autowired
    CourseRepository courseRepository;

    public void delete(UUID id){
        this.courseRepository.deleteById(id);
        
    }

}
