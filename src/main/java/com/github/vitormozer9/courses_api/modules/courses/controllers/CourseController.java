package com.github.vitormozer9.courses_api.modules.courses.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.vitormozer9.courses_api.modules.courses.entities.CourseEntity;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @PostMapping("/")
    public void create(@RequestBody CourseEntity courseEntity) {
        System.out.println("Teste 01");
        System.out.println(courseEntity.getName());
    }
    
}
