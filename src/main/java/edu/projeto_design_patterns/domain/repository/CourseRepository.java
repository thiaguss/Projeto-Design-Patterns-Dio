package edu.projeto_design_patterns.domain.repository;

import edu.projeto_design_patterns.domain.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CourseRepository extends JpaRepository<Course, Long> {
     Optional<Course> findByName(String name);
}
