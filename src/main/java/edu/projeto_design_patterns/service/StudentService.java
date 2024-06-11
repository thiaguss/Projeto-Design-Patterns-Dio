package edu.projeto_design_patterns.service;

import edu.projeto_design_patterns.domain.model.Student;
import edu.projeto_design_patterns.domain.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll(){
        try{
            return studentRepository.findAll();
        }catch (Exception e){
            throw new RuntimeException("Error when searching for students", e);
        }
    }

    public Student getStudentById(Long id){
        try{
            return studentRepository.getById(id);
        }catch (Exception e){
            throw new RuntimeException("Unable to find the provided ID", e);
        }
    }

    public Student createStudent(Student student){
        try{
            if (student.getId() != null && studentRepository.existsById(student.getId())) {
                String err = "Unable to add a new student: Student with ID " + student.getId() + " already exists";
                throw new RuntimeException(err);
            }
            return studentRepository.save(student);
        }catch (Exception e){
            throw new RuntimeException("Unable to add a new student", e);
        }
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        return studentRepository.save(existingStudent);
    }
    
    public Student deleteStudent (Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        studentRepository.deleteById(id);
        return student;
    }

}
