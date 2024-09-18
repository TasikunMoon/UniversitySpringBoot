//package com.syntexpro.university.utils;
//
//import com.syntexpro.university.repository.StudentRepository;
//import com.syntexpro.university.entity.Student;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//import java.util.List;
//
//@Configuration
//public class StudentDataConfig {
//@Bean
//CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
//    return args -> {
//        Student mehedi = new Student(
//                101L,
//                "Mehedi",
//                "Aziz",
//                "abc@gmail.com",
//                42);
//        studentRepository.save(mehedi);
//        Student moon = new Student(
//                102L,
//                "Tasikun",
//                "Moon",
//                "123@gmail.com",
//                25);
//        studentRepository.saveAll(List.of(mehedi, moon));
//
//
//
//    };
//  }
//}
