package com.github.vitormozer9.courses_api.modules.courses.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.vitormozer9.courses_api.modules.courses.entities.CourseEntity;
import com.github.vitormozer9.courses_api.modules.courses.useCases.CreateCourseUseCase;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CreateCourseUseCase courseUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody CourseEntity courseEntity) {
        try {
            var result = this.courseUseCase.execute(courseEntity);
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
