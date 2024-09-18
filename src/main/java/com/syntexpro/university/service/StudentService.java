package com.syntexpro.university.service;

import com.syntexpro.university.entity.Student;
import com.syntexpro.university.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Slf4j
@Service
public class StudentService {
@Autowired
    private StudentRepository repository;

    public void addNewStudent(Student student){
        Optional<Student> findStudent = repository.findStudentByEmail(student.getEmail());
        if (findStudent.isPresent()) {
            throw new IllegalStateException("You already registered this email");
        }
        log.info("Duplicate Email Address");
        repository.save(student);
    }
@Transactional
    public void updateStudent(Long id, String firstName, String lastName, String email) {
        Student student = repository.findById(id).orElseThrow(() -> new IllegalStateException(
                "student with id" + id + "not exists"));
        if (firstName != null && firstName.length() > 0 && !Objects.equals(student.getFirstName(), firstName)) {
            student.setFirstName(firstName);
        }
        if (lastName != null && lastName.length() > 0 && !Objects.equals(student.getLastName(), lastName)) {
            student.setLastName(lastName);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            student.setEmail(email);
        }

    }

    public  void deleteStudent(Long id){
        boolean idExits = repository.existsById(id);
        if (!idExits){
            log.info("Student id not present in DB");
        }
        repository.deleteById(id);
    }



}
