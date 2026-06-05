package com.github.vitormozer9.courses_api.modules.courses.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.vitormozer9.courses_api.modules.courses.entities.CourseEntity;
import com.github.vitormozer9.courses_api.modules.courses.useCases.CreateCourseUseCase;
import com.github.vitormozer9.courses_api.modules.courses.useCases.ListCoursesUseCase;
import com.github.vitormozer9.courses_api.modules.courses.useCases.SearchCourseUseCase;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CreateCourseUseCase courseUseCase;

    @Autowired
    SearchCourseUseCase searchCourseUseCase;

    @Autowired
    ListCoursesUseCase listCoursesUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody CourseEntity courseEntity) {
        try {
            var result = this.courseUseCase.execute(courseEntity);
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> listAll(@RequestParam(required = false) String name,
                                          @RequestParam(required = false) String category
        ){

        try {
            var result = this.listCoursesUseCase.execute(name, category);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> showById(@PathVariable UUID id){
        try {
            var result = this.searchCourseUseCase.searchById(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
