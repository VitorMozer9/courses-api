package com.github.vitormozer9.courses_api.modules.courses.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.vitormozer9.courses_api.modules.courses.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID>{
    Optional<CourseEntity> findByName(String name);
    Optional<CourseEntity> findById(UUID id);
    List<CourseEntity> findAllByNameContainingIgnoreCase(String name);
    List<CourseEntity> findAllByCategoryContainingIgnoreCase(String Category);
    List<CourseEntity> findAllByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(
            String name,
            String category);
}
