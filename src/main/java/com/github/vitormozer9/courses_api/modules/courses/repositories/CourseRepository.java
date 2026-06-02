package com.github.vitormozer9.courses_api.modules.courses.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.vitormozer9.courses_api.modules.courses.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID>{
    Optional<CourseEntity> findByName(String name);
}
