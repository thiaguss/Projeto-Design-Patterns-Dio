package edu.projeto_design_patterns.service;

import edu.projeto_design_patterns.domain.model.Course;
import edu.projeto_design_patterns.domain.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


    public List<Course> getAllCourses() {
        try {
            return courseRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error when searching for courses", e);
        }
    }

    public Course getCourseByName(String name) {
        try {
            return courseRepository.findByName(name)
                    .orElseThrow(() -> new RuntimeException("Course with name " + name + " not found"));
        } catch (Exception e) {
            throw new RuntimeException("Unable to find the provided course name", e);
        }
    }

    public Course createCourse(Course course) {
        try {
            if (course.getId() != null && courseRepository.existsById(course.getId())) {
                String err = "Unable to add a new student: Course with ID " + course.getId() + " already exists";
                throw new RuntimeException(err);
            }
            return courseRepository.save(course);
        } catch (Exception e) {
            throw new RuntimeException("Unable to create a new course", e);
        }
    }

    public Course deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        courseRepository.deleteById(id);
        return course;
    }
}
