package com.syntexpro.university.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    private Student student;
    @BeforeEach
    void setUp(){
        student = new Student();
    }


   @DisplayName("Entity-Student Test in own way")
   @Test
   void studentTest(){

       student.setId(1L);
       student.setFirstName("Tasikun");
       student.setLastName("Moon");
       student.setEmail("tmoon@gmail.com");
       student.setAge(27);

       assertEquals(1L, student.getId());
       assertEquals("Tasikun", student.getFirstName());
       assertEquals("Moon", student.getLastName());
       assertEquals("tmoon@gmail.com", student.getEmail());
       assertEquals(27, student.getAge());
   }
    @DisplayName("Entity-Student Chat Gpt")
    @Test
    void testStudentConstructorAndGetters() {
        // Arrange
        Long expectedId = 1L;
        String expectedFirstName = "John";
        String expectedLastName = "Doe";
        String expectedEmail = "john.doe@example.com";
        Integer expectedAge = 22;

        // Act
        student.setId(expectedId);
        student.setFirstName(expectedFirstName);
        student.setLastName(expectedLastName);
        student.setEmail(expectedEmail);
        student.setAge(expectedAge);

        //Assert
        assertThat(student.getId()).isEqualTo(expectedId);
        assertThat(student.getFirstName()).isEqualTo(expectedFirstName);
        assertThat(student.getLastName()).isEqualTo(expectedLastName);
        assertThat(student.getEmail()).isEqualTo(expectedEmail);
        assertThat(student.getAge()).isEqualTo(expectedAge);

    }






}
