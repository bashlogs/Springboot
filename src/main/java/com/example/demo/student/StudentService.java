package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<student> getStudents(){
//        return List.of(new student(1L, "Mayur Khadde", "mayur.khadde@gmail.com", LocalDate.of(2000, Month.FEBRUARY, 5), 21));
        return studentRepository.findAll();
    }

    public void addNewStudent(student s1){
        Optional<student> studentByEmail = studentRepository.findStudentByEmail(s1.getEmail());

        if(studentByEmail.isPresent()){
            throw new IllegalStateException("Email already in use");
        }
        studentRepository.save(s1);
    }

    public void deleteStud(Long id){
        boolean exists = studentRepository.existsById(id);
        if(exists){
            studentRepository.deleteById(id);
        }
        else{
            throw new IllegalStateException("Student with id " + id + " not found");
        }
    }

    @Transactional
    public void updateStudent(Long id, String name, String email){
        student s1 = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id " + id + " does not exits"));

        if(name != null && name.length() > 0 && !Objects.equals(s1.getName(), name)){
            s1.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(s1.getEmail(), email)){
            Optional<student> studentByEmail = studentRepository.findStudentByEmail(s1.getEmail());

            if(studentByEmail.isPresent()){
                throw new IllegalStateException("Email already in use");
            }
            s1.setEmail(email);
        }
    }


}