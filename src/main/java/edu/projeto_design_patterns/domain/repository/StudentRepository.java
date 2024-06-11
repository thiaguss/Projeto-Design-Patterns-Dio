package edu.projeto_design_patterns.domain.repository;

import edu.projeto_design_patterns.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> { }
